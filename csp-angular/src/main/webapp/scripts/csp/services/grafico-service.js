angular.module('csp').service('GraficoService', [function(){
	
	var graficos = {};
	
	this.get = function(local){
		return graficos[local];
	};

	this.remove = function(local){
		delete graficos[local];
	};
	
	this.add = function(local, historico){
		graficos[local] = {};
		graficos[local].labels = [];
		graficos[local].valores = [];
		graficos[local].indice = historico.indiceCriminalidade.valor;
		
		graficos[local].labels.push('Estupros');
		graficos[local].labels.push('Lesões Corporais');
		graficos[local].labels.push('Roubos');
		graficos[local].labels.push('Homicídios');
		
		graficos[local].valores.push(historico.estupros);
		graficos[local].valores.push(historico.lesoes);
		graficos[local].valores.push(historico.roubos);
		graficos[local].valores.push(historico.homicidios);
	};
	
}]);