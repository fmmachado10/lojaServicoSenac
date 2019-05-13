package negocio;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import bean.Pessoa;
import enumerador.EnumTipoPessoa.TipoPessoa;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class CadastroPessoaCtrl {

	private Pessoa pessoa;

	private List<Pessoa> pessoas; // = new ArrayList<>();

	private Pessoa pessoaSelecionado;

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

		} else {

			PessoaDAO.alterar(pessoa);

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

	public List<Pessoa> getPesquisar() {

		// return EquipamentoDao.pesquisar();

		return null;

	}

	public void limpar() {

		this.pessoa = new Pessoa();

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

}
