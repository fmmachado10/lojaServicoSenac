package negocio;

import java.util.List;

import bean.Produto;
import persistencia.ProdutoDAO;

public class CadastroProdutoCtrl {

	private final String PAG_LISTA = "lista_equipamento";
	private final String PAG_FORM = "cadastroProduto";
	
	private Produto produto;

	public Produto getProduto() {
		return produto;
	}

	public void setEquipamento(Produto produto) {
		this.produto = produto;
	}
	
	public String actionGravar() {
		if (produto.getId() == 0) {
			ProdutoDAO.inserir(produto);
			return actionInserir();
		}
		else {
			ProdutoDAO.alterar(produto);
			return PAG_LISTA;
		}
	}
	
	public String actionInserir() {
		produto = new Produto();
		return PAG_FORM;
	}
	
	public String actionAlterar(Produto eqp) {
		produto = eqp;
		return PAG_FORM;
	}

	public String actionExcluir(Produto eqp) {
		ProdutoDAO.excluir(eqp);
		return PAG_LISTA;
	}
	
	public List<Produto> getPesquisar() {
		//return EquipamentoDao.pesquisar();
		return null;
	}
	
	
}
