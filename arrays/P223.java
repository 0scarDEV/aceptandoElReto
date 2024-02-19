import java.util.*;

public class P223 {
    static java.util.Scanner entrada;
   
    public static void main (String args[]) {
        entrada = new java.util.Scanner(System.in);
        int numCasosDePrueba = entrada.nextInt();

        for (int i = 0; i < numCasosDePrueba; i++) {
            casoDePrueba();
        }
    }

    private static void casoDePrueba(){
	short longSecuencia = entrada.nextShort(), min = -1, max = -1, cantMulti = 0, ultimo = 0;
        int[] secuencia = new int[longSecuencia];
        Iterator it;
        Short[] ac;
        TreeMap<Short, Short[]> mapa = new TreeMap();
        boolean sigueBuscando = true;
        
        
        for (int i = 0; i < secuencia.length; i++) {
            secuencia[i] = entrada.nextInt();  
        }
        
        
        for (short i = 0; i < secuencia.length; i++) {
            if (min < 0){
                if (secuencia[i] != 0){
                    sigueBuscando = false;
                    min = i;
                    max = i;
                    cantMulti++;
                }
            }else if (max != -1){
                if (secuencia[i] == 0){
                    if (!mapa.keySet().contains(cantMulti)){
                        max = (short) (i - 1);
                    
                        ac = new Short[]{min, max};
                        mapa.put(cantMulti, ac);

                        min = -1;
                        max = -1;
                        cantMulti = 0;
                    }else{
                        min = -1;
                        max = -1;
                        cantMulti = 0;
                    }
                }else{
                    cantMulti++;
                }
            }
            
            if (i == secuencia.length - 1){
                if (cantMulti > 0){
                    if (!mapa.keySet().contains(cantMulti)){
                        max = i;
                        ac = new Short[]{min, max};
                        mapa.put(cantMulti, ac);
                    }
                }
            }
        }
        
        if (sigueBuscando){
            System.out.println("SIGUE BUSCANDO");
        }else{
            it = mapa.keySet().iterator();
            
            while (it.hasNext()) {
                ultimo = (short) it.next(); 
            }
            
            ac = mapa.get(ultimo);
            
            System.out.println(ultimo + " -> " + "[" + ac[0] + "," + ac[1] + "]");
        }
    }
}
