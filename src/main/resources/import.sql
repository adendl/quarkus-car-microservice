INSERT INTO car (id, uuid, carBrand, carModel, yearModel) VALUES 
(nextval('hibernate_sequence'), random_uuid(), 'Brand A', 'Model A', 2022),
(nextval('hibernate_sequence'), random_uuid(), 'Brand B', 'Model B', 2021),
(nextval('hibernate_sequence'), random_uuid(), 'Brand C', 'Model C', 2020),
(nextval('hibernate_sequence'), random_uuid(), 'Brand C', 'Model D', 2023);