
//González Vera Bruno 3IV8

import java.util.Scanner;

//clase datos

public class Datos{

    //metodo que se encarga de pedir todos los datos de los jugadores
    public static void Datos(){
        
        Scanner entrada = new Scanner(System.in);
        Jugador1 obj1 = new Jugador1();
        Jugador2 obj2 = new Jugador2();

        String nom,apodos;
        int edad, intentos;
        int y = 0;

        //aqui se obtienen los valores de las variables de las clases hijas
        
        System.out.println("Ingresa el nombre del Jugador 1(El Jugador 1 decidira la(s) palabra(s))");
        nom = entrada.nextLine();
        obj1.setNombre(nom);

        System.out.println("Ingresa el nombre del Jugador 2(El que va a jugar)");
        nom = entrada.nextLine();
        obj2.setNombre(nom);

        System.out.println("Ahora, "+obj2.getNombre()+ " decidira el apodo de "+obj1.getNombre());

        System.out.println("El apodo de "+obj1.getNombre()+" sera:");
        apodos = entrada.nextLine();
        obj2.setApodos(apodos);
        
        /*System.out.println("Ahora "+obj2.getApodos()+ " decidira la cantidad de intentos que tendra "
        +obj2.getNombre());

        System.out.println("Los intentos seran:");
        intentos = entrada.nextInt();
        obj1.setIntentos(intentos);*/

        //try catch
        //solo acepta valores enteros para la edad
        
        while(true){
            
        try { 
            
            System.out.println("Ingresa la edad de "+obj2.getApodos());
            edad = entrada.nextInt();
            obj1.setEdad(edad);


        }catch (Exception e) {
                System.out.println("Ingresa solo valores enteros");
                System.out.println("Error: "+ e.getMessage());
                System.exit(0);
            }
        
        try { 
            
            System.out.println("Ingresa la edad de "+obj2.getNombre());
            edad = entrada.nextInt();
            obj2.setEdad(edad);
            break;
            
        }catch (Exception e) {
                    System.out.println("Ingresa solo valores enteros");
                    System.out.println("Error: "+ e.getMessage());
                    System.exit(0);

            }
        }
    }
}
            
