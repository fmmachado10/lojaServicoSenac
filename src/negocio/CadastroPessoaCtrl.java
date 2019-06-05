package negocio;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import bean.Pessoa;
import enumerador.EnumTipoPessoa.TipoPessoa;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class CadastroPessoaCtrl {

	private Pessoa pessoa;

	private List<Pessoa> pessoas; // = new ArrayList<>();

	private Pessoa pessoaSelecionado;

	@SuppressWarnings("unused")
	private TipoPessoa tipoPessoa;

	public Pessoa getPessoa() {

		return pessoa;

	}

	public CadastroPessoaCtrl() {

		if (pessoa == null) {

			this.pessoa = new Pessoa();

		}

		pessoas = PessoaDAO.consultar();

	}

	public void setPessoa(Pessoa pessoa) {

		this.pessoa = pessoa;

	}

	public void actionGravar() {

		if (pessoa.getId() == 0) {

			PessoaDAO.inserir(pessoa);
			
			FacesMessage message = new FacesMessage("Pessoa adicionada.");
			FacesContext.getCurrentInstance().addMessage(null, message);
			
			limpar();

		} else {

			PessoaDAO.alterar(pessoa);
			
			limpar();

		}

		limpar();

	}

	public void actionEditar() {

		if (pessoa.getId() > 0) {

			PessoaDAO.alterar(pessoa);

		}

		limpar();

	}

	public void actionExcluir() {

		if (pessoa.getId() > 0) {

			PessoaDAO.excluir(pessoa);

		}

		limpar();

	}


	public void limpar() {

		this.pessoa = new Pessoa();
		
		setTipoPessoa(null);

		this.pessoas = PessoaDAO.consultar();

		System.out.println("limpando...");

	}

	public void aoSelecionar() {

		this.pessoa = pessoaSelecionado;

	}

	public void aoDesselecionar() {

		limpar();

	}

	public List<Pessoa> getPessoas() {

		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {

		this.pessoas = pessoas;

	}

	public Pessoa getPessoaSelecionado() {

		return pessoaSelecionado;

	}

	public void setPessoaSelecionado(Pessoa pessoaSelecionado) {

		this.pessoaSelecionado = pessoaSelecionado;

	}

	public TipoPessoa[] getTipoPessoa() {

		return TipoPessoa.values();

	}
	
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		
		this.tipoPessoa = tipoPessoa;
		
	}

	
}
