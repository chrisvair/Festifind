<h1>FESTI'FIND - Trouvez le festival de votre coeur !</h1>

<h2>Présentation de notre site</h2>

<p>
    Notre plateforme conviviale et intuitive vous permet de rechercher facilement des festivals en fonction de votre emplacement, de vos préférences musicales, artistiques ou culturelles. Que vous soyez passionné de musique, de cinéma, de gastronomie ou d'arts visuels, Festi'find vous propose une sélection variée d'événements adaptés à vos goûts.
</p>    
<p>
    Notre site expose une API, dont le fonctionnement est décrit à la fin de ce document, et consommme 3 différentes API.
</p>

<h3>API consommées</h3>

<ul>
    <li>Nous utilisons l'API du gouvernement pour recueillir la liste des festivals et leurs informations</li>
    <pre><a href=https://data.culture.gouv.fr/explore/dataset/festivals-global-festivals-_-pl/information/>https://data.culture.gouv.fr/explore/dataset/festivals-global-festivals-_-pl/information/</a></pre>
    <li>Nous utilisons l'API du gouvernement API Geo de découpage administratif pour relier les communes à leurs coordonnées GPS</li>
    <pre><a href=https://api.gouv.fr/documentation/api-geo>https://api.gouv.fr/documentation/api-geo</a></pre>
    <li>Nous utilisons l'API de Leaflet via la librairie Leaflet pour afficher une carte interactive</li>
    <pre><a href=https://leafletjs.com/>https://leafletjs.com/</a></pre>
</ul>



<h2>Page d'Accueil</h2>

<p>Cette page représente la page d'accueil de l'application Festi'Find.</p>

<h3>Structure de la Page</h3>

<ul>
    <li>La page inclut une barre de navigation.</li>
    <li>Un champ de recherche est disponible pour rechercher des festivals.</li>
    <li>La carte interactive affiche les emplacements des festivals.</li>
</ul>

<h3>Ressources Utilisées</h3>

<ul>
    <li>La page utilise Leaflet.js pour afficher la carte interactive.</li>
    <li>Le style de la page est personnalisé avec des feuilles de style CSS.</li>
    <li>Bootstrap est utilisé pour le style et la mise en page.</li>
    <li>Le plugin Geoportal Leaflet est utilisé pour intégrer des fonctionnalités supplémentaires à la carte.</li>
</ul>

<h3>Fonctionnalité de Recherche</h3>

<ul>
    <li>Les utilisateurs peuvent rechercher des festivals en saisissant un terme dans le champ de recherche et en appuyant sur "Enter".</li>
    <li>La recherche redirige vers une autre page avec le terme de recherche en tant que paramètre de requête.</li>
</ul>

<h2>Festivals</h2>

<h3>Liste des Festivals</h3>

<p>Cette page affiche une liste de festivals avec leurs détails associés.</p>

<h3>Structure de la Page</h3>

<ul>
    <li>La page inclut une barre de navigation.</li>
    <li>Chaque festival est représenté par une carte affichant les détails suivants :</li>
    <ul>
        <li>Nom du festival</li>
        <li>Période principale de déroulement du festival</li>
        <li>Commune principale de déroulement</li>
        <li>Sous-catégorie de musique</li>
        <li>Un bouton "Voir plus" pour afficher davantage de détails sur le festival.</li>
    </ul>
    <li>La page inclut également une carte interactive affichant l'emplacement de chaque festival.</li>
</ul>

<h3>Scripts Utilisés</h3>

<ul>
    <li>La page utilise Leaflet.js pour afficher la carte interactive.</li>
    <li>Leaflet.markercluster est utilisé pour regrouper les marqueurs sur la carte.</li>
    <li>Bootstrap est utilisé pour le style des boutons et de la mise en page.</li>
</ul>

<h2>Détails du Festival</h2>

<h3>Structure de la Page</h3>

<ul>
  <li>La page affiche les détails d'un festival sélectionné.</li>
  <li>Elle inclut une barre de navigation.</li>
  <li>Les détails du festival sont présentés dans une carte.</li>
  <li>Une section de commentaires permet aux utilisateurs d'ajouter et de consulter des commentaires sur le festival.</li>
  <li>Un bouton "Retour" permet de revenir à la page précédente.</li>
</ul>

<h3>Détails du Festival</h3>

<ul>
  <li>Le nom du festival, sa période de déroulement principale, sa commune principale de déroulement et sa sous-catégorie musicale sont affichés.</li>
  <li>Un lien vers le site Internet du festival est disponible.</li>
</ul>

<h3>Section des Commentaires</h3>

<ul>
  <li>Les commentaires associés au festival sont affichés.</li>
  <li>Les utilisateurs peuvent ajouter un nouveau commentaire via un formulaire.</li>
  <li>Chaque commentaire affiche le nom de l'auteur, la date et le contenu du commentaire.</li>
</ul>

<h3>Ressources Utilisées</h3>

<ul>
  <li>La page utilise Leaflet.js pour afficher la carte interactive des détails du festival.</li>
  <li>Le plugin Leaflet.markercluster est utilisé pour regrouper les marqueurs sur la carte.</li>
  <li>Bootstrap est utilisé pour le style des boutons et de la mise en page.</li>
</ul>

<h2>Documentation de notre API</h2>
<h3>Obtenir les festivals avec les commentaires</h3>
<p>Notre API vous permet de récupérer une liste de festivals avec leurs commentaires associés.</p>
<h3>Endpoint</h3>
<pre>GET /api/explore</pre>
<h3>Paramètres de requête</h3>
<ul>
    <li><strong>search</strong> (optionnel) : Permet de filtrer les festivals par un terme de recherche.</li>
    <li><strong>value</strong> (optionnel) : Spécifie le type de recherche. Les valeurs possibles sont "Festival", "Month" et "Location".</li>
</ul>
<h3>Exemple</h3>
<pre>GET /api/explore?search=test&amp;value=Location</pre>
<h3>Réponse</h3>
<p>La réponse est un tableau JSON contenant des objets représentant les festivals ainsi que leurs commentaires associés.</p>
<h3>Détails de l'implémentation</h3>
<p>L'API interagit avec notre base de données et d'autres services pour récupérer les informations sur les festivals et leurs commentaires associés. Les festivals sont récupérés à partir d'une source de données externe à l'aide de requêtes HTTP, puis enrichis avec les commentaires provenant d'un service Firebase. Les commentaires sont associés aux festivals en fonction de leur identifiant unique. L'API est implémentée en utilisant le framework Spring Boot en Java.</p>
