function accordionToggle() {
  let accordion = document.querySelector('.accordion');

  if (accordion.style.display === 'none' || accordion.style.display === '') {
    accordion.style.display = 'block';
  } else {
    accordion.style.display = 'none';
  }
};

window.onload = function() {
  let a = document.getElementById("saiba");

  a.onclick = function() {
    accordionToggle();
    return false;
  }
}