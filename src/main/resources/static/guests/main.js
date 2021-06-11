

$('document').ready(function(){	
	$('.table #editButton').on('click',function(event){			
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(guest, status){
			$('#IdEdit').val(guest.id);
			$('#nameEdit').val(guest.name);
			$(function(){
				$("#ddlselect").change(function (){
					var status=$("#ddlselect option:selected").text();
					$("#txtresults").val(status);
				})
			})
		});		
		$('#editModal').modal();				
	});	
	
	$('.table #deleteButton').on('click',function(event){
		event.preventDefault();		
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);		
		$('#deleteModal').modal();
	});
});