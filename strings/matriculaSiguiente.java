package strings;

public class matriculaSiguiente {

    static java.util.Scanner entrada;
    static StringBuilder salidas = new StringBuilder("");

    public static void main(String args[]) {
        entrada = new java.util.Scanner(System.in);

        while (casoDePrueba()) {
        }
    }

    private static boolean casoDePrueba() {
        String matricula, numeroCuatroDigitos;
        int num;
        char c1, c2, c3;
                
        if ("9999 ZZZ".equals(matricula = entrada.nextLine())) {
            System.out.print(salidas.toString());
            return false;
        }
        
        num = Integer.parseInt(matricula.substring(0, 4));
        c1 = matricula.charAt(5);
        c2 = matricula.charAt(6);
        c3 = matricula.charAt(7);
        
        if (num > 9998){
            num = 0000;
            if (c3 == 'Z'){
                c3 = 'B';
                if (c2 == 'Z'){
                    c2 = 'B';
                    c1++;
                    if (c1 == 'E' || c1 == 'I' || c1 == 'O' || c1 == 'U'){
                        c1++;
                    }
                }else{
                    c2++;
                    if (c2 == 'E' || c2 == 'I' || c2 == 'O' || c2 == 'U'){
                        c2++;
                    }
                }
            }else{
                c3++;
                if (c3 == 'E' || c3 == 'I' || c3 == 'O' || c3 == 'U'){
                    c3++;
                }
            }
        }else{
            num++;
        }
        
        if (num < 10){
            numeroCuatroDigitos = "000" + num;
        }else if (num < 100){
            numeroCuatroDigitos = "00" + num;
        }else if (num < 1000){
            numeroCuatroDigitos = "0" + num;
        }else{
            numeroCuatroDigitos = num + "";
        }
        
        salidas.append(numeroCuatroDigitos).append(" ").append(c1).append(c2).append(c3).append("\n");
        
        return true;
    }
}
