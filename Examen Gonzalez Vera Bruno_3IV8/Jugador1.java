//González Vera Bruno

//aqui hay herencia y encapsulamiento 
//clase hija

public class Jugador1 extends Persona{

    //private int intentos;

    //metodo para acceder a la clase principal y al ladrido
    public Jugador1(){

    }

    public Jugador1(String nombre, int edad){
        
        super(nombre, edad);

        //acceso a la variable propia de la clase
        
        //esto fue lo que se me olvido ponerlo con diagonales:
        //this.intentos = intentos;
    }

    //metodos get y set para establecer y obtener
    /*
    public int getIntentos(){
        return intentos;
    }
    //envia u establecer
    public void setIntentos(int intentos){
        this.intentos = intentos;
    }
    */                                
}