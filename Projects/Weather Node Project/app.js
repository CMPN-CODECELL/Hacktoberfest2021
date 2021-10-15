// const { response } = require("express");
const express = require("express")
const https = require("https")
const path = require("path")

const bodyParser = require("body-parser")

const app = express();
app.use(bodyParser.urlencoded({extended: true}))

app.get("/", function(req, res) {
    res.sendFile(__dirname + "/index.html")
})

app.post("/", function(req, res) {

    const city = req.body.cityName
    const url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=bc46936b15431a851c0d571a7ddafd3e&units=metric#"
    https.get(url, function(response) {
        console.log(response.statusCode)
        
        response.on("data", (data) => {
            const weatherData = JSON.parse(data)
            const temp = weatherData.main.temp
            const weatherDescription = weatherData.weather[0].description
            const icon = weatherData.weather[0].icon
            const imgurl = "https://openweathermap.org/img/wn/" + icon + "@2x.png"
            res.write(`<p>The weather is ${weatherDescription}</p>`)
            res.write(`<h1>The Temprature in ${city} is ${temp} degree celcius</h1>`)
            res.write(`<img src= "${imgurl}" alt="Description-Pic">`)
            res.send()
        })
    })
})

app.listen(3000, function() {
    console.log("Server is running")
})