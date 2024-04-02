package t1;

import java.io.IOException;
import java.nio.file.Path;

public class Files {
    // Esta clase normalmente no dejará usarla xd socorro AZZIZZZ
    public static void main(String[] args) {
        Path origen = Path.of("numeros.bin");
        Path destino = Path.of("duplicado.bin");
        try {
            java.nio.file.Files.copy(origen, destino);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
