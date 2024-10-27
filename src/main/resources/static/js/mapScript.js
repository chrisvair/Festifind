// Leaflet map initialization
var map = L.map('map').setView([46.60, 2.18], 6);

// Adding tile layer
L.tileLayer('https://tiles.stadiamaps.com/tiles/alidade_smooth_dark/{z}/{x}/{y}{r}.png', {
    maxZoom: 19,
    attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
}).addTo(map);

function search(event) {
    if (event.key === "Enter") {
        var searchTerm = document.getElementById("searchInput").value;
        var searchValue = document.getElementById("search-select").value;
        // Redirect to another page with the search term as a query parameter
        window.location.href = "/festival?search=" + encodeURIComponent(searchTerm)+"&value="+encodeURIComponent(searchValue);
    }
}


function getCitiesOnQuery() {
    let query = window.location.search;
    console.log(window.location.search);
    let url = '/api/data' + query;
    console.log(query);
    fetch(url)
        .then(response => response.json())
        .then(data => {
            console.log(window.location.search);
            let festivals = [];
            for (let i = 0; i < data.results.length; i++) {
                let name = data.results[i].nom_du_festival;
                let lat = data.results[i].geocodage_xy.lat;
                let lon = data.results[i].geocodage_xy.lon;
                festivals.push({ name, lat, lon });
            }
            // Initialize marker cluster group
            var markerCluster = L.markerClusterGroup({
                maxClusterRadius: 30 // cluster radius in pixels
            });

            // Adding markers to the marker cluster group
            for (let i = 0; i < festivals.length; i++) {
                let marker = L.marker([festivals[i].lat, festivals[i].lon])
                    .bindPopup(festivals[i].name);
                markerCluster.addLayer(marker); // Add marker to the cluster group
            }

            // Add the marker cluster group to the map
            map.addLayer(markerCluster);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
            throw error;
        });
}

getCitiesOnQuery();

// Card Interaction
// Wrap code that relies on the DOM inside the event listener
document.addEventListener('DOMContentLoaded', function() {

    var cards = document.querySelectorAll('.card');

    function zoomToCoordinates(lat, lon) {
        map.setView([lat, lon], 8);
    }

    cards.forEach(function(card) {
        card.addEventListener('click', function() {
            var lat = parseFloat(card.getAttribute('data-lat'));
            var lon = parseFloat(card.getAttribute('data-lon'));
            zoomToCoordinates(lat, lon);
        });
    });
});





