package negocio;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Produto;
import persistencia.ProdutoDAO;



@ManagedBean
@SessionScoped
@WebServlet("/ProdutoCtrl")
public class ProdutoCtrl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Produto produto = new Produto();

		//produto.setId(Long.parseLong(request.getParameter("id").toString()));
		produto.setNome(request.getParameter("nome"));
		produto.setPreco(Float.parseFloat(request.getParameter("preco")));
				
		if (request.getParameter("submit").equals("submit_Buscar") ) {
			
			//buscar(produto);
			//response.getWriter().println("Buscado com sucesso.");
			
		} else if (request.getParameter("submit").equals("submit_Cadastrar")) {
			
			actionGravar(produto);
			response.getWriter().println("Cadastrado com sucesso.");
			
		} else if (request.getParameter("submit").equals("submit_Excluir")) {
			
			//excluir(produto);
			//response.getWriter().println("Excluído com sucesso.");
			
		}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

		System.out.println("método doPost...");

	}
	
	
	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListagem() {
		
		return ProdutoDAO.listagem("");
				
	}
	
	public String actionGravar(Produto produto) {
		if (produto.getId() == 0) {
			
			ProdutoDAO.inserir(produto);
			return "";
		}
		else {
			ProdutoDAO.alterar(produto);
			return "lista_produto";
		}
	}
	
	
}
