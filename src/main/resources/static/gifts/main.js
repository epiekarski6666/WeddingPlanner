$('document').ready(function(){


	$('.table #editButton').on('click',function(event){
		event.preventDefault();

		var href= $(this).attr('href');

		$.get(href, function(gift, display){
			$('#IdEdit').val(gift.id);
			$('#nameEdit').val(gift.name);
			$(function(){
				$("#ddlselect").change(function (){
					var display=$("#ddlselect option:selected").text();
					$("#txtresults").val(display);
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