package negocio;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.FormaPagamento;
import bean.Pessoa;
import persistencia.FormaPagamentoDAO;
import persistencia.PessoaDAO;

@ManagedBean
@SessionScoped
public class CadastroFormaPagamentoCtrl {
	
	private FormaPagamento formaPagamento;

	private List<FormaPagamento> formaPagamentos; 
	
	
	public CadastroFormaPagamentoCtrl() {

		if (formaPagamento == null) {

			this.formaPagamento = new FormaPagamento();

		}

		formaPagamentos = FormaPagamentoDAO.consultar();

	}


	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}


	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}


	public List<FormaPagamento> getFormaPagamentos() {
		return formaPagamentos;
	}


	public void setFormaPagamentos(List<FormaPagamento> formaPagamentos) {
		this.formaPagamentos = formaPagamentos;
	}
	
	
	public void actionGravar() {

		if (formaPagamento.getId() == 0) {

			FormaPagamentoDAO.inserir(formaPagamento);
			
			limpar();

		} else {

			FormaPagamentoDAO.alterar(formaPagamento);
			
			limpar();

		}

		limpar();

	}

	public void actionEditar() {

		if (formaPagamento.getId() > 0) {

			FormaPagamentoDAO.alterar(formaPagamento);

		}

		limpar();

	}

	public void actionExcluir() {

		if (formaPagamento.getId() > 0) {

			FormaPagamentoDAO.excluir(formaPagamento);

		}

		limpar();

	}


	public void limpar() {

		this.formaPagamento = new FormaPagamento();
		
		this.formaPagamentos = FormaPagamentoDAO.consultar();

		System.out.println("limpando...");

	}
	
	

}
