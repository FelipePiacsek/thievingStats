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
		dataInicio.setFullYear(2014);
		
		var dataFim = new Date();
		dataFim.setFullYear(2016);
		
		var query = new Object();
//		query.dataInicio = "2014-01-01 00:00:00";
//		query.dataFim = "2016-01-01 00:00:00";
		query.dataFim = dataFim.toISOString();
		query.dataInicio = dataInicio.toISOString();
		
		console.log(query);
		
		Requests.Do(Endpoints.base.locais.logradouro.historicoCriminal.replace(":id", 3595)).get(query).$promise.then(function(response){
			console.log(response);
		}, function(promise){
			alertify.error("Erro ao carregar o histórico da minha rua.");
		});
	};
});