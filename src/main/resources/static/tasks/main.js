

$('document').ready(function(){	
	$('.table #editButton').on('click',function(event){			
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(task, comment){
			$('#IdEdit').val(task.id);
			$('#nameEdit').val(task.name);
			$(function(){
				$("#ddlselect").change(function (){
					var status=$("#ddlselect option:selected").text();
					$("#txtresults").val(status);
				})
			})
			$('#commentEdit').val(task.comment);
			$('#updatedOnEdit').val(task.updatedOn.substr(0,10));
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