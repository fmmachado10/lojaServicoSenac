package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servico")
public class Servico {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "nome", length=50, nullable=true)
	private String nome;	
	
	@Column(name = "descricao", length=50, nullable=true)
	private String descricao;
	
	@Column(name = "unidade", length=50, nullable=true)
	private String unidade;
	
	@Column(name = "valor", nullable=true)
	private Float valor;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	} 
	
	
	
	
}
