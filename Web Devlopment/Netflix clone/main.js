
let i;

const topp = document.getElementById("trending");
const thriller = document.getElementById("thriller");
const children = document.getElementById("children");
const romantic = document.getElementById("romantic");
const suspense = document.getElementById("suspence");
async function ne() {
    const data = await fetch("movies.json");
    const respdata = await data.json();
    // console.log(respdata)
    for (i = 0; i < 6; i++) {
        let imgg = document.createElement("div");
        imgg.setAttribute('id', String(i))
        imgg.innerHTML = `<img src=${respdata["top"][i].Poster} alt="" id="${String(i)}" class="cardimg">`;
        topp.appendChild(imgg);
        imgg.addEventListener("click", () => {
            const newel = document.createElement("div");
            newel.setAttribute('id', 'discon');
            newel.classList.add("content");
            newel.innerHTML = `<h1> ${respdata["top"][imgg.id].Title}</h1>
            <h2>${respdata["top"][imgg.id].Plot}</h2>
            <button class="btn" onclick="lightbox_close();">Play</button>`;
            document.querySelector(".judgy").innerHTML = `<img src=${respdata["top"][imgg.id].Poster} alt="" class="imgshow">`;
            document.querySelector(".judgy").appendChild(newel);

        });
    }
    i = 0;
    for (i = 0; i < 6; i++) {
        let imgg = document.createElement("div");
        imgg.setAttribute('id', String(i))
        imgg.innerHTML = `<img src=${respdata["thriller"][i].Poster} alt="" class="cardimg">`;
        thriller.appendChild(imgg);
        imgg.addEventListener("click", () => {
            const newel = document.createElement("div");
            newel.setAttribute('id', 'discon');
            newel.classList.add("content");
            newel.innerHTML = `<h1> ${respdata["thriller"][imgg.id].Title}</h1>
            <h2>${respdata["thriller"][imgg.id].Plot}</h2>
            <button class="btn" onclick="lightbox_close();">Play</button>`;
            document.querySelector(".judgy").innerHTML = `<img src=${respdata["thriller"][imgg.id].Poster} alt="" class="imgshow">`;
            document.querySelector(".judgy").appendChild(newel);

        });

    }
    i = 0;
    for (i = 0; i < 6; i++) {
        let imgg = document.createElement("div");
        imgg.setAttribute('id', String(i))
        imgg.innerHTML = `<img src=${respdata["children"][i].Poster} alt="" class="cardimg">`;
        children.appendChild(imgg);
        imgg.addEventListener("click", () => {
            const newel = document.createElement("div");
            newel.setAttribute('id', 'discon');
            newel.classList.add("content");
            newel.innerHTML = `<h1> ${respdata["children"][imgg.id].Title}</h1>
            <h2>${respdata["children"][imgg.id].Plot}</h2>
            <button class="btn" onclick="lightbox_close();">Play</button>`;
            document.querySelector(".judgy").innerHTML = `<img src=${respdata["children"][imgg.id].Poster} alt="" class="imgshow">`;
            document.querySelector(".judgy").appendChild(newel);

        });

    }
    i = 0;
    for (i = 0; i < 6; i++) {
        let imgg = document.createElement("div");
        imgg.setAttribute('id', String(i))
        imgg.innerHTML = `<img src=${respdata["Suspence"][i].Poster} alt="" class="cardimg">`;
        suspense.appendChild(imgg);
        imgg.addEventListener("click", () => {
            const newel = document.createElement("div");
            newel.setAttribute('id', 'discon');
            newel.classList.add("content");
            newel.innerHTML = `<h1> ${respdata["Suspence"][imgg.id].Title}</h1>
            <h2>${respdata["Suspence"][imgg.id].Plot}</h2>
            <button class="btn" onclick="lightbox_close();">Play</button>`;
            document.querySelector(".judgy").innerHTML = `<img src=${respdata["Suspence"][imgg.id].Poster} alt="" class="imgshow">`;
            document.querySelector(".judgy").appendChild(newel);

        });

    }
    i = 0;
    for (i = 0; i < 6; i++) {
        let imgg = document.createElement("div");
        imgg.setAttribute('id', String(i))
        imgg.innerHTML = `<img src=${respdata["Romantic"][i].Poster} alt="" class="cardimg">`;
        romantic.appendChild(imgg);
        imgg.addEventListener("click", () => {
            const newel = document.createElement("div");
            newel.setAttribute('id', 'discon');
            newel.classList.add("content");
            newel.innerHTML = `<h1> ${respdata["Romantic"][imgg.id].Title}</h1>
            <h2>${respdata["Romantic"][imgg.id].Plot}</h2>
            <button class="btn" onclick="lightbox_close();">Play</button>`;
            document.querySelector(".judgy").innerHTML = `<img src=${respdata["Romantic"][imgg.id].Poster} alt="" class="imgshow">`;
            document.querySelector(".judgy").appendChild(newel);

        });

    }


}
ne()

window.document.onkeydown = function (e) {
    if (!e) {
        e = event;
    }
    if (e.keyCode == 27) {
        lightbox_close();
    }
}

function lightbox_open() {
    document.getElementById("VisaChipCardVideo").classList.toggle("hide");
    var lightBoxVideo = document.getElementById("VisaChipCardVideo");
    window.scrollTo(0, 0);
    document.getElementById('light').style.display = 'block';
    document.getElementById('fade').style.display = 'block';
    lightBoxVideo.play();
}

function lightbox_close() {
    document.getElementById("VisaChipCardVideo").classList.toggle("hide");
    var lightBoxVideo = document.getElementById("VisaChipCardVideo");
    document.getElementById('light').style.display = 'none';
    document.getElementById('fade').style.display = 'none';
    lightBoxVideo.pause();
}