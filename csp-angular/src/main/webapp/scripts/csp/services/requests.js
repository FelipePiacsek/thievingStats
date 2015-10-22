/**
 * Serviço genérico para requests.
 */
angular.module('csp').service('Requests', ['$resource',   function($resource){
	this.Do = function(endpoint, queryParameters){
		return $resource(endpoint,queryParameters,{
			post:{
				method:"POST",
				isArray:false
			},
			get:{
				method:"GET",
				isArray:false
			},
			getAll:{
				method:"GET",
				isArray:true
			},
			update:{
				method:"PUT",
				isArray:false
			},
	        remove:{
	            method:"DELETE",
	            isArray:false
	        },
	        postMultipart:{
				method:"POST",
				transformRequest: angular.identity,
				isArray:false
			}
	    });
	};
}]);