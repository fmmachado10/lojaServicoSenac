package util;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AjudanteContextoFaces {

	public static FacesContext getFacesContext() {

		return FacesContext.getCurrentInstance();

	}

	public static Map<String, Object> getRequestMap() {

		return getFacesContext().getExternalContext().getRequestMap();

	}

	public static Map<String, Object> getSessionMap() {

		return getFacesContext().getExternalContext().getSessionMap();

	}

	public static HttpSession getSessao() {

		HttpServletRequest request = (HttpServletRequest) getFacesContext().getExternalContext().getRequest();

		return request.getSession();

	}

}
