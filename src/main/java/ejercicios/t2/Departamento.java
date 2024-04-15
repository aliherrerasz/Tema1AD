package ejercicios.t2;

import java.io.Serializable;

public record Departamento(int id, String nombre) implements Serializable {
    private static final long serialVersionUID = 1;
    
}
