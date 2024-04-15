package ejercicios.t1;

import java.io.Serializable;

public record Empleado(String nombre, double sueldo) implements Serializable {
}
