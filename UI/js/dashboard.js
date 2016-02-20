$(document).ready(function() {
      $( "#dialog" ).dialog({
      autoOpen: false,
	  modal: true,
      show: {
        effect: "blind",
        duration: 1000
      },
      hide: {
        effect: "explode",
        duration: 1000
      }
    });
    $( "#transaction" ).click(function() {
		console.log("Transaction Click");
      $( "#dialog" ).dialog("open");
    });
 });