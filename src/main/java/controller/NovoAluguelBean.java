package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.CarroDAO;
import dao.MotoristaDAO;
import modelo.Aluguel;
import modelo.ApoliceSeguro;
import modelo.Carro;
import modelo.Motorista;
import service.CadastroAluguelService;
import service.NegocioException;
import util.jsf.FacesMessages;

@Named
@ViewScoped
public class NovoAluguelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluguel aluguel;
	
	private List<Carro> carros;
	
	@Inject
	private CadastroAluguelService cadastroAluguelService;
	
	@Inject
	private CarroDAO carroDAO;
	
	@Inject
	private MotoristaDAO motoristaDAO;
	
	private List<Motorista> motoristas;
	
	@Inject
	private FacesMessages facesMessages;
	
	public void salvar() {
		try {
			this.cadastroAluguelService.salvar(aluguel);
			facesMessages.info("Aluguel salvo com sucesso!");
			
			this.limpar();
		} catch (NegocioException e) {
			facesMessages.error(e.getMessage());
		}
	}
	
	public void inicializar() {
		this.limpar();
		
		this.carros = this.carroDAO.buscarTodos();
		this.motoristas = this.motoristaDAO.buscarTodos();
	}
	
	public void limpar() {
		this.aluguel = new Aluguel();
		this.aluguel.setApoliceSeguro(new ApoliceSeguro());
	}

	public Aluguel getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public List<Carro> getCarros() {
		return carros;
	}
	
	public List<Motorista> getMotoristas() {
	    return motoristas;
	}

}
