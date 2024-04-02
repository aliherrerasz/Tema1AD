package t1;

import java.io.*;

public class archivosBinarios {
    public static void main(String[] args) {
        // Programa que crea archivo binario con 0 y 1
        // Hay que hacer un try -con resources- porque salen excepciones
        try(
                // El archivo empieza vacío, si  existe lo sobreescribe, a  menos que pongamos 'true'
                OutputStream a = new FileOutputStream("numeros.bin");
                // Capuchón para que vaya más rápido
                BufferedOutputStream b = new BufferedOutputStream(a);
                // Para trabajar con datos básicos y no solo con 0 y 1, trabajamos con DATA
                DataOutputStream c = new DataOutputStream(b);
                ){

        c.writeUTF("hola");
        c.writeInt(8);
        c.writeBoolean(true);
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
