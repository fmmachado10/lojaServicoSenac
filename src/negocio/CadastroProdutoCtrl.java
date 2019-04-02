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
	
	private List<Produto> produtos; // = new ArrayList<>();
	
    private Produto produtoSelecionado;

	public Produto getProduto() {
		
		return produto;
		
	}

	public CadastroProdutoCtrl() {
		
		if (produto == null) {
			
			this.produto = new Produto();
			
		}

	}

	public void setEquipamento(Produto produto) {
		
		this.produto = produto;
		
	}

	public void actionGravar() {
		
		if (produto.getId() == 0) {
			
			ProdutoDAO.inserir(produto);
			
		} else {
			
			ProdutoDAO.alterar(produto);
			
		}
		
	}

	/*
	 * public void actionGravar() { if (produto.getId() == 0) {
	 * ProdutoDAO.inserir(produto); } else { ProdutoDAO.alterar(produto); } }
	 */

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
		// return EquipamentoDao.pesquisar();
		return null;
	}

	public void limpar() {
		
		this.produto = new Produto();
		
		this.produtos = ProdutoDAO.consultar();
		
		System.out.println("limpando...");
		
	}
	
	
	public void aoSelecionar(){
		
        this.produto = produtoSelecionado;
        
    }

    public void aoDesselecionar(){
    	
        limpar();
        
    }

    public List<Produto> getProdutos() {
    	
        return produtos;
    }
    
    public void setProdutos(List<Produto> produtos) {
    	
        this.produtos = produtos;
        
    }

    public Produto getProdutoSelecionado() {
    	
        return produtoSelecionado;
        
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
    	
        this.produtoSelecionado = produtoSelecionado;
        
    }

}
