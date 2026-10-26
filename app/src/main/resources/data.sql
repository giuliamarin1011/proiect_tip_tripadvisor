
-- 1. Orase
INSERT INTO oras (nume, judet, tara, descriere)
SELECT 'Brasov', 'Brasov', 'Romania',
       'Oras cunoscut pentru centrul istoric si zona montana'
    WHERE NOT EXISTS (
    SELECT 1 FROM oras
    WHERE nume = 'Brasov' AND tara = 'Romania'
);

INSERT INTO oras (nume, judet, tara, descriere)
SELECT 'Bucuresti', 'Bucuresti', 'Romania',
       'Capitala Romaniei'
    WHERE NOT EXISTS (
    SELECT 1 FROM oras
    WHERE nume = 'Bucuresti' AND tara = 'Romania'
);

INSERT INTO oras (nume, judet, tara, descriere)
SELECT 'Cluj-Napoca', 'Cluj', 'Romania',
       'Oras cu obiective culturale si istorice'
    WHERE NOT EXISTS (
    SELECT 1 FROM oras
    WHERE nume = 'Cluj-Napoca' AND tara = 'Romania'
);

-- 2. Categorii
INSERT INTO categorie (nume, descriere)
SELECT 'Istoric', 'Obiective istorice'
    WHERE NOT EXISTS (
    SELECT 1 FROM categorie WHERE nume = 'Istoric'
);

INSERT INTO categorie (nume, descriere)
SELECT 'Natura', 'Parcuri si obiective naturale'
    WHERE NOT EXISTS (
    SELECT 1 FROM categorie WHERE nume = 'Natura'
);

INSERT INTO categorie (nume, descriere)
SELECT 'Cultural', 'Muzee si obiective culturale'
    WHERE NOT EXISTS (
    SELECT 1 FROM categorie WHERE nume = 'Cultural'
);

-- 3. Utilizatori demonstrativi
INSERT INTO utilizator (nume, email, parola_hash)
SELECT 'Ana Popescu', 'ana@example.com', 'hash_demo_ana'
    WHERE NOT EXISTS (
    SELECT 1 FROM utilizator WHERE email = 'ana@example.com'
);

INSERT INTO utilizator (nume, email, parola_hash)
SELECT 'Mihai Ionescu', 'mihai@example.com', 'hash_demo_mihai'
    WHERE NOT EXISTS (
    SELECT 1 FROM utilizator WHERE email = 'mihai@example.com'
);

INSERT INTO utilizator (nume, email, parola_hash)
SELECT 'Elena Dumitru', 'elena@example.com', 'hash_demo_elena'
    WHERE NOT EXISTS (
    SELECT 1 FROM utilizator WHERE email = 'elena@example.com'
);

-- 4. Mijloace de transport
INSERT INTO mijloc_transport (denumire)
SELECT 'Autobuz'
    WHERE NOT EXISTS (
    SELECT 1 FROM mijloc_transport WHERE denumire = 'Autobuz'
);

INSERT INTO mijloc_transport (denumire)
SELECT 'Tren'
    WHERE NOT EXISTS (
    SELECT 1 FROM mijloc_transport WHERE denumire = 'Tren'
);

INSERT INTO mijloc_transport (denumire)
SELECT 'Masina'
    WHERE NOT EXISTS (
    SELECT 1 FROM mijloc_transport WHERE denumire = 'Masina'
);

INSERT INTO mijloc_transport (denumire)
SELECT 'Pe jos'
    WHERE NOT EXISTS (
    SELECT 1 FROM mijloc_transport WHERE denumire = 'Pe jos'
);

-- 5. Atractii
INSERT INTO atractie
(nume, descriere, adresa, id_oras, program, pret_intrare)
SELECT 'Castelul Bran',
       'Castel istoric din zona Brasovului',
       'Strada General Traian Mosoiu',
       o.id_oras, '09:00-18:00', 60.00
