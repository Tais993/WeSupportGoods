CREATE TABLE "unit"
(
    id   int PRIMARY KEY GENERATED ALWAYS AS identity,
    unit varchar(30) UNIQUE
);
