package ejercicios.t1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
* El duplicado se llamará duplicado.bin y estará en la misma carpeta
* que el original. El programa usará el método
* System.getProperty pasándole como parámetro “java.version” para
* detectar la versión de Java.
 En caso de ser Java 8 (o inferior): se usará la clase Files para hacer el duplicado.
 A partir de Java 9: hará el duplicado con los nuevos métodos de java.io
* */
public class ej15 {
    public static void main(String[] args) {
        System.out.println("Introduce la ruta de un archivo: ");
        String ruta = new Scanner(System.in).nextLine();
        String version = (System.getProperty("java.version"));
        vers
        Path carpetaOrigen = Paths.get(ruta);

        if (version <= 8) {
            if (Files.isDirectory(carpetaOrigen)) {
                Path destino = Path.of("duplicado.bin");
                try {
                    java.nio.file.Files.copy(carpetaOrigen, destino);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("La ruta no es una carpeta");
            }

        } else {
            try (
                    InputStream a = new FileInputStream(ruta);
                    BufferedInputStream b = new BufferedInputStream(a);
                    OutputStream c = new FileOutputStream("duplicado");
                    BufferedOutputStream d = new BufferedOutputStream(c);
            ) {
                b.transferTo(d);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