FROM oras o
WHERE o.nume = 'Brasov'
  AND o.tara = 'Romania'
  AND NOT EXISTS (
    SELECT 1 FROM atractie a
    WHERE a.nume = 'Castelul Bran'
      AND a.id_oras = o.id_oras
);

INSERT INTO atractie
(nume, descriere, adresa, id_oras, program, pret_intrare)
SELECT 'Parcul Herastrau',
       'Parc mare din Bucuresti',
       'Soseaua Nordului',
       o.id_oras, 'Permanent', 0.00
FROM oras o
WHERE o.nume = 'Bucuresti'
  AND o.tara = 'Romania'
  AND NOT EXISTS (
    SELECT 1 FROM atractie a
    WHERE a.nume = 'Parcul Herastrau'
      AND a.id_oras = o.id_oras
);

INSERT INTO atractie
(nume, descriere, adresa, id_oras, program, pret_intrare)
SELECT 'Gradina Botanica',
       'Spatiu cu plante si sere',
       'Strada Republicii',
       o.id_oras, '09:00-17:00', 15.00
FROM oras o
WHERE o.nume = 'Cluj-Napoca'
  AND o.tara = 'Romania'
  AND NOT EXISTS (
    SELECT 1 FROM atractie a
    WHERE a.nume = 'Gradina Botanica'
      AND a.id_oras = o.id_oras
);

-- 6. Categorii pentru atractii
INSERT INTO atractie_categorie (id_atractie, id_categorie)
SELECT a.id_atractie, c.id_categorie
FROM atractie a
         JOIN oras o ON o.id_oras = a.id_oras
         JOIN categorie c ON c.nume = 'Istoric'
WHERE a.nume = 'Castelul Bran'
  AND o.nume = 'Brasov'
  AND NOT EXISTS (
    SELECT 1 FROM atractie_categorie ac
    WHERE ac.id_atractie = a.id_atractie
      AND ac.id_categorie = c.id_categorie
);

INSERT INTO atractie_categorie (id_atractie, id_categorie)
SELECT a.id_atractie, c.id_categorie
FROM atractie a
         JOIN oras o ON o.id_oras = a.id_oras
         JOIN categorie c ON c.nume = 'Natura'
WHERE a.nume = 'Parcul Herastrau'
  AND o.nume = 'Bucuresti'
  AND NOT EXISTS (
    SELECT 1 FROM atractie_categorie ac
    WHERE ac.id_atractie = a.id_atractie
      AND ac.id_categorie = c.id_categorie
);

INSERT INTO atractie_categorie (id_atractie, id_categorie)
SELECT a.id_atractie, c.id_categorie
FROM atractie a
         JOIN oras o ON o.id_oras = a.id_oras
         JOIN categorie c ON c.nume = 'Cultural'
WHERE a.nume = 'Gradina Botanica'
  AND o.nume = 'Cluj-Napoca'
  AND NOT EXISTS (
    SELECT 1 FROM atractie_categorie ac
    WHERE ac.id_atractie = a.id_atractie
      AND ac.id_categorie = c.id_categorie
);

-- 7. Recenzii
INSERT INTO recenzie (id_utilizator, id_atractie, nota, comentariu)
SELECT u.id_utilizator, a.id_atractie, 5,
       'Un loc foarte interesant'
FROM utilizator u
         JOIN atractie a ON a.nume = 'Castelul Bran'
         JOIN oras o ON o.id_oras = a.id_oras
WHERE u.email = 'ana@example.com'
  AND o.nume = 'Brasov'
  AND NOT EXISTS (
    SELECT 1 FROM recenzie r
    WHERE r.id_utilizator = u.id_utilizator
      AND r.id_atractie = a.id_atractie
);

INSERT INTO recenzie (id_utilizator, id_atractie, nota, comentariu)
SELECT u.id_utilizator, a.id_atractie, 4,
       'Un parc frumos pentru plimbari'
FROM utilizator u
         JOIN atractie a ON a.nume = 'Parcul Herastrau'
         JOIN oras o ON o.id_oras = a.id_oras
