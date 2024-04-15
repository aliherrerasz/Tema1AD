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
        Departamento d = new Departamento(siguienteId, nombre);
        if (!archivo.isFile()) {
            try (
                    OutputStream a = new FileOutputStream(ruta);
                    BufferedOutputStream b = new BufferedOutputStream(a);
                    ObjectOutputStream c = new ObjectOutputStream(b);

            ) {
                c.writeObject(new Departamento(siguienteId+1,nombre));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (
                OutputStream a = new FileOutputStream(this.ruta);
                BufferedOutputStream b = new BufferedOutputStream(a);
                ObjectOutputStream c = new ObjectOutputStream(b);
        ) {
            if (siguienteId == null) {
                int mayorId = 0;
                for (Departamento departamento : this.getDepartamentos()) {
                    if (departamento.id() > mayorId) {
                        mayorId = departamento.id();
                    }
                }
                siguienteId = mayorId + 1;
            }
            c.writeObject(d);
            siguienteId++;

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return d;
    }
}
