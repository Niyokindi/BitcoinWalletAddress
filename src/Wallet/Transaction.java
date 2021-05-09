package Wallet;
import java.security.*;
import java.util.*;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.bitcoinj.core.*;
import org.bouncycastle.crypto.agreement.srp.SRP6Util;


public class Transaction {
	public String TransactionId;
	public PublicKey sender;
	public PublicKey recipient;
	public float value;
	public byte[] signature;
	
	public ArrayList<TransactionInput> inputs = new ArrayList<>();
	public ArrayList<TransactionOutput>outputs = new ArrayList<>();
	
	private static int count = 0;
	
	public Transaction(PublicKey from, PublicKey to, Float value, ArrayList<TransactionInput> inputs) {
		this.sender = from;
		this.recipient = to;
		this.value = value;
		this.inputs = inputs;
	}
	public static class StringUtil {
	    //Applies Sha256 to a string and returns the result. 
	    public static String applySha256(String input){     
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");            
	            //Applies sha256 to our input, 
	            byte[] hash = digest.digest(input.getBytes("UTF-8"));           
	            StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
	            for (int i = 0; i < hash.length; i++) {
	                String hex = Integer.toHexString(0xff & hash[i]);
	                if(hex.length() == 1) hexString.append('0');
	                hexString.append(hex);
	            }
	            return hexString.toString();
	        }
	        catch(Exception e) {
	            throw new RuntimeException(e);
	        }
	    }   
	}
	
	private String calculateHash() {
		count++;
		return StringUtil.applySha256(StringUtil.getStringFromKey)
		
	}
}
