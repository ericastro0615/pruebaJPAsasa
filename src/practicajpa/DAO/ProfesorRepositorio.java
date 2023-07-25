 
package practicajpa.DAO;

import java.util.List;
import practicajpa.entidades.Profesor;

 
public class ProfesorRepositorio extends RepositorioJPA<Profesor>{

    public ProfesorRepositorio() {
        super();
    }
    
    
    public void crear(Profesor profesor) {
        super.create(profesor);
    }
    
    public void editar (Profesor profesor) {
        super.update(profesor);
    }
    
    public void borrar (Long id) {
        Profesor profesor = em.find(Profesor.class, id);
        super.delete(profesor);
    }
    
    
    public List <Profesor> listarProfesores () {
        super.conect();
        List<Profesor> profList = em.createNamedQuery("Profesor.buscarTodos").getResultList();
        super.disconect();
        return profList;
    }
    
   public Profesor findId (Long id){
       super.conect(); ///       ↖↖↖↖     el obj al que se hace referencia en setParameter es el argumento del metodo         ↘↘↘
       Profesor profesorQuery = em.createNamedQuery("Profesor.buscarPorId", Profesor.class).
               setParameter("id", id).getSingleResult(); 
       super.disconect();                           /// el 1° id de (⬆⬆⬆) setParameter hace referencia a Profesor.buscarID ⬆⬆
       return profesorQuery;
   }  
        
// aqui, si hay varios nombres con el mismo prof con el mismo nombre, NO sirve 
public List <Profesor> buscarPorNombre (String nombre) {
    super.conect();
    //Se debe retornar una lista y no obj, para que haya varios resultados  y luego filtrar por nombre
     List<Profesor> profList = em.createQuery("SELECT p FROM Profesor p WHERE p.nombre = :nombre", Profesor.class).
                    setParameter("nombre",nombre).getResultList();     //estos puntos ⬆ significan seteo //estos puntos ⬆ significan seteo
    super.disconect();
    return profList;
        
}   
           
           
           
 }
