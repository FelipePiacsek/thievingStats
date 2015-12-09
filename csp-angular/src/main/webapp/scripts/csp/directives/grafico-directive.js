angular.module('csp').directive('graficoDirective', ['cspConstants', 'GraficoService', function (cspConstants, GraficoService){
	return {
		restrict : 'E',
		scope : {local : '=', showName : '='},
		templateUrl: cspConstants.templates.componentes.grafico,
		link : function(scope, element, attrs){
			scope.chartData = function(){
				return GraficoService.get(scope.local).valores;
			};
			
			scope.chartLabel = function(){
				return GraficoService.get(scope.local).labels;
			};
			
			
			scope.indiceCriminalidade = function(){
				return GraficoService.get(scope.local).indice.toFixed(2);
			};
			
			
			
		}
	};
}]);