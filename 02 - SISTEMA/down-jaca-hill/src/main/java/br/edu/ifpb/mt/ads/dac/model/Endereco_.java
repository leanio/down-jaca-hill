package br.edu.ifpb.mt.ads.dac.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Endereco.class)
public abstract class Endereco_ extends br.edu.ifpb.mt.ads.dac.model.EntidadePersistente_ {

	public static volatile SingularAttribute<Endereco, Cidade> cidade;
	public static volatile SingularAttribute<Endereco, String> complemento;
	public static volatile SingularAttribute<Endereco, Integer> numero;
	public static volatile SingularAttribute<Endereco, String> bairro;
	public static volatile SingularAttribute<Endereco, String> rua;

	public static final String CIDADE = "cidade";
	public static final String COMPLEMENTO = "complemento";
	public static final String NUMERO = "numero";
	public static final String BAIRRO = "bairro";
	public static final String RUA = "rua";

}

