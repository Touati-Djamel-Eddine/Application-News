***********************************************************************************************************
# Informations sur l’application et la librairie :
***********************************************************************************************************

Application : l’application utilise le module api Request pour récupérer les données (la liste des films et actualités). elle se compose d’une vue principale divisé en deux partie:<br/>
<br/>
    - La première partie en haut contient la liste des films, l’utilisateur peut choisir entre afficher les films populaire ou les mieux notés via un spinner. Un bouton permettant de faire un refresh de la liste. la vue contient également une interaction que lorsque l’utilisateur clique sur un film une vue avec les détails de ce dernier sera affiché.
    - La deuxième partie contient une liste des dernières actualités avec un filtre par pays et un bouton refresh. La liste est mise à jour chaque 10 minutes.
<br/>
l’architecture MVVM est implémenté dans cette Application. la langue est également adapté automatiquement  entre Anglais et français par rapport à la langue utilisé par défaut dans le téléphone.
<br/>

Module Api request : c’est un module android permettant  d'exécuter des requêtes API du site <a href="https://themoviedb.org" target="_blank">`https://themoviedb.org`</a>  pour récuperer les films(les plus populaire ou les mieux notés)  et du site <a href="https://newsapi.org" target="_blank">`https://newsapi.org`</a>   pour récuperer les dernières actualités avec un filtre par pays.
le module est chargé sur Jcenter(Bintray) afin de rendre la librairie accessible à tous.<br/>

le module peut être utilisée via jCenter en utilisant une implémentation :<br/>
```
    implementation "com.djamel.apirequestlibrary:apirequestlibrary:1.0.0"
```
<br/>

## Support

Reach out to me at one of the following places!

- gmail : kadertouati78@gmail.com




