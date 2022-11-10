CREATE TABLE Artikel
(
    Artikelnummer int PRIMARY KEY GENERATED ALWAYS AS Identity,
    Omschrijving varchar(200),
    Prijs decimal
);
