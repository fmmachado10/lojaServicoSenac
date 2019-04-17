package negocio;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Servico;
import persistencia.ServicoDAO;

@ManagedBean
@SessionScoped
public class CadastroServicoCtrl {

	private Servico servico;

	private List<Servico> servicos; // = new ArrayList<>();

	private Servico servicoSelecionado;

	public Servico getServico() {

		return servico;

	}

	public CadastroServicoCtrl() {

		if (servico == null) {

			this.servico = new Servico();

		}

		servicos = ServicoDAO.consultar();

	}

	public void setEquipamento(Servico servico) {

		this.servico = servico;

	}

	public void actionGravar() {

		if (servico.getId() == 0) {

			ServicoDAO.inserir(servico);

		} else {

			ServicoDAO.alterar(servico);

		}

		limpar();

	}

	public void actionEditar() {

		if (servico.getId() > 0) {

			ServicoDAO.alterar(servico);

		}

		limpar();

	}

	public void actionExcluir() {

		if (servico.getId() > 0) {

			ServicoDAO.excluir(servico);

		}

		limpar();

	}

	
	public List<Servico> getPesquisar() {

		// return EquipamentoDao.pesquisar();

		return null;

	}

	public void limpar() {

		this.servico = new Servico();

		this.servicos = ServicoDAO.consultar();

		System.out.println("limpando...");

	}

	public void aoSelecionar() {

		this.servico = servicoSelecionado;

	}

	public void aoDesselecionar() {

		limpar();

	}

	public List<Servico> getServicos() {

		return servicos;
	}

	public void setServicos(List<Servico> servicos) {

		this.servicos = servicos;

	}

	public Servico getServicoSelecionado() {

		return servicoSelecionado;

	}

	public void setServicoSelecionado(Servico servicoSelecionado) {

		this.servicoSelecionado = servicoSelecionado;

	}

}
