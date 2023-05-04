var hotelAPI = "http://localhost:8080/api/hotels";
//
function getHotels(){
    fetch(hotelAPI)
        .then(function(response){
            return response.json();
        })
        .then(function(hotels){
            renderHotels(hotels);
        })
}
//${}
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

const check = () => {
	const login = document.querySelector('.bb')
	const auth = document.querySelector('.auth')
	


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


function renderHotels(hotels){
    var listHotelBlock =document.querySelector('.listRoom');
    console.log(hotels);
    var html = hotels.map(function(hotel){
        return `
        <li class="item">
        <a href="#">   <div class="roomPic" style="background-image: url(${hotel.imgLink}) "></div>
           <div class="userReply">
                  <div class="rating">
                    ${function loop(){
                        var rate=[];
                        for(let i=0;i<hotel.rating;i++){                         
                            rate.push('<i class="ratingStar fas fa-star"></i>')
                        }
                        return rate;
                    }
                        ()
                    }


                  </div>
                  <Span class="review">25 review</Span>
           </div>
              <div class="roomName">${hotel.name}</div>
              <div class="price">
                  <span class="roomCostTitle">Giá Tiền</span>
                  <span class="roomCostNumber">${hotel.price} đ/ngày </span>
              </div>
              <div class="roomLeft">
                  <span class="roomLeft">Còn ${hotel.quantityRoom} phòng</span>
                  <i class="fa-solid fa-ticket"></i>
                  <span class="roomIn">120 đã đặt</span>
              </div>
              <button class="bookBtn">
                  Đặt Ngay
                  <i class="fa-solid fa-bolt-lightning ml10"></i>
              </button></a>                      
   </li>
        `;
    });
    listHotelBlock.innerHTML = html.join('');

 
}
function start(){
	check();
    getHotels();

}

start();