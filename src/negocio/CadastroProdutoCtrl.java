package negocio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import bean.Produto;
import persistencia.ProdutoDAO;

@ManagedBean
@SessionScoped
public class CadastroProdutoCtrl {

	private Produto produto;

	private List<Produto> produtos; // = new ArrayList<>();

	private Produto produtoSelecionado;

	private UploadedFile file;

	private String nomeDoArquivo;

	public Produto getProduto() {

		return produto;

	}

	public CadastroProdutoCtrl() {

		if (produto == null) {

			this.produto = new Produto();

		}

		produtos = ProdutoDAO.consultar();

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

	public void handleFileUpload(FileUploadEvent event) {

		System.out.println("Chamou ... ********************");

		UploadedFile file = event.getFile();

	}

	public void carregarArquivo(FileUploadEvent event) throws FileNotFoundException, IOException {

		FacesMessage msg = new FacesMessage("Sucesso " + event.getFile().getFileName() + " foi carregado.",
				event.getFile().getFileName() + " foi carregado.");

		nomeDoArquivo = event.getFile().getFileName(); // pego o nome do arquivo

		String caminho = FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("\\fotos\\" + nomeDoArquivo); // diretorio o qual vou salvar o arquivo do upload, equivale
															// ao nome completamente qualificado

		byte[] conteudo = event.getFile().getContents(); // daqui pra baixo é somente operações de IO.

		FileOutputStream fos = new FileOutputStream(caminho);

		fos.write(conteudo);

		fos.close();

	}

	public void doUpload(FileUploadEvent fileUploadEvent) { 
		
        UploadedFile uploadedFile = fileUploadEvent.getFile();  
        
        String fileNameUploaded = uploadedFile.getFileName(); 
        
        long fileSizeUploaded = uploadedFile.getSize(); 
        
        String infoAboutFile = "<br/> Arquivo recebido: <b>" + fileNameUploaded + "</b><br/>" + "Tamanho do Arquivo: <b>"+fileSizeUploaded + "</b>";
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        facesContext.addMessage(null, new FacesMessage("Sucesso", infoAboutFile));
        
	}

}
