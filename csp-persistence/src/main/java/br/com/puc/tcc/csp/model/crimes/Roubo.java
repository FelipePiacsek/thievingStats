package br.com.puc.tcc.csp.model.crimes;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "tb_roubos")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Roubo extends Ocorrencia{

}
