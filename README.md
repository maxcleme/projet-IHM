# Projet-IHM

## Specs fonctionnelles

- Contraintes des profs
- Génération des prévisualisations des emplois du temps
- Vote des profs
- Vote des étudiants
- Génération des .ics personnalisés pour chaque étudiant/prof

- INSTALLER MONGODB

## Méthodes API

Object TimeTable : { id, nom, imagePath, nbVote }


- TimeTableController :

	Ajouter un emploi du temps :
		PUT /timetable/{nom} + "file" dans le corp de la requette ( cf l'envoi de fichier dans FTP )
		Retour : Un objet TimeTable 
		
		Rq : Le nombre de vote est initialisé à 0.
		
	Lister les emplois du temps :
		GET /timetable
		Retour : La liste des emplois du temps
		
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
		
	
		




