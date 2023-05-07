const orderAPI = "http://localhost:8080/api/order"

//FUCTION GET Cookies by key
function getCookie(name) {
	const value = `; ${document.cookie}`;
	const parts = value.split(`; ${name}=`);
	if (parts.length === 2) return parts.pop().split(';').shift();
}
async function getOrderData() {
	const userId = getCookie("id");
	const orderAPIwithIdUser = `${orderAPI}/${userId}`;

	try {
		const response = await fetch(orderAPIwithIdUser);
		const data = await response.json();
		return data;
	} catch (error) {
		console.error(error);
	}
}

const hide = () => {

	document.querySelector('.alert_main').classList.add('hide');
}
getOrderData().then(data => {
	const listOrder = data.map((item) => {
		const room = item.room;
		const user = item.user;
		return `
	   <li>
            <div class="payment_manage_content_item">
                <div class="payment_manage_content_img">
                    <img src="${room.imgLink}" alt="">
                </div>
                <div class="payment_manage_content_inforroom">
                    <div class="payment_inforroom_title">
                        <p class="title_left">${room.name}</p>
                        <div class="up">
                            <p class="title_right">1 Phòng / 1 Đêm</p>
                        </div>
                    </div>
                    <p class="inforroom_1">${room.description}</p>
                    <p class="inforroom_2">Ngày đến: ${item.datein}</p>
                    <p class="inforroom_2">Ngày đi: ${item.dateout}</p>
                    <p class="inforroom_2">Số lượng phòng: ${item.quantity}</p>
                </div>
                <div class="payment_manage_content_inforcustomer">
                    <label>Tên khách hàng:</label>
                    <p>${user.name}</p>
                    <label>Quốc gia:</label>
                    <p>Việt Nam</p>
                    <label>Tổng tiền:</label>
                    <p>${item.totalPrice.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}</p>
                </div>
                <div class="payment_manage_content_inforcustomer">
                    <label>Số điện thoại:</label>
                    <p>${user.phone ? user.phone : 'chưa có số điện thoại'}</p>
                    <label>Thanh toán bằng:</label>
                    <p>Thanh toán trực tiếp khi nhận phòng</p>

                </div>
                <div class="payment_manage_content_btn">
                    <button class="btn-cancel" onclick = "fcCancel(${item.id})">
                	    Hủy đặt phòng
                    </button>
                
                </div>
               
                
            </div>
            
        </li>          `
	})
	const ul = document.querySelector('.js-listOrder');
	ul.innerHTML = listOrder.join("")
}).catch();

const popupCancel = document.querySelector(".alert_main")
const btnHuy = document.querySelector(".alert_main_back_btn")
const btnConfirmCancel = document.querySelector(".js-btn-confirmCancel")
//fuciton cancel booking
const fcCancel = (orderId) => {
	popupCancel.classList.remove("hide")
	//	document.body.style.overflow = "hidden"
	btnHuy.onClick = () => {
		fcCancel();
	}
	btnConfirmCancel.onclick = async () => {
		const url = "http://localhost:8080/api/order";
		const orderAPIDelete = `${url}/${orderId}`;
		await fetch(orderAPIDelete, {
			method: 'DELETE',
		})
			.then(response => {
				if (response.ok) {
					alert("Xóa đơn hàng thành công");
					window.location.pathname = "/cart";
					location.reload;

				} else {
					alert("Xóa đơn hàng không thành công");
				}
			})
			.catch(error => {
				alert("Có lỗi xảy ra khi xóa đơn hàng:", error);
			});
	}
}

const closePopupCancel = () => {
	popupCancel.classList.add = "hide"
}
const check = () => {
	const login = document.querySelector('.bb')
	const auth = document.querySelector('.auth')
	const role = getCookie('role');


	if(localStorage.getItem('oke') && role==1) {
		return auth.innerHTML = `    <a  href="/home" class="btn">Trang chủ</a>
                   					 <a  href="/cart" class="btn">Đặt phòng</a>
                   					  <div class="wrapper">
                        <span class="userName">Xin chào ${getCookie('name').replaceAll('-',' ')}
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
const remove = () => {
	localStorage.clear('oke');
	window.location.reload();
	
}
check();