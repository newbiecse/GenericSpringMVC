$(document).ready(function() {

	$("form").submit(function(event){
	
		event.preventDefault();
		
	    var formData = new FormData($(this)[0]);
	
	    $.ajax({
//	        url: "http://localhost:8080/SpringMVCHibernate/uploadFile",
	        url: $(this).attr("action"),
	        type: 'POST',
	        data: formData,
	        async: false,
	        success: function (data) {
	            alert(data)
	        },
	        cache: false,
	        contentType: false,
	        processData: false
	    });
	
	    return false;
	});
});