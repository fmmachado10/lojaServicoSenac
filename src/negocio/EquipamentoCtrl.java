package negocio;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bean.Equipamento;
import persistencia.EquipamentoDAO;


@ManagedBean
@SessionScoped
public class EquipamentoCtrl {

	private final String PAG_LISTA = "lista_equipamento";
	private final String PAG_FORM = "form_equipamento";
	
	private bean.Equipamento equipamento;

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	public String actionGravar() {
		if (equipamento.getId() == 0) {
			EquipamentoDAO.inserir(equipamento);
			return actionInserir();
		}
		else {
			EquipamentoDAO.alterar(equipamento);
			return PAG_LISTA;
		}
	}
	
	public String actionInserir() {
		equipamento = new Equipamento();
		return PAG_FORM;
	}
	
	public String actionAlterar(Equipamento eqp) {
		equipamento = eqp;
		return PAG_FORM;
	}

	public String actionExcluir(Equipamento eqp) {
		EquipamentoDAO.excluir(eqp);
		return PAG_LISTA;
	}
	
//	public List<Equipamento> getPesquisar() {
//		return EquipamentoDAO.pesquisar();
//	}
	
}
