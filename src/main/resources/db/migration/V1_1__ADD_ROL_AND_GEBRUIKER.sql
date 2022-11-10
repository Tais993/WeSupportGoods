CREATE TABLE Rol
(
    Rol varchar(100) PRIMARY KEY
);

CREATE TABLE Gebruiker
(
    Gebruikersnaam varchar(100) primary key,
    Wachtwoord     varchar(100),
    Email          varchar(100),
    Rol            Rol
);
