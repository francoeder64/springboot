import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
public class Encriptar {
    /**
     * Encripta el valor pasado en textToEncrypt utilizando la llave encriptionKey.
     * 
     * @param textToEncrypt
     * @param encriptionKey
     * @return
     * @throws IOException
     * @throws InvalidAlgorithmParameterException
     */
    public static String encrypt(String textToEncrypt, String encriptionKey)throws IOException, InvalidAlgorithmParameterException {
        try {
            IvParameterSpec iv = new IvParameterSpec("0123456789ABCDEF".getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(encriptionKey.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
            byte[] encrypted = cipher.doFinal(textToEncrypt.getBytes());
            return new String(Base64.encodeBase64(encrypted));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IOException(ex);
        }
    }
    /**
     * Desencripta el valor pasado en textToEncrypt utilizando la llave encriptionKey.
     * 
     * @param encryptedText
     * @param encriptionKey
     * @return
     * @throws IOException
     * @throws InvalidAlgorithmParameterException 
     */
    public static String decrypt(String encryptedText, String encriptionKey) throws IOException, InvalidAlgorithmParameterException {
        String base64EncryptedString = "";
        try {
            IvParameterSpec iv = new IvParameterSpec("0123456789ABCDEF".getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(encriptionKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.decodeBase64(encryptedText.getBytes()));
            base64EncryptedString = new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
            base64EncryptedString = "9999";
        }
        return base64EncryptedString;
    }   
}
