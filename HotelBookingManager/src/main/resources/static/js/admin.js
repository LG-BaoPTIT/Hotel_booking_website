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


	if(localStorage.getItem('oke') && role==1) {
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
	if (localStorage.getItem('oke') && role==0) {
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
	
	return auth.innerHTML  = ` <a  href="#" class="btn">Trang chủ</a>
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
								<img src="${hotel.imgLink ? hotel.imgLink : 'data:image/jpeg;base64,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' }" alt="">
								<div class="content_item_left_infomation">
									<p class="item_left_information_1">${hotel.name}</p>
									<p class="item_left_information_2"> 
										                    ${function loop(){
                        var rate=[];
                        for(let i=0;i<hotel.rate;i++){                         
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
		id:localStorage.getItem('roomUpdateId'),
		name: name,
		description: description,
		rate: rating,
		price: price,
		status:'0'
		
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
	if(response.ok){
		getHotels();
		clearInputs()
		alert('Cập nhật thành công!');
	}
	else{
		alert('Cập nhật thất bại!');
	}
	
}
/// Thêm phòng
const apiRoom = "http://localhost:8080/api/rooms";
async function addroom() {
	const name = document.querySelector('input[placeholder="Tên phòng"]').value;
	const description = document.querySelector('input[placeholder="Mô tả phòng"]').value;
	const rating = document.querySelector('input[placeholder="xếp hạng"]').value;
	const price = document.querySelector('input[placeholder="Giá"]').value;

	const formData = {
		name: name,
		description: description,
		rate: rating,
		price: price,
		status:'0'
		
	};
	const fetchOptions = {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
			Accept: "application/json",
		},
		body: JSON.stringify(formData),
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
	
}
function clearInputs() {
  var inputs = document.querySelectorAll('.addroom_form input');
  for (var i = 0; i < inputs.length; i++) {
    inputs[i].value = '';
  }
}
function validateForm() {
  // Lấy tất cả các trường input từ form
  const inputFields = document.querySelectorAll('.addroom_form input');

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
 async function deleteRoom(id){
	const formData = {
		id:id
	}
	const fetchOptions = {
		method: "DELETE",
		headers: {
			"Content-Type": "application/json",
			Accept: "application/json",
		},
		body: JSON.stringify(formData),
	};
	
	const reponse = await fetch(apiDeleteRoom,fetchOptions);
	if(reponse.ok){
		getHotels();
		setTimeout(()=>alert("Xóa phòng thành công!"),500)
		
		
	}
	else{
		alert("Xóa phòng thất bại!")
	}
	
	
}
//
function start() {
	check();

	getHotels();

}

start();
