angular.module('csp').controller('CadastroModalController', function ($scope, Endpoints, Requests) {

	
	var initController = function(){
		$scope.usuario = new Object();
		$scope.usuario.nome = "";
		$scope.usuario.sobrenome = "";
		$scope.usuario.email = "";
		$scope.usuario.residencia = new Object();
		$scope.usuario.residencia.cep = "";
	};
	initController();

	
	$scope.cadastrar = function(){
		console.log($scope.usuario);
		Requests.Do(Endpoints.base.usuario.cadastro).post($scope.usuario).$promise.then(function(response){
			alertify.success("Usuário cadastrado com sucesso!");
		}, function(promise){
			for(i=0;i<promise.data.objects.length;i++){
				alertify.error(promise.data.objects[i]);
			}
		});
	};
});