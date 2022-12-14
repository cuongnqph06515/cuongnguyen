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

//slide show



