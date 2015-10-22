var cspApp = angular.module('csp',
  [
   'csp.endpoints',
   'ui.router',
   'ui.bootstrap',
   'ngStorage',
   'ngResource'
  ]).constant('cspConstants',{
		templates: {
			componentes : {
				main : "views/components/main.html"
			},
  			modais : {
  				cadastro: 'views/modals/cadastro-modal.html'
  			}
		}
}).config(function($stateProvider, $urlRouterProvider, cspConstants) {
	// States
	$stateProvider
	.state('csp', {
		name: 'csp',
		abstract: true,
		url: 'csp',
		template: "<div ui-view></div>"
	}).state('csp.main',{
		name: 'csp.main',
		url: 'csp/visualização',
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

