
var delayInMilliseconds = 5000; //1 second

/*
setTimeout(function() {
  fadeOutEffect("animated-title"
  )
}, delayInMilliseconds);
*/

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
  var pattern = /^\s*([A-Za-z]{1,}([\.,] |[-']| ))+[A-Za-z]+\.?\s*$/
  if(inputFullname.match(pattern)){
    
     var findInvalidImg = document.getElementById("invalidNameImg")
     var findvalidImg = document.getElementById("validNameImg")
     if(findInvalidImg != null){
      findInvalidImg.remove()
     }
     if(findvalidImg != null){
      findvalidImg.remove()
     }
    
    var createValidImg = document.createElement("img")
    createValidImg.src = "/src/main/resources/static/images/valid.png"
    createValidImg.setAttribute("class","validNameImg")
    createValidImg.setAttribute("id", "validNameImg")
    var findDiv = document.getElementById("formBox");
    findDiv.appendChild(createValidImg)
  }
  else if(inputFullname == ""){
    var findInvalidImg = document.getElementById("invalidNameImg")
     var findvalidImg = document.getElementById("validNameImg")
     if(findInvalidImg != null || findvalidImg != null){
      findInvalidImg.remove()
      findvalidImg.remove()
     }
  }
  else{
    var findvalidImg = document.getElementById("validNameImg")
    var findInvalidImg = document.getElementById("invalidNameImg")
    if(findInvalidImg != null){
      findInvalidImg.remove()
     }
     if(findvalidImg != null){
      findvalidImg.remove()
     }
    
    
    var createValidImg = document.createElement("img")
    createValidImg.src = "/src/main/resources/static/images/invalid.png"
    createValidImg.setAttribute("class","invalidNameImg")
    createValidImg.setAttribute("id", "invalidNameImg")
    var findDiv = document.getElementById("formBox");
    findDiv.appendChild(createValidImg)
  }
}
function validatePassword(){
  var inputFullname = document.getElementById("formPassword").value;
  var inputFullNameWithoutValue = document.getElementById("formPassword")
  var pattern = /^\s*([A-Za-z]{1,}([\.,] |[-']| ))+[A-Za-z]+\.?\s*$/
  if(inputFullname.match(pattern)){
    
     var findInvalidImg = document.getElementById("invalidPasswordImg")
     var findvalidImg = document.getElementById("validPasswordImg")
     if(findInvalidImg != null){
      findInvalidImg.remove()
     }
     if(findvalidImg != null){
      findvalidImg.remove()
     }
    
    var createValidImg = document.createElement("img")
    createValidImg.src = "/src/main/resources/static/images/valid.png"
    createValidImg.setAttribute("class","validPasswordImg")
    createValidImg.setAttribute("id", "validPasswordImg")
    var findDiv = document.getElementById("formBox");
    findDiv.appendChild(createValidImg)
  }
  else if(inputFullname == ""){
    var findInvalidImg = document.getElementById("invalidPasswordImg")
     var findvalidImg = document.getElementById("validPasswordImg")
     if(findInvalidImg != null || findvalidImg != null){
      findInvalidImg.remove()
      findvalidImg.remove()
     }
  }
  else{
    var findvalidImg = document.getElementById("validPasswordImg")
    var findInvalidImg = document.getElementById("invalidPasswordImg")
    if(findInvalidImg != null){
      findInvalidImg.remove()
     }
     if(findvalidImg != null){
      findvalidImg.remove()
     }
    
    
    var createValidImg = document.createElement("img")
    createValidImg.src = "/src/main/resources/static/images/invalid.png"
    createValidImg.setAttribute("class","invalidPasswordImg")
    createValidImg.setAttribute("id", "invalidPasswordImg")
    var findDiv = document.getElementById("formBox");
    findDiv.appendChild(createValidImg)
  }
}

function validateEmail(){
  var inputFullname = document.getElementById("formEmail").value;
  var inputFullNameWithoutValue = document.getElementById("formEmail")
  var pattern = /^\s*([A-Za-z]{1,}([\.,] |[-']| ))+[A-Za-z]+\.?\s*$/
  if(inputFullname.match(pattern)){
    
     var findInvalidImg = document.getElementById("invalidEmailImg")
     var findvalidImg = document.getElementById("validEmailImg")
     if(findInvalidImg != null){
      findInvalidImg.remove()
     }
     if(findvalidImg != null){
      findvalidImg.remove()
     }
    
    var createValidImg = document.createElement("img")
    createValidImg.src = "/src/main/resources/static/images/valid.png"
    createValidImg.setAttribute("class","validEmailImg")
    createValidImg.setAttribute("id", "validEmailImg")
    var findDiv = document.getElementById("formBox");
    findDiv.appendChild(createValidImg)
  }
  else if(inputFullname == ""){
    var findInvalidImg = document.getElementById("invalidEmailImg")
     var findvalidImg = document.getElementById("validEmailImg")
     if(findInvalidImg != null || findvalidImg != null){
      findInvalidImg.remove()
      findvalidImg.remove()
     }
  }
  else{
    var findvalidImg = document.getElementById("validEmailImg")
    var findInvalidImg = document.getElementById("invalidEmailImg")
    if(findInvalidImg != null){
      findInvalidImg.remove()
     }
     if(findvalidImg != null){
      findvalidImg.remove()
     }
    
    
    var createValidImg = document.createElement("img")
    createValidImg.src = "/src/main/resources/static/images/invalid.png"
    createValidImg.setAttribute("class","invalidEmailImg")
    createValidImg.setAttribute("id", "invalidEmailImg")
    var findDiv = document.getElementById("formBox");
    findDiv.appendChild(createValidImg)
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