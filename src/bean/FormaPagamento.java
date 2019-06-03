package bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class FormaPagamento {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "descricao", length=50, nullable=true)
	private String descricao;
	
	@Column(name = "numMaxParcelas", nullable=true)
	private int numMaxParcelas;
	
	@Column(name = "numPadraoParcelas", nullable=true)
	private int numPadraoParcelas;
	
	@Column(name = "intervalDias", nullable=true)
	private int intervalDias;
	
	@Column(name = "percentualAcrescimo", nullable=true)
	private float percentualAcrescimo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNumMaxParcelas() {
		return numMaxParcelas;
	}

	public void setNumMaxParcelas(int numMaxParcelas) {
		this.numMaxParcelas = numMaxParcelas;
	}

	public int getNumPadraoParcelas() {
		return numPadraoParcelas;
	}

	public void setNumPadraoParcelas(int numPadraoParcelas) {
		this.numPadraoParcelas = numPadraoParcelas;
	}

	public int getIntervalDias() {
		return intervalDias;
	}

	public void setIntervalDias(int intervalDias) {
		this.intervalDias = intervalDias;
	}

	public float getPercentualAcrescimo() {
		return percentualAcrescimo;
	}

	public void setPercentualAcrescimo(float percentualAcrescimo) {
		this.percentualAcrescimo = percentualAcrescimo;
	}
	
	

}
