package proyectofinal;
//AUTOR: Ricardo Espinosa Y Juan Diego Camargo
import java.awt.Desktop;
import java.util.*;
import java.io.*;
public class controlCarcelaria {
    public static void main(String[] args) {
        String archivoPrincipal = "datosCarcel.csv", archivoInfo = "informacionCarcel.txt", contraseña = null;
        int filas = 801, columnas = 13, opcion = 0, seguir = 0;
        Scanner tc = new Scanner(System.in);
        String [][] principal = new String [filas][columnas];
        do{
            System.out.println(opcionesInicio());
            opcion = tc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("ABRIENDO ARCHIVO...");
                    abrirArchivoInfo(archivoInfo);
                    break;
                case 2:
                    System.out.println(opcionesBaseDatos());
                    opcion = tc.nextInt();
                    switch(opcion){
                        case 1:
                            System.out.println("ABRIENDO ARCHIVO...");
                            abrirArchivoCompleto(archivoPrincipal);
                            break;
                        case 2:
                            System.out.println(opcionesDatosPabellones());
                            opcion = tc.nextInt();
                            switch(opcion){
                                case 1:
                                    System.out.println("Pabellon 1");
                                    break;
                                case 2:
                                    System.out.println("Pabellon 2");
                                    break;
                                case 3:
                                    System.out.println("Pabellon 3");
                                    break;
                                case 4:
                                    System.out.println("Pabellon 4");
                                    break;
                                case 5:
                                    System.out.println("Pabellon 5");
                                    break;
                                default:
                                    System.out.println("Opcion incorrecta");
                            }
                            break;
                        default:
                            System.out.println("Opcion incorrecta");
                    }
                    break;
                case 3:
                    System.out.println(opcionesBuscarPPL());
                    opcion = tc.nextInt();
                    switch(opcion){
                        case 1:
                            System.out.println("Ingresa la identificacion del PPL");
                            break;
                        case 2:
                            System.out.println("Ingresa la celda");
                            break;
                        default:
                            System.out.println("Opcion incorrecta");
                    }
                    break;
                case 4:
                    System.out.println("ESTADISTICAS DE LA CARCEL:");
                    break;
                case 5:
                    do{
                        System.out.println("Ingrese la clave de acceso (12345)");
                        contraseña = tc.next();
                        if(contraseña.equals("12345")){
                            System.out.println("ACCESO EXITOSO");
                            System.out.println(opcionesAdministracion());
                            opcion = tc.nextInt();
                            switch(opcion){
                                case 1:
                                    System.out.println("Celdas disponibles");
                                    break;
                                case 2:
                                    System.out.println(opcionesCastigos());
                                    opcion = tc.nextInt();
                                    switch(opcion){
                                        case 1:
                                            System.out.println("Disminuir horas de visita");
                                            break;
                                        case 2:
                                            System.out.println("Aumentar pena");
                                            break;
                                        default:
                                            System.out.println("Opcion Incorrecta");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Ingrese la identificacion del PPl a trasladar");
                                    break;
                                default:
                                    System.out.println("Opcion incorrecta");
                            }
                    }else
                        System.out.println("Clave de acceso incorrecta");
                    }
                    while(!contraseña.equals("12345"));
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    
            }
            System.out.println("DESEA CONTINUAR CON EL PROGRAMA?([1]SI/[2]NO)");
            seguir = tc.nextInt();
            if(seguir == 2)
                System.out.println("GRACIAS POR USAR ESTE PROGRAMA");
        }while(seguir == 1);
    }
    
    //Cadenas para presentar listas de opciones
    public static String opcionesInicio(){
        String cadena = "SISTEMA DE CONTROL CARCELARIA\n"
                        + "Ingrese el numero correspondiente a la opcion deseada\n"
                        + "[1] -> Ver informacion de la carcel\n"
                        + "[2] -> Ingresar a la base de datos\n"
                        + "[3] -> Buscar PPL\n"
                        + "[4] -> Observar estadisticas\n"
                        + "[5] -> Administracion (SOLO PERSONAL AUTORIZADO)";
        return cadena;
    }
    public static String opcionesBaseDatos(){
        String cadena = "Ingrese el numero correspondiente a la opcion deseada\n"
                        + "[1] -> Ver la base de datos completa\n"
                        + "[2] -> Ver la base de datos distribuida por pabellones";
        return cadena;
    }
    public static String opcionesDatosPabellones(){
        String cadena = "Ingrese el numero correspondiente al pabellon que desea verificar\n"
                        + "[1] -> Pabellon 1\n"
                        + "[2] -> Pabellon 2\n"
                        + "[3] -> Pabellon 3\n"
                        + "[4] -> Pabellon 4\n"
                        + "[5] -> Pabellon 5";
        return cadena;
    }
    public static String opcionesBuscarPPL(){
        String cadena = "Ingrese el numero correspondiente a la opcion deseada\n"
                        + "[1] -> Buscar PPl por su identificacion\n"
                        + "[2] -> Buscar PPls por su celda";
        return cadena;
    }
    public static String opcionesAdministracion(){
        String cadena = "Ingrese el numero correspondiente a la opcion deseada\n"
                        + "[1] -> Consultar celdas disponibles\n"
                        + "[2] -> Castigar PPLs\n"
                        + "[3] -> Trasladar PPL";
        return cadena;
    }
    public static String opcionesCastigos(){
        String cadena = "Ingrese el numero correspondiente a la opcion deseada\n"
                        + "[1] -> Disminuir horas de visita\n"
                        + "[2] -> Aumentar pena";
        return cadena;
    }
    
    public static void leercsv(String[][] principal, String archivoPrincipal){
        try {
            int i = 0;
            Scanner l = new Scanner(new File(archivoPrincipal));
            while(l.hasNext()){
                String []arreglo = l.nextLine().split(";");
                principal[i][0] = arreglo[0];
                principal[i][1] = arreglo[1];
                principal[i][2] = arreglo[2];
                principal[i][3] = arreglo[3];
                principal[i][4] = arreglo[4];
                principal[i][5] = arreglo[5];
                principal[i][6] = arreglo[6];
                principal[i][7] = arreglo[7];
                principal[i][8] = arreglo[8];
                principal[i][9] = arreglo[9];
                principal[i][10] = arreglo[10];
                principal[i][11] = arreglo[11];
                principal[i][12] = arreglo[12];
                i++;
            }
            l.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }  
    }
    
    public static void abrirArchivoInfo(String archivoInfo){
        // Ruta
        String rutaArchivo = System.getProperty("user.dir") + File.separator + archivoInfo;
        try {
            abrirArchivos(rutaArchivo);
            System.out.println("Puedes visualizar la informacion en el archivo "+archivoInfo);
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo CSV: " + e.getMessage());
        }
    }
    
    public static void abrirArchivoCompleto(String archivoPrincipal) {
        // Ruta
        String rutaArchivo = System.getProperty("user.dir") + File.separator + archivoPrincipal;
        try {
            abrirArchivos(rutaArchivo);
            System.out.println("Puedes visualizar la informacion en el archivo "+archivoPrincipal);
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo CSV: " + e.getMessage());
        }
    }
    
    private static void abrirArchivos(String rutaArchivo) throws IOException {
        File archivoCSV = new File(rutaArchivo);

        // Verificar si Desktop es compatible
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            // Verificar si el archivo existe antes de intentar abrirlo
            if (archivoCSV.exists()) {
                desktop.open(archivoCSV);//Abrir archivo
            } else {
                System.out.println("El archivo CSV no existe en la ruta especificada.");
            }
        } else {
            System.out.println("La apertura de archivos no es compatible en este sistema.");
        }
    }
}