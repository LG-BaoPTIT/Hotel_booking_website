const signupbutton= document.querySelector('.js-signupbutton')
const loginbutton= document.querySelector('.js-loginbutton')
const formsignup = document.querySelector('.js-formsignup')
const formlogin = document.querySelector('.js-formlogin')
const cancelbutton = document.querySelector('.js-cancel')
const cancelbuttonlogin = document.querySelector('.js-cancel1')
function Opentab() {
    formsignup.classList.add('form-active')
}
function Closetab(){
    formsignup.classList.remove('form-active')
}
function Opentab1() {
    formlogin.classList.add('form-active')
}
function Closetab1(){
    formlogin.classList.remove('form-active')
}
loginbutton.addEventListener('click',Opentab1)
signupbutton.addEventListener('click',Opentab)
cancelbutton.addEventListener('click',Closetab)
cancelbuttonlogin.addEventListener('click',Closetab1)
var index=0;
var arr_anh=[
    "/styles/img/banner/banner6.png",
    "/styles/img/banner/banner4.jpg",
    "/styles/img/banner/banner5.jpg",
    "/styles/img/banner/banner1.jpg",
    "/styles/img/banner/banner3.jpg",
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
