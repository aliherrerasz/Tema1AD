package ejercicios.t2;

import java.util.List;

public interface DepartamentoDAO {
    public List<Departamento> getDepartamentos();
    public Departamento añadir(String nombre);
}
