
package practicajpa;

import practicajpa.servicios.ServiciosGenerales;

/**
 se desea modelar un sist de administración de una escuela de música. 
 * La escuela ofrece cursos de diferentes instrumentos musicales
 * y de hist de la música. C/ clase está a cargo de un profesor. 
 * A su vez, c/ prof puede dar mas de un curso. 
 * Los aumnos se inscriben en las clases y pueden tomar varias clases, pero
 * c/clase puede tener un max de 20 alumnos.
 * Del Curso se conoce el nombre, el dia de la sem que se dicta, la hr de inicio y la
 * hr de fin., ademas del cupo max de alumnos.
 * Del Prof se conoce su nombre, y su apellido
 * Del Alumno se conoce su nombre y apellido
 * @OneToMany profesor puede dar varios cursos pero un curso solo tiene
un profesor.    ---- Curso - Profesor
 * @ManyToMany alumno puede tomar varios cursos 
 * y un curso tiene varios alumnos --------- Curso - Alumno 
 * 
 * Se pide: generar el codigo de las entidades usadno JPA,
 * incluyendo : 
 * atributos y relaciones
 * uso de herencia
 * getters y setters
 * constructores
 * anotaciones
 * 
 * Hacer el crud de cada una de las entidades
 * Escribir algunas consultas a la DB con @NativeQuery , @NamedQuery y @Query
 */
public class PracticaJPA {

   
    public static void main(String[] args) {
      
        ServiciosGenerales serviciosGenerales = new ServiciosGenerales();
        
        serviciosGenerales.cargarBase();
        serviciosGenerales.consultas();
    }
    
}
