let pageIntro = document.querySelector('.page-intro');
let nextBtn = document.querySelector('.next-btn');
let backBtn = document.querySelector('.back-btn');
let i = 0;
let pagination = document.querySelectorAll('.fa-circle');

arr = ['https://wallpaperboat.com/wp-content/uploads/2019/10/cool-website-background-02.jpg', 'https://freellustrustrations.s3.us-east-2.amazonaws.com/free-images/thumbimg_25361957thumbejpg.jpg', 'https://images.pexels.com/photos/1229861/pexels-photo-1229861.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'https://i.pinimg.com/600x315/3d/38/4d/3d384d829dbf4b678cfea617114e149d.jpg'];
function updatePagination(i) {
    for (let j = 0; j < arr.length; j++) {
        if (j == i) {
            pagination[j].classList.remove('fas');
            pagination[j].classList.add('far');
        }
        else {
            pagination[j].classList.remove('far');
            pagination[j].classList.add('fas');
        }
    }
}
nextBtn.addEventListener('click', function (e) {
    if (i < arr.length - 1)
        i++;
    else i = 0;
    pageIntro.style.backgroundImage = `url(${arr[i]})`;
    updatePagination(i);
})
backBtn.addEventListener('click', function (e) {
    if (i > 0)
        i--;
    else i = arr.length - 1;
    pageIntro.style.backgroundImage = `url(${arr[i]})`;
    updatePagination(i);
})

let mainImage = document.querySelector('.main-img');
let lifeImages = document.querySelectorAll('.img-container img');
for (let i = 0; i < lifeImages.length; i++) {
    lifeImages[i].addEventListener('click', function (e) {
        for (let j = 0; j < lifeImages.length; j++) {
            lifeImages[j].classList.remove('active-img');
        }
        e.currentTarget.classList.add('active-img');
        mainImage.src = e.currentTarget.src;
    })
}

let vids = document.querySelectorAll('video');
let downVidBtn = document.querySelector('.next-btn-vid');
let upVidBtn = document.querySelector('.back-btn-vid');
let videoNum = 0;
downVidBtn.addEventListener('click', function (e) {
    vids[videoNum].pause();
    if (videoNum < 2) videoNum++;
    vids[videoNum].scrollIntoView({
        behavior: "auto",
        block: "center",
        inline: "center"
    });
    vids[videoNum].play();
})
upVidBtn.addEventListener('click', function (e) {
    vids[videoNum].pause();
    if (videoNum > 0) videoNum--;
    vids[videoNum].scrollIntoView({
        behavior: "auto",
        block: "center",
        inline: "center"
    });
    vids[videoNum].play();
})