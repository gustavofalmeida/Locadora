package service;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import dao.FabricanteDAO;
import modelo.Fabricante;
import util.jpa.Transactional;

public class CadastroFabricanteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private FabricanteDAO fabricanteDAO;
	
	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		if (StringUtils.isEmpty(fabricante.getNome())) { 
			throw new NegocioException("O nome do fabricante é obrigatório");
		}
		
		this.fabricanteDAO.salvar(fabricante);
	}
	
}
