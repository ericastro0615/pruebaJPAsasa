
package practicajpa.entidades;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


//namedQueries engloba TODAS las query
@NamedQueries ({
    @NamedQuery (
        name = "Profesor.buscarTodos",
        query = "SELECT p FROM Profesor P"
),

@NamedQuery (
        name = "Profesor.buscarPorId",
        query = "SELECT p FROM Profesor p WHERE p.id= :id"
)
    
})



 @Entity
 @Table (name="profesores")
public class Profesor extends Persona{
@OneToMany (mappedBy = "profesor")
private Set<Curso>cursos ;

    public Profesor() {
    }

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }



}
