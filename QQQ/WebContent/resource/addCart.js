
	function d(){
		alert("fd");
		var va="id="+$(".val").text();
		$.ajax({
			url : "addShoppingBasket",
			data : va,
			success : function(data){
				$(".val").text(data);
			}
		});
   	}
   	

