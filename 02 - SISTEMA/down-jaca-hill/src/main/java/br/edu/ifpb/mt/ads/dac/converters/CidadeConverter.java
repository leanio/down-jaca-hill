package br.edu.ifpb.mt.ads.dac.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.edu.ifpb.mt.ads.dac.model.Cidade;
import br.edu.ifpb.mt.ads.dac.services.CidadeService;
import br.edu.ifpb.mt.ads.dac.services.ServiceDacException;

@FacesConverter(forClass = Cidade.class)
public class CidadeConverter implements Converter<Cidade> {

	@Inject
	private CidadeService CidadeService;

	@Override
	public Cidade getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}

		try {
			Long codigo = Long.parseLong(value);
			return CidadeService.buscarPeloCodigo(codigo);
		} catch (ServiceDacException | NumberFormatException e) {
			String msgErroStr = String.format(
					"Erro de conversão! Não foi possível realizar a conversão da string '%s' para o tipo esperado.",
					value);
			FacesMessage msgErro = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);
			throw new ConverterException(msgErro);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Cidade value) {
		if (!(value instanceof Cidade)) {
			return null;
		}
		
		Long id = ((Cidade) value).getCodigo();
		return (id != null) ? id.toString() : null;
	}

}
