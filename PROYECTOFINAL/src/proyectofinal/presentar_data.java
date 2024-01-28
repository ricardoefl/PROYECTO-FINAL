package proyectofinal;
//AUTOR: Ricardo Espinosa Y Juan Diego Camargo
/*
Los datos se presentan en consola bien tabulados pero algunos
no son correctos, esta es solo una maqueta para empezar a trabajar 
con archivos.
*/
import java.time.LocalDate;
import java.util.Random;
public class presentar_data {
    public static void main(String[] args) {
        int filas = 15;
        int columnas = 11;
        String [][]principal = new String [filas][columnas];
        generarCedulas(principal, filas);
        generarNombresPPL(principal, filas);
        generaredades(principal, filas);
        generarPenas(principal, filas);
        generarFechasIngreso(principal, filas);
        generarFechasSalida(principal, filas);
        generarClasificacion(principal, filas);
        generarPabellon(principal, filas);
        generarCelda(principal, filas);
        generarVisita(principal, filas);
        generardelitos(principal, filas);
        presentarData(principal, filas);
    }
    
    public static void presentarData(String principal[][], int filas){ //Presentar datos en la consola
        System.out.println("Cedula\t\t| Nombres\t\t\t\t| Edad(Anios)\t| Pena(anios)\t|Fecha(Ingreso)\t| Fecha(Salida)\t| Pabellon\t| Celda\t\t| Clasificacion\t| Visitas semanales(Horas)\t| Delito");
        for (int i = 0; i < filas; i++) {
            System.out.printf("%s\t%s\t\t%s\t\t%s\t\t%s\t%s\t%s\t\t%s\t\t%s\t\t%s\t\t\t%s\n",
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
        String nomPersonas1[] = {"Robert","Dario","Fabian","Gonzo","Carlos","Mario","Steward","Victor","Michael","Byron"};
        String nomPersonas2[] = {"Antonio","Cesar","Pablo","Adrian","Diego","Julian","Sergio","Paulo","Angel","Vicent"};
        String apePersonas1[] = {"Paredes","Romero","Cuenca","Guerrero","Garcia","Smither","Cevallos","Perero","Gonzales","Perez"};
        String apePersonas2[] = {"Sanchez","Ramirez","Hidalgo","Rivera","Gomez","Espinosa","Reyes","Roman","Morales","Castro"};
        for (int i = 0; i < principal.length; i++) {
            int indAleatorioNomb1 = (int) (Math.random() * nomPersonas1.length-1) + 1;
            int indAleatorioNomb2 = (int) (Math.random() * nomPersonas2.length-1) + 1;
            int indAleatorioApe1 = (int) (Math.random() * apePersonas1.length-1) + 1;
            int indAleatorioApe2 = (int) (Math.random() * apePersonas1.length-1) + 1;
            principal[i][1] = nomPersonas1[indAleatorioNomb1] + " " + nomPersonas2[indAleatorioNomb2] + " " + apePersonas1[indAleatorioApe1] + " " + apePersonas2[indAleatorioApe2];
        }
    }
    
    public static void generaredades(String principal[][], int filas){ //Generar edades de los PPL
        int edad = 0;
        for (int i = 0; i < filas; i++) {
            edad = (int) (Math.random() * 85) + 18;
            principal[i][2] = String.valueOf(edad);
        }
    }
    
    public static void generarPenas(String principal[][], int filas){//Generar los años de pena
        int pena = 0;
        for (int i = 0; i < filas; i++) {
            pena = (int) (Math.random() * 100) + 1;
            principal[i][3] = String.valueOf(pena);
        }
    }
    
    public static void generarFechasIngreso(String principal[][], int filas){ //Generar las fechas de ingreso de los PPL
        int dia = 0;
        int mes = 0;
        int anio = 0;
        LocalDate fechaActual = LocalDate.now();
        Random rand = new Random();
        int anioActual = fechaActual.getYear();//Obtener el año actual en string
        for (int i = 0; i < filas; i++) {
            dia = (int) (Math.random() * 31) + 1;
            mes = (int) (Math.random() * 12) + 1;
            anio = rand.nextInt(Integer.valueOf(anioActual)- 1950 + 1) + 1950;//Se transforma a entero
            principal[i][4] = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(anio);
        }
    }
    
    public static void generarFechasSalida(String principal[][], int filas){ //Generar las fechas de salida de los PPL
        int dia = 0;
        int mes = 0;
        int anio = 0;
        LocalDate fechaActual = LocalDate.now();
        Random rand = new Random();
        int anioActual = fechaActual.getYear();//Obtener el año actual en string
        for (int i = 0; i < filas; i++) {
            dia = (int) (Math.random() * 31) + 1;
            mes = (int) (Math.random() * 12) + 1;
            anio = rand.nextInt(Integer.valueOf(anioActual)- 1950 + 1) + 1950;//Se transforma a entero
            principal[i][5] = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(anio);
        }
    }
    
    public static void generarClasificacion(String principal[][], int filas){//Generar la clasificacion segun sus delitos
        String clasificacion[]={"A", "M", "B"};
        for (int i = 0; i < filas; i++) {
            int indAleatorio = (int) (Math.random() * clasificacion.length-1) + 1;
            principal[i][8] = clasificacion[indAleatorio];
        }
    }
    
    public static void generarPabellon(String principal[][], int filas){//Generar su respectivo pabellon
        String medianaPeligrosidad[] = {"2(B)","3(C)"};
        String bajaPeligrosidad[] = {"4(D)","5(E)"};
        int indAleatorio = 0;
        for (int i = 0; i < filas; i++) {
            if(principal[i][8].equals("A"))
                principal[i][6] = "1(A)";
            else if (principal[i][8].equals("M")){
                indAleatorio = (int) (Math.random() * medianaPeligrosidad.length-1) + 1;
                principal[i][6] = medianaPeligrosidad[indAleatorio];
            }else if (principal[i][8].equals("B")){
                indAleatorio = (int) (Math.random() * bajaPeligrosidad.length-1) + 1;
                principal[i][6] = bajaPeligrosidad[indAleatorio];
            }
        }
    }
    
    public static void generarCelda(String principal[][], int filas){//Generar su respectiva celda - en funcion al pabellon
        int aleatorio = 0;
        for (int i = 0; i < filas; i++) {
            aleatorio = (int) (Math.random() * 90) + 1;
            principal[i][7] = String.valueOf(aleatorio);
        }
    }
    
    public static void generarVisita(String principal[][], int filas){//Generar las horas de visita a la semana
        int aleatorio = 0;
        for (int i = 0; i < filas; i++) {
            aleatorio = (int) (Math.random() * 4) + 1;
            principal[i][9] = String.valueOf(aleatorio) + " Hora(s)";
        }
    }
    
    public static void generardelitos(String principal[][], int filas){//Generar el delito cometido
        String delitos[]={"Robo", "Extorsion", "Asesinato", "Homicidio","Narcotrafico", "Otro"};
        for (int i = 0; i < filas; i++) {
            int indAleatorio = (int) (Math.random() * delitos.length-1) + 1;
            principal[i][10] = delitos[indAleatorio];
        }
    }
}