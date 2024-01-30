package proyectofinal;
//AUTOR: Ricardo Espinosa Y Juan Diego Camargo
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;
public class presentar_data {
    public static void main(String[] args) {
        int filas = 32;
        int columnas = 12;
        String [][]principal = new String [filas][columnas];
        generarCedulas(principal, filas);//0
        generarNombresPPL(principal, filas);//1
        generarClasificacion(principal, filas);//9
        generarFechasIngreso(principal, filas);//4
        generaredades(principal, filas);//2
        generarPenas(principal, filas);//3
        generarFechasSalida(principal, filas);//5
        generarAniosRestantes(principal, filas);//6
        generarPabellon(principal, filas);//7
        generarCelda(principal, filas);//8
        generarVisita(principal, filas);//10
        generardelitos(principal, filas);//11
        guardarEnCSV(principal, filas, "datosCarcel.csv");
    }
    
    
    public static void guardarEnCSV(String[][] principal, int filas, String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezados
            writer.write("Cedula; Nombres; Edad(Anios); Pena(anios); Fecha(Ingreso)(d/m/a); Fecha(Salida)(d/m/a); Anios Restantes; Pabellon; Celda; Clasificacion; Visitas semanales(Horas); Delito\n");

            // Escribir datos
            for (int i = 0; i < filas; i++) {
                writer.write(String.format("%s; %s; %s; %s; %s; %s; %s; %s; %s; %s; %s; %s\n",
                        principal[i][0], principal[i][1], principal[i][2], principal[i][3], principal[i][4], principal[i][5],
                        principal[i][6], principal[i][7], principal[i][8], principal[i][9], principal[i][10], principal[i][11]));
            }

            System.out.println("Datos guardados correctamente en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
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
        String nomPersonas1[] = {"Roberto","Dario","Fabian","Gonzalo","Carlos","Mario","Pedro","Victor","Michael","Byron"};
        String nomPersonas2[] = {"Antonio","Cesar","Pablo","Adrian","Diego","Julian","Sergio","Paulo","Angel","Vicente"};
        String apePersonas1[] = {"Paredes","Romero","Cuenca","Guerrero","Garcia","Torres","Cevallos","Perero","Gonzales","Perez"};
        String apePersonas2[] = {"Sanchez","Ramirez","Hidalgo","Rivera","Gomez","Espinosa","Reyes","Roman","Morales","Castro"};
        for (int i = 0; i < principal.length; i++) {
            int indAleatorioNomb1 = (int) (Math.random() * nomPersonas1.length-1) + 0;
            int indAleatorioNomb2 = (int) (Math.random() * nomPersonas2.length-1) + 0;
            int indAleatorioApe1 = (int) (Math.random() * apePersonas1.length-1) + 0;
            int indAleatorioApe2 = (int) (Math.random() * apePersonas1.length-1) + 0;
            principal[i][1] = nomPersonas1[indAleatorioNomb1] + " " + nomPersonas2[indAleatorioNomb2] + " " + apePersonas1[indAleatorioApe1] + " " + apePersonas2[indAleatorioApe2];
        }
    }
    
    public static void generaredades(String principal[][], int filas){ //Generar edades de los PPL
        int edad = 0;
        int anioActual = 0;
        LocalDate fechaActual = LocalDate.now();
        anioActual = fechaActual.getYear();
        String anioIngresoAux = null;
        int anioIngreso = 0;
        int resto = 0;
        Random rand = new Random();
        for (int i = 0; i < filas; i++) {
            edad = rand.nextInt(60- 18 + 1) + 18;
            anioIngresoAux = principal[i][4].substring(6);
            anioIngreso = Integer.valueOf(anioIngresoAux);
            resto = anioActual - anioIngreso;
            if(edad <= (resto+18))
                edad = (resto+18) + (int) (Math.random() * 5-1) + 1;
            principal[i][2] = String.valueOf(edad);
        }
    }
    
    public static void generarPenas(String principal[][], int filas){//Generar los años de pena
        int pena = 0;
        int AnioIngreso = 0;
        int resto = 0;
        String AnioIngresoaux = null;
        LocalDate fechaActual = LocalDate.now();
        int AnioActual = fechaActual.getYear();
        for (int i = 0; i < filas; i++) {
            pena = (int) (Math.random() * 30) + 1;//Pena maxima en Ecuador es 50 años
            AnioIngresoaux = principal[i][4].substring(6);//String
            AnioIngreso = Integer.valueOf(AnioIngresoaux);//Entero
            resto = AnioActual - AnioIngreso;
            if(pena <= resto)//Nunca van a salir penas incoherentes 
                pena = resto + (int) (Math.random() * 5) + 2;
            
            principal[i][3] = String.valueOf(pena);
        }
    }
    
    public static void generarFechasIngreso(String principal[][], int filas){ //Generar las fechas de ingreso de los PPL
        int dia = 0;
        int mes = 0;
        int anio = 0;
        LocalDate fechaActual = LocalDate.now();
        Random rand = new Random();
        int anioActual = fechaActual.getYear();
        for (int i = 0; i < filas; i++) {
            dia = (int) (Math.random() * 31) + 1;
            mes = (int) (Math.random() * 12) + 1;
            anio = rand.nextInt(Integer.valueOf(anioActual)- 1985 + 1) + 1980;
            if((dia < 10)&&(mes < 10))
                principal[i][4] = "0" + String.valueOf(dia) + "/0" + String.valueOf(mes) + "/" + String.valueOf(anio);
            else if(dia < 10)
                principal[i][4] = "0" + String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(anio);
            else if(mes < 10)
                principal[i][4] = String.valueOf(dia) + "/0" + String.valueOf(mes) + "/" + String.valueOf(anio);
            else
                principal[i][4] = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(anio);
        }
    }
    
    public static void generarFechasSalida(String principal[][], int filas){ //Generar las fechas de salida de los PPL
        String dia = null;
        String mes = null;
        String anioIngreso = null;
        String pena = null;
        int anioSalida = 0;
        for (int i = 0; i < filas; i++) {
            dia = principal[i][4].substring(0, 2);
            mes = principal[i][4].substring(3, 5);
            anioIngreso = principal[i][4].substring(6);
            pena = principal[i][3].substring(0);
            anioSalida = Integer.valueOf(anioIngreso)+Integer.valueOf(pena);
            principal[i][5] = dia + "/" + mes + "/" + String.valueOf(anioSalida);
        }
    }
    
    public static void generarAniosRestantes(String principal[][], int filas){
        String aniosalida = null;
        int anioActual = 0;
        LocalDate fechaActual = LocalDate.now();
        anioActual = fechaActual.getYear();
        int aniosRestantes = 0;
        for (int i = 0; i < filas; i++) {
            aniosalida = principal[i][5].substring(6);
            aniosRestantes = Integer.valueOf(aniosalida) - anioActual;
            principal[i][6] = String.valueOf(aniosRestantes);
        }
    }
    
    public static void generarClasificacion(String principal[][], int filas){//Generar la clasificacion segun sus delitos
        Random rand = new Random();
        int indAleatorio = 0;
        String clasificacion[]={"A", "M", "B"};
        for (int i = 0; i < filas; i++) {
            indAleatorio = rand.nextInt(Integer.valueOf(clasificacion.length-1)- 0 + 1) + 0;
            principal[i][9] = clasificacion[indAleatorio];
        }
    }
    
    public static void generarPabellon(String principal[][], int filas){//Generar su respectivo pabellon
        String medianaPeligrosidad[] = {"2(B)","3(C)"};
        String bajaPeligrosidad[] = {"4(D)","5(E)"};
        int indAleatorio = 0;
        for (int i = 0; i < filas; i++) {
            if(principal[i][9].equals("A"))
                principal[i][7] = "1(A)";
            else if (principal[i][9].equals("M")){
                indAleatorio = (int) (Math.random() * medianaPeligrosidad.length-1) + 1;
                principal[i][7] = medianaPeligrosidad[indAleatorio];
            }else if (principal[i][9].equals("B")){
                indAleatorio = (int) (Math.random() * bajaPeligrosidad.length-1) + 1;
                principal[i][7] = bajaPeligrosidad[indAleatorio];
            }
        }
    }
    
    public static void generarCelda(String principal[][], int filas){//Generar su respectiva celda - en funcion al pabellon
        int aleatorio = 0;
        for (int i = 0; i < filas; i++) {
            aleatorio = (int) (Math.random() * 90) + 1;
            principal[i][8] = String.valueOf(aleatorio);
        }
    }
    
    public static void generarVisita(String principal[][], int filas){//Generar las horas de visita a la semana
        int horas = 0;
        for (int i = 0; i < filas; i++) {
            if(principal[i][9].equals("A"))//Las horas van de acuerdo a la clasificacion
                horas = 1;
            else if(principal[i][9].equals("M"))
                horas = 2;
            else if(principal[i][9].equals("B"))
                horas = 4;
            principal[i][10] = String.valueOf(horas) + " Hora(s)";
        }
    }
    
    public static void generardelitos(String principal[][], int filas){//Generar el delito cometido
        int indAleatorio = 0;
        String delitosA[]={"Narcotrafico", "Homicidio"};
        String delitosM[]={"Robo", "Hurto", "Fraude", "Evacion de Impuestos"};
        String delitosB[]={"Invacion de Propiedad Privada", "Escandalo Publico", "Estafa", "Otros"};
        for (int i = 0; i < filas; i++) {
            if(principal[i][9].equals("A")){
                indAleatorio = (int) (Math.random() * delitosA.length-1) + 0;
                principal[i][11] = delitosA[indAleatorio];
            }else if(principal[i][9].equals("M")){
                indAleatorio = (int) (Math.random() * delitosM.length-1) + 0;
                principal[i][11] = delitosM[indAleatorio];
            }else if(principal[i][9].equals("B")){
                indAleatorio = (int) (Math.random() * delitosB.length-1) + 0;
                principal[i][11] = delitosB[indAleatorio];
            }
        }
    }
}