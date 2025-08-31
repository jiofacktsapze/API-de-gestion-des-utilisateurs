# API de Gestion des utilisateurs

## 📌 Fonctionnalités
- 📄 Créer un utilisateur avec nom, email et mot de passe (crypté avec
	BCrypt).
- 📋 Consulter la liste des utilisateurs. (Authentification exigée)
- 📝 Mettre à jour un utilisateur. (Authentification exigée)
- 🗑️ Supprimer un utilisateur. (Authentification exigée)
- 🗑️ Authentification : Un utilisateur peut se connecter via son email et son mot de passe.


Prérequis :

IDE recommandé : IntelliJ IDEA
Outils de test : Swagger UI ou Postman
Environnement : JDK 21 et Maven
Importation du projet : Ouvrir le dossier du projet dans IntelliJ IDEA Laisser l'IDE configurer les dépendances automatiquement


Créer une base de données PostgreSQL nommée usermanagment via pgAdmin, ou alors vous pouvez aussi aussi créer une base de donnée avec un autre nom, il vous suffira juste de modifier les informations de l'application dans le fichier "application.properties" ou "application.yml" pour les adapter aux votres.

Compilation et lancement : Compiler le projet Lancer l'application via la classe principale (annotée @SpringBootApplication) en utilisant le bouton "run" de votre IDE intellij

🚀 url pour tester l'application sur swagger
Accès à l'interface Swagger : Ouvrir un navigateur web Accéder à : 👉 http://localhost:8080/swagger-ui.html ou 👉 http://localhost:8080/swagger-ui/index.html


Instruction pour les test sur swagger:

Après avoir démarrer le projet, bien vouloir utiliser ces liens http://localhost:8080/swagger-ui/index.html#/   ou ceci http://localhost:8080/swagger-ui/index.html pour avoir accès à l’interface graphique de swagger puis créer un utilisateur (avec pour rôle ADMIN) sur l’API POST /api/auth/register Ajouter un nouveau utilisateur avec par exemple les données suivantes :
{
  "username": "username",
  "email": "email@gmail.com",
  "password": "password",
  "role": "ADMIN"
}

Response body : Vous verez l'utilisateur que vous venez de créer avec les détails Code réponse : 200 OK

Ensuite utilisez exactement ces mêmes données ci-dessus que vous avez renseignés pour vous authentifier à travers l’API POST/api/auth/login, une fois connecté utilisez le token qui ous sera genéré sur Authorize(un symbole de cadenas) puis coller uniquement le token du genre(HYjjsbdk5rzfgbjfe6...) dans le champ value qui vous sera proposé ensuite cliquez sur close tout en restant connecté car c’est une fois authentifié que vous pouvez tester toutes les autres API car elles exigent d’être d’abord authentifiées avant de faire toutes opérations sur les autres API.


Tester un endpoint (exemple PUT) : CAS DE MISE A JOUR D'UN UTILISATEUR Dans Swagger UI : Sélectionner le contrôleur PUT Met à jour un utilisateur Cliquer sur "PUT" pour développer la section Cliquer sur "Try it out" Dans le corps de la requête : Remplacer le contenu exemple par vos données Exemple : 
{
  "username": "user100",
  "email": "email@gmail.com",
  "password": "password",
  "role": "ADMIN"
}

Supprimer l'id (généré automatiquement) Renseigner les champs obligatoires (titre, description, statut)

Cliquer sur "Execute" Vérifier la réponse "les nouvelles données mise à jour" si tout s'est bien passé

Response body : Vous verez la tache que vous venez de créer avec les détails Code réponse : 200 OK

NB : Veuiller à bien respecter l'étape d'authentification car ce n'est qu'une fois authentifié que vous pourrez exécuter toutes les autres requettes car la seule requette disponible sans authentification est la requette:
POST
/api/auth/register
Ajouter un nouveau utilisateur

pour exécuter les autres il vous faut etre authentifié.
