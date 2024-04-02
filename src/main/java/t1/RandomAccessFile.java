package t1;

import java.io.IOException;

public class RandomAccessFile {
    public static void main(String[] args) {
        try(
                java.io.RandomAccessFile a = new java.io.RandomAccessFile("numeros.bin","r")
        ){
            for(int i = 0; i<a.length(); i++){
                int byteLeido = a.read();
                System.out.println(Integer.toBinaryString(byteLeido));
            }
        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
