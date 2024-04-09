package ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
* Realiza un programa que lea el archivo palabras.bin del ejercicio anterior
* y recupere las palabras en un List<String>.
* A continuación, el programa las mostrará en pantalla.
* */
public class ej6 {
    public static void main(String[] args) {
        try(
                InputStream a = new FileInputStream("palabras.bin");
                BufferedInputStream b = new BufferedInputStream(a);
                DataInputStream c = new DataInputStream(b);
                )
        {
            List<String> palabras = new ArrayList<>();
            while(c.read()!=-1){
                palabras.add(c.readUTF());
            }
            for (String palabra : palabras) {
                System.out.println(palabra);
            }
        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
