
-- 1. Orase
INSERT INTO oras (nume, judet, tara, descriere) VALUES
('Brasov', 'Brasov', 'Romania', 'Oras cunoscut pentru centrul istoric si zona montana'),
('Bucuresti', 'Bucuresti', 'Romania', 'Capitala Romaniei'),
('Cluj-Napoca', 'Cluj', 'Romania', 'Oras cu obiective culturale si istorice');

-- 2. Categorii
INSERT INTO categorie (nume, descriere) VALUES
('Istoric', 'Obiective istorice'),
('Natura', 'Parcuri si obiective naturale'),
('Cultural', 'Muzee si obiective culturale');

-- 3. Utilizatori
-- Parolele sunt demonstrative, nu parole reale pentru autentificare.
INSERT INTO utilizator (nume, email, parola_hash) VALUES
('Ana Popescu', 'ana@example.com', 'hash_demo_ana'),
('Mihai Ionescu', 'mihai@example.com', 'hash_demo_mihai'),
('Elena Dumitru', 'elena@example.com', 'hash_demo_elena');

-- 4. Mijloace de transport
INSERT INTO mijloc_transport (denumire) VALUES
('Autobuz'),
('Tren'),
('Masina'),
('Pe jos');

-- 5. Atractii
INSERT INTO atractie
(nume, descriere, adresa, id_oras, program, pret_intrare)
VALUES
('Castelul Bran', 'Castel istoric din zona Brasovului',
 'Strada General Traian Mosoiu', 1, '09:00-18:00', 60.00),
('Parcul Herastrau', 'Parc mare din Bucuresti',
 'Soseaua Nordului', 2, 'Permanent', 0.00),
('Gradina Botanica', 'Spatiu cu plante si sere',
 'Strada Republicii', 3, '09:00-17:00', 15.00);

-- 6. Asocierea atractiilor cu categoriile
INSERT INTO atractie_categorie (id_atractie, id_categorie) VALUES
(1, 1),
(2, 2),
(3, 3);

-- 7. Recenzii
INSERT INTO recenzie
(id_utilizator, id_atractie, nota, comentariu)
VALUES
(1, 1, 5, 'Un loc foarte interesant'),
(2, 2, 4, 'Un parc frumos pentru plimbari'),
(3, 3, 5, 'O experienta placuta');

-- 8. Trasee
INSERT INTO traseu
(id_atractie, id_transport, id_oras_plecare, descriere,
 durata_minute, distanta_km, cost_estimativ)
VALUES
(1, 1, 2, 'Autobuz din Bucuresti spre zona atractiei', 180, 170.00, 40.00),
(2, 4, 2, 'Acces pietonal in Bucuresti', 20, 1.50, 0.00),
(3, 2, 3, 'Traseu cu trenul pana in Cluj-Napoca', 30, 5.00, 10.00);
