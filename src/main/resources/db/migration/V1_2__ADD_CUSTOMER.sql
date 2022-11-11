CREATE TABLE "customer"
(
    id             int PRIMARY KEY GENERATED ALWAYS AS Identity,
    company_name   varchar(255) NOT NULL,
    contact_person varchar(255) NOT NULL,
    phone_number   varchar(20)  NOT NULL
);
