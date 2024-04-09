package ejercicios;

import java.io.*;
import java.util.Scanner;

/*
* Haz un programa que pregunte por teclado al usuario la ruta de un archivo y
* le haga un duplicado leyendo el archivo de entrada en bloques de 4096 bytes.
* Ahora mismo da igual la ruta donde se guarde el duplicado ni el nombre que le pongas.
* */
public class ej4 {
    public static void main(String[] args) {
        System.out.println("Introduce la ruta de un archivo: ");
        String ruta = new Scanner(System.in).nextLine();
        try(
                InputStream a = new FileInputStream("ruta");
                BufferedInputStream b = new BufferedInputStream(a);
                OutputStream c = new FileOutputStream("duplicado");
                BufferedOutputStream d = new BufferedOutputStream(c);
                )
        {
            while(b.read(b.readNBytes(4096))!=-1){
                byte[] array = new byte[4096];
                c.write(b.readNBytes(4096));
            }

        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
