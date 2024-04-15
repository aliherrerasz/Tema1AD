package ejercicios.t1;

import java.io.*;
import java.util.Scanner;

/*
* : Haz un programa que pregunte por teclado al usuario la ruta de un archivo y el programa
nos muestre en pantalla los unos y ceros que lo componen.
* */
public class ej1 {
    public static void main(String[] args) {
        System.out.println("Introduce la ruta de un archivo: ");
        String ruta = new Scanner(System.in).nextLine();
        try(InputStream a = new FileInputStream(ruta);
            BufferedInputStream b = new BufferedInputStream(a);
            DataInputStream c = new DataInputStream(b);
            )
        {
            while(c.read()>-1){
                System.out.println(c.read());
            }


        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
