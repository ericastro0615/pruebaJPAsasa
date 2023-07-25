
package practicajpa.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

 @MappedSuperclass 
 //asi esta clase no se incluye en la DB pero SI sus atributos
public abstract class Persona {
     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
     //se da el nombre a la columna y ademas la cant de caracteres permitidos
     @Column(name = "nombre",length = 20, nullable = false)
     private String nombre;
    
     @Column(name = "nombre",length = 20, nullable = false)
    private String apellido;

      //no se genera el constructor con el ID PROQUE SE genera a traves de la DB
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
// de ID solo getter, ya que no quiero modificarlo a traves de java
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Persona: " + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido ;
    }
    
    
      
    
}
