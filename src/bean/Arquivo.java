package bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Arquivo {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "nomeArquivo", length=100, nullable=true)
	private String nomeArquivo;
	
	@Column(name = "sufixo", length=10, nullable=true)
	private String sufixo;
	
	@Column(name = "tipoArquivo", length=20, nullable=true)
	private String tipoArquivo;
	
	@Column(name = "caminhoArquivo", length=100, nullable=true)
	private String caminhoArquivo;
		
	public Arquivo() {
		super();
	}

	public Arquivo(String nomeArquivo, String sufixo, String tipoArquivo) {
		
		super();
		
		this.nomeArquivo = nomeArquivo;
		
		this.sufixo = sufixo;
		
		this.tipoArquivo = tipoArquivo;
		
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getSufixo() {
		return sufixo;
	}

	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	
	

}
