# TravelGuide – Modelarea bazei de date

## 1. Descrierea domeniului

TravelGuide este o aplicație care permite utilizatorilor să descopere atracții turistice, să consulte informații despre acestea și să publice recenzii și evaluări. Aplicația include informații despre orașe, categorii de atracții și trasee de transport.

## 2. Entități

Baza de date conține următoarele entități:

1. **oras** – stochează informații despre orașe, județe, țări și descrieri.
2. **categorie** – conține categoriile în care pot fi încadrate atracțiile.
3. **utilizator** – păstrează numele, adresa de e-mail, parola hash și data înregistrării.
4. **mijloc_transport** – conține mijloacele de transport disponibile.
5. **atractie** – stochează numele, descrierea, adresa, programul, prețul și orașul unei atracții.
6. **atractie_categorie** – realizează asocierea dintre atracții și categorii.
7. **recenzie** – stochează nota, comentariul și data recenziei publicate de un utilizator.
8. **traseu** – conține informații despre transportul către o atracție, orașul de plecare, durată, distanță și cost estimativ.

## 3. Relații între entități

- Un oraș poate avea mai multe atracții turistice.
- O atracție poate aparține mai multor categorii, iar o categorie poate include mai multe atracții.
- Un utilizator poate publica mai multe recenzii.
- O atracție poate avea mai multe recenzii.
- O atracție poate avea mai multe trasee.
- Un mijloc de transport poate fi utilizat pentru mai multe trasee.
- Un oraș poate fi oraș de plecare pentru mai multe trasee.

## 4. Integritatea datelor

Baza de date utilizează chei primare pentru identificarea înregistrărilor și chei străine pentru legăturile dintre tabele. Sunt folosite constrângeri pentru a preveni datele invalide, precum note în afara intervalului 1–5 sau prețuri negative.

## 5. Fișiere SQL

- `sql/01_schema.sql` – definește structura bazei de date.
- `sql/02_fixtures.sql` – introduce date de test pentru verificarea funcționării bazei de date.