package br.com.puc.tcc.csp.model.crimes;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "tb_estupros")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Estupro extends Ocorrencia {

}
