package ejercicios.t1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
* Primero programa
* el siguiente record (si no sabes, puedes hacer una clase), donde
tendrás que proteger adecuadamente la nota para que
* esté comprendida entre 0 y 10.
* */
public class ej9 {
    public static void main(String[] args) {
        List<Nota> notas = new ArrayList<>();
        int opcion = -1;
        while (opcion != 3) {
            System.out.println("""
                    1. Añadir la nota de un examen
                    2. Guardar
                    3. Salir
                    """);
            opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("Escribe el nombre de una asignatura: ");
                    String asignatura = new Scanner(System.in).nextLine();
                    System.out.println("Escribe la nota de un examen: ");
                    int nota = new Scanner(System.in).nextInt();
                    Nota n = new Nota(asignatura, nota);
                    notas.add(n);
                }
                case 2 -> {
                    try (
                            OutputStream a = new FileOutputStream("notas.bin");
                            BufferedOutputStream b = new BufferedOutputStream(a);
                            DataOutputStream c = new DataOutputStream(b);
                    ) {
                        c.writeInt(notas.size());
                        for (Nota nota : notas) {
                            c.writeUTF(nota.asignatura());
                            c.writeInt(nota.nota());
                        }

                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("Has salido del programa.");
                }
                default -> {
                    System.out.println("Opción no válida");
                }
            }
        }
    }
}
