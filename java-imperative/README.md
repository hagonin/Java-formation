# Application de Recensement de Population

## Description

Cette application Java permet d'analyser les données de recensement de population françaises à partir d'un fichier CSV. Elle offre une interface en ligne de commande avec un menu interactif pour rechercher et afficher diverses statistiques de population.

## Fonctionnalités

L'application propose 9 options dans son menu principal :

1. **Population d'une ville** - Recherche la population d'une ville spécifique
2. **Population d'un département** - Calcule la population totale d'un département
3. **Population d'une région** - Calcule la population totale d'une région
4. **Top 10 des régions les plus peuplées** - Affiche les régions classées par population
5. **Top 10 des départements les plus peuplés** - Affiche les départements classés par population
6. **Top 10 des villes les plus peuplées d'un département** - Recherche dans un département spécifique
7. **Top 10 des villes les plus peuplées d'une région** - Recherche dans une région spécifique
8. **Top 10 des villes les plus peuplées de France** - Classement national
9. **Sortir** - Quitte l'application

## Structure du Projet

### Package : `fr.diginamic.recensement`

#### Classes du modèle de données :

- **`City`** - Représente une ville avec ses informations administratives et sa population
- **`Region`** - Représente une région avec sa population agrégée
- **`Departement`** - Représente un département avec sa population agrégée
- **`Recensement`** - Classe principale contenant toutes les villes et les méthodes d'accès aux données

#### Classes de service :

- **`MenuService`** - Classe abstraite pour tous les services de menu
- **`RecherchePopulationCity`** - Service de recherche par ville
- **`RecherchePopulationDepartement`** - Service de recherche par département
- **`RecherchePopulationRegion`** - Service de recherche par région
- **`Affichage10RegionsPlusPeuplees`** - Service d'affichage du top 10 des régions
- **`Affichage10DepartementsPlusPeuplees`** - Service d'affichage du top 10 des départements
- **`Affichage10VillesPlusPeupleesDepartement`** - Service d'affichage du top 10 des villes par département
- **`Affichage10VillesPlusPeupleesRegion`** - Service d'affichage du top 10 des villes par région
- **`Affichage10VillesPlusPeupleesFrance`** - Service d'affichage du top 10 des villes de France

#### Classe principale :

- **`ApplicationRecensement`** - Point d'entrée de l'application avec la boucle de menu

## Format du fichier CSV

Le fichier CSV doit avoir le format suivant (séparateur : point-virgule) :

```
Region Code;Region Name;Department Code;City Code;City Name;Population
01;Auvergne-Rhône-Alpes;01;01001;L'Abergement-Clémenciat;758
11;Île-de-France;75;75101;Paris 1er Arrondissement;16888
...
```

## Compilation et Exécution

### Compilation :

```bash
cd src
javac fr/diginamic/recensement/*.java
```

### Exécution :

```bash
java fr.diginamic.recensement.ApplicationRecensement
```

## Utilisation

1. **Démarrage** : L'application charge automatiquement le fichier `recensement.csv` depuis le répertoire courant
2. **Navigation** : Utilisez les numéros 1-9 pour naviguer dans le menu
3. **Saisie** : Suivez les instructions pour saisir les noms de villes, codes de départements, etc.
4. **Sortie** : Choisissez l'option 9 pour quitter l'application

## Exemples d'utilisation

### Recherche de population d'une ville :

```
Votre choix: 1
Veuillez saisir le nom de la ville: Lyon
Population de Lyon: 518,635 habitants
```

### Recherche par département :

```
Votre choix: 2
Veuillez saisir le code du département: 69
Population du département 69: 558,271 habitants
```

### Top 10 des villes de France :

```
Votre choix: 8
Top 10 des villes les plus peuplées de France:
==============================================
1. Marseille (13) - Population: 868,277
2. Lyon (69) - Population: 518,635
3. Aix-en-Provence (13) - Population: 145,071
...
```

## Architecture et Conception

L'application suit les principes de conception suivants :

- **Séparation des responsabilités** : Chaque classe a une responsabilité spécifique
- **Pattern Service** : Chaque fonctionnalité du menu est implémentée dans une classe de service séparée
- **Polymorphisme** : Utilisation de la classe abstraite `MenuService`
- **Encapsulation** : Les données sont protégées avec des getters/setters appropriés
- **Extensibilité** : Facile d'ajouter de nouvelles fonctionnalités en créant de nouveaux services

## Fonctionnalités techniques

- **Lecture CSV robuste** : Gestion des erreurs de parsing et des fichiers manquants
- **Recherche insensible à la casse** : Les recherches de villes et régions ne sont pas sensibles à la casse
- **Agrégation de données** : Calcul automatique des populations par département et région
- **Tri et classement** : Utilisation des Streams Java pour le tri et la limitation des résultats
- **Formatage des nombres** : Affichage des populations avec séparateurs de milliers
- **Gestion d'erreurs** : Gestion appropriée des exceptions et messages d'erreur informatifs

## Extensions possibles

- Support de fichiers CSV avec différents délimiteurs
- Export des résultats vers un fichier
- Interface graphique (GUI)
- Base de données au lieu de fichiers CSV
- API REST pour accès distant
- Recherche floue pour les noms de villes
- Graphiques et visualisations
- Historique des recherches
