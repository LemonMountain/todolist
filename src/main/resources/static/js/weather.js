const API_KEY = "af44d685b9a7132a149ac0fac81a7fe7";

function location(position) {
    var lat = position.coords.latitude;
    var lng = position.coords.longitude;

    var url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lng}&appid=${API_KEY}&units=metric`;
    fetch(url).then(response => response.json()).then((data) => {
        const weather = document.querySelector("#weather span:first-child");
        const city = document.querySelector("#weather span:last-child");
        city.innerHTML = data.name;
    })
}