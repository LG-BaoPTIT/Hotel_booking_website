const add= document.querySelector('.js-addformbutton')
const cancel= document.querySelector('.js-cancelbutton')
const addform= document.querySelector('.js-form_add')
const cancel2= document.querySelector('.js-cancelbutton2')
const updates= document.querySelectorAll('.js-updatebutton')
const updateform= document.querySelector('.js-form_update')

function Opentab() {
    addform.classList.add('form-active')
}
function Closetab(){
    addform.classList.remove('form-active')
}

function Closetab1(){
    updateform.classList.remove('form-active')
}
function Opentab1() {
    updateform.classList.add('form-active')
}

updates.forEach(item => {
    item.addEventListener('click',()=>{
        updateform.classList.add('form-active')
    })
});
const remove = () => {
	localStorage.clear('oke');
	window.location.reload();
	
}
add.addEventListener('click',Opentab)
cancel.addEventListener('click',Closetab)
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
	
	const auth = document.querySelector('.auth')
	console.log(localStorage.getItem('oke'));


	if(localStorage.getItem('oke')) {
		return auth.innerHTML = `    <a  href="/home" class="btn">Trang chủ</a>
                   					 <a  href="#" class="btn">Đặt phòng</a>
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
	return auth.innerHTML  = ` <a  href="#" class="btn">Trang chủ</a>
                   					 <a  href="#" class="btn">Đặt phòng</a>
                    				<a  href="/login" class="btn">Đăng nhập</a>
                    				<a  href="/register" class="btn">Đăng ký</a>`;
	
	
	
}
//

// lấy API
var hotelAPI = "http://localhost:8080/api/rooms";
function getHotels(){
    fetch(hotelAPI)
        .then(function(response){
            return response.json();
        })
        .then(function(hotels){
            renderHotels(hotels);
        })
        .catch((err)=>{
			console.log(err);
		})
}
//render ra danh sách khách sạn;
function renderHotels(hotels){
    var listHotelBlock =document.querySelector('.content_manage_content');
  
    var html = hotels.map(function(hotel){
        return `
                        <div class="content_manage_container">
						<div class="manage_content_item">
							<div class="manage_content_item_left">
								<img src="${hotel.imgLink}" alt="">
								<div class="content_item_left_infomation">
									<p class="item_left_information_1">${hotel.name}</p>
									<p class="item_left_information_2">Khách sạn ${hotel.rating} sao.</p>
									<p class="item_left_information_3">Số Phòng ${hotel.quantityRoom}</p>
									
								</div>
							</div>
							<div class="manage_content_item_right">
								<div class="item_right_icon">
									<i class="fa-solid fa-pen-to-square"></i>
									<i class="fa-solid fa-trash"></i>
								</div>
								<p class="item_right_cost">1250000 đ</p>
							</div>
						</div>
					</div>
   
        `;
    });
    listHotelBlock.innerHTML = html.join('');

 
}
function start(){
	check();
	
    getHotels();

}

start();
