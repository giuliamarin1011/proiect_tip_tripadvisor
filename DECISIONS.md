interfata web -> pagina cu atractiile turistice, detalii, recenzii, autentificare
utilizare: java + spring boot - controller, sercive, repository

pentru tabele -> postgresql

Spring boot - creeaza serverul + organizeaza functionalitatile

Spring Data JPA- lucrul cu tabele postgresql prin clase java

spring Security- autentificare + fucntie de rol

postgresql - pastreaza datele
html/ css - pt pagini web


# DECISIONS – TravelGuide

## Decizia 1 – Utilizarea PostgreSQL

**Decizie:** PostgreSQL a fost ales ca sistem de gestiune a bazei de date.

**Motiv:** Aplicația utilizează date relaționale și necesită constrângeri de integritate, relații între tabele și interogări SQL.

## Decizia 2 – Utilizarea Java și Spring Boot

**Decizie:** Backend-ul aplicației este realizat folosind Java și Spring Boot.

**Motiv:** Aceste tehnologii permit organizarea aplicației pe componente și separarea responsabilităților.

## Decizia 3 – Utilizarea Spring Data JPA

**Decizie:** Accesul la baza de date este realizat prin Spring Data JPA.

**Motiv:** Repository-urile permit efectuarea operațiilor CRUD fără scrierea manuală a tuturor interogărilor SQL.

## Decizia 4 – Separarea aplicației în straturi

**Decizie:** Proiectul este organizat în pachete distincte pentru entity, repository, service și controller.

**Motiv:** Separarea responsabilităților facilitează întreținerea, testarea și extinderea aplicației.

## Decizia 5 – Utilizarea Thymeleaf

**Decizie:** Interfața web utilizează Thymeleaf pentru integrarea datelor din backend în paginile HTML.

**Motiv:** Permite generarea dinamică a paginilor și afișarea informațiilor preluate din baza de date.

## Decizia 6 – Relația many-to-many dintre atracții și categorii

**Decizie:** Relația este implementată prin tabelul intermediar `atractie_categorie`.

**Motiv:** O atracție poate aparține mai multor categorii, iar o categorie poate include mai multe atracții.

## Decizia 7 – Utilizarea BCrypt pentru parole

**Decizie:** Parolele noi sunt transformate în hash folosind BCrypt înainte de salvarea în baza de date.

**Motiv:** Parolele nu trebuie stocate în format text simplu.

## Decizia 8 – Interfață vizuală personalizată

**Decizie:** Interfața utilizează o paletă de culori formată din verde închis, crem și teracotă, împreună cu fonturile Playfair Display și DM Sans.

**Motiv:** Se urmărește o identitate vizuală potrivită unei aplicații turistice, diferențiată de un panou administrativ generic.

## Decizia 9 – Utilizarea Maven

**Decizie:** Maven este utilizat pentru gestionarea dependențelor și configurarea construirii proiectului.

**Motiv:** Simplifică administrarea bibliotecilor utilizate de aplicație.

## Decizia 10 – Încărcarea datelor demonstrative

**Decizie:** Datele inițiale sunt introduse prin fișierul `data.sql`.

**Motiv:** Permite popularea bazei de date cu informații demonstrative necesare testării funcționalităților aplicației.

