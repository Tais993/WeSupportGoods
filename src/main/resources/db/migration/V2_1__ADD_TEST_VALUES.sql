INSERT INTO "role" (role)
VALUES ('Picker'),
       ('Verkoper'),
       ('Voorraadmanager');

INSERT INTO "user" (username, password, email, role)
VALUES ('Daan', 'D@@n1230', 'daan@wesg.com', 'Picker'),
       ('Jannick', 'J@nn1ck1987', 'jannick@wesg.com', 'Voorraadmanager'),
       ('Tom', 'Tom123', 'tom@wesg.com', 'Picker'),
       ('Marij', 'M@r1j', 'marij@wesg.com', 'Verkoper');

INSERT INTO "unit" (unit)
VALUES ('Stuks'),
       ('Rol'),
       ('Pallet');

INSERT INTO "item" (name, description, price)
VALUES ('Schroefp4.5', 'Parker schroef 4.5mm (doos 50 st)', 3.95),
       ('Schroefp5.0', 'Parker schroef 5.0mm (doos 50 st)', 4.25),
       ('DiamB8', 'Diamantboor M8', 12),
       ('PVC0.5', 'PVC folie 0.5mm 1m2', 1.80),
       ('EPDM0.8', 'EPDM rubber folie 0.8mm 1m2', 3.60),
       ('Emm10l', '10L emmer', 1.50),
       ('Emm10lS', '10L emmer stevig', 2.95),
       ('Kok3.0mm6m70', '70mm koker, 3.0mm dik, lengte 6m', 35),
       ('Buis2.0mm6m30', '30mm buis, 2.0mm dik, lengte 6m', 17.50),
       ('AfdFol', 'Afdekfolie 1m2', 0.95),
       ('Schp1.7', 'Schop 1,7m steel', 20.95);


