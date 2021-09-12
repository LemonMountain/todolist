const API_KEY = "0cb4d5b98a3cbf5e54def4092e5d914d";

function todolistWeather(position) {
    const lat = position.coords.latitude;
    const lng = position.coords.longitude;

    const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lng}&appid=${API_KEY}&units=metric`;
    fetch(url).then(response => response.json()).then((data) => {
        const weather = document.querySelector("#weather span:first-child");
        const city = document.querySelector("#weather span:last-child");
        console.log(url);
        city.innerHTML = data.name;
        weather.innerHTML = `${data.weather[0].main} / ${data.main.temp}`;
    });
}

    function weatherError() {
        alert("널 찾을 수 없어...거기에서 기다려줘 내가 금방 널 찾을게..!");
    }

navigator.geolocation.getCurrentPosition(todolistWeather, weatherError);
