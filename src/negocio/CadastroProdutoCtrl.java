package negocio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import bean.Arquivo;
import bean.Produto;
import persistencia.ProdutoDAO;
import util.AjudanteContextoFaces;

@ManagedBean
@SessionScoped
public class CadastroProdutoCtrl {
	
	private static final int BUFFER_SIZE = 6124;
	
	private static final String LOCAL_HOST = "localhost";
	
	private static final String CAMINHO_IMAGEM_LOCALHOST = "C:\\PROJETOS\\LOJASERVICOS\\lojaServicoSenac\\WebContent\\resources\\imagens\\";
	
	//private static final String CAMINHO_IMAGEM_LOCALHOST = "C:\\PROJETOSSENAC\\LOJASERVICO\\lojaServicoSenac\\WebContent\\resources\\imagens\\";
	
	private static final String CAMINHO_IMAGEM = "C:\\PROJETOS\\LOJASERVICOS\\lojaServicoSenac\\WebContent\\resources\\imagens\\";

	private Produto produto;

	private List<Produto> produtos; 

	private Produto produtoSelecionado;

	private UploadedFile file;

	private String nomeDoArquivo;
	
	private String tipoArquivo;
	
	private List<SelectItem> lstTipoArquivo;
	
	private List<Arquivo> listaArquivo;

	public Produto getProduto() {

		return produto;

	}

	public CadastroProdutoCtrl() {

		if (produto == null) {

			this.produto = new Produto();

		}

		produtos = ProdutoDAO.consultar();

	}
	

	public void actionGravar() {

		if (produto.getId() == 0) {
			
			ProdutoDAO.inserir(produto);
			
		} else {

			ProdutoDAO.alterar(produto);

		}

		limpar();

	}

	public void actionEditar() {

		if (produto.getId() > 0) {

			ProdutoDAO.alterar(produto);

		}

		limpar();

	}

	public void actionExcluir() {

		if (produto.getId() > 0) {

			ProdutoDAO.excluir(produto);

		}

		limpar();

	}

	public void limpar() {

		this.produto = new Produto();

		this.produtos = ProdutoDAO.consultar();
		
		setListaArquivo(new ArrayList<Arquivo>());
	
		System.out.println("limpando...");

	}

	public void aoSelecionar() {

		this.produto = produtoSelecionado;

	}

	public void aoDesselecionar() {

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

	public UploadedFile getFile() {

		return file;

	}

	public void setFile(UploadedFile file) {

		this.file = file;

	}	
	
	public String getNomeDoArquivo() {
		
		return nomeDoArquivo;
		
	}

	public void setNomeDoArquivo(String nomeDoArquivo) {
		
		this.nomeDoArquivo = nomeDoArquivo;
		
	}

	public String getTipoArquivo() {
		
		return tipoArquivo;
		
	}

	public void setTipoArquivo(String tipoArquivo) {
		
		this.tipoArquivo = tipoArquivo;
		
	}

	public void setLstTipoArquivo(List<SelectItem> lstTipoArquivo) {
		
		this.lstTipoArquivo = lstTipoArquivo;
		
	}
	
	public List<Arquivo> getLstArquivosSelecao() {
		
		if (listaArquivo == null) {
			
			listaArquivo = new ArrayList<Arquivo>();
			
		}
		
		return listaArquivo;
		
	}
	
	public List<SelectItem> getLstTipoArquivo() {
		
		if (lstTipoArquivo == null) {
			
			lstTipoArquivo = new ArrayList<SelectItem>();
			
			lstTipoArquivo.add(new SelectItem(null, "Selecione um Tipo de Arquivo"));
			
		}
		
		return lstTipoArquivo;
		
	}	

	public List<Arquivo> getListaArquivo() {
		
		return listaArquivo;
		
	}

	public void setListaArquivo(List<Arquivo> listaArquivo) {
		this.listaArquivo = listaArquivo;
	}
	
	public void uploadArquivoSelecao(FileUploadEvent fileUploadEvent) { 
		
		File fileDestination = null;
		
		String caminhoArquivo = "";
		
		String nomeArquivo = "";
		
		Calendar calendar = Calendar.getInstance();

		String extensaoArquivo = fileUploadEvent.getFile().getFileName().substring(fileUploadEvent.getFile().getFileName().lastIndexOf('.'));
		
		String nomeDoProduto = getProduto().getNome();
		
		nomeDoProduto = nomeDoProduto.replace(" ", "") + "_"; 
		
		String nomeArquivoFileUploadEvent = nomeDoProduto +  fileUploadEvent.getFile().getFileName().substring(0, fileUploadEvent.getFile().getFileName().indexOf('.')) + "_" + calendar.getTimeInMillis();

		try {
			
			nomeArquivo = (new String(nomeArquivoFileUploadEvent.getBytes(), "ISO-8859-1")); 
			
		} catch (UnsupportedEncodingException e1) {
			
			e1.printStackTrace();
			
		}

		if (getServerName().equals(LOCAL_HOST)) {
			
			caminhoArquivo = CAMINHO_IMAGEM_LOCALHOST;
			
			fileDestination = new File(CAMINHO_IMAGEM_LOCALHOST);
			
		} else {
			
			caminhoArquivo = CAMINHO_IMAGEM;
			
			fileDestination = new File(CAMINHO_IMAGEM);
			
		}

		if (caminhoArquivo != null && !caminhoArquivo.equals("")) {
			
			caminhoArquivo = caminhoArquivo + nomeArquivo + extensaoArquivo;
			
		}

		System.out.println(caminhoArquivo);

		if (!fileDestination.exists()) {
			
			fileDestination.mkdir();
			
		}

		Arquivo arquivo = new Arquivo();	
		
		arquivo.setNomeArquivo(nomeArquivoFileUploadEvent);	
		
		arquivo.setCaminhoArquivo(caminhoArquivo);

		File result = new File(caminhoArquivo);

		try {
			FileOutputStream fileOutputStream = new FileOutputStream(result);

			byte[] buffer = new byte[BUFFER_SIZE];

			int bulk;
			
			InputStream inputStream = fileUploadEvent.getFile().getInputstream();
			
			while (true) {
				
				bulk = inputStream.read(buffer);
				
				if (bulk < 0) {
					
					break;
					
				}
				
				fileOutputStream.write(buffer, 0, bulk);
				
				fileOutputStream.flush();
			}

			fileOutputStream.close();
			
			inputStream.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}

		getLstArquivosSelecao().add(arquivo);
		
		
		/*
		for (SelectItem i : lstTipoArquivo) {
			if (i.getValue() != null && i.getValue().equals(getTipoArquivo())) {
				lstTipoArquivo.remove(i);
				setTipoArquivo(null);
				break;
			}
		}
		*/
		
	}
	
	public String getServerName() {
		
		HttpServletRequest request = (HttpServletRequest) AjudanteContextoFaces.getFacesContext().getExternalContext().getRequest();
		
		return request.getServerName();
		
	}
	


}
