package arrays;

public class molinosDeViento {
    static java.util.Scanner entrada;

    public static void main(String args[]) {
        entrada = new java.util.Scanner(System.in);

        while (casoDePrueba()) {
        }
    }

    private static boolean casoDePrueba() {
        int numMolinos, consulta, molinoInicial, molinoFinal, energiaTotal;
        int[] energiaMolinos;

        numMolinos = entrada.nextInt();
        
        if (numMolinos == 0) {
            return false;
        }
        
        numMolinos++;
        energiaMolinos = new int[numMolinos];
        
        
        for (int i = 1; i < energiaMolinos.length; i++) {
            energiaMolinos[i] = entrada.nextInt();    
            energiaMolinos[i] += energiaMolinos[i - 1];
        }
        
        consulta = entrada.nextInt();
        
        for (int i = 0; i < consulta; i++) {
            molinoInicial = entrada.nextInt() - 1;
            molinoFinal = entrada.nextInt();
            
            energiaTotal = energiaMolinos[molinoFinal] - energiaMolinos[molinoInicial];
            
            System.out.println(energiaTotal);
        }
        
        return true;
    }
}