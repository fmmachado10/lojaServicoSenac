package bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue
	@Column(name = "pro_id")
	private long id;
	
	@JoinColumn(name = "formaPagamento_id", referencedColumnName = "id")
	@OneToOne(fetch = FetchType.LAZY)
	private FormaPagamento formaPagamento;
	
	@OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
	private List<ItensPedido> itensPedidos;
	
	@Column(name = "dataEmissao", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataEmissao;
	
	@Column(name = "status", nullable = false, length = 20)
	private String status;
	
	@Column(name = "dataAutorizacao", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAutorizacao;
	
	@Column(name = "totalProduto", nullable=true)
	private Float totalProduto;
	
	@Column(name = "totalServico", nullable=true)
	private Float totalServico;
	
	@Column(name = "totalGeral", nullable=true)
	private Float totalGeral;
	
	@Column(name = "desconto", nullable=true)
	private Float desconto;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<ItensPedido> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<ItensPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}

	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}

	public Float getTotalProduto() {
		return totalProduto;
	}

	public void setTotalProduto(Float totalProduto) {
		this.totalProduto = totalProduto;
	}

	public Float getTotalServico() {
		return totalServico;
	}

	public void setTotalServico(Float totalServico) {
		this.totalServico = totalServico;
	}

	public Float getTotalGeral() {
		return totalGeral;
	}

	public void setTotalGeral(Float totalGeral) {
		this.totalGeral = totalGeral;
	}

	public Float getDesconto() {
		return desconto;
	}

	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
	

}
