const add = document.querySelector('.js-addformbutton')
const cancel = document.querySelector('.js-cancelbutton')
const cancelBtnUpdate = document.querySelector('.js-cancelbuttonBtn')
const addform = document.querySelector('.js-form_add')
const addform2 = document.querySelector('.js-form_add2')
const cancel2 = document.querySelector('.js-cancelbutton2')
const updates = document.querySelectorAll('.js-updatebutton')
const updateform = document.querySelector('.js-form_update')

function Opentab() {
	addform.classList.add('form-active')
}
function Opentab2(roomid) {
	localStorage.setItem('roomUpdateId', roomid);
	addform2.classList.add('form-active')


}
function Closetab() {
	addform.classList.remove('form-active')
}
function Closetab2() {
	localStorage.removeItem('roomUpdateId');
	addform2.classList.remove('form-active')

}

function Closetab1() {
	updateform.classList.remove('form-active')
}
function Opentab1() {
	updateform.classList.add('form-active')
}

updates.forEach(item => {
	item.addEventListener('click', () => {
		updateform.classList.add('form-active')
	})
});

const remove = () => {
	localStorage.clear('oke');
	window.location.reload();

}

console.log(cancelBtnUpdate)

add.addEventListener('click', Opentab)
cancel.addEventListener('click', Closetab)
cancelBtnUpdate.addEventListener('click', Closetab2)
/*cancel2.addEventListener('click',Closetab1)*/
//lấy cookie theo key
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
//tùy chỉnh các mục ở header
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
check();

//

// lấy API
var hotelAPI = "http://localhost:8080/api/rooms";
function getHotels() {
	fetch(hotelAPI)
		.then(function(response) {
			return response.json();
		})
		.then(function(hotels) {
			renderHotels(hotels);
		})
		.catch((err) => {
			console.log(err);
		})
}
//render ra danh sách khách sạn;
function renderHotels(hotels) {
	var listHotelBlock = document.querySelector('.content_manage_content');

	var html = hotels.map(function(hotel) {
		return `
                        <div class="content_manage_container">
						<div class="manage_content_item">
							<div class="manage_content_item_left">
								<img src="${ hotel.imgLink}">
								<div class="content_item_left_infomation">
									<p class="item_left_information_1">${hotel.name}</p>
									<p class="item_left_information_2"> 
										                    ${function loop() {
				var rate = [];
				for (let i = 0; i < hotel.rate; i++) {
					rate.push('<i class="ratingStar fas fa-star"></i>')
				}
				return rate.join('');
			}
				()
			}
									
									</p>
									<p class="item_left_information_3">
		    ${function status() {
				if (hotel.status == 0) {
					return 'Trạng thái: còn trống'
				}
				else {
					return 'Trạng thái: đã thuê'
				}
			}
				()
			}
									
									</p>
									
								</div>
							</div>
							<div class="manage_content_item_right">
								<div class="item_right_icon">
						
									<i class="fa-solid fa-pen-to-square" onclick='Opentab2(${hotel.id})'></i>
									<button class="fa-solid fa-trash" onclick='deleteRoom(${hotel.id})' ></button>
									
									
								</div>
								<p class="item_right_cost">${hotel.price}đ/ngày</p>
							</div>
						</div>
					</div>
   
        `;
	});
	listHotelBlock.innerHTML = html.join('');


}
//sua phong
const apiUpdateRoom = "http://localhost:8080/api/rooms/update";
async function updateRoom() {
	const name = document.getElementById('roomname').value;
	const description = document.getElementById('description').value;
	const rating = document.getElementById('rating').value;
	const price = document.getElementById('price').value;

	const formData = {
		id: localStorage.getItem('roomUpdateId'),
		name: name,
		description: description,
		rate: rating,
		price: price,
		status: '0'

	};
	console.log(formData);
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
		getHotels();
		clearInputs()
		alert('Cập nhật thành công!');
	}
	else {
		alert('Cập nhật thất bại!');
	}

}
/// Thêm phòng
const apiRoom = "/api/rooms";
/*async function addroom() {
	console.log("123123");
	const name = document.querySelector('input[placeholder="Tên phòng"]').value;
	const description = document.querySelector('input[placeholder="Mô tả phòng"]').value;
	const rating = document.querySelector('input[placeholder="xếp hạng"]').value;
	const price = document.querySelector('input[placeholder="Giá"]').value;
	const fileInput = document.querySelector('input[type="file"]');
	
	const formData = {
		name: name,
		description: description,
		rate: rating,
		price: price,
		status:'0',
		image: fileInput.files[0]
		
	};
	console.log(formData);
	const fetchOptions = {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
			Accept: "application/json",
		},
		body: JSON.stringify(formData),
		body: formData
	};
	
	const response = await fetch(apiRoom, fetchOptions);
	if(response.ok){
		getHotels();
		clearInputs()
		alert('Thêm phòng thành công!');
	}
	else{
		alert('Thêm phòng không thành công!');
	}
	
}*/
/*------------------------------------------------------*/
const form = document.getElementById('upload-img');
form.addEventListener('submit', async (event) => {
	event.preventDefault();

	const formData = new FormData();
	
	const nameValue = document.querySelector('input[name="name"]').value;
	const descriptionValue = document.querySelector('input[name="description"]').value;
	const rateValue = document.querySelector('input[name="rate"]').value;
	const priceValue = document.querySelector('input[name="price"]').value;
	const fileInput = document.querySelector('input[type="file"]');

	formData.append('image', fileInput.files[0]);
	formData.append('name', nameValue);
	formData.append('description',descriptionValue);
	formData.append('rate', rateValue);
	formData.append('price', priceValue);
	formData.append('status', '0');
	console.log(formData);
	const response = await fetch('/api/rooms', {
		method: 'POST',
		body: formData
	});
	
	
});

/*------------*/
function clearInputs() {
	var inputs = document.querySelectorAll('.addroom_form input');
	for (var i = 0; i < inputs.length; i++) {
		inputs[i].value = '';
	}
}
function validateForm() {
	// Lấy tất cả các trường input từ form
	const inputFields = document.querySelectorAll('.addroom_form1 input');

	// Duyệt qua tất cả các trường input và kiểm tra xem chúng đã được điền đầy đủ hay không
	for (let i = 0; i < inputFields.length; i++) {
		if (inputFields[i].value === '') {
			alert('Vui lòng điền đầy đủ thông tin của phong!');
			return false;
		}
	}
	// Nếu tất cả các trường input đã được điền đầy đủ, trả về true để gửi form lên server
	return true;
}
/// xóa phòng
const apiDeleteRoom = "http://localhost:8080/api/rooms/delete";
async function deleteRoom(id) {
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

	const reponse = await fetch(apiDeleteRoom, fetchOptions);
	if (reponse.ok) {
		getHotels();
		setTimeout(() => alert("Xóa phòng thành công!"), 500)


	}
	else {
		alert("Xóa phòng thất bại!")
	}


}
//
function start() {
	check();

	getHotels();

}
var inputs = document.querySelectorAll('.inputfile');
Array.prototype.forEach.call(inputs, function(input) {
	var label = input.nextElementSibling,
		labelVal = label.innerHTML;

	input.addEventListener('change', function(e) {
		var fileName = '';
		if (this.files && this.files.length > 1)
			fileName = (this.getAttribute('data-multiple-caption') || '').replace('{count}', this.files.length);
		else
			fileName = e.target.value.split('\\').pop();

		if (fileName)
			label.querySelector('span').innerHTML = fileName;
		else
			label.innerHTML = labelVal;
	});
});

start();
///