WHERE u.email = 'mihai@example.com'
  AND o.nume = 'Bucuresti'
  AND NOT EXISTS (
    SELECT 1 FROM recenzie r
    WHERE r.id_utilizator = u.id_utilizator
      AND r.id_atractie = a.id_atractie
);

INSERT INTO recenzie (id_utilizator, id_atractie, nota, comentariu)
SELECT u.id_utilizator, a.id_atractie, 5,
       'O experienta placuta'
FROM utilizator u
         JOIN atractie a ON a.nume = 'Gradina Botanica'
         JOIN oras o ON o.id_oras = a.id_oras
WHERE u.email = 'elena@example.com'
  AND o.nume = 'Cluj-Napoca'
  AND NOT EXISTS (
    SELECT 1 FROM recenzie r
    WHERE r.id_utilizator = u.id_utilizator
      AND r.id_atractie = a.id_atractie
);

-- 8. Trasee
INSERT INTO traseu
(id_atractie, id_transport, id_oras_plecare, descriere,
 durata_minute, distanta_km, cost_estimativ)
SELECT a.id_atractie, m.id_transport, o.id_oras,
       'Autobuz din Bucuresti spre zona atractiei',
       180, 170.00, 40.00
FROM atractie a
         JOIN oras destinatie ON destinatie.id_oras = a.id_oras
         JOIN mijloc_transport m ON m.denumire = 'Autobuz'
         JOIN oras o ON o.nume = 'Bucuresti'
    AND o.tara = 'Romania'
WHERE a.nume = 'Castelul Bran'
  AND destinatie.nume = 'Brasov'
  AND NOT EXISTS (
    SELECT 1 FROM traseu t
    WHERE t.id_atractie = a.id_atractie
      AND t.id_transport = m.id_transport
      AND t.id_oras_plecare = o.id_oras
      AND t.descriere = 'Autobuz din Bucuresti spre zona atractiei'
);

INSERT INTO traseu
(id_atractie, id_transport, id_oras_plecare, descriere,
 durata_minute, distanta_km, cost_estimativ)
SELECT a.id_atractie, m.id_transport, o.id_oras,
       'Acces pietonal in Bucuresti',
       20, 1.50, 0.00
FROM atractie a
         JOIN oras destinatie ON destinatie.id_oras = a.id_oras
         JOIN mijloc_transport m ON m.denumire = 'Pe jos'
         JOIN oras o ON o.nume = 'Bucuresti'
    AND o.tara = 'Romania'
WHERE a.nume = 'Parcul Herastrau'
  AND destinatie.nume = 'Bucuresti'
  AND NOT EXISTS (
    SELECT 1 FROM traseu t
    WHERE t.id_atractie = a.id_atractie
      AND t.id_transport = m.id_transport
      AND t.id_oras_plecare = o.id_oras
      AND t.descriere = 'Acces pietonal in Bucuresti'
);

INSERT INTO traseu
(id_atractie, id_transport, id_oras_plecare, descriere,
 durata_minute, distanta_km, cost_estimativ)
SELECT a.id_atractie, m.id_transport, o.id_oras,
       'Traseu cu trenul pana in Cluj-Napoca',
       30, 5.00, 10.00
FROM atractie a
         JOIN oras destinatie ON destinatie.id_oras = a.id_oras
         JOIN mijloc_transport m ON m.denumire = 'Tren'
         JOIN oras o ON o.nume = 'Cluj-Napoca'
    AND o.tara = 'Romania'
WHERE a.nume = 'Gradina Botanica'
  AND destinatie.nume = 'Cluj-Napoca'
  AND NOT EXISTS (
    SELECT 1 FROM traseu t
    WHERE t.id_atractie = a.id_atractie
      AND t.id_transport = m.id_transport
      AND t.id_oras_plecare = o.id_oras
      AND t.descriere = 'Traseu cu trenul pana in Cluj-Napoca'
);
