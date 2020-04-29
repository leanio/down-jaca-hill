package br.edu.ifpb.mt.ads.dac.converters;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.edu.ifpb.mt.ads.dac.model.Pessoa;
import br.edu.ifpb.mt.ads.dac.services.PessoaService;
import br.edu.ifpb.mt.ads.dac.services.ServiceDacException;

@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter<Pessoa> {

	@Inject
	private PessoaService pessoaService;

	@Override
	public Pessoa getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().isEmpty()) {
			return null;
		}

		try {
			Long codigo = Long.parseLong(value);
			return pessoaService.buscarPeloCodigo(codigo);
		} catch (ServiceDacException | NumberFormatException e) {
			String msgErroStr = String.format(
					"Erro de conversão! Não foi possível realizar a conversão da string '%s' para o tipo esperado.",
					value);
			FacesMessage msgErro = new FacesMessage(FacesMessage.SEVERITY_ERROR, msgErroStr, msgErroStr);
			throw new ConverterException(msgErro);
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Pessoa value) {
		if (!(value instanceof Pessoa)) {
			return null;
		}
		
		Long id = ((Pessoa) value).getCodigo();
		return (id != null) ? id.toString() : null;
	}

}
