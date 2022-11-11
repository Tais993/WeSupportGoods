CREATE TABLE "order"
(
    id int PRIMARY KEY GENERATED ALWAYS AS Identity,
    customer_id int REFERENCES customer (id),
    finished boolean NOT NULL DEFAULT false
);
