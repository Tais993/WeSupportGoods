CREATE TABLE bestellingregel
(
    bestellingnummer integer REFERENCES bestelling (bestellingnummer),
    artikelnummer varchar(30) REFERENCES artikel (artikelnummer),
    eenheid varchar(30) REFERENCES eenheid (eenheid),
    aantal int NOT NULL CHECK (aantal > 0),

    PRIMARY KEY (bestellingnummer, artikelnummer, eenheid)
);
