angular.module('csp.endpoints', []).constant('Endpoints', {
	base : {
		locais :{
			logradouro : {
				model : '/csp-resources/logradouro/',
				historicoCriminal : '/csp-resources/logradouro/:id/historicoCriminal'
			},
			bairro : {
				model : '/csp-resources/bairro/',
				todos : '/csp-resources/bairro/all',
				historicoCriminal : '/csp-resources/bairro/:id/historicoCriminal'
			},
			
		}
	}
	
});