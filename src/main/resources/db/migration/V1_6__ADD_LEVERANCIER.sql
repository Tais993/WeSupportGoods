CREATE TABLE leverancier
(
    leveranciernummer int PRIMARY KEY GENERATED ALWAYS AS Identity,
    bedrijfsnaam varchar(255),
    contactpersoon varchar(255),
    telefoonnummer varchar(20),
    emailadres varchar(255)
);
