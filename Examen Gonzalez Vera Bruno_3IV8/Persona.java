

//González Vera Bruno 3IV8
//clase padre persona

public class Persona{

    //variables propias de la clase
    private String nombre;
    private int edad;

    public Persona(){
        //constructor
    }
    
    public Persona(String nombre, int edad){

        this.nombre = nombre;
        this.edad = edad;
    }

    
    //getters y setters

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getEdad(){
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }
}