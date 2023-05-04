function validateRegisterForm() {
	const password = document.getElementById("password").value;
	const confirm_password = document.getElementById("confirm_password").value;
	const form = document.querySelector(".form_left_main_input");
	let isValid = true;
	document.getElementById("user-error").textContent = "";
	document.getElementById("password-error2").textContent = "";
	document.getElementById("password-error1").textContent = ""
	document.getElementById("register-success").textContent = "";
	form.addEventListener('submit', (e) => {

		e.preventDefault();
	})

	if (password.length < 6) {
		document.getElementById("password-error1").textContent = "Mật khẩu phải có ít nhất 6 kí tự";
		isValid = false;
	}

	if (password !== confirm_password) {
		document.getElementById("password-error2").textContent = "Mật khẩu không khớp";
		document.getElementById("password-error1").textContent = ""
		isValid = false;
	}
	if (isValid) {
		registerUser();
	}

}

async function registerUser() {
	const fullname = document.getElementById("fullname").value;
	const username = document.getElementById("username").value;
	const password = document.getElementById("password").value;
	const roleuser = "1";
	const url = "http://localhost:8080/registeruser";

	const formData = {
		name: fullname,
		username: username,
		password: password,
		role: roleuser
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

	const response = await fetch(url, fetchOptions)
	if (!response.ok) {
		const errorResponse = await response.json();
		console.log(errorResponse.success);
		document.getElementById("user-error").textContent = errorResponse.message;
	}
	else {
		document.getElementById("register-success").textContent = "Tạo tài khoản thành công";
		setTimeout(() => {
			window.location.href = '/login'
		}, 2000)

	}

	/*	if (response.ok) { 
			localStorage.setItem('oke',response.ok)
			 window.location.href = "http://localhost:8080/home";
			}		
		else{
			document.getElementById("password-error").textContent = "Sai thông tin đăng nhập!";
		}*/




}