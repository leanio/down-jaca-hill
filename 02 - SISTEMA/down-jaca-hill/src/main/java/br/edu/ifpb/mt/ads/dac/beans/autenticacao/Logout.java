package br.edu.ifpb.mt.ads.dac.beans.autenticacao;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.mt.ads.dac.beans.AbstractBean;

@Named
@RequestScoped
public class Logout extends AbstractBean {

	private static final long serialVersionUID = -7437667367775973347L;

	public static void efetuarLogout() throws IOException, ServletException {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.invalidate();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		request.logout();
		
		ec.redirect(request.getContextPath());
	}

}
