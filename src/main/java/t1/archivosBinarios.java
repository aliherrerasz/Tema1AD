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
                // Si queremos guardar un objeto y no un dato básico, se usa Object
                ObjectOutputStream d = new ObjectOutputStream(c);
                ){
        // Es mejor usar siempre el último que hemos hecho, habría que sustituir esto por d
        d.writeUTF("hola");
        d.writeInt(8);
        d.writeBoolean(true);

        Persona p = new Persona("Romi", 24);
        d.writeObject(p);
        }catch (IOException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
