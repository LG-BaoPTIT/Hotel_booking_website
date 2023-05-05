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
                <div class="payment_manage_content_inforcustomer">
                    <label>Quốc gia</label>
                    <p>Việt Nam</p>
                </div>
            </div>
            
        </li>          `
  })
  const ul = document.querySelector('.js-listOrder');
  ul.innerHTML = listOrder.join("")
}).catch();
