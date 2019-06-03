package negocio;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Produto;
import persistencia.ProdutoDAO;

@ManagedBean
@SessionScoped
public class CarrinhoCtrl {
	
	private List<Produto> produtos; 
	
	
/*	
	public CarrinhoCtrl() {

		if (produto == null) {

			this.produto = new Produto();

		}

		produtos = ProdutoDAO.consultar();

	}
*/		
	
	
	public Produto getProduto(long id) {
		
		Produto ap = null;
		
		for (Produto p: produtos) {	
			
			if (p.getId() == id) {
				
				return p;
			}	
			
		}
		
		return ap;
		
	}
	
	/*
	public void adiciona(Produto p) {
		
		if (getProduto(p.getId()) == null) {
			
			produtos.add(p);
		}else {
			p.setQuantidadeCarrinho(p.carrinho() + 1);
		}
	
	}
	
*/
	
	
}
