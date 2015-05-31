$(document).ready(function() {
	// alert('ready');
	
	$("#productForm").submit(function(event) {
		event.preventDefault();

	    $.ajax({
	            url:'http://localhost:8080/generic/products/add',
	            type:'POST',
	            data:$(this).serialize(),
	            success:function(result){
	                alert(result);

	            }

	    });	
	});
});