package Wallet;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import org.bitcoinj.core.Base58;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.*;

public class Bitcoin_Address {
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Kenji's bitcoin address generator");
		System.out.println("---------------------------------------------");
		System.out.println();
		System.out.println("Loading...");
		System.out.println();
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
		ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256k1");
		keyGen.initialize(ecSpec);
		//Finding Private Key
		KeyPair kp = keyGen.generateKeyPair();
		PublicKey pub = kp.getPublic();
		PrivateKey pvt = kp.getPrivate();
		ECPrivateKey epvt = (ECPrivateKey)pvt;
		String sepvt = adjustTo64(epvt.getS().toString(16).toUpperCase());
		System.out.println("Private Key(s[" + sepvt.length()+ "]): "+ sepvt );
		//Finding Public Key
		ECPublicKey epub = (ECPublicKey)pub;
		ECPoint pt = epub.getW();
		String sx = adjustTo64(pt.getAffineX().toString(16).toUpperCase());
		String sy = adjustTo64(pt.getAffineY().toString(16).toUpperCase());
		String bcPub = "04" + sx + sy;
		System.out.println("Public Key: "+ bcPub);
		//SHA-256 Public Key
		MessageDigest sha = MessageDigest.getInstance("SHA-256");
		byte[]s1 = sha.digest(bcPub.getBytes("UTF-8"));
		StringBuilder sb = new StringBuilder();
		for (byte b : s1) {
			sb.append(String.format("%02X", b));
		}
		System.out.println("sha-256: "+sb.toString().toUpperCase());
		//RIPEMD-160 Public Key
		Security.addProvider(new BouncyCastleProvider());
		MessageDigest rmd = MessageDigest.getInstance("RipeMD160");
		byte[] r1 = rmd.digest(s1);
		byte[] r2 = new byte[r1.length + 1];
		r2[0] = 0;
		for(int i = 0; i<r1.length; i++)
			r2[i+1] = r1[i];
		
		StringBuilder sb2 = new StringBuilder();
		for (byte b : r2) {
			sb2.append(String.format("%02X", b));
		}
		System.out.println("RipeMD-160: "+sb2.toString().toUpperCase());
		//Double Hashing
		byte[] s2 = sha.digest(r2);
		StringBuilder sb3 = new StringBuilder();
		for (byte b : s2) {
			sb3.append(String.format("%02X", b));
		}
		System.out.println("sha-256(1): " + sb3.toString().toUpperCase());
		byte[]s3 = sha.digest(s2);
		
		StringBuilder sb4 = new StringBuilder();
		for (byte b : s3) {
			sb4.append(String.format("%02X", b));
		}
		System.out.println("sha-256(2): "+sb4.toString().toUpperCase());
		byte[]a1 = new byte[25];
		for(int i = 0; i<r2.length;i++)
			a1[i] = r2[i];
		for(int i = 0; i<5;i++)
			a1[20+i] = s3[i];
		//Base58 Encoding
		System.out.println("Wallet Address: " + Base58.encode(a1));
		
	}
	static private String adjustTo64(String s) {
		switch(s.length()) {
		case 62: return "00" + s;
		case 63: return "0" + s;
		case 64: return s;
		default: throw new IllegalArgumentException("Not a valid key: " +s)
		;
		}
	}
	
}
