$(document).ready(function(){
	$("#reset").validate({
		 rules:{
			cpassword:{
				required:true,
				minlength:8,
				maxlength:15
			},
			npassword:{
				required:true,
				minlength:8,
				maxlength:15
			},
			conpassword:{
				required:true,
				minlength:8,
				maxlength:15,
				equalto:"npassword"
			}
		 },
		 messages:{
			 cpassword:{
				 required:"This field is required!",
					 minlength:"Password cannot be less than 8 characters!",
					 maxlength:"Password cannot exceed 15 characters"
			 },
			 npassword:{
				 required:"This field is required!",
					 minlength:"Password cannot be less than 8 characters!",
					 maxlength:"Password cannot exceed 15 characters"
			 },
			 conpassword:{
				 required:"This field is required!",
					 minlength:"Password cannot be less than 8 characters!",
					 maxlength:"Password cannot exceed 15 characters",
					 equalto:"Password does not match!"
			 }
		 },
		 submitHandler:function(form)
			{
				form.submit();
			},
			highlight:function (element){
				$(element).parent().addClass('error')
				$(element).before().css('background-color','#FF5733');
			},
			unhighlight:function (element){
				$(element).parent().removeClass('error')
				$(element).before().css('background-color','white');
			}
	});
	
});