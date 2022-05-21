package br.com.luciano.testecascade.repository;

import br.com.luciano.testecascade.entity.Socio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class SocioRepository {
    
    @PersistenceContext
    private EntityManager em;
    
    public Socio findById(Integer id){
        return em.find(Socio.class, id);
    }
    
    public List<Socio> findAll(){
        
        TypedQuery<Socio> query = em.createQuery("SELECT s FROM Socio s", Socio.class);
        return query.getResultList();
    }
    
    public void save(Socio socio){
        
        em.persist(socio);
    }
    
    public Socio update(Socio socio){
        return em.merge(socio);
    }
    
    public void deleteById(Integer id){
        Socio socio = em.find(Socio.class, id);
        em.remove(socio);
    }
}
