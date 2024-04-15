package ejercicios.t1;

import java.io.*;

/*
* Muchos videojuegos necesitan calcular las operaciones matemáticas Math.sin y
Math.cos sobre números entre 0 y 360 y no pueden perder tiempo durante la partida en llamar a
esos métodos porque son muy lentos. Realiza un programa que genere un archivo llamado
trigonometrics.bin en el que se guarden los resultados de dichos cálculos, según este formato:
* */
public class ej7 {
    public static void main(String[] args) {
        try(
                OutputStream a = new FileOutputStream("trigonometrics.bin");
                BufferedOutputStream b = new BufferedOutputStream(a);
                DataOutputStream c = new DataOutputStream(b);
                )
        {
            for(int i = 0; i<=360; i++){
                double anguloRadianes = Math.toRadians(i);
                double seno = Math.sin(anguloRadianes);
                double coseno = Math.cos(anguloRadianes);
                c.writeInt(i);
                c.writeDouble(seno);
                c.writeDouble(coseno);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
