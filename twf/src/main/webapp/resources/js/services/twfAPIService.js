angular.module("twfApplication").factory("twfAPI", function (config) {
	return {
        changePage: function (view) {
    		window.location = config.baseUrl+view;
    	},
    	listBeanValidationMessages: function(array){
    		for(i in array) {
                console.log(array[i].message);
            }   	  
    	},
    	forceFormBind: function(form){
    		if(form.$valid){
    		   angular.forEach($scope.form, function(value, key) {
    			  if (value.hasOwnProperty('$modelValue')) {
    			     if (!value.$viewValue) {
    			         value.$setViewValue("");
    				 }
    			  }
    		   });
    		}
    	}
    };
});