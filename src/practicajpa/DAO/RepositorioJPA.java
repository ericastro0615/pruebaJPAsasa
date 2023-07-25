
package practicajpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class RepositorioJPA<T> {

    protected EntityManagerFactory emf;
    protected EntityManager em;

    public RepositorioJPA() {
        emf = Persistence.createEntityManagerFactory(("practicaJPAPU"));
        em = emf.createEntityManager();
    }

    protected void conect() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

    protected void disconect() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void create(T object) {
        conect();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        disconect();
    }

    protected void update(T object) {
        conect();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        disconect();
    }

    protected void delete(T object) {
        conect();
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
        disconect();
    }

    
}
