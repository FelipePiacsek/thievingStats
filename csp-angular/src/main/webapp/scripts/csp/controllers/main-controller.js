angular.module('csp').controller('MainController', function ($scope, Endpoints, Requests) {

	
	var initController = function(){
	};
	initController();

	var getBairros = function(){
		Requests.Do(Endpoints.base.locais.bairro.todos).get().$promise.then(function(response){
			console.log(response);
		}, function(promise){
			alertify.error("Erro ao listar os bairros.");
		});
	};
	
	$scope.teste = function(){
		//yyyy-mm-dd hh:mm:ss
		var dataInicio = new Date();
		dataInicio.setFullYear(2011);
		
		var dataFim = new Date();
		dataFim.setFullYear(2016);
		
		var query = new Object();
//		query.dataInicio = "2014-01-01 00:00:00";
//		query.dataFim = "2016-01-01 00:00:00";
		query.dataFim = dataFim.toISOString();
		query.dataInicio = dataInicio.toISOString();
		
		console.log(query);
		
		Requests.Do(Endpoints.base.locais.cidade.historicoCriminal.replace(":id", 1)).get(query).$promise.then(function(response){
			historico = response.objects[0];
			historico.dataInicio = new Date(historico.dataInicio);
			historico.dataFim = new Date(historico.dataFim);
			console.log(historico);
		}, function(promise){
			alertify.error("Erro ao carregar o histórico da minha rua.");
		});
	};
	
	$scope.cadastrar = function(){
		var usuario = new Object();
		usuario.nome = "Felipe";
		usuario.sobrenome = "Piacsek";
		usuario.email = "felipe..piacsek@fdte.org.br";
		usuario.residencia = new Object();
		usuario.residencia.cep = "04111000";
		console.log(usuario);
		Requests.Do(Endpoints.base.usuario.cadastro).post(usuario).$promise.then(function(response){
			alertify.success("Usuário cadastrado com sucesso!");
		}, function(promise){
			for(i=0;i<promise.data.objects.length;i++){
				alertify.error(promise.data.objects[i]);
			}
		});
	};
});