CREATE TABLE "supplier_item"
(
    id int PRIMARY KEY GENERATED ALWAYS AS identity,
    article_id int REFERENCES item (id),
    supplier_id int REFERENCES supplier (id),
    price int
);
