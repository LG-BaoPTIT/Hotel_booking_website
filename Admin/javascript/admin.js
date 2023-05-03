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

add.addEventListener('click',Opentab)
cancel.addEventListener('click',Closetab)
cancel2.addEventListener('click',Closetab1)