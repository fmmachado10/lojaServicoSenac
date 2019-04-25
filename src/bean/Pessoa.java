package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import enumerador.EnumTipoPessoa;
import enumerador.EnumTipoPessoa.TipoPessoa;

@Entity
@Table(name="pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue
	@Column(name = "pes_id")
	private long id;
	
	@Column(name = "pes_nome", length=50, nullable=true)
	private String nome;	
	
	@Column(name = "pes_cpf", length=50, nullable=true)
	private String cpf;
		
	@Column(name = "pes_rg", length=50, nullable=true)
	private String rg;
	
	@Column(name = "pes_rua", length=50, nullable=true)
	private String rua;
	
	@Column(name = "pes_bairro", length=50, nullable=true)
	private String bairro;
	
	@Column(name = "pes_cidade", length=50, nullable=true)
	private String cidade;
	
	@Column(name = "pes_uf", length=50, nullable=true)
	private String uf;
	
	@Column(name = "pes_cep", length=50, nullable=true)
	private Integer cep;
	
	@Column(name = "pes_email", length=50, nullable=true)
	private String email;
	
	@Column(name = "pes_senha", length=50, nullable=true)
	private String senha;

	@Column(name = "pes_tipo", length=30, nullable=true)
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipoPessoa;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	
}
