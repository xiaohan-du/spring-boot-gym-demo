INSERT INTO gym(name, id, location, fee, is_approved)
VALUES ('Pure Gym', '000', 'Western Avenue', 75.5, 1),
       ('Easy Gym', '111', 'City Center', 23.95, 1),
       ('JD Gym', '222', 'Capitol Shopping Center', 15.99, 1);

INSERT INTO manager(id, name, address, role_id, gym_id)
VALUES (1, 'John Bloke', '2, The Parade', 1, '000'),
       (2, 'Dave Parry', '14, East Grove', 2, '000'),
       (3, 'Tom Jones', '6, The Walk', 2, '000'),
       (4, 'Judy Lau', '76, Western Avenue', 1, '111'),
       (5, 'Toby Smith', '1, Park Place', 2, '111'),
       (6, 'Dai Ryan', '54, Museum Place', 3, '111'),
       (7, 'Clare James', '3, Gordon Rd', 1, '222'),
       (8, 'Lisa Scott', '9, Salisbury Rd', 2, '222'),
       (9, 'Deal Peel', '55, Column Terrace', 3, '222');

INSERT INTO manager_role(id, title)
VALUES (1, 'Chair'), (2, 'Secretary'), (3, 'Treasurer');

INSERT INTO member(id, name, address, tier, gym_id)
VALUES (1, 'AJ', 'Cosmeston St', 1, '000'),
       (2, 'TK', 'Maindy Rd', 1, '000'),
       (3, 'RE', 'Crown Way', 2, '111'),
       (4, 'VR', 'Allensbank Cres', 2, '111'),
       (5, 'AT', 'New Rd', 3, '222'),
       (6, 'PJ', 'Africa Rd', 3, '222')