angular.module('csp').controller('MainController', function ($scope, Endpoints, Requests, GraficoService) {

	var loadModels = function(endpoint, model){
		Requests.Do(endpoint).get().$promise.then(function(response){
			console.log(response);
			$scope[model] = response.objects;
		}, function(promise){
			alertify.error("Erro no carregamento de opções.");
		});
		
	};
	
	var loadBairros = function(){
		loadModels(Endpoints.base.locais.bairro.todos, 'bairrosDisponiveis');
	};
	
	var loadZonas = function(){
		loadModels(Endpoints.base.locais.zona.todos, 'zonasDisponiveis');
	};
	
	var requestHistorico = function(endpoint, local, query){
		Requests.Do(endpoint).get(query).$promise.then(function(response){
			historico = response.objects[0];
			historico.dataInicio = new Date(historico.dataInicio);
			historico.dataFim = new Date(historico.dataFim);
			$scope.historicos[local] = historico;
			GraficoService.add(historico.local.nome, historico);
		}, function(promise){
			alertify.error("Erro ao carregar o histórico.");
		});
	}
	
	var initController = function(){
		var dataInicio = new Date();
		dataInicio.setFullYear(2011);
		var dataFim = new Date();
		dataFim.setFullYear(2016);
		var query = new Object();
		query.dataFim = dataFim.toISOString();
		query.dataInicio = dataInicio.toISOString();
		$scope.historicos = {};
		loadZonas();
		loadBairros();
		requestHistorico(Endpoints.base.locais.cidade.historicoCriminal.replace(":id", 1), 'CIDADE', query);
	};
	initController();
	
	var getHistorico = function(endpoint, local){
		var dataInicio = new Date();
		dataInicio.setFullYear(2011);
		var dataFim = new Date();
		dataFim.setFullYear(2016);
		var query = new Object();
		query.dataFim = dataFim.toISOString();
		query.dataInicio = dataInicio.toISOString(); //Montar data de acordo com o que vier da tela.
		requestHistorico(endpoint, local, query);
	};
	
	$scope.getHistoricoZona = function(){
		getHistorico(Endpoints.base.locais.zona.historicoCriminal.replace(":id", $scope.selectedZona.id), 'ZONA');
	};
	
	$scope.getHistoricoBairro = function(){
		getHistorico(Endpoints.base.locais.bairro.historicoCriminal.replace(":id", $scope.selectedBairro.id), 'BAIRRO');
	};
	
	$scope.getHistoricoLogradouro = function(){
		Requests.Do(Endpoints.base.locais.logradouro.model + $scope.cepLogradouro).get().$promise.then(function(response){
			if(response.objects){
				getHistorico(Endpoints.base.locais.logradouro.historicoCriminal.replace(":id", response.objects[0].id), 'LOGRADOURO');
			}else{
				alertify.error("O logradouro com o cep " + $scope.cepLogradouro + " não está cadastrado no sistema.");
			}
		}, function(promise){
			alertify.error("Erro ao carregar o histórico.");
		});
	};
	
});