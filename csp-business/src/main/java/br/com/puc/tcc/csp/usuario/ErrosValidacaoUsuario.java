package br.com.puc.tcc.csp.usuario;

public enum ErrosValidacaoUsuario {

	USUARIO_REPETIDO("Usuário já cadastrado no sistema."),  CADASTRO_INCOMPLETO("Preencha todas as informações."), RESIDENCIA_NAO_ENCONTRADA("O cep informado não corresponde a nenhum local cadastrado na base de dados.");
	
	private String mensagemDeErro;
	
	ErrosValidacaoUsuario(String mensagem){
		this.mensagemDeErro = mensagem;
	}

	public String getMensagemDeErro() {
		return mensagemDeErro;
	}

}
