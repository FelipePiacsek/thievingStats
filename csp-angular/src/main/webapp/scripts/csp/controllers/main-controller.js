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
		Requests.Do(Endpoints.base.locais.logradouro.model + "04111000").get().$promise.then(function(response){
			console.log(response);
		}, function(promise){
			alertify.error("Erro ao listar os bairros.");
		});
	};
});