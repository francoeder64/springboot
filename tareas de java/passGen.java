import java.util.Random;
import java.io.IOException;
/*
Clase original , para la generar un String Ramdom
 */
public class passGen{
    // Version 1.0
    //String dCase = "abcdefghijklmnopqrstuvwxyz";
    //String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //String sChar = "!@#$%/&*";
    //String intChar = "0123456789";
    //Random r = new Random();
    //StringBuilder pass = new StringBuilder();
     
    //public static void main(String[] args) {
    //    System.out.println ("Generated Pass: " + Genkey());
    //

    public static String Genkey() throws IOException { 
    String dCase = "abcdefghijklmnopqrstuvwxyz";
    String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String sChar = "!@#$%/&*";
    String intChar = "0123456789";
    Random r = new Random();
    StringBuilder pass = new StringBuilder();
    
    try {
        while (pass.length () != 8){
            int rPick = r.nextInt(4);
            if (rPick == 0){
                int spot = r.nextInt(26);
                pass.append(dCase.charAt(spot));
            } else if (rPick == 1) {
                int spot = r.nextInt(26);
                pass.append(uCase.charAt(spot));
            } else if (rPick == 2) {
                int spot = r.nextInt(8);
                pass.append(sChar.charAt(spot));
            } else {
                int spot = r.nextInt(10);
                pass.append(intChar.charAt(spot));
            }
        }
    } catch (Exception ex) {
            ex.printStackTrace();
            throw new IOException(ex);
        }   
        String  ValGen = "";
        ValGen = pass.toString();
        return  ValGen; 
    }
}
