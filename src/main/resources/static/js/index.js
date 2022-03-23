var delayInMilliseconds = 5000; //1 second

setTimeout(function() {
  fadeOutEffect(
  )
}, delayInMilliseconds);

function fadeOutEffect() {
    var s = document.getElementById('animated-title').style;
    s.opacity = 1;
    (function fade(){(s.opacity-=.1)<0?s.display="none":setTimeout(fade,40)})();
    var s2 = document.getElementById('animated-title')
    
}

setTimeout(function() {
    var s2 = document.getElementById('animated-title')
    s2.remove()
  }, 7000);