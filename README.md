# RH Manager

## Table des Matières

1. [Introduction](#introduction)
2. [Fonctionnalités](#fonctionnalités)
3. [Architecture](#architecture)
4. [Technologies Utilisées](#technologies-utilisées)
5. [Prérequis](#prérequis)
6. [Installation et Configuration](#installation-et-configuration)
7. [Commandes de Compilation et de Lancement](#commandes-de-compilation-et-de-lancement)
8. [Structure du Projet](#structure-du-projet)
9. [Modèle de Données](#modèle-de-données)
10. [Sécurité](#sécurité)
11. [Contributions](#contributions)

---

## Introduction

**RH Manager** est une application web CRUD conçue pour simplifier la gestion des employés d'une organisation. Développée en utilisant Spring Boot pour le back-end et Thymeleaf pour le front-end, cette application permet d'ajouter, de modifier, de consulter et de supprimer les informations des employés dans une base de données MySQL. Elle adopte une architecture MVC claire pour garantir maintenabilité et extensibilité.

---

## Fonctionnalités

- Ajouter un nouvel employé.
- Modifier les informations d'un employé existant.
- Supprimer un employé.
- Lister tous les employés.
- Valider les données saisies pour éviter les erreurs.
- Authentification et autorisation via Spring Security.

---

## Architecture

- **Pattern** : MVC (Model-View-Controller)
- **Backend** : Spring Boot
- **Frontend** : Thymeleaf (template engine)

---

## Technologies Utilisées

- **Langage** : Java 17
- **Frameworks** : Spring Boot (Web, Security, Data JPA, Validation)
- **Base de Données** : MySQL
- **Gestionnaire de Dépendances** : Maven
- **Autres** : Lombok pour réduire le boilerplate code

---

## Prérequis

Avant de commencer, assurez-vous d'avoir les outils suivants installés sur votre machine :

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [MySQL](https://dev.mysql.com/downloads/)
- Un IDE comme IntelliJ IDEA ou Eclipse

---

## Installation et Configuration

1. Clonez le projet :
   ```bash
   git clone https://github.com/votre-repo/rh-manager.git
   ```

2. Importez le projet dans votre IDE préféré.

3. Configurez la base de données dans `application.properties` :
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/rh_manager
   spring.datasource.username=VOTRE_UTILISATEUR
   spring.datasource.password=VOTRE_MOT_DE_PASSE
   spring.jpa.hibernate.ddl-auto=update
   ```

4. Installez les dépendances Maven :
   ```bash
   mvn clean install
   ```

5. Lancez l'application :
   ```bash
   mvn spring-boot:run
   ```

---

## Commandes de Compilation et de Lancement

- Pour compiler le projet :
  ```bash
  mvn clean install
  ```

- Pour exécuter l'application :
  ```bash
  mvn spring-boot:run
  ```

- Pour générer un fichier JAR exécutable :
  ```bash
  mvn clean package
  ```
  Le fichier JAR se trouvera dans le répertoire `target/`. Vous pouvez le lancer avec :
  ```bash
  java -jar target/rh-manager-1.0.0.jar
  ```

---

## Structure du Projet

Voici une vue d'ensemble de l'arborescence du projet :

```
RHManager/
├── src/main/java/com/example/rhmanager
│   ├── controller         # Contrôleurs Spring MVC
│   ├── model              # Entités JPA
│   ├── repository         # Interfaces JPA pour la gestion des données
│   ├── service            # Logique métier
│   └── RHManagerApplication.java  # Point d'entrée de l'application
├── src/main/resources
│   ├── static             # Fichiers CSS/JS
│   ├── templates          # Vues Thymeleaf
│   └── application.properties # Configuration de l'application
└── pom.xml                # Gestion des dépendances Maven
```

---

## Modèle de Données

La base de données contient une table principale :

### Table `employee`

| Colonne       | Type           | Contraintes          |
|---------------|----------------|----------------------|
| id            | BIGINT         | Primary Key, Auto-increment |
| nom           | VARCHAR(50)    | NOT NULL             |
| prenom        | VARCHAR(50)    | NOT NULL             |
| telephone     | VARCHAR(15)    | NULLABLE             |
| domaine       | VARCHAR(50)    | NULLABLE             |
| salaire       | DECIMAL(10,2)  | NULLABLE             |

---

## Sécurité

L'application utilise **Spring Security** pour gérer l'authentification et l'autorisation :

- Authentification basée sur une base de données (utilisateurs/admins).
- Accès restreint à certaines pages selon le rôle de l'utilisateur.

---

## Contributions

Les contributions sont les bienvenues !

1. Forkez le projet.
2. Créez une branche pour votre fonctionnalité :
   ```bash
   git checkout -b feature/ma-fonctionnalite
   ```
3. Faites vos modifications et committez :
   ```bash
   git commit -m "Ajout d'une nouvelle fonctionnalité"
   ```
4. Poussez la branche :
   ```bash
   git push origin feature/ma-fonctionnalite
   ```
5. Créez une Pull Request.

---

Merci d'utiliser **RH Manager** ! 🎉
