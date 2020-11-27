//González Vera Bruno 3IV8

//importacion de librerias correspondientes y mas
import java.util.*;

//clase juego
public class Juego{

    public Juego(){
        //Constructor
    }

    //metodo mas importante
    public static void juego(){

        //objeto scanner
        Scanner entrada = new Scanner(System.in);

        //creacion de un objeto para invocar un metodo
        Datos datos = new Datos();

        //invocacion del metodo que pide los datos 
        datos.Datos();

        //intento fallido de craer objetos para invocar los metodos
        //de las clases hijas

        //Jugador1 obj1 = new Jugador1();
        //Jugador2 obj2 = new Jugador2();

        //varible que indica fin del juego
        boolean Terminado = false;
        
        //variable para los intentos
        int inte = 3;

        //variable para continuar jugando
        char continuar;

        //Mas intentos fallidos

        //System.out.println("Turno de "+obj2.getApodos());
        
        //estructura del juego
        do{
            
            String palabra = getPalabraSecreta();
            char[] palabraGuiones = getGuiones(palabra);

            //Otra falla

            //System.out.println("Turno de "+obj2.getNombre());
    
            do{
                System.out.println("Tienes "+inte+" intentos");

                System.out.println(palabraGuiones);

                System.out.println("Introduce una letra:");
                char letra = entrada.next().charAt(0);

                boolean letraAcertada = false;
                
                for(int i = 0; i<palabra.length(); i++){
                    if(palabra.charAt(i) == letra){
                        palabraGuiones[i] = letra;
                        letraAcertada = true;
                    }
                }

                if(!letraAcertada){
                    System.out.println("No has acertado ninguna letra");
                    --inte;

                    if(inte == 0){
                        System.out.println("Has perdido el juego\nLa palabra secreta era: "+palabra);
                        Terminado = true;
                    }
                }else{
                    boolean Ganado = !hayGuones(palabraGuiones);

                    if(Ganado){
                    System.out.println("Has ganado el juego\nLa palabra secreta era: "+palabra);
                    Terminado = true;
                    }   
                } 

            }while(!Terminado);

            //Pregunta para continuar el juego
            
            System.out.println("Deseas continuar jugando?");
            System.out.println("1.- SI");
            System.out.println("2.- NO");
            continuar = entrada.next().charAt(0);

        }while(continuar =='1');

        //Para salir del programa:

        entrada.close();
    }

    //metodo que pregunta la palabra
    
    public static String getPalabraSecreta(){

        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingresa la(s) palabra(s)\nEn caso de ser mas de una palabra, remplaza los espacios con guiones medios");
        String palabra = entrada.next();

        return palabra;
    }

    //metodo que sirve para determinar si he adivinado la palabra
    
    public static boolean hayGuones(char[] a){
        for(char l:a){
            if(l =='_')return true;
        }
        return false;
    }

    //metodo para transformar la palabra en guiones bajos
    
    public static char[] getGuiones(String palabra){
        int nLetras = palabra.length();

        char[] palabraGuiones = new char[nLetras];

        for(int i = 0; i<palabraGuiones.length; i++){
            palabraGuiones[i] = '_';
        }
        return palabraGuiones;
    }   
}

//fin
