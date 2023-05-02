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
function renderHotels(hotels){
    var listHotelBlock =document.querySelector('.listRoom');
    var html = hotels.map(function(hotel){
        return `
        <li class="item">
        <a href="#">   <div class="roomPic"></div>
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
              <span class="roomName">${hotel.name}</span>
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
    getHotels();

}

start();