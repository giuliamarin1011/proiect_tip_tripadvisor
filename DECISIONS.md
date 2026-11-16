interfata web -> pagina cu atractiile turistice, detalii, recenzii, autentificare
utilizare: java + spring boot - controller, sercive, repository

pentru tabele -> postgresql

Spring boot - creeaza serverul + organizeaza functionalitatile

Spring Data JPA- lucrul cu tabele postgresql prin clase java

spring Security- autentificare + fucntie de rol

postgresql - pastreaza datele
html/ css - pt pagini web

Decizia 5 – Separarea aplicației în straturi

 Proiectul este organizat în pachete distincte pentru entity, repository, service și controller.

Motiv: Separarea responsabilităților facilitează întreținerea, testarea și extinderea aplicației.

Decizia 6 – Utilizarea Thymeleaf

 Interfața web utilizează Thymeleaf pentru integrarea datelor din backend în paginile HTML.

Motiv: Permite generarea dinamică a paginilor și afișarea informațiilor preluate din baza de date.

 Decizia 7 – Relația many-to-many dintre atracții și categorii

Relația este implementată prin tabelul intermediar `atractie_categorie`.

Motiv:O atracție poate aparține mai multor categorii, iar o categorie poate include mai multe atracții.

Decizia 8 – Utilizarea BCrypt pentru parole

Decizie: Parolele noi sunt transformate în hash folosind BCrypt înainte de salvarea în baza de date.

Motiv: Parolele nu trebuie stocate în format text simplu.

 Decizia 10 – Interfață vizuală personalizată

Interfața utilizează o paletă de culori formată din verde închis, crem și teracotă, împreună cu fonturile Playfair Display și DM Sans.

Motiv: Se urmărește o identitate vizuală potrivită unei aplicații turistice, diferențiată de un panou administrativ generic.

Decizia 11 – Utilizarea Maven

Decizie: Maven este utilizat pentru gestionarea dependențelor și configurarea construirii proiectului.

Motiv: Simplifică administrarea bibliotecilor utilizate de aplicație.

 Decizia 11 – Încărcarea datelor demonstrative

Datele inițiale sunt introduse prin fișierul `data.sql`.

Motiv: Permite popularea bazei de date cu informații demonstrative necesare testării funcționalităților aplicației.

