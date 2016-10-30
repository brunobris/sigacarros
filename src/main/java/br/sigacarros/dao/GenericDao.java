package br.sigacarros.dao;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao<T> {
	
	private final static String UNIT_NAME = "sigacarrosbase-unit";
	
	@PersistenceContext(unitName = UNIT_NAME)
    private EntityManager em;
	private Class<T> classeEntidade;
	
	public GenericDao(Class<T> classeEntidade) {
        this.classeEntidade = classeEntidade;
    }
	
	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void save(T entity) {
        em.persist(entity);
    }
 

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
    protected void delete(Object id, Class<T> classe) {
        T removida = em.getReference(classe, id);
 
        em.remove(removida);
    }
 
    public T update(T entidade) {
        return em.merge(entidade);
    }
    
    public T find(int entidadeID) {
        return em.find(classeEntidade, entidadeID);
    }
    
    @SuppressWarnings("unchecked")
	protected List<T> findAll(String sql, Class type) {
    	return this.em.createNativeQuery(sql, type).getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<T> findByName(String nome) {
    	List<T> lista = em.createNamedQuery("findByName")
    				 .setParameter("nomeModelo", nome).getResultList();
    	
    	return lista;
    }

    @SuppressWarnings("unchecked")
    protected List<T> findByMarca(Integer idMarca) {
        try {
            List<T> lista = em.createNamedQuery("findByMarca")
                     .setParameter("marcaId", idMarca).getResultList();
            return lista;
        } catch (Exception ex) {
        	ex.printStackTrace();
            return null;
        }
    }
    
 
}
