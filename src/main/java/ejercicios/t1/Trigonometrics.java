package ejercicios.t1;

import java.io.*;

public class Trigonometrics {
    private double[] senos;
    private double[] cosenos;
    public Trigonometrics() throws IOException{
        try(
                InputStream a = new FileInputStream("trigonometrics.bin");
                BufferedInputStream b = new BufferedInputStream(a);
                DataInputStream c = new DataInputStream(b);
                )
        {
            for(int i = 0; i<= 360; i++){
                int angulo = c.readInt();
                double seno = c.readDouble();
                double coseno = c.readDouble();
                senos[i] = seno;
                cosenos[i] = coseno;

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    public double getSeno(int n){
        if(n<0){
            throw new IllegalArgumentException("No puede ser negativo");
        }
        int resto = n % 360;
        return senos[resto];
    }
    public double getCoseno(int n){
        if(n<0){
            throw new IllegalArgumentException("No puede ser negativo");
        }
        int resto = n % 360;
        return cosenos[resto];
    }
}
