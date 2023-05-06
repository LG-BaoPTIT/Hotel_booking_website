const remove = () => {
	localStorage.clear('oke');
	window.location.reload();

}

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
// lấy API
var hotelAPI = "http://localhost:8080/api/order";
function getOrder() {
	fetch(hotelAPI)
		.then(function(response) {
			return response.json();
		})
		.then(function(orders) {
			renderOrder(orders);
		})
		.catch((err) => {
			console.log(err);
		})
}
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


//render ra danh sách khách sạn;
function renderOrder(orders) {
	var listHotelBlock = document.querySelector('.listOder');

	var html = orders.map(function(order) {
		return `
			   <div class="payment_manage_content_item">
                            <div class="payment_manage_content_img">
                                <img src="${order.room.imgLink}" alt="">
                            </div>
                            <div class="payment_manage_content_inforroom">
                                <div class="payment_inforroom_title">
                                    <p class="title_left">Bridge Resort</p>
                                    <div class="up">
                                        <p class="title_right">1 Phòng / 1 Đêm</p>
                                    </div>
                                </div>
                                <p class="inforroom_1">Phòng hai giường đơn</p>
                                <p class="inforroom_2">Ngày đến:${order.datein}</p>
                                <p class="inforroom_2">Ngày đi: ${order.dateout}</p>
        
                            </div>
                            <div class="payment_manage_content_inforcustomer">
                                <label>Tên khách hàng:</label>
                                <p>${order.user.name}</p>
                                <label>Tổng tiền:</label>
                                <p>${order.totalPrice}</p>
                            </div>
                            <div class="payment_manage_content_inforcustomer">
                                <label>Số điện thoại:</label>
                                <p>${order.user.phone}</p>
                                <label>Thanh toán bằng:</label>
                                <p>Tiền mặt</p>
        
                            </div>
                          
        
                        </div>
                        
                    </li>
                       
        `;
	});
	listHotelBlock.innerHTML = html.join('');


}
function start(){
	check();
	getOrder();
}
start();