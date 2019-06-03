package bean;

public class Arquivo {
	
	private String nomeArquivo;	
			
	private String caminhoArquivo;		
		
	public Arquivo() {
		super();
	}

	public Arquivo(String nomeArquivo) {
		
		super();
		
		this.nomeArquivo = nomeArquivo;
				
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	
	

}