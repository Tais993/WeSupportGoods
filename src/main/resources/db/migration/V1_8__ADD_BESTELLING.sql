CREATE TABLE bestelling
(
    bestellingnummer int GENERATED ALWAYS AS Identity constraint bestelling_pk unique,
    klantnummer int REFERENCES klant (klantnummer),
    afgerond boolean NOT NULL DEFAULT false,

    PRIMARY KEY (bestellingnummer, klantnummer)
);
