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
			zona : {
				model : '/csp-resources/zona/',
				todos : '/csp-resources/zona/all',
				historicoCriminal : '/csp-resources/zona/:id/historicoCriminal'
			},
			cidade : {
				model : '/csp-resources/cidade/',
				todos : '/csp-resources/cidade/all',
				historicoCriminal : '/csp-resources/cidade/:id/historicoCriminal'
			}
			
		},
		usuario : {
			cadastro : '/csp-resources/usuario/'
		}
	}
	
});