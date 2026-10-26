
CREATE TABLE oras (
    id_oras INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nume VARCHAR(100) NOT NULL,
    judet VARCHAR(100),
    tara VARCHAR(100) NOT NULL,
    descriere TEXT
);

CREATE TABLE categorie (
    id_categorie INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nume VARCHAR(100) NOT NULL UNIQUE,
    descriere TEXT
);

CREATE TABLE utilizator (
    id_utilizator INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nume VARCHAR(100) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    parola_hash VARCHAR(255) NOT NULL,
    data_inregistrarii TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mijloc_transport (
    id_transport INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    denumire VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE atractie (
    id_atractie INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nume VARCHAR(150) NOT NULL,
    descriere TEXT,
    adresa VARCHAR(250),
    id_oras INTEGER NOT NULL REFERENCES oras(id_oras),
    program VARCHAR(200),
    pret_intrare NUMERIC(10,2)
        CHECK (pret_intrare IS NULL OR pret_intrare >= 0)
);

CREATE TABLE atractie_categorie (
    id_atractie INTEGER NOT NULL
        REFERENCES atractie(id_atractie) ON DELETE CASCADE,
    id_categorie INTEGER NOT NULL
        REFERENCES categorie(id_categorie) ON DELETE CASCADE,
    PRIMARY KEY (id_atractie, id_categorie)
);

CREATE TABLE recenzie (
    id_recenzie INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_utilizator INTEGER NOT NULL
        REFERENCES utilizator(id_utilizator) ON DELETE CASCADE,
    id_atractie INTEGER NOT NULL
        REFERENCES atractie(id_atractie) ON DELETE CASCADE,
    nota INTEGER NOT NULL CHECK (nota BETWEEN 1 AND 5),
    comentariu TEXT,
    data_recenziei TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE traseu (
    id_traseu INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    id_atractie INTEGER NOT NULL
        REFERENCES atractie(id_atractie) ON DELETE CASCADE,
    id_transport INTEGER NOT NULL
        REFERENCES mijloc_transport(id_transport),
    id_oras_plecare INTEGER NOT NULL
        REFERENCES oras(id_oras),
    descriere TEXT,
    durata_minute INTEGER CHECK (
        durata_minute IS NULL OR durata_minute > 0
    ),
    distanta_km NUMERIC(8,2) CHECK (
        distanta_km IS NULL OR distanta_km > 0
    ),
    cost_estimativ NUMERIC(10,2) CHECK (
        cost_estimativ IS NULL OR cost_estimativ >= 0
    )
);
