package ejercicios;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ej12 {
    public static void main(String[] args) {
        Map<String, List<Empleado>> datos = new HashMap<>();
        datos.put(
                "Informática",List.of(
                new Empleado("Antonio",1200),
                new Empleado("Pedro",1800),
                new Empleado("Ana",2000))
                );
        datos.put(
                "Recursos Humanos", List.of(
                        new Empleado("Hermenegildo",1500),
                        new Empleado("Lucia",2000)
                )
        );
        try(
                OutputStream a = new FileOutputStream("empresa.bin");
                BufferedOutputStream  b = new BufferedOutputStream(a);
                ObjectOutputStream c = new ObjectOutputStream(b);
        )
        {
            c.writeObject(datos);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
