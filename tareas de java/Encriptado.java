

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
// Encriptado de prueba para el envio de informacion sencible del canal 
// HAP-San Salvador 14 de septiembre del 2021 
public class Encriptado {

	  private static SecretKeySpec secretKey;
	  private static SecretKeySpec secretKeyh;
	  private static byte[] key;



	    public static void setKey(String myKey) 
	    {
	        MessageDigest sha = null;
	        try {
	            key = myKey.getBytes(StandardCharsets.ISO_8859_1);
	            sha = MessageDigest.getInstance("SHA-1");
	            key = sha.digest(key);
	            key = Arrays.copyOf(key, 16); 
	            secretKey = new SecretKeySpec(key, "AES");
	        } 
	        catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public static String encrypt(String strToEncrypt, String mykeyh) 
	    {
			String ValorParm = strToEncrypt;
			MessageDigest sha = null;
	        try {
				key = mykeyh.getBytes(StandardCharsets.ISO_8859_1);
	            sha = MessageDigest.getInstance("SHA-1");
	            key = sha.digest(key);
	            key = Arrays.copyOf(key, 16); 
	            secretKeyh = new SecretKeySpec(key, "AES");
	        } 
	        catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }

	        try
	        {
	            //setKey(secret);
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	            cipher.init(Cipher.ENCRYPT_MODE, secretKeyh);
	            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.ISO_8859_1))).toString() + "-" + ValorParm;
	        } 
	        catch (Exception e) 
	        {
	            //System.out.println("Error while encrypting: " + e.toString());
	        }
	        return strToEncrypt ;
	    }
	 
	    public static String decrypt(String strToDecrypt)//, String secret) 
	    {
	        try
	        {
	            //setKey(secret);
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	            cipher.init(Cipher.DECRYPT_MODE, secretKey);
	            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Error while decrypting: " + e.toString());
	        }
	        return null;
	    }
		
}
