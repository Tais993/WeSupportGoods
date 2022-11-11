CREATE TABLE "role"
(
    id   int PRIMARY KEY GENERATED ALWAYS AS identity,
    role varchar(100) UNIQUE
);

CREATE TABLE "user"
(
    id       int PRIMARY KEY GENERATED ALWAYS AS identity,
    username varchar(100) UNIQUE,
    password varchar(100),
    email    varchar(100) UNIQUE,
    role     varchar(100) REFERENCES role (role)
);
