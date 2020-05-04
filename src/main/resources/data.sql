INSERT INTO authority (id, authority) VALUES
(1,	'ROLE_ADMIN'),
(2,	'ROLE_USER'),
(3,	'ROLE_COMPANY_MANAGE');

INSERT INTO company (id, ceo, created, name) VALUES
(1,	'Vincent Paris',	'1968-01-01',	'Sopra Steria'),
(2,	'John W. Thompson',	'1976-11-26',	'Microsoft');

INSERT INTO country (id, name) VALUES
(1,	'FRANCE'),
(2,	'ESPAGNE'),
(3,	'ITALIE');

INSERT INTO contact (id, mail, firstname, name, country_id) VALUES
(1,	'laurent.pierre@nowhere.org',	'Laurent',	'Pierre',	1),
(2,	'paul.dupond@nowhere.org',	'Paul',	'Dupond',	2);

INSERT INTO contact_companies (contact_id, companies_id) VALUES
(1,	1),
(2,	2);

INSERT INTO "user" (id, password, username) VALUES
(1,	'$2a$10$TcUIA3w1ovYR1pEes3au4eISmn0xCXRsDC7UIZ9nYR7u13nezw1RS',	'administrator');

INSERT INTO user_authorities (user_id, authorities_id) VALUES
(1,	1);

SELECT pg_catalog.setval('seq_authority', 4, false);
SELECT pg_catalog.setval('seq_company', 51, true);
SELECT pg_catalog.setval('seq_country', 51, true);
SELECT pg_catalog.setval('seq_user', 51, true);
