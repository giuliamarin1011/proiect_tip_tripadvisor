# Documentarea interfetei – TravelGuide

## 1. Scopul aplicatiei

este o aplicatie web destinata descoperirii atractiilor turistice si planificarii deplasarilor către acestea. Utilizatorii pot consulta informații despre orașe și atracții, pot explora categorii turistice, pot consulta trasee și pot publica recenzii.

## 2. Descrierea paginilor

### 2.1. Pagina principală
Prezintă aplicația și oferă acces către lista atracțiilor turistice și către funcția de căutare.

### 2.2. Lista atracțiilor turistice
Afișează atracțiile disponibile, cu posibilitatea de filtrare după oraș și categorie.

### 2.3. Detaliile unei atracții
Afișează numele atracției, descrierea, adresa, orașul, programul de vizitare, prețul de intrare și recenziile asociate.

### 2.4. Trasee și transport
Afișează traseele asociate atracțiilor, orașul de plecare, mijlocul de transport, durata, distanța și costul estimativ, atunci când aceste informații sunt disponibile.

### 2.5. Autentificare și înregistrare
Permite utilizatorilor să se autentifice sau să își creeze un cont.

### 2.6. Profilul utilizatorului
Afișează informațiile contului și recenziile publicate de utilizator.

## 3. Legătura dintre interfață și baza de date

Interfața utilizează datele din tabelele `oras`, `categorie`, `atractie`, `atractie_categorie`, `utilizator`, `recenzie`, `traseu` și `mijloc_transport`.

Paginile vor fi implementate progresiv, pe măsură ce sunt dezvoltate funcționalitățile aplicației.

## 4. Stadiul implementării

Paginile descrise reprezintă structura planificată a interfeței. Funcționalitățile vor fi implementate și testate în etapele următoare ale proiectului

# Modelarea bazei de date – TravelGuide

## 1. Introducere

Baza de date TravelGuide a fost proiectată pentru gestionarea informațiilor referitoare la destinații și atracții turistice.

Sistemul utilizează PostgreSQL și este organizat în opt tabele relaționate prin chei primare și chei externe.

Modelul urmărește reducerea redundanței datelor și păstrarea integrității referențiale.

## 2. Descrierea tabelelor

### 2.1. Tabelul oras

Stochează informațiile despre orașele disponibile în aplicație.

Câmpuri:
- `id_oras` – cheie primară, generată automat;
- `nume` – numele orașului;
- `judet` – județul;
- `tara` – țara;
- `descriere` – descrierea orașului.

### 2.2. Tabelul categorie

Stochează categoriile utilizate pentru clasificarea atracțiilor turistice.

Câmpuri:
- `id_categorie` – cheie primară;
- `nume` – numele categoriei, unic;
- `descriere` – descrierea categoriei.

### 2.3. Tabelul utilizator

Stochează informațiile despre utilizatorii aplicației.

Câmpuri:
- `id_utilizator` – cheie primară;
- `nume` – numele utilizatorului;
- `email` – adresă de email unică;
- `parola_hash` – hash-ul parolei;
- `data_inregistrarii` – data înregistrării.

### 2.4. Tabelul mijloc_transport

Stochează mijloacele de transport utilizate în definirea traseelor.

Câmpuri:
- `id_transport` – cheie primară;
- `denumire` – denumirea mijlocului de transport, unică.

### 2.5. Tabelul atractie

Stochează atracțiile turistice.

Câmpuri:
- `id_atractie` – cheie primară;
- `nume` – numele atracției;
- `descriere` – descrierea atracției;
- `adresa` – adresa atracției;
- `id_oras` – cheie externă către tabelul oras;
- `program` – programul de vizitare;
- `pret_intrare` – prețul de intrare.

### 2.6. Tabelul atractie_categorie

Realizează asocierea dintre atracții și categorii.

Câmpuri:
- `id_atractie` – cheie externă către atractie;
- `id_categorie` – cheie externă către categorie.

Cele două câmpuri formează împreună cheia primară compusă.

### 2.7. Tabelul recenzie

Stochează recenziile publicate de utilizatori.

Câmpuri:
- `id_recenzie` – cheie primară;
- `id_utilizator` – cheie externă către utilizator;
- `id_atractie` – cheie externă către atracție;
- `nota` – valoare între 1 și 5;
- `comentariu` – textul recenziei;
- `data_recenziei` – data publicării.

### 2.8. Tabelul traseu

Stochează informațiile despre traseele turistice.

Câmpuri:
- `id_traseu` – cheie primară;
- `id_atractie` – cheie externă către atracție;
- `id_transport` – cheie externă către mijlocul de transport;
- `id_oras_plecare` – cheie externă către oraș;
- `descriere` – descrierea traseului;
- `durata_minute` – durata estimată;
- `distanta_km` – distanța;
- `cost_estimativ` – costul estimat.

## 3. Relațiile dintre tabele

Modelul bazei de date conține următoarele relații:

- Un oraș poate avea mai multe atracții turistice.
- O atracție aparține unui singur oraș.
- O atracție poate fi asociată mai multor categorii.
- O categorie poate fi asociată mai multor atracții.
- Un utilizator poate publica mai multe recenzii.
- O atracție poate avea mai multe recenzii.
- O atracție poate avea mai multe trasee.
- Un mijloc de transport poate fi utilizat în mai multe trasee.
- Un oraș poate reprezenta punctul de plecare pentru mai multe trasee.

Relația dintre atracții și categorii este de tip many-to-many și este implementată prin tabelul intermediar `atractie_categorie`.

## 4. Constrângeri de integritate

Pentru păstrarea consistenței datelor au fost utilizate:
- Chei primare;
- Chei externe;
- Constrângeri UNIQUE pentru anumite câmpuri;
- Constrângeri CHECK pentru nota recenziei;
- Constrângeri CHECK pentru valorile numerice pozitive sau nenegative;
- Valori implicite pentru datele de înregistrare și publicare.

## 5. Date inițiale

Pentru testarea aplicației au fost introduse date demonstrative prin intermediul fișierului `data.sql`.

Acestea includ orașe, categorii, utilizatori, mijloace de transport, atracții, recenzii, trasee și asocieri între atracții și categorii.

Inserările au fost realizate astfel încât datele demonstrative să poată fi încărcate fără duplicarea înregistrărilor existente.

## 6. Maparea obiect-relațională

Entitățile Java sunt mapate pe tabelele bazei de date folosind Jakarta Persistence API.

Pentru relații au fost utilizate adnotări precum:
- `@ManyToOne`;
- `@Id`;
- `@IdClass`;
- `@JoinColumn`.

Accesul la date este realizat prin repository-uri care extind `JpaRepository`.

## 7. Concluzii

Modelul bazei de date oferă o structură relațională pentru administrarea informațiilor turistice.

Separarea informațiilor în tabele distincte permite organizarea eficientă a datelor și facilitează dezvoltarea ulterioară a aplicației.