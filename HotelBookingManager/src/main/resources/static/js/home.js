
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
      return ("Vui lòng chọn đầy đủ thông tin ");
    }
  }
  if(data.datein > data.dateout) {
	  return "Vui lòng chọn lại ngày tháng";
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

//tùy chỉnh các mục ở header
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

function getReviewText(rate) {
  if (rate <= 3) {
    return "Bình thường";
  } else if (rate <= 4) {
    return "Tốt";
  } else {
    return "Xuất sắc";
  }
}

function renderHotels(hotels){
    var listHotelBlock =document.querySelector('.listRoom');
    var html = hotels.map(function(hotel){
		const id = hotel.id;
		const name = hotel.name;
		const des = hotel.description
		const price = hotel.price;
		const image = hotel.imgLink;
		const status = hotel.status;
		const rate = hotel.rate;
		const brickPrice = Number(hotel.price) * 1.2;
        return `
        <li class="item">
       			<div class="roomPic" style="background-image: url(${hotel.imgLink}) "></div>
           <div class="userReply">
                  <div class="rating">
                    ${function loop(){
                        var rate=[];
                        for(let i=0;i<hotel.rate;i++){                         
                            rate.push('<i class="ratingStar fas fa-star"></i>')
                        }
                        return rate;
                    }
                        ()
                    }


                  </div>
                  <Span class="review">${getReviewText(hotel.rate)}</Span>
           </div>
              <div class="roomName">${hotel.name}</div>
              <div class="price">
                  <span class="roomCostTitle">Giá Tiền</span>
                  <span class="roomCostNumber">${hotel.price} đ/ngày </span>
              </div>
              <div class="roomLeft">
                  <span class="roomLeft">Còn Phòng</span>
                  <i class="fa-solid fa-ticket"></i>
                  <strike class="roomIn">${brickPrice.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' })}</strike>
              </div>
              <button class="bookBtn" onclick ="fcOrder('${id}', '${name}', '${des}', '${price}', '${image}', ${rate}, ${status})">
                  Đặt Ngay
                  <i class="fa-solid fa-bolt-lightning ml10"></i>
              </button>                      
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
const dpTotalPrice = document.querySelector(".js-price")
const confirm = document.querySelector('.btn-pay')

const fcOrder = (roomID,name,des, price, imgRoom, rate, status) => {
	
	
	
	if(!checkUserLogin) {
		window.location.href = '/login'
	}
	else {
		const orderAPI = "http://localhost:8080/api/order";
	
		async function getOrderData() {
	 		const orderAPIwithIdUser = `${orderAPI}/room/${roomID}`;
	  		try {
    			const response = await fetch(orderAPIwithIdUser);
    			const data = await response.json();
	    return data;
	  } catch (error) {
	    	console.error(error);
	  }
	}
	
	getOrderData().then(data => {
		function getBookedDates(data) {
		  const bookedDates = [];
		  data.forEach(({ datein, dateout }) => {
		    const startDate = new Date(datein);
		    const endDate = new Date(dateout);
		    const days = Math.floor((endDate - startDate) / (24 * 60 * 60 * 1000));
		    for (let i = 0; i <= days; i++) {
		      const date = new Date(startDate);
		      date.setDate(startDate.getDate() + i);
		      bookedDates.push({
		        year: date.getFullYear(),
		        month: date.getMonth() + 1,
		        day: date.getDate()
		      });
		    }
		  });
		  return bookedDates;
		}
		
		const bookedDates = getBookedDates(data);	
		
		function checkBookingConflict(bookedDates, startDate, endDate) {
			
		  const conflictDates = [];
		  const days = Math.floor((endDate - startDate) / (24 * 60 * 60 * 1000));
		  for (let i = 0; i <= days; i++) {
		    const date = new Date(startDate);
		    date.setDate(startDate.getDate() + i);
		    const year = date.getFullYear();
		    const month = date.getMonth() + 1;
		    const day = date.getDate();
		    const conflict = bookedDates.find(bookedDate => {
		      return bookedDate.year === year && bookedDate.month === month && bookedDate.day === day;
		    });
		    if (conflict) {
		      conflictDates.push(conflict);
		    }
		  }
		  return conflictDates;
		}
		
		datein.addEventListener('input', () => {		
		  const startDate = new Date(datein.value);
		  const endDate = new Date(dateout.value);
		  if (startDate && endDate) {
		    const conflicts = checkBookingConflict(bookedDates, startDate, endDate);
		    if (conflicts.length > 0) {
		      const conflictDates = conflicts.map(conflict => `${conflict.day}/${conflict.month}`).join(', ');
		      const message = `Trong khoảng thời gian từ ngày ${startDate.toLocaleDateString()} đến ngày ${endDate.toLocaleDateString()}, đã có người đặt phòng vào các ngày: ${conflictDates}`;
		      alert(message);
				datein.value = null;
				dateout.value = null;
		    }
		  }
		});
		
		dateout.addEventListener('input', () => {
		  const startDate = new Date(datein.value);
		  const endDate = new Date(dateout.value);
		  if (startDate && endDate) {
		    const conflicts = checkBookingConflict(bookedDates, startDate, endDate);
		    if (conflicts.length > 0) {
		       const conflictDates = conflicts.map(conflict => `${conflict.day}/${conflict.month}`).join(', ');
		      const message = `Trong khoảng thời gian từ ngày ${startDate.toLocaleDateString()} đến ngày ${endDate.toLocaleDateString()}, đã có người đặt phòng vào các ngày: ${conflictDates}`;
		      alert(message);
				datein.value = null;
				dateout.value = null;
		    }
		  }
		});
	})
		
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
			const roomCount = 1;
			const totalPrice = roomCount * dayCount * price;
			dpTotalPrice.innerHTML = totalPrice ? totalPrice.toLocaleString('vi-VN', { style: 'currency', currency: 'VND' }) : '0 đ';
			return totalPrice;
		}
		
		datein.addEventListener('change', function() {
		  if (datein.value && dateout.value) {
		    calculatePrice();
		  }
		});
		
		dateout.addEventListener('change', function() {
		  if (datein.value && dateout.value) {
		    calculatePrice();
		  }
		});	
		//open Popup
		OrderPopup.classList.remove("hide");
		document.body.style.overflow = "hidden";	
		
		//handle when click confirm
		confirm.onclick = async() => {
			const orderData = {
				quantity : 1,
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
			
			const check = validateOrderData(orderData); 
			if( check === true) {
				const response = await fetch(url, fetchOptions)
				if (!response.ok) {
				}
				else {
					datein.value=null;
					dateout.value=null;
					alert("đặt phòng thành công")
					fcOrderClose();
				}
			} else {
				alert(check)
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

var index=0;
var arr_anh=[
	"https://cdn1.ivivu.com/iVivu/2018/06/15/15/khach-san-paris-deli-da-nang-42-800x450.jpg",
    "//khachsandayroi.com/wp-content/uploads/2017/09/about_banner.jpg",
    "https://anhthaohotel.com/wp-content/uploads/2019/07/banner-anhthao-hotel-2.jpg",
    "https://brghospitality.vn/palace/wp-content/uploads/sites/5/2019/09/Palace_Banner-Superior-1920X704-02-02.jpg",
    "http://banthachriversidehotel.com/wp-content/uploads/2020/12/ceafc01706f3f7adaee2.jpg",
]
function prev(){
    index--;
    if(index <-0) index = arr_anh.length-1;
    document.getElementById("hinh").src=arr_anh[index];
    
}
function next(){
    index++;
    if(index==arr_anh.length) index = 0;
    document.getElementById("hinh").src=arr_anh[index];
}
setInterval("next()",5000);

start();