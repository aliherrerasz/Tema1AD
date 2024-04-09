package ejercicios;

import java.io.*;

/*
* Haz un programa que lea todos los números que hay en el archivo notas_aleatorias.bin y
nos muestre el total de números que hay en el archivo, el mayor de los números,
* el menor, la suma y la media de los números.
* */
public class ej3 {
    public static void main(String[] args) {
        try(
                InputStream a = new FileInputStream("notas-aleatorias.bin");
                BufferedInputStream b = new BufferedInputStream(a);
                DataInputStream c = new DataInputStream(b);
                ) {
            int numeroLeido = 0;
            int max = 0;
            int min = 10;
            int suma = 0;
            while (c.read()>-1){
                int n = c.readInt();
                if(n>max){
                    max = n;
                }else if(n<min){
                    min = n;
                }
                suma += n;
                numeroLeido++;
            }
            System.out.println("Se han leído "+numeroLeido+" números.\n El máximo" +
                    "es "+max+", el mínimo es "+min+", la suma es "+suma+" y la media es "+(suma*1.0)/numeroLeido);
        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
