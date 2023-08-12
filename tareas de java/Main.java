package prueba;

public class Main {

	public static void main(String[] args) {
		Encriptado.setKey("OMNICHANEL_PER");
		String convertir = Encriptado.encrypt("577");
		
		
		String valorHex = asciiToHex(convertir);
		
		String valorAscii = hexToAsc(valorHex);

		System.out.println("Valor Ascii: " + valorAscii);
		String desc = Encriptado.decrypt(valorAscii);
		
		System.out.println("Valor: " + desc);
	}

	private static String hexToAsc(String valorHex) {
		StringBuilder output = new StringBuilder("");
		    
		for (int i = 0; i < valorHex.length(); i += 2) {
			String str = valorHex.substring(i, i + 2);
			output.append((char) Integer.parseInt(str, 16));
		}
		    
		return output.toString();
	}
	private static String asciiToHex(String valorAscii) {
	    char[] chars = valorAscii.toCharArray();
	    StringBuilder hex = new StringBuilder();
	    for (char ch : chars) {
	        hex.append(Integer.toHexString((int) ch));
	    }

	    return hex.toString();
	}

}
