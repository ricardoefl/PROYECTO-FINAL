package proyectofinal;
//AUTOR: Ricardo Espinosa Y Juan Diego Camargo
import java.util.*;
public class controlCarcelaria {
    public static void main(String[] args) { //Solo estan cedulas nombres y edades
        int filas = 5;
        int columnas = 11;
        String [][]principal = new String [filas][columnas];
        generarCedulas(principal, filas);
        generarNombresPPL(principal, filas);
        generaredades(principal, filas);
        presentarData(principal, filas);
    }
    
    public static void presentarData(String principal[][], int filas){ //Presentar datos en la consola
        System.out.println("Cedula\t\t| Nombres\t\t\t\t| Edad(Anios)\t| Fecha(Ingreso)\t| Fecha(Salida)\t| Pabellon\t| Celda\t\t| Clasificacion\t| Pena(Anios)\t| Visitas semanales(Horas)\t| Delito");
        for (int i = 0; i < filas; i++) {
            System.out.printf("%s\t%s\t\t%s\t\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t\t\t%s\n",
            principal[i][0], principal[i][1], principal[i][2], principal[i][3], principal[i][4], principal[i][5], 
            principal[i][6], principal[i][7], principal[i][8], principal[i][9], principal[i][10] );
        }
    }
    
    public static void generarCedulas(String principal[][], int filas){ //Generar identificaciondes de los PPL
        int x1 = 0;
        int x2 = 0;
        for (int i = 0; i < principal.length; i++) {
            x1 = (int) (Math.random() * 90102-1) + 10190;
            x2 = (int) (Math.random() * 90102-1) + 10190;
            principal[i][0] =  String.valueOf(x1) + String.valueOf(x2);
        }
    }
    
    public static void generarNombresPPL(String principal[][], int filas){ //Generar nombres completos de los PPL
        String nomPersonas1[] = {"Roberto","Dario","Fabian","Gonzalo","Carlos","Santiago","Marco","Victor","Michael","Byron"};
        String nomPersonas2[] = {"Antonio","Cesar","Pablo","Adrian","Diego","Julian","Sergio","Paulo","Angel","Vicente"};
        String apePersonas1[] = {"Paredes","Romero","Cuenca","Guerrero","Garcia","Martinez","Cevallos","Lopez","Gonzales","Perez"};
        String apePersonas2[] = {"Sanchez","Ramirez","Hidalgo","Rivera","Gomez","Espinosa","Reyes","Cruz","Morales","Castro"};
        for (int i = 0; i < principal.length; i++) {
            int indAleatorioNomb1 = (int) (Math.random() * nomPersonas1.length-1) + 1;
            int indAleatorioNomb2 = (int) (Math.random() * nomPersonas2.length-1) + 1;
            int indAleatorioApe1 = (int) (Math.random() * apePersonas1.length-1) + 1;
            int indAleatorioApe2 = (int) (Math.random() * apePersonas1.length-1) + 1;
            principal[i][1] = nomPersonas1[indAleatorioNomb1] + " " + nomPersonas2[indAleatorioNomb2] + " " + apePersonas1[indAleatorioApe1] + " " + apePersonas2[indAleatorioApe2];
        }
    }
    
    public static void generaredades(String principal[][], int filas){ //generar edades de los PPL
        int edad = 0;
        for (int i = 0; i < filas; i++) {
            edad = (int) (Math.random() * 90) + 18;
            principal[i][2] = String.valueOf(edad);
        }
    }
}