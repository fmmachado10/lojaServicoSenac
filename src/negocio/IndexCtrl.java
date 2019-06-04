package negocio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import bean.ItensPedido;
import bean.Produto;
import persistencia.ProdutoDAO;
import util.AjudanteContextoFaces;

@ManagedBean
@ViewScoped
public class IndexCtrl {

	private static final String LOCAL_HOST = "localhost";

	private static final String CAMINHO_IMAGEM_LOCALHOST = "C:\\PROJETOSSENAC\\LOJASERVICO\\lojaServicoSenac\\WebContent\\resources\\imagens";
	// private static final String CAMINHO_IMAGEM_LOCALHOST = "C:\\PROJETOS\\LOJASERVICOS\\lojaServicoSenac\\WebContent\\resources\\imagens";

	private Produto produto;

	private List<Produto> produtos; 
		
	private List<ItensPedido> itensPedidos = new ArrayList();

	public IndexCtrl() {

		if (produto == null) {

			this.produto = new Produto();

		}

		produtos = ProdutoDAO.consultar();

		produtos = buscarImagensProdutos(produtos);

	}

	public List<Produto> buscarImagensProdutos(List<Produto> produtos) {

		for (int i = 0; i < produtos.size(); i++) {

			try {

				produtos.get(i).setCaminhoImagem(buscaArquivo(produtos.get(i).getNome() + "_"));

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		return produtos;

	}

	public String obterCaminho() {

		if (getServerName().equals(LOCAL_HOST)) {

			return CAMINHO_IMAGEM_LOCALHOST;

		} else {

			ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext()
					.getContext();

			return context.getRealPath("/");

		}

	}

	public String getServerName() {

		HttpServletRequest request = (HttpServletRequest) AjudanteContextoFaces.getFacesContext().getExternalContext()
				.getRequest();

		return request.getServerName();

	}

	public String buscaArquivo(String palavra) {

		File file = new File(CAMINHO_IMAGEM_LOCALHOST);

		File afile[] = file.listFiles();

		int i = 0;

		for (int j = afile.length; i < j; i++) {

			if (afile[i].getName().startsWith(palavra)) {

				return afile[i].getName();

			}
		}

		return "";

	}

	public List<Produto> getProdutos() {

		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {

		this.produtos = produtos;

	}
	
	public void adicionarCarrinho(Produto p) {

		if (p.getId() > 0) {

			ItensPedido itemPedido = new ItensPedido();
			
			itemPedido.setProduto(p);
			
			itemPedido.setQuantidade(1);
			
			itemPedido.setValorUnitario(p.getPreco());
			
			itemPedido.setSubTotal(p.getPreco());
			
			itensPedidos.add(itemPedido);
						
		} 

	}
	
	public void mostrarCarrinho() {
		System.out.println("Itens no Carrinho: " + getItensPedidos());
	}
	
	public void finalizarCompra() {
		
		
		
		
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<ItensPedido> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<ItensPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}

	

}
