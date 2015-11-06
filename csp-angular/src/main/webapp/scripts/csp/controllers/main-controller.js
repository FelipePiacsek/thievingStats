angular.module('csp').controller('MainController', function ($scope, Endpoints, Requests) {

	

	var getBairros = function(){
		Requests.Do(Endpoints.base.locais.bairro.todos).get().$promise.then(function(response){
			console.log(response);
		}, function(promise){
			alertify.error("Erro ao listar os bairros.");
		});
	};
	
	var adicionarGrafico = function(historico, local){
		$scope.dadosGraficos[local] = new Object();
		$scope.dadosGraficos[local].labels = [];
		$scope.dadosGraficos[local].valores = [];
		
		$scope.dadosGraficos[local].labels.push('Estupros');
		$scope.dadosGraficos[local].labels.push('Lesões Corporais');
		$scope.dadosGraficos[local].labels.push('Roubos');
		$scope.dadosGraficos[local].labels.push('Homicídios');
		
		$scope.dadosGraficos[local].valores.push(historico.estupros);
		$scope.dadosGraficos[local].valores.push(historico.lesoes);
		$scope.dadosGraficos[local].valores.push(historico.roubos);
		$scope.dadosGraficos[local].valores.push(historico.homicidios);
		console.log("Grafico da cidade adicionado.");
		console.log($scope.dadosGraficos);
	};
	
	var initController = function(){
		var dataInicio = new Date();
		dataInicio.setFullYear(2011);
		
		var dataFim = new Date();
		dataFim.setFullYear(2016);
		
		var query = new Object();
		query.dataFim = dataFim.toISOString();
		query.dataInicio = dataInicio.toISOString();
		$scope.dadosGraficos = new Object();
		Requests.Do(Endpoints.base.locais.cidade.historicoCriminal.replace(":id", 1)).get(query).$promise.then(function(response){
			historico = response.objects[0];
			historico.dataInicio = new Date(historico.dataInicio);
			historico.dataFim = new Date(historico.dataFim);
			adicionarGrafico(historico, 'CIDADE');
		}, function(promise){
			alertify.error("Erro ao carregar o histórico da minha rua.");
		});
	};
	initController();
	
	
});