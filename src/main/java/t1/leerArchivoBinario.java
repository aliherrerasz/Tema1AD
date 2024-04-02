package t1;

import java.io.*;

public class leerArchivoBinario {
    public static void main(String[] args) {
        try(
                // El archivo empieza vacío, si  existe lo sobreescribe, a  menos que pongamos 'true'
                InputStream a = new FileInputStream("numeros.bin");
                // Capuchón para que vaya más rápido
                BufferedInputStream b = new BufferedInputStream(a);
                // Para trabajar con datos básicos y no solo con 0 y 1, trabajamos con DATA
                DataInputStream c = new DataInputStream(b);
                // Leemos
                ObjectInputStream d = new ObjectInputStream(c);
        ){

            String palabra  = d.readUTF();
            int numero = d.readInt();
            boolean variable = d.readBoolean();
            System.out.println(numero+" "+palabra);
            Persona p = (Persona) d.readObject();
            System.out.println(p.getEdad()+" "+p.getNombre());
        }catch (IOException | ClassNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
