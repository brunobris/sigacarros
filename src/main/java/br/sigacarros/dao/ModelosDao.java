package br.sigacarros.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.sigacarros.data.ModelosData;

@Stateless
public class ModelosDao extends GenericDao<ModelosData> {
	
	public ModelosDao() {
		super(ModelosData.class);
	}
	
	
	public void salvar(ModelosData modelosData) {
		super.save(modelosData);
	}
	
	public void atualizar(ModelosData modelosData) {
		super.update(modelosData);
	}
	
	public void excluir(Integer id) {
		 super.delete(id, ModelosData.class);
	}
	
	public ModelosData findById(Integer codigo) {
		return super.find(codigo);
	}
	
	public ModelosData findById(Integer codigo, Boolean prefetch) {
		ModelosData modelo = super.find(codigo);
		
		if (prefetch) {
			modelo.getVersoesData().size();
		}
		
		return modelo;
	}
	
	public List<ModelosData> findByName(String nome) {
		return super.findByName(nome);
	}
	
	public List<ModelosData> listar() {
		return super.findAll("select * from modelos", ModelosData.class);
	}
	
    @SuppressWarnings("unchecked")
    public List<ModelosData> findByMarca(Integer idMarca) {
        try {
            List<ModelosData> lista = getEm().createNamedQuery("findByMarca")
                     .setParameter("marcaId", idMarca).getResultList();
            return lista;
        } catch (Exception ex) {
        	ex.printStackTrace();
            return null;
        }
    }

}
