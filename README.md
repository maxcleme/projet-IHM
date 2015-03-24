# Projet-IHM

## Specs fonctionnelles

- Contraintes des profs
- Génération des prévisualisations des emplois du temps
- Vote des profs
- Vote des étudiants
- Génération des .ics personnalisés pour chaque étudiant/prof

## Méthodes API

- Ajouter EDT    : 			PUT /emploidutemps
						{ nom : 'Nom'}
- Stockage image : 			PUT /image
- Liste des EDT  : 			GET /emploidutemps(/column/order) <- Route optionnelle
						[{ nom: 'Nom', image: 'Image.png', votes : 6 }, { nom: 'Nom2', image: 'Image2.png', votes : 9 }]
- Vote           : 			PUT /vote/iduser/idemploidutemps
- Annuler vote	 :			DELETE /vote/iduser/idemploidutemps


