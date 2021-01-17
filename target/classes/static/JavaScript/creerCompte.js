/*
* Validates user inputs with rules and returns matching error messages if not followed
*/
$(document).ready(function() {
	$("#main-form").validate({
		rules : {
			password : {
				minlength : 6
			},
			password_confirm : {
				minlength : 6,
				equalTo : "#password"
			}
		},
		highlight : function (input) {
            $(input).addClass('is-invalid');
        },
        unhighlight : function (input) {
        	$(input).removeClass('is-invalid');
        },
        errorPlacement : function (error, element) {
        	$(element).next().append(error);
        },
		messages : {
			password : {
				minlength : "Le mot de passe doit contenir au moins 6 caractères"
			},
			password_confirm : {
				minlength : "Le mot de passe doit contenir au moins 6 caractères",
				equalTo : "Les mots de passe ne concordent pas"
			}
		}
	});
});