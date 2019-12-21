***********************************************************************************************************
# Informations sur l’application et la librairie :
***********************************************************************************************************
Module Api request : c’est un module android permettant  d'exécuter des requêtes API du site <a href="https://themoviedb.org" target="_blank">`https://themoviedb.org`</a>  pour récuperer les films(les plus populaire ou les mieux notés)  et du site <a href="https://newsapi.org" target="_blank">`https://newsapi.org`</a>   pour récuperer les dernières actualités avec un filtre par pays.
le module est chargé sur Jcenter(Bintray) afin de rendre la librairie accessible à tous.<br/>

le module peut être utilisée via jCenter en utilisant une implémentation :<br/>
```
    implementation "com.djamel.apirequestlibrary:apirequestlibrary:1.0.0"
```
<br/>
Application : l’application utilise le module api Request pour récupérer les données (la liste des films et actualités). elle se compose d’une vue principale divisé en deux partie:<br/>
<br/>
    - La première partie en haut contient la liste des films, l’utilisateur peut choisir entre afficher les films populaire ou les mieux notés via un spinner. Un bouton permettant de faire un refresh de la liste. la vue contient également une interaction que lorsque l’utilisateur clique sur un film une vue avec les détails de ce dernier sera affiché.
    - La deuxième partie contient une liste des dernières actualités avec un filtre par pays et un bouton refresh. La liste est mise à jour chaque 10 minutes.
<br/>
l’architecture MVVM est implémenté dans cette Application. la langue est également adapté automatiquement  entre Anglais et français par rapport à la langue utilisé par défaut dans le téléphone.
<br/>

***********************************************************************************************************
# Voici les étapes à suivre pour upload une librairie sur Bintray 
***********************************************************************************************************

1:/Création d’un compte Bintray : créez un compte sur bintray.com

2:/Création d’un nouveau référentiel :  Dans le tableau de bord de votre profil cliquez sur le bouton  Add New Repository et un simple formulaire à remplir vous sera présenté.<br/>

3:/Ajout d’un nouveau paquet : cliquez sur Add New Package et remplissez les informations nécessaires.

4:/Ajout d’une nouvelle version: cliquez sur le bouton add new version et ajouté un numéro de version par exemple : 1.0.0<br/>

5:/Configuration du gradle dans android studio : La première étape consiste à ajouter des plugins Bintray et Maven dans votre projet Android. Alors, ajoutez ces lignes dans votre build.gradlefichier racine <br/>
    
            classpath 'com.jfrog.bintray.gradle:gradle-bintray-plugin:1.4'
            classpath 'com.github.dcendents:android-maven-gradle-plugin:1.4.1'
    
    Maintenant, vous devez configurer les configurations de votre bibliothèque dans le build.gradlefichier de la bibliothèque.
    <br/>;
            ext {
                bintrayRepo = 'apirequestlibrary'
                bintrayName = 'com.djamel.apirequestlibrary'

                libraryName='apirequestlibrary'

                publishedGroupId = 'com.djamel.apirequestlibrary'
                artifact = 'apirequestlibrary'

                libraryDescription = 'push library apirequest in bintray'

                siteUrl = 'https://github.com/dtouati/apirequestlibrary'
                gitUrl = 'https://github.com/dtouati/apirequestlibrary.git'

                libraryVersion = '1.0.0'

                developerId = 'dtouati'
                developerName = 'Touati Djamel'
                developerEmail = 'dtouati@adneom.com'

                licenseName = 'The Apache Software License, Version 2.0'
                licenseUrl = 'http://www.apache.org/licenses/LICENSE-2.0.txt'
                allLicenses = ["Apache-2.0"]
            }
        //add these liens to publish library to bintray
        if (project.rootProject.file('local.properties').exists()) {
            apply from: 'https://raw.githubusercontent.com/numetriclabz/jcenter/master/installv.gradle'
            apply from: 'https://raw.githubusercontent.com/numetriclabz/jcenter/master/bintrayv.gradle'
        }
<br/>
    Ligne 2 et 3: Nous appliquons nos plugins Bintray et Maven.
    Ligne 8 et 9: Nous spécifions les noms de référentiel et de package Bintray. Vous pouvez les voir dans l'image suivante.<br/>
    Ligne 11: Nous spécifions le nom du module dont AAR / JAR à compiler et à télécharger sur Bintray et jCenter<br/>
    Lignes 17, 18 et 19: elles spécifient respectivement l'ID de groupe, l'ID d'artefact et le numéro de version. Toute bibliothèque sur jCenter est récupérée dans Android Studio à l'aide de cette structure.<br/>
    Ligne 22 à ligne 30: Ce sont les détails de la bibliothèque et sont explicites.
    Ligne 47: Ceci est une condition pour vérifier si le projet a un local.propertiesfichier ou non. Si le fichier n'est pas disponible, la tâche de téléchargement ne s'exécutera pas.<br/>
    Lignes 48 et 49: Ces lignes téléchargeront les tâches de gradeau à télécharger sur le bintray à partir des URL spécifiées.<br/>


5:/Ajout d’une clé api : Copiez votre clé API et ajoutez ces lignes dans votre 
    ```java 
            local.propertiesfichier : =>
    ```
    ```java
            bintray.user=Your_bintray_username
            bintray.apikey=Your_API_key
    ```


6:/Compiler la librairie : exécutez la commande suivante pour compiler :<br/>
    ```
        $gradlew install
    ```
    <br/>
    Si vous rencontrez une erreur liée à javadoc ou si vous voyez quelque chose comme l'image ci-dessous, utilisez cette solution de contournement.
    Ajoutez ces lignes dans votre build.gradlefichier racine pour résoudre ce problème javadoc.<br/>
        ```java
            subprojects {
                tasks.withType(Javadoc).all { enabled = false }
            }
        ```

7:/upload la librairie sur Bintray: Après que la compilation est réussi. exécutez la commande suivante : <br/>
    ```
    $gradlew bintrayupload
    ```
    <br/>
8:/Ajout de la librairie JCenter : Enfin ajouter la librairie sur jCentre en cliquant sur le bouton AddJCenter. Vous devez notamment attendre quelques heures avant que votre requête soit accepté.<br/>

## Support

Reach out to me at one of the following places!

- gmail : kadertouati78@gmail.com




