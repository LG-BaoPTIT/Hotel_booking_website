const add = document.querySelector('.js-addformbutton')
const cancel = document.querySelector('.js-cancelbutton')
const addform = document.querySelector('.js-form_add')
const cancel2 = document.querySelector('.js-cancelbutton2')
const addAccountBtn = document.querySelector('.addroom_form_submit_add')
const updates = document.querySelectorAll('.js-updatebutton')
const updateform = document.querySelector('.js-form_update')

function Opentab() {
	addform.classList.add('form-active')
}
function Closetab() {
	addform.classList.remove('form-active')
}

function Closetab1() {
	localStorage.removeItem('accountUpdateId');
	updateform.classList.remove('form-active')
}
function Opentab1(id) {
	localStorage.setItem('accountUpdateId', id);
	updateform.classList.add('form-active')
}


add.addEventListener('click', Opentab)
cancel.addEventListener('click', Closetab)
cancel2.addEventListener('click', Closetab1)
addAccountBtn.addEventListener('click', addAccount)
function getCookie(name) {
	const value = `; ${document.cookie}`;
	const parts = value.split(`; ${name}=`);
	if (parts.length === 2) return parts.pop().split(';').shift();
}
const remove = () => {
	localStorage.clear('oke');
	window.location.reload();

}
const check = () => {
	const login = document.querySelector('.bb')
	const auth = document.querySelector('.auth')
	const role = getCookie('role');


	if (localStorage.getItem('oke') && role == 1) {
		return auth.innerHTML = `    <a  href="/home" class="btn">Trang chủ</a>
                   					 <a  href="/cart" class="btn">Đặt phòng</a>
                   					  <div class="wrapper">
                        <span class="userName">Xin chào ${getCookie('name')}
                            <i class="fa-solid fa-caret-down" style="color: orange;"></i>
                        </span>
                        <ul class="supnav">
                           <li class="item1">
                           		<a class="itemLink">Thông tin cá nhân </a>
                           </li>   
                            <li class="item1">
                           		<a class="itemLink">Đổi mật khẩu </a>
                           </li> 
           	
                           <li class="item1">
                           		<a  href="/logout" class="itemLink" onclick="remove()">Đăng xuất</a>
                           </li>
                        </ul>
                    </div>
                   
                </div>`

	}
	if (localStorage.getItem('oke') && role == 0) {
		return auth.innerHTML = `    <a  href="/home" class="btn">Trang chủ</a>
                   					 <a  href="#" class="btn">Đặt phòng</a>
                   					  <div class="wrapper">
                        <span class="userName">Xin chào ${getCookie('name')}
                            <i class="fa-solid fa-caret-down" style="color: orange;"></i>
                        </span>
                        <ul class="supnav">
                           <li class="item1">
                           		<a  href="/admin" class="itemLink" ">Quản lí</a>
                           </li>   
                            <li class="item1">
                           		<a class="itemLink">Đổi mật khẩu </a>
                           </li> 
           	
                           <li class="item1">
                           		<a  href="/logout" class="itemLink" onclick="remove()">Đăng xuất</a>
                           		
                           </li>
                        </ul>
                    </div>
                   
                </div>`

	}

	return auth.innerHTML = ` <a  href="#" class="btn">Trang chủ</a>
                   					 <a  href="#" class="btn">Đặt phòng</a>
                    				<a  href="/login" class="btn">Đăng nhập</a>
                    				<a  href="/register" class="btn">Đăng ký</a>`;



}
//check thong tin hien thi ra header
check();
//render ra cac tai khoan
var accountAPI = "http://localhost:8080/api/users";
function getAccount() {
	fetch(accountAPI)
		.then(function(response) {
			return response.json();
		})
		.then(function(accounts) {
			renderAccounts(accounts);
		})
		.catch((err) => {
			console.log(err);
		})
}
function renderAccounts(accounts) {
	var listAccount = document.querySelector('.account_item_box');

	var html = accounts.map(function(account) {

		return `
   			<div class="account_item">
                                <div class="account_item_left">
                                    <p class="account_item_name">${account.name}
                                    
                                    (${function role() {
				if (account.role == 1) {
					return 'user';
				}
				else {
					return 'admin';
				}
			}
				()
			})
                                    
                                    </p>
                                    <p>--------</p>
                                </div>
                                <div class="item_right_icon account_icon">
                                    <div class="item_right_icon_box">
                                        <i class="fa-solid fa-pen-to-square js-updatebutton"   onclick='Opentab1(${account.id})'></i>
                                        <i class="fa-solid fa-trash"style="cursor: pointer;" onclick='deleteAccount(${account.id})'  ></i>
                                    </div>
                                </div>
                            </div>
        `;

	});

	listAccount.innerHTML = html.join('');


}
//chinh sua tai khoan
const apiUpdateRoom = "http://localhost:8080/api/users/update";
async function updateAccount() {
	// Lấy giá trị từ ô input "Họ và tên"
	const hoVaTen = document.querySelector('input[placeholder="Nhập họ và tên"]').value;

	// Lấy giá trị từ ô input "Tên tài khoản"
	const tenTaiKhoan = document.querySelector('input[placeholder="Nhập tên tài khoản"]').value;

	// Lấy giá trị từ ô input "Mật khẩu"
	const matKhau = document.querySelector('input[placeholder="Thanh toán bằng"]').value;

	// Lấy giá trị từ ô input "Địa chỉ"
	const diaChi = document.querySelector('input[placeholder="Địa chỉ"]').value;

	// Lấy giá trị từ ô input "Số điện thoại"
	const soDienThoai = document.querySelector('input[placeholder="Số điện thoại"]').value;
	const userRoleRadios = document.querySelectorAll('input[name="role"]');
	let userRoleValue;
	for (let i = 0; i < userRoleRadios.length; i++) {
		if (userRoleRadios[i].checked) {
			userRoleValue = userRoleRadios[i].value;
			break;
		}
	}

	const formData = {
		id: localStorage.getItem('accountUpdateId'),
		name: hoVaTen,
		username: tenTaiKhoan,
		password: matKhau,
		address: diaChi,
		phone: soDienThoai,
		role:userRoleValue

	};
	
	const fetchOptions = {
		method: "PUT",
		headers: {
			"Content-Type": "application/json",
			Accept: "application/json",
		},
		body: JSON.stringify(formData),
	};

	const response = await fetch(apiUpdateRoom, fetchOptions);
	if (response.ok) {
		getAccount();
		 clearInputValues()
		alert('Cập nhật thành công!');
	}
	else {
		alert('Cập nhật thất bại!');
	}

}
//xoa tai khoan
const apiDeleteAccount = "http://localhost:8080/api/users/delete";
async function deleteAccount(id) {
	const formData = {
		id: id
	}
	const fetchOptions = {
		method: "DELETE",
		headers: {
			"Content-Type": "application/json",
			Accept: "application/json",
		},
		body: JSON.stringify(formData),
	};

	const reponse = await fetch(apiDeleteAccount, fetchOptions);
	if (reponse.ok) {
		getAccount();
		setTimeout(() => alert("Xóa tài khoản thành công!"), 500)


	}
	else {
		alert("Xóa tài khoản thất bại!")
	}


}
//Them tai khoan
const apiAddAcount = "http://localhost:8080/registeruser";
async function addAccount() {
	const name = document.querySelector('input[placeholder="Họ và tên"]').value;
	const username = document.querySelector('input[placeholder="Tên tài khoản"]').value;
	const password1 = document.querySelector('input[placeholder="Mật khẩu"]').value;
	const password2 = document.querySelector('input[placeholder="Nhập lại mật khẩu"]').value;
	const userRoleRadios = document.querySelectorAll('input[name="role"]');
	let userRoleValue;
	for (let i = 0; i < userRoleRadios.length; i++) {
		if (userRoleRadios[i].checked) {
			userRoleValue = userRoleRadios[i].value;
			break;
		}
	}
	var check = true;
	if (!name || !username || !password1 || !password2) {
		check = false;
		alert('Vui lòng nhập đầy đủ thông tin');
	} else if (password1 !== password2) {
		check = false;
		alert('Mật khẩu nhập lại không đúng');
	} else if (password1.length < 6) {
		check = false;
		alert('Mật khẩu phải có ít nhất 6 ký tự');
	}
	if (check == true) {
		const formData = {
			name: name,
			username: username,
			password: password1,
			role: userRoleValue
		}

		const fetchOptions = {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
				Accept: "application/json",
			},
			body: JSON.stringify(formData),
		};

		const response = await fetch(apiAddAcount, fetchOptions);
		if (response.ok) {
			alert('Thêm tài khoản thành công!');
			getAccount();
			clearInputs()

		}
		else {
			alert('Tên tài khoản đã tồn tại!');
		}
	}


}
function clearInputValues() {
  const inputElements = document.querySelectorAll('input'); // Lấy tất cả các ô input

  for (const inputElement of inputElements) {
    inputElement.value = ''; // Xóa giá trị của mỗi ô input
  }
}
function clearInputs() {
	document.querySelector('input[placeholder="Họ và tên"]').value = '';
	document.querySelector('input[placeholder="Tên tài khoản"]').value = '';
	document.querySelector('input[placeholder="Mật khẩu"]').value = '';
	document.querySelector('input[placeholder="Nhập lại mật khẩu"]').value = '';
}
function start() {
	check();
	getAccount();


}
start();


