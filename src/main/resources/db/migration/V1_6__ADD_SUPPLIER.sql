CREATE TABLE "supplier"
(
    id int PRIMARY KEY GENERATED ALWAYS AS Identity,
    company_name varchar(255),
    contact_person varchar(255),
    phone_number varchar(20),
    email varchar(255)
);
