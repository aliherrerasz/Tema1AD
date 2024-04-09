package ejercicios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Realiza un programa que pregunte al usuario palabras y las vaya guardando en un
List<String>. Cuando el usuario escriba “fin”
* (esta palabra también se guardará en la lista), el programa creará un archivo
* llamado palabras.bin y escribirá sobre él la lista de palabras, en este
formato:
* */
public class ej5 {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>();
        String palabraAñadir = "";
        while(!palabraAñadir.equalsIgnoreCase("fin")){
            palabraAñadir = escribirPalabra();
            palabras.add(palabraAñadir);
        }

        try(OutputStream a = new FileOutputStream("palabras.bin");
            BufferedOutputStream b = new BufferedOutputStream(a);
            DataOutputStream c = new DataOutputStream(b);
        ){
            for(int i = 0; i< palabras.size(); i++){
                c.writeUTF(palabras.get(i));
            }
        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    private static String escribirPalabra(){
        System.out.println("Escribe una palabra: ");
        return new Scanner(System.in).nextLine();
    }

}
