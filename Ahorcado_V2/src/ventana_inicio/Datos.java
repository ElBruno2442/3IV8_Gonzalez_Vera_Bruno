
//González Vera Bruno 3IV8
//Repositorio de GitHub:
//https://github.com/ElBruno2442/3IV8_Gonzalez_Vera_Bruno

package ventana_inicio;

/**
 *
 * @author BRUNO
 */

/*
En esta clase se encuentan las variables quue
  servirian para la creacion del Arraylist
*/
public class Datos {
    
    //Las variables para el Nombre, Edad y Score
    private String nombre;
    private String edad;
    private String score;
    
    //El constructor junto a los Getters y Setters
    public Datos() {
    }

    public Datos(String edad, String nombre, String score) {
        
        this.nombre = nombre;
        this.edad = edad;
        this.score = score;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }    
       
}
