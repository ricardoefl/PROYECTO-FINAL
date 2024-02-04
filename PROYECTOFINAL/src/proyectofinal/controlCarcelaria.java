package proyectofinal;
//AUTOR: Ricardo Espinosa Y Juan Diego Camargo
import java.util.*;
import java.io.*;
public class controlCarcelaria {
    public static void main(String[] args) {
        String nombreArchivo = "datosCarcel.csv";
        int filas = 801;
        int columnas = 13;
        String [][] principal = new String [filas][columnas];
    }
    
    public static void leercsv(String[][] principal, int filas, int columnas, String nombreArchivo){
        try {
            String arreglo[] = new String[columnas];
            int i = 0;
            Scanner l = new Scanner(new File(nombreArchivo));
            while(l.hasNext()){
                arreglo[i] = l.nextLine().split(";");
                i++;
            }
        } catch (Exception e) {
        }  
    }
}