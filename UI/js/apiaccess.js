var database_url = "/rest";
function category(requestType, endpoint, data){
	switch(requestType){
		case "get":
			$.get(database_url + endpoint, function(data){
				return data;
			}, "json");
			break;
		case "post":
			$.post(database_url + endpoint, data, function(data){
				return data;
			}, "json");
			break;
		case "put":
			$.put(database_url + endpoint, data, function(data){
				return data;
			}, "json");
			break;
		case "delete":
			$.delete(database_url + endpoint, function(data){
				return data;
			}, "json");
			break;
	}
}