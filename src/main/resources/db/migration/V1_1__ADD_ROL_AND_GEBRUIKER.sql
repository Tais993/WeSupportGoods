CREATE TABLE rol
(
    rol varchar(100) PRIMARY KEY
);

CREATE TABLE gebruiker
(
    gebruikersnaam varchar(100) PRIMARY KEY,
    wachtwoord     varchar(100),
    email          varchar(100),
    rol varchar(100) REFERENCES rol (rol)
);
