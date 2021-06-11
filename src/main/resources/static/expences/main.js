

$('document').ready(function(){
	$('#editMyBudget').on('click',function(event){
		event.preventDefault();

		var href= $(this).attr('href');

		$.get(href, function(mybudget, status){
			$('#IdEditMyBudget').val(1);
			// $('#nameEdit').val(expences.name);
			$('#nameEditMyBudget').val(mybudget.value);
		});
		$('#editModalMyBudget').modal();
	});

	$('.table #editButton').on('click',function(event){			
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$.get(href, function(expences, status){
			$('#IdEdit').val(expences.id);
			$('#nameEdit').val(expences.name);
			$('#valueEdit').val(expences.value);
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