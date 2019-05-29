package negocio;

import java.util.List;

import bean.Produto;
import persistencia.ProdutoDAO;

public class IndexCtrl {
	
	private Produto produto;
	
	private List<Produto> produtos; // = new ArrayList<>();
	
	public IndexCtrl() {

		if (produto == null) {

			this.produto = new Produto();

		}

		produtos = ProdutoDAO.consultar();

	}

}
