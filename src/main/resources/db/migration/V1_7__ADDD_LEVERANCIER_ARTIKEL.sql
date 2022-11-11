CREATE TABLE leverancier_artikel
(
    artikelnummer varchar(30) REFERENCES artikel (artikelnummer),
    leveranciernummer int REFERENCES leverancier (leveranciernummer),
    prijs int,

    PRIMARY KEY (artikelnummer, leveranciernummer)
);
