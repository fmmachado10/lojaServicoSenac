package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="itensPedido")
public class ItensPedido {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@JoinColumn(name = "pedido_id")
	@ManyToOne(optional = false)
	private Pedido pedido;
	
	@JoinColumn(name = "produto_id", referencedColumnName = "pro_id")
	@OneToOne(fetch = FetchType.LAZY)
	private Produto produto;
	
	@JoinColumn(name = "servico_id", referencedColumnName = "id")
	@OneToOne(fetch = FetchType.LAZY)
	private Servico servico;
	
	@Column(name = "quantidade", nullable=true)
	private float quantidade;
	
	@Column(name = "valorUnitario", nullable=true)
	private float valorUnitario;
	
	@Column(name = "subTotal", nullable=true)
	private float subTotal;
	
	@Override
	public String toString() {
		return "ItensPedido [id=" + id + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario
				+ ", subTotal=" + subTotal + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	
	

}
