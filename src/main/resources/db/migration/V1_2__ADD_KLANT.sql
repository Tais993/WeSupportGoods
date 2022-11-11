CREATE TABLE klant
(
    klantnummer integer PRIMARY KEY GENERATED ALWAYS AS Identity,
    bedrijfsnaam varchar(255) NOT NULL ,
    contactpersoon varchar(255) NOT NULL ,
    telefoonnummer varchar(20) NOT NULL
);
