package ejercicios.t2;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ArchivoDepartamentoDAO implements DepartamentoDAO {
    private Integer siguienteId;
    private String ruta;

    public ArchivoDepartamentoDAO(String ruta) {
        this.ruta = ruta;
        siguienteId = null;
    }

    @Override
    public List<Departamento> getDepartamentos() {
        List<Departamento> listaDepartamentos = new ArrayList<>();
        try (
                InputStream a = new FileInputStream(this.ruta);
                BufferedInputStream b = new BufferedInputStream(a);
                ObjectInputStream c = new ObjectInputStream(b);
        ) {
            boolean repetir = true;
            while (repetir) {
                try {
                    listaDepartamentos.add((Departamento) c.readObject());
                } catch (EOFException | ClassNotFoundException e) {
                    repetir = false;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listaDepartamentos;
    }

    @Override
    public Departamento añadir(String nombre) {
        File archivo = new File(ruta);
        if(!archivo.isFile()){
            try(
                    OutputStream a = new FileOutputStream(ruta);
                    BufferedOutputStream b = new BufferedOutputStream(a);
                    ObjectOutputStream c  = new ObjectOutputStream(b);

            ) {
                c.writeObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try(
                InputStream a = new FileInputStream(this.ruta);
                BufferedInputStream  b = new BufferedInputStream(a);
                ObjectInputStream c  = new ObjectInputStream(b);
                ){


        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
