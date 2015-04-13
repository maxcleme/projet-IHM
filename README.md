# Projet-IHM

## Specs fonctionnelles

- Contraintes des profs
- Génération des prévisualisations des emplois du temps
- Vote des profs
- Vote des étudiants
- Génération des .ics personnalisés pour chaque étudiant/prof

- INSTALLER MONGODB
- DEMARRER MONGODB AVANT DE LANCER LE SERVEUR


## Accès au resource

Les resources nécéssaires à la parti WEB sont placé dans :
	
	src/main/java/resources/public
	
Elles sont ensuites accessible par :

	localhost:8080/{nomDeLaRessource}

## Méthodes API

Object TimeTable : { id, nom, imagePath, nbVote }


- TimeTableController :

	Ajouter un emploi du temps :
		POST /timetable 
		Dans le corp de la requette :
			- "nom"
			- "file"  ( cf l'envoi de fichier dans FTP : multipart/form-data )
		Retour : Un objet TimeTable 
		
		Rq : Le nombre de vote est initialisé à 0. Un exemple de formulaire est disponible dans src/main/java/webapp/WEB-INF/jsp/index.jsp
		
	Lister les emplois du temps :
		GET /timetable
		Retour : La liste des emplois du temps
		
		GET /timetable?order={order}
		order = ASC | DESC
		
		
TODO : Parametrage optionnel sur le GET pour filtrer la liste.
	
- Vote :

	Ajouter un vode :
		PUT /vote/{idUser}/{idTimeTable}
		Retour : Un message de succes ou d'erreur.
		
		Rq : L'objet TimeTable d'id {idTableTable} est incrémenté de un. Le nombre de vote par Utilisateur est parametré sur 3.
		
	Supprimer un vote :
		DELETE /vote/{idUser}/{idTimeTable}
		Retour : Un message de succes ou d'erreur.
		
		Rq : L'objet TimeTable d'id {idTableTable} est decincrémenté de un.
		
- Contrainte :

	Lister les contraintes :
		GET /list/{idUser}
		Retour : une liste d'objet Contrainte
		
	Ajouter une contrainte :
		POST /add/{idUser}
		Dans le corp de la requette :
			- "motif"
			- "debut"
			- "fin"
			- "importance"
		Retour : Un objet Contrainte
		
	Modifier une contrainte :
		POST /update/{idUser}
		Dans le corp de la requette :
			- "id"
			- "motif"
			- "debut"
			- "fin"
			- "importance"
		Retour : Un objet Contrainte
		
	Supprimer une contrainte :	
		DELETE /delete/{idUser}/{idContrainte}
		Retour : void
		




