package strings;

public class P334 {
	static java.util.Scanner entrada;
	public static void main (String args[]) {
		entrada = new java.util.Scanner(System.in);
		int numCasosDePrueba = Integer.parseInt(entrada.nextLine());

		for (int i = 0; i < numCasosDePrueba; i++) {
			casoDePrueba();
		}
	}
	private static void casoDePrueba(){
		String nombre = entrada.nextLine();

		if (nombre.length() < 3){
			nombre = "  ".concat(nombre);
		}

		if (esPicto(nombre)){
			if (sacarEtnia(nombre).equals("PLUS ULTRA")){
				System.out.println("PICTO");
			}else{
				System.out.println("MULATO");
			}
		}else{
			System.out.println(sacarEtnia(nombre));
		}
	}
	private static String sacarEtnia(String nombre){
		int resto = nombre.length() - 2;
		String ultimos = nombre.substring(resto, nombre.length());

		if ("IX".equals(ultimos)){
			return "GALO";
		} else if ("US".equals(ultimos) || "UM".equals(ultimos)) {
			return "ROMANO";
		} else if ("IC".equals(ultimos)) {
			return "GODO";
		} else if ("AS".equals(ultimos)) {
			return "GRIEGO";
		} else if ("AF".equals(ultimos)) {
			return "NORMANDO";
		} else if ("IS".equals(ultimos) || "OS".equals(ultimos) || "AX".equals(ultimos)) {
			return "BRETON";
		} else if ("EZ".equals(ultimos)) {
			return "HISPANO";
		} else if ("A".equals(ultimos.substring(1, 2))) {
			return "INDIO";
		} else {
			return "PLUS ULTRA";
		}
	}
	private static boolean esPicto(String nombre){
		String primeros = nombre.substring(0, 3);

		return primeros.equals("MAC");
	}
}