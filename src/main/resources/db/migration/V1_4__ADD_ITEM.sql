CREATE TABLE "item"
(
    id          int PRIMARY KEY GENERATED ALWAYS AS identity,
    name        varchar(30) UNIQUE,
    description varchar(200),
    price       decimal
);
