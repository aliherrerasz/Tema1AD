package ejercicios.t2;

import java.util.List;

public class DepartamentoRepository {
    private static DepartamentoRepository INSTANCIA;
    private DepartamentoDAO dao;

    public DepartamentoRepository(DepartamentoDAO dao) {
        this.dao = dao;
    }
    public static DepartamentoRepository getInstancia(){
        return INSTANCIA;
    }
    public static DepartamentoRepository inicializar(DepartamentoDAO dao){
        if(INSTANCIA == null){
            INSTANCIA = new DepartamentoRepository(dao);
        }
        return INSTANCIA;
    }
    public List<Departamento> getDepartamentos(){
        return dao.getDepartamentos();
    }
    public Departamento añadir(String nombre){
        return dao.añadir(nombre);
    }
}
