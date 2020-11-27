//González Vera Bruno 3IV8

//clase hija

public class Jugador2 extends Persona{

    //variable propia
    private String apodos;

    
    public Jugador2(){
        //constructor
    }
    
    public Jugador2(String nombre, int edad, String apodos){
        
        super(nombre, edad);
        this.apodos = apodos;
    }

    


    public String getApodos(){
        return apodos;
    }
  
    public void setApodos(String apodos){
        this.apodos = apodos;
    }
    
}