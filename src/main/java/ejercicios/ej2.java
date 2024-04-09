package ejercicios;

import java.io.*;
import java.util.Random;

/*
* Haz un programa que genere un número aleatorio N entre 10 y 120.
* A continuación, el programa creará un archivo llamado notas_aleatorias.bin
*  y en él escribirá primero el número N y después,
* N números aleatorios comprendidos entre 0 y 10.
* Dibuja la tabla con el formato del archivo.
* */
public class ej2 {
    public static void main(String[] args) {
        int aleatorio = new Random().nextInt(0,11);
        try(
                OutputStream a = new FileOutputStream("notas-aleatorias.bin");
                BufferedOutputStream b = new BufferedOutputStream(a);
                DataOutputStream c = new DataOutputStream(b);
        ) {
            c.writeInt(aleatorio);
            for(int i = 0; i<aleatorio; i++){
                c.writeInt(new Random().nextInt(0,11));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
