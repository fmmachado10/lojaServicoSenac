package negocio;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Produto;
import persistencia.ProdutoDAO;

@ManagedBean
@SessionScoped
public class CadastroProdutoCtrl {

	private final String PAG_LISTA = "listaProduto";
	private final String PAG_FORM = "cadastroProduto";
	
	private Produto produto;

	public Produto getProduto() {
		return produto;
	}
	
	public CadastroProdutoCtrl() {		
		this.produto = new Produto();
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
	
	public void limpar(){
        this.produto = new Produto();
        System.out.println("limpando...");        
    }
	
	
}
