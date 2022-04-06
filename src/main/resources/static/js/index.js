const { format } = require("express/lib/response");

var delayInMilliseconds = 5000; //1 second

setTimeout(function() {
  fadeOutEffect("animated-title"
  )
}, delayInMilliseconds);

function fadeOutEffect(id) {
    var s = document.getElementById(id).style;
    s.opacity = 1;
    (function fade(){(s.opacity-=.1)<0?s.display="none":setTimeout(fade,30)})();  
}

function fadeInEffect(id) {
    var div = document.getElementById(id)
    
    div.classList.toggle("fadeIn")
    
}

/*
setTimeout(function() {
    var s2 = document.getElementById('animated-title')
    s2.remove()
  }, 4000);

setTimeout(function(){
fadeInEffect("whiteBackground")
},5000);


const input = document.getElementById('formFullName');
const log = document.getElementById('bror');

input.onkeyup = logKey;

function logKey(e) {
  log.textContent += ` ${e.code}`;
}
*/

function validateFullName(){
  var inputFullname = document.getElementById("formFullName").value;
  var inputFullNameWithoutValue = document.getElementById("formFullName")
  var pattern = "^[a-zA-Z\s]+$"
  if(inputFullname.match(pattern)){
    inputFullNameWithoutValue.classList
  }
  else{
    inputFullNameWithoutValue.classList.remove("valid")
    inputFullNameWithoutValue.classList.add("invalid")
  }
}

function register(){
  var inputFullname = document.getElementById("formFullName").value;
  var inputEmail = document.getElementById("formEmail").value;
  var inputPassword = document.getElementById("formPassword").value;

  let postObj = {
    fullName: inputFullname,
    email: inputEmail,
    password: inputPassword
}

let post = JSON.stringify(postObj)

var xhr = new XMLHttpRequest()
xhr.open("POST", "http://localhost:8081/registration")
xhr.setRequestHeader("Content-Type", "application/json; charset=UTF-8")
xhr.send(post)
xhr.onload = function(){
    if(xhr.status === 200){
      var data = JSON.parse(this.response)
      console.log(data[0])
    } 
    xhr.send()

}

}