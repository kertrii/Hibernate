INSERT INTO Client (name)
VALUES ('Oleksiy'),
       ('Mykola'),
       ('Kateryna'),
       ('Viktor'),
       ('Anna'),
       ('Maksym'),
       ('Dmytro'),
       ('Sasha'),
       ('Kyryl'),
       ('Olesya');


INSERT INTO Planet (id, name)
VALUES
    ('MARS', 'Mars'),
    ('MERC', 'Mercury'),
    ('VEN', 'Venus'),
    ('SAT', 'Saturn'),
    ('JUP', 'Jupiter');

INSERT INTO Ticket (client_id, from_planet_id, to_planet_id)
VALUES
    (1, 'MARS', 'MERC'),
    (2, 'MERC', 'VEN'),
    (3, 'VEN', 'SAT'),
    (4, 'SAT', 'JUP'),
    (5, 'JUP', 'MARS'),
    (6, 'JUP', 'SAT'),
    (7, 'SAT', 'VEN'),
    (8, 'VEN', 'MERC'),
    (9, 'MERC', 'MARS'),
    (10, 'MARS', 'VEN');
