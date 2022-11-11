CREATE TABLE "order_line"
(
    id int PRIMARY KEY GENERATED ALWAYS AS identity,
    order_id int REFERENCES "order" (id),
    item_id int REFERENCES item (id),
    unit_id int REFERENCES unit (id),
    amount int NOT NULL CHECK (amount > 0)
);
