function like(id){
	var url = "http://localhost:8080/pd04166.asm/like?id=" + id;
		$.getJSON(url, function(data) {
		if(data.status == "false"){
			console.log("ko thanh cong");
			window.location.assign("http://localhost:8080/pd04166.asm/login");
		}else{
			console.log("like thành công");
			var btnId = "#btn-like-"+id;
			$(btnId).text("ABc");
		}
	});
}