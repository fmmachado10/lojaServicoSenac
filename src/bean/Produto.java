package bean;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue
	@Column(name = "pro_id")
	private long id;
	
	@Column(name = "pro_nome", length=50, nullable=true)
	private String nome;
	
	@Column(name = "pro_preco", nullable=true)
	private Float preco;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "arquivo")
	private List<Arquivo> listaArquivo;
	
	public List<Arquivo> getListaArquivo() {
		return listaArquivo;
	}

	public void setListaArquivo(List<Arquivo> listaArquivo) {
		this.listaArquivo = listaArquivo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

}
