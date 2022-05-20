
var checkMail = true;
var checkUsername = false;
function checkEmail() {
	var email = document.getElementsByName("email")[0].value;
	var url = "http://localhost:8080/pd04166.asm/check?email=" + email;
	var small = document.getElementById('emailError');
	if (email == "") {
		checkEmail = true;
		isValid();
		return;
	}
	$.getJSON(url, function(data) {
		//console.log(data);
		var check = data.email;
		if (check == 'false') {
			

			small.innerHTML = ("Email đã tồn tại !!!");
		} else {
			small.innerHTML = ("Email hợp lệ");
		}
	});
	isValid();
}


function fcheckUsername() {
	var email = document.getElementsByName("username")[0].value;
	var url = "http://localhost:8080/pd04166.asm/check?username=" + email;
	var small = document.getElementById('userError');
	$.getJSON(url, function(data) {
		//console.log(data);
		var check = data.username;
		if (check == 'false') {
		
			small.innerHTML = ("User name đã tồn tại");
			checkUsername = false;
		} else {
			small.innerHTML = ("User name hợp lệ");
			checkUsername = true;
		}
	});
	isValid();
}

function isValid() {
	var btn = document.getElementById("submit");
	if (checkEmail == true && checkUsername == true) {
		btn.removeAttribute("disabled");
		console.log("a")
	} else {
		btn.setAttribute("disabled", "");
	}
}