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


setTimeout(function() {
    var s2 = document.getElementById('animated-title')
    s2.remove()
  }, 7000);

setTimeout(function(){
fadeInEffect("whiteBackground")
},6700);

