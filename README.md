# 🛠️ Gestion des Incidents Réseau
# 📌 Contexte :
#### Dans les organisations modernes, les infrastructures informatiques jouent un rôle central dans le fonctionnement quotidien des services. Les réseaux, les équipements et les systèmes doivent être opérationnels en permanence afin d’assurer la continuité des activités.Cependant, les incidents techniques (pannes matérielles, problèmes réseau, erreurs système, dysfonctionnements logiciels) sont inévitables. Lorsqu’ils ne sont pas gérés efficacement, ces incidents peuvent entraîner :Des interruptions de service ,Une perte de productivité ,Une baisse de performance et Des risques organisationnels .
#### Dans ce contexte, il devient indispensable de mettre en place un système informatisé permettant : L’enregistrement des incidents ,Le suivi de leur état ,L’affectation aux techniciens , La gestion des équipements concernés ,La consultation et la recherche rapide des informations.
#### C’est dans cette optique que le projet Gestion des Incidents Réseau a été développé, afin de proposer une application desktop permettant d’optimiser la gestion et le suivi des incidents au sein d’une organisation.
# ❓ Problématique:
#### Dans de nombreuses structures, la gestion des incidents est encore réalisée de manière manuelle ou semi-informatisée (documents papier, fichiers Excel, communications informelles). Cette méthode présente plusieurs limites :
#### - Difficulté de suivi des incidents en temps réel
#### - Absence de centralisation des informations
#### - Risque de perte de données
#### - Mauvaise affectation des techniciens
#### - Difficulté d’analyse statistique des incidents
#### - Manque de traçabilité et d’historique
#### Face à ces limitations, la problématique principale de ce projet est la suivante :Comment concevoir et développer une application informatique permettant de gérer efficacement les incidents réseau, d’assurer leur suivi, leur affectation et leur traitement, tout en garantissant la fiabilité, la centralisation et la sécurité des données ?
# 🎯 Objectif:
#### Le but principal est développé une application Java Desktop connectée à une base de données relationnelle, permettant :
#### - L’authentification des utilisateurs
#### - La gestion des incidents
#### - L’affectation aux techniciens
#### - La gestion des équipements
#### - La recherche multicritère
#### - Le suivi du statut des interventions
# 📊 Diagrammes :
## Diagramme use case
<img width="1446" height="908" alt="Capture d&#39;écran 2026-02-28 200038" src="https://github.com/user-attachments/assets/70a97c5b-ded2-4a2d-88f7-5f20b4cbd996" />

## Diagramme de classe :

<img width="770" height="585" alt="Capture d&#39;écran 2026-02-28 200451" src="https://github.com/user-attachments/assets/01f2c81c-ce0e-4511-a772-03b578286b06" />

# 🗃 Tables de Données:
#### - Incident (id, date ouverture , date cloture , priorite , statut)
#### - Technicien (id, nom, specialite , email)
#### - Equipement (id, nom, type, ip, localisation)
# ✨ Fonctionnalités Principales :
## Gestion des Équipements :
#### - Ajouter un équipement :Formulaire pour saisir le nom, type (Routeur / Switch / Point d’Accès), adresse IP et localisation.
#### - Modifier un équipement :Mettre à jour les informations d’un équipement existant.
#### - Supprimer un équipement :Retirer un équipement de la base de données.
## Gestion des Techniciens :
#### - Ajouter un technicien :Saisir le nom, spécialité (Réseau / Sécurité / Maintenance…), et email.
#### - Modifier un technicien :Mettre à jour les informations d’un technicien existant.
#### - Supprimer un technicien :Supprimer un technicien de la base.
## Gestion des Incidents : 
#### - Déclarer un incident :Créer un nouvel incident en sélectionnant :L’équipement concerné,Lapriorité (Faible / Moyenne / Élevée) ,La description ,La date d’ouverture  .
#### - Affecter un technicien :Associer un technicien à un incident.
#### - Clôturer un incident :Saisir la date de clôture et changer le statut en “Résolu”.
#### - Calcul automatique de la durée :Durée = dateCloture – dateOuverture.
## Filtrage des Incidents :
#### - Filtrer par priorité
#### - Filtrer par statut
#### - Filtrer par localisation
#### - Filtrer par période (date début – date fin)
# 🔍 Requêtes sql :

![WhatsApp Image 2026-02-28 at 20 43 00](https://github.com/user-attachments/assets/47b3d5ee-8d35-4481-9473-b063b79bb192)

![WhatsApp Image 2026-02-28 at 20 43 00](https://github.com/user-attachments/assets/e56f12ee-e623-4cdb-8d9b-7501f3e146ae)

![WhatsApp Image 2026-02-28 at 20 43 00](https://github.com/user-attachments/assets/8be949a5-aa2e-4d52-9a4f-c676ce6af2ca)

# 🏛 Architecture :
![WhatsApp Image 2026-02-28 at 12 50 53](https://github.com/user-attachments/assets/a2633e70-e22a-414a-895e-e03753b77029)

# 🛠 Technologies Utilisées:
#### - Base de données : MySQL
#### - Gestion de base de données : phpMyAdmin
#### - Accès aux données : JDBC
#### - Framework d'interface graphique : Java Swing
#### - Outils de développement : NetBeans (IDE Java) 
#### - Outil de diagramme:  StarUml
#### - Architectures : Draw io







https://github.com/user-attachments/assets/cf8a50b2-64c3-42fe-a4c3-bdb7a482702e




