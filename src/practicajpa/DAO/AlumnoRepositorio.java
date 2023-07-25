
package practicajpa.DAO;

import java.util.List;
import practicajpa.entidades.Alumno;


public class AlumnoRepositorio extends  RepositorioJPA<Alumno>{



//se llama al EntityManager y al EntityManagerFactory
    public AlumnoRepositorio() {
        super(); 
    }
   
    
    public void crearAlumno (Alumno alumno) {
        super.create(alumno);
    }
    
   public void editarAlumno (Alumno alumno) {
       //verificar si llamando al metodo se puede reciclar el finID en editar
       findId(Long.MIN_VALUE);
       super.update(alumno);
   }
    
   //IMPORTANTE, verificar si el alumno existe antes de borrar - VERIFICAR!
   public void borrarAlumno (Long id) {
       Alumno alumno = findId (id);
       super.delete(alumno);
   }
    
   public Alumno findId (Long Id) {
       super.conect();
       Alumno alumno = em.find(Alumno.class, Id);
       super.disconect();
       return alumno;
   } 
   
   //@namedquery permite separar el codigo JPa del SQl
   public List <Alumno> listarAlumnos () {
       super.conect();
       ///ver  ALumno.findAll en clase @NamedQuery, es mas ordenado que quede afuera de la clase el cod sql de JPA
       List <Alumno> alumnos = em.createQuery("Alumno.findAll", Alumno.class).getResultList();
       super.disconect();
       return alumnos;
    }
   
   //NativeQuery permite trabajar con consultas mas compleas de SQL
   public Long cantidadAlumnos () {
       super.conect();
       Long cantidad = (Long)em.createNativeQuery("SELECT COUNT (*) "
               + "FROM alumnos ").getSingleResult(); //se toma el nombre de la tabla que le di en clase alumno @Table
       return cantidad;
   }
   
   
   
   
}
