var cspApp = angular.module('csp',
  [
   'csp.endpoints',
   'ui.router',
   'ui.bootstrap',
   'chart.js',
   'ngResource'
  ]).constant('cspConstants',{
		templates: {
			componentes : {
				main : "views/components/main.html",
				grafico : "views/components/grafico.html"
				
			},
  			modais : {
  				cadastro: 'views/components/modals/cadastro-modal.html'
  			}
		}
}).config(function($stateProvider, $urlRouterProvider, cspConstants) {
	// States
	$stateProvider
	.state('csp', {
		name: 'csp',
		abstract: true,
		url: '/criminalidade',
		template: "<div ui-view></div>"
	}).state('csp.main',{
		name: 'csp.main',
		url: '/visualizar',
		templateUrl: cspConstants.templates.componentes.main,
	});
});

cspApp.run(function ($rootScope, $state) {
	$state.go("csp.main");
	$rootScope.$on('$stateChangeStart', function (event, toState, toParams) {

	});
	
	$rootScope.is = function(name) {
		return $state.is(name);
	}
	$rootScope.includes = function(name) {
		return $state.includes(name);
	}
  
});

