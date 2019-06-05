package negocio;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import bean.FormaPagamento;
import bean.ItensPedido;
import bean.Pedido;
import bean.Pessoa;
import bean.Produto;
import persistencia.FormaPagamentoDAO;
import persistencia.PedidoDAO;
import persistencia.PessoaDAO;
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
	
	private int total;
	
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

		HttpServletRequest request = (HttpServletRequest) AjudanteContextoFaces.getFacesContext().getExternalContext().getRequest();

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
			
			itemPedido.setServico(null);
			
			itemPedido.setQuantidade(1);
			
			itemPedido.setValorUnitario(p.getPreco());
			
			itemPedido.setSubTotal(p.getPreco());
			
			itensPedidos.add(itemPedido);
			
			total += p.getPreco();
						
		} 

	}
	
	public void mostrarCarrinho() {
		
		System.out.println("Itens no Carrinho: " + getItensPedidos());
		
	}
	
	public void finalizarCompra() {
		
		System.out.println("Finalizando compra...");
		
		Pedido pedido = new Pedido();
		
		FormaPagamento formaPagamento = new FormaPagamento();
		formaPagamento = FormaPagamentoDAO.buscarFormaPagamentoPadrao();
		
		pedido.setFormaPagamento(formaPagamento);
		pedido.setDataAutorizacao(new Date());
		pedido.setDataEmissao(new Date());
		pedido.setDesconto((float) 0);
		pedido.setStatus("Aguardando pagamento");
		pedido.setTotalGeral((float) getTotal());
		pedido.setTotalProduto((float) getTotal());
		pedido.setTotalServico((float) 0);
		pedido.setItensPedidos(getItensPedidos());
		
		actionGravarPedido(pedido);
		
		System.out.println("Compra finalizada!");
		
	}	
	
	
	public void actionGravarPedido(Pedido pedido) {

		if (pedido.getId() == 0) {

			PedidoDAO.inserir(pedido);
			
			limpar();

		} else {

			PedidoDAO.alterar(pedido);
			
			limpar();

		}

		limpar();

	}
	
	public void limpar() {
		
		setItensPedidos(new ArrayList());

		System.out.println("limpando...");

	}


	public String getTotalString() {
		
		return "Total: " + getTotal();
		
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	

}
