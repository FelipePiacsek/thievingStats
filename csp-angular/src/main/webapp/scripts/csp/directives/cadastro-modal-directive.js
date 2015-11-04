angular.module('csp').directive('cadastroModal', ['cspConstants', function (cspConstants){
	return {
		restrict : 'E',
		templateUrl: cspConstants.templates.modais.cadastro
	};
}]);