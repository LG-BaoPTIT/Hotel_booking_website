
//FUCTION GET Cookies by key
function getCookie(name) {
  const value = `; ${document.cookie}`;
  const parts = value.split(`; ${name}=`);
  if (parts.length === 2) return parts.pop().split(';').shift();
}
//fuction validate form order
function validateOrderData(data) {
  for (let key in data) {
    if (data[key] === "" || data[key] === NaN || data[key] === null || data[key] === undefined) {
      return false;
    }
  }
  return true;
}


var hotelAPI = "http://localhost:8080/api/rooms";
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


function renderHotels(hotels){
    var listHotelBlock =document.querySelector('.listRoom');
    var html = hotels.map(function(hotel){
		const id = hotel.id;
		const name = hotel.name;
		const des = hotel.description
		const price = hotel.price;
		const image = hotel.imgLink;
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
              <button class="bookBtn" onclick ="fcOrder('${id}', '${name}', '${des}', '${price}', '${image}')">
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

//PNND fuction call api post order_detail

const checkUserLogin = localStorage.getItem("oke");
const OrderPopup = document.querySelector(".order_main")
const ImgRoomOrder = document.querySelector(".jsImgRoomOrder");
const NameRoomOrder = document.querySelector(".order_content_item_name");
const DesRoomOrder = document.querySelector(".order_content_item_type");
const PriceRoomOrder = document.querySelector(".order_content_item_price");
const datein = document.querySelector(".datein")
const dateout = document.querySelector(".dateout")
const numberRoom = document.querySelector(".numberRooms");
const dpTotalPrice = document.querySelector(".js-price")
const confirm = document.querySelector('.btn-pay')

const fcOrder = (roomID,name,des, price, imgRoom) => {
	if(!checkUserLogin) {
		window.location.href = '/login'
	}
	else {
		//edit content in popup
		ImgRoomOrder.src = imgRoom;
		NameRoomOrder.innerHTML = name;
		DesRoomOrder.innerHTML = des;
		PriceRoomOrder.innerHTML = Number(price).toLocaleString('vi-VN', { style: 'currency', currency: 'VND' });
		
		// handle price when click input date and number rooms
		
		const calculatePrice = () => {
			const startDate = new Date(datein.value);
			const endDate = new Date(dateout.value);
			const timeLive = endDate.getTime() - startDate.getTime();
			const dayCount = Math.ceil(timeLive/(1000 * 60 * 60 * 24));
			const roomCount = numberRoom.value;
			const totalPrice = roomCount * dayCount * price;
			dpTotalPrice.innerHTML = totalPrice ? totalPrice.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' }) : '0 đ';
			return totalPrice;
		}
		
		datein.addEventListener('change', function() {
		  if (datein.value && dateout.value && numberRoom.value) {
		    calculatePrice();
		  }
		});
		
		dateout.addEventListener('change', function() {
		  if (datein.value && dateout.value && numberRoom.value) {
		    calculatePrice();
		  }
		});
		numberRoom.addEventListener('change', function() {
		  if (datein.value && dateout.value && numberRoom.value) {
		    calculatePrice();
		  }
		});	
		//open Popup
		OrderPopup.classList.remove("hide");
		document.body.style.overflow = "hidden";	
		
		//handle when click confirm
		confirm.onclick = async() => {
			const orderData = {
				quantity : numberRoom.value,
				datein : datein.value,
				dateout : dateout.value,
				totalPrice: calculatePrice(),
				user_id: getCookie("id"),
				room_id: roomID
			};
			
			const fetchOptions = {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
					Accept: "application/json",
				},
				body: JSON.stringify(orderData),
			};
			
			const url = "http://localhost:8080/api/order";
			if(validateOrderData(orderData)) {
				const response = await fetch(url, fetchOptions)
				if (!response.ok) {
				}
				else {
					alert("đặt phòng thành công")
					fcOrderClose();
				}
			} else {
				alert("Vui lòng điền đầy đủ thông tin đặt phòng")
			}
			
		}
	}
}

//fc close popup
const fcOrderClose = () => {
	OrderPopup.classList.add("hide");
	document.body.style.overflow = "auto";
}

const iconClose = document.querySelector(".order_content_item_cancel");
iconClose.onclick = () => {
	fcOrderClose();
}


const btnOrderMore = document.querySelector(".order_form_wantadditem");
btnOrderMore.onclick = () => {
	fcOrderClose();
}



	


	


start();