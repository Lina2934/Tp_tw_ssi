-- Initialisation des tables
INSERT INTO Personne (nom) VALUES ('Dupont');
INSERT INTO Personne (nom) VALUES ('Martin');

INSERT INTO Projet (nom, debut) VALUES ('Projet A', '2023-01-01');
INSERT INTO Projet (nom, debut) VALUES ('Projet B', '2023-02-01');

-- Insertion dans la table Participation avec les bonnes colonnes
INSERT INTO Participation (role, pourcentage, matricule, code)
VALUES ('Développeur', 50.0, 1, 1);  -- Remplacez personne_matricule par matricule et projet_code par code

-- Ce fichier ne peut pas être vide
SELECT 0 as INUTILE;
