package t1;

import java.io.*;

public class Programa {
    public static void main(String[] args) {
        try(
                InputStream a = new FileInputStream("numeros.bin");
                BufferedInputStream b = new BufferedInputStream(a);
                ){
            int byteLeido = 0;
            while( (byteLeido = b.read()) !=-1){
                // System.out.println(byteLeido);
                // Para mostrarlo como 0 y 1
                System.out.println(Integer.toBinaryString(byteLeido));
                // Se pueden leer bloques de bytes
            }

        }catch(IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
