package bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ItensPedido {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	
	private Pedido pedido;
	
	
	
	private Produto produto;
	
	private Servico servico;
	
	@Column(name = "quantidade", length=50, nullable=true)
	private int quantidade;
	
	private int valorUnitario;
	
	private int subTotal;
	
	

}
