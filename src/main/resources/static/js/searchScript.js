function search(event) {
    if (event.key === "Enter") {
        var searchTerm = document.getElementById("searchInput").value;
        // Redirect to another page with the search term as a query parameter
        window.location.href = "/festival?search=" + encodeURIComponent(searchTerm);
        console.log(window.location.search);
    }
}
