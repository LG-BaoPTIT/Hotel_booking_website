async function validateLoginForm(e) {
	const form = document.getElementById("form-login");
	const username = document.getElementById("username").value;
	const password = document.getElementById("password").value;
	let isValid = true;
	form.addEventListener('submit', (e) => {

		e.preventDefault();
	})
	// validate username
	if (username === "") {
		document.getElementById("username-error").textContent = "Hãy nhập tên tài khoản.";
		isValid = false;
	} else {
		document.getElementById("username-error").textContent = "";
	}

	// validate password
	if (password === "") {
		document.getElementById("password-error").textContent = "Hãy nhập mật khẩu.";
		isValid = false;
	} else {
		document.getElementById("password-error").textContent = "";
	}
	if (isValid) {

		// create an object with the form data
		const formData = {
			username: username,
			password: password
		};

		//make a POST request to the server using fetch API

		//
		const fetchOptions = {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
				Accept: "application/json",
			},
			body: JSON.stringify(formData),
		};

		const response = await fetch("http://localhost:8080/checklogin", fetchOptions);

		if (response.ok) {
			localStorage.setItem('oke', response.ok)
			const respon = response.json();
			
			if(getCookie('role')==1){
				window.location.href = "http://localhost:8080/home";
			}
			if(getCookie('role')==0){
				window.location.href = "http://localhost:8080/admin";
			}
			
		}
		else {
			document.getElementById("login-fail").textContent = "Sai thông tin đăng nhập!";
		}
		

	}


}


function getCookie(name) {
  var cookies = document.cookie.split(';');
  for (var i = 0; i < cookies.length; i++) {
    var cookie = cookies[i].trim();
    if (cookie.indexOf(name) == 0) {
      return decodeURIComponent(cookie.substring(name.length + 1));
    }
  }
  return null;
}

function resetResponse() {
	document.getElementById("username-error").textContent = "";
	document.getElementById("password-error").textContent = "";
	document.getElementById("login-fail").textContent = "";
}