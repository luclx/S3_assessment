
$( document ).ready(function() {
const divs = document.querySelectorAll("div");
for (let i = 0; i < divs.length; ++ i) {
    divs[i].addEventListener('click', function(i) {
        alert(divs[i].id);
        event.stopPropagation();        
    }.bind(this, i));
}
})