package bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Pedido {
	
	private long id;
	
	private FormaPagamento formaPagamento;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pedido_id")
	private List<ItensPedido> itensPedidos;
	
	
	
	

}
