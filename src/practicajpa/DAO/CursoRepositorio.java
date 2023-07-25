 
package practicajpa.DAO;

import java.util.List;
import practicajpa.entidades.Curso;
import practicajpa.enumerados.DiaDeLaSemana;

 
public class CursoRepositorio extends RepositorioJPA<Curso> {
    
    public CursoRepositorio () {
        super();
    } 
    
    public void crear (Curso curso) {
        super.create(curso);
    }
    
    public void editar (Curso curso) {
        super.update(curso);
    }
    
    public void borrar (Long id) {
        Curso curso = findId (id);
        super.delete(curso);
    }
    
    
    public List <Curso> listarCursos () {
        super.conect();
        List<Curso> cursos = em.createNamedQuery("Curso.findAll").getResultList();
        super.disconect();
        return cursos;
    }
    
    public Curso findId (long id) {
        super.conect();
        Curso curso = em.createQuery("Curso.buscarPorId", Curso.class).setParameter("id", id).getSingleResult();
        super.disconect();
        return curso;
    }
    
    //aqui hay un solo curso con un solo nombre, no hay error a dif de las personas
    public Curso buscarPorNombre (String nombre) {
        super.conect();
        Curso curso = em.createNamedQuery("SELECT c FROM Curso c WHERE c.nombre=:nombre", Curso.class).
                setParameter("nombre", nombre).getSingleResult();
        super.disconect();
        return curso;
    }
    
    
    public List<Curso> listarCursosPorDia (DiaDeLaSemana dia) {
        super.conect();
        List <Curso> cursos = em.createQuery("SELECT c FROM Curso C WHERE c.dia=:dia", Curso.class).
                setParameter("dia", dia.toString()).getResultList();
        super.disconect();
        return cursos;
    }
    
    
}
