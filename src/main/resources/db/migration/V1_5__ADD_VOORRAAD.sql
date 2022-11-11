CREATE TABLE voorraad
(
    artikelnummer varchar(30) REFERENCES artikel (artikelnummer),
    eenheid varchar(30) REFERENCES eenheid (eenheid),
    aantal integer NOT NULL,
    locatie varchar(30) NOT NULL ,

    PRIMARY KEY (artikelnummer, eenheid)
);
