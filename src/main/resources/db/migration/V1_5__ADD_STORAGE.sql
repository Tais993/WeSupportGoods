CREATE TABLE "storage"
(
    id int PRIMARY KEY GENERATED ALWAYS AS identity,
    item_id int REFERENCES item (id),
    unit_id int REFERENCES unit (id),
    amount int NOT NULL,
    location varchar(30) NOT NULL
);
