package ejercicios;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ej13 {
    public static void main(String[] args) {
        try (
                InputStream a = new FileInputStream("empresa.bin");
                BufferedInputStream b = new BufferedInputStream(a);
                ObjectInputStream c = new ObjectInputStream(b);
        ) {
            Map<String, List<Empleado>> map = (Map<String, List<Empleado>>) c.readObject();
            System.out.println("Introduce el nombre de un departamento: ");
            String departamento = new Scanner(System.in).nextLine();
            if(map.containsKey(departamento)){
                System.out.println(map.get(departamento));
            }else{
                System.out.println("Ese departamento no existe");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
