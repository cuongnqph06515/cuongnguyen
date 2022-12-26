// active tag in nav menu
var lstMenu = document.getElementById("lstMenu");
var menuItem = lstMenu.getElementsByClassName("menu-item");
for (var i = 0; i < menuItem.length; i++) {
    menuItem[i].addEventListener("click", function () {
        var current = document.getElementsByClassName("active");
        current[0].className = current[0].className.replace(" active", "");
        this.className += " active";
    });
}

//validate register

let id = (id) => document.getElementById(id);
let classes = (className) => document.getElementsByClassName(className);
let valid = true;

let fullname = id("fullname"),
    username = id("username"),
    password = id("password"),
    repassword = id("repassword"),
    email = id("email"),
    address = id("address"),
    birthday = id("birthday"),
    mobile = id("mobile"),
    
errorMessage = classes("error"),
gender = classes("gender");


let usernamePatern = new RegExp(/[^a-zA-Z0-9]/),
    emailPatern = new RegExp(/^[a-zA-Z0-9.-_]{1,}@[a-zA-Z.-]{2,}[.]{1}[a-zA-Z]{2,3}/)
    paternMobile0 = new RegExp(/((09|03|07|08|05)+([0-9]{8})\b)/),
    paternMobile84 = new RegExp(/((84)+([0-9]{9})\b)/);


let validate = (id, serial, message) =>{
    if(id !== null){
        if(id.value.trim() === "" && id !== repassword){
            errorMessage[serial].innerHTML = message + "không thể để trống!";
            id.style.border = "2px solid red";
            valid = false;
        }
        else if((id === fullname || id === username) && id.value.trim().length > 200 ){
            errorMessage[serial].innerHTML = message + "không nhập quá 200 ký tự!";
            id.style.border = "2px solid red";
            valid = false;
        }
        else if(id === username && usernamePatern.test(id.value.trim())){
            errorMessage[serial].innerHTML = message + "không chứa ký tự đặc biệt và khoảng trắng!";
            id.style.border = "2px solid red";
            valid = false;
        }else if(id === password && (id.value.trim().length < 5 || id.value.trim().length > 51)){
            errorMessage[serial].innerHTML = message + "nhập trong khoảng 5 đến 51 ký tự!";
            id.style.border = "2px solid red";
            valid = false;
        }else if(id === repassword && id.value !== password.value){
            errorMessage[serial].innerHTML = message + "không chính xác!";
            id.style.border = "2px solid red";
            valid = false;
        }
        else if(id === email){
            if(!emailPatern.test(id.value.trim())){
                errorMessage[serial].innerHTML = message + "không đúng định dạng. ex: example@gmail.com";
                id.style.border = "2px solid red";
                valid = false;
            }else if(id.value.trim().length > 100){
                errorMessage[serial].innerHTML = message + "không quá 100 ký tự!";
                id.style.border = "2px solid red";
                valid = false;
            }else{
                    errorMessage[serial].innerHTML = '';
                    id.style.border = "1px solid #e6e6e6";
                    valid = true;
            }
        }
        else if(id===address && id.value.length >500){
            errorMessage[serial].innerHTML = message + "không quá 500 ký tự!";
                id.style.border = "2px solid red";
                valid = false;
        }
        else{
            errorMessage[serial].innerHTML = '';
            id.style.border = "1px solid #e6e6e6";
            valid = true;
        }
    }
}

let checkGender = (gender, serial, message) =>{
        if(gender[0].checked || gender[1].checked || gender[2].checked){
            errorMessage[serial].innerHTML = '';
        }
        else{
            errorMessage[serial].innerHTML = message + "phải được chọn!";
        }
}

let checkMobile = (id, serial) =>{
    let comp0 = paternMobile0.test(id.value);
    let comp84 = paternMobile84.test(id.value);
    if(id.value.trim() === ""){
        errorMessage[serial].innerHTML ="Số điện thoại không để trống!";
        id.style.border = "2px solid red";
        valid = false;
    }else 
    if(!comp84 && !comp0){
        errorMessage[serial].innerHTML = "Số điện thoại không đúng định dạng!";
        id.style.border = "2px solid red";
        valid = false;
    }else{
        errorMessage[serial].innerHTML = '';
        id.style.border = "1px solid #e6e6e6";
        valid = true;
    }
}

let validateBirthday = (date) => {
    let today = new Date();
    let currentDay = today.getDate();
    let currentMonth = today.getMonth() + 1;
    let currentYear = today.getFullYear();
    let year = parseInt(date.substring(0,4));
    let month = parseInt(date.substring(5,7));
    let day = parseInt(date.substring(8,10));
    if(year > currentYear){
       return -1;
    }else if(month > currentMonth && year === currentYear){
        return -1;
    }else if(day > currentDay && month === currentMonth && year === currentYear){
        return -1;
    }else{
        return 0;
    }
    
}

let toggleButton = (value) =>{
    id(value).classList.toggle("notice-content");
}

let checkBirthday = (id, serial) =>{
    if(id.value.trim() === ""){
        errorMessage[serial].innerHTML ="Ngày sinh không để trống!";
        id.style.border = "2px solid red";
        valid = false;
    }
    else if(validateBirthday(id.value)){
        errorMessage[serial].innerHTML ="Ngày sinh không lớn hơn ngày hiện tại!";
        id.style.border = "2px solid red";
        valid = false;
    }
    else{
        errorMessage[serial].innerHTML = '';
        id.style.border = "1px solid #e6e6e6";
        valid = true;
    }
}

["submit"].forEach(type =>{
    id("form").addEventListener(type, (e)=>{
        e.preventDefault();
        validate(fullname,0, "Họ tên ");
        validate(username,1, "Tài khoản ");
        validate(password,2, "Mật khẩu ");
        validate(repassword,3, "Re password ");
        checkGender(gender,4, "Giới tính ");
        validate(email,5, "Email ");
        validate(address,6, "Địa chỉ ");
        checkBirthday(birthday,7);
        checkMobile(mobile,8);
        if(valid){
            toggleButton("notice");
            setTimeout(()=>{
                toggleButton("notice");
                window.location.href="http://127.0.0.1:5501/index.html";
            }, 2000);
        }
    });
});

function menuToggle(){
    id("toggle").classList.toggle("show-menu");
    id("overlay").classList.toggle("show-overlay");
}



