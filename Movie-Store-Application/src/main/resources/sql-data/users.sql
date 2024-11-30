INSERT INTO
    App_user (firstName, lastName, email, password)
VALUES
    -- s28113@pjwstk.edu.pl/ Pjatk123 / ADMIN
    ('Piotr', 'Dancewicz', 's28113@pjwstk.edu.pl', '{bcrypt}$2a$10$cLj7OzLGBlQpF7bw4bMtIOVugCy95v2VrgKMe5k3UrGO5OVG01vo.'),
    -- alex@pja.edu.pl / TPOtask12 / EMPLOYEE
    ('Maciej', 'Kot', 'maci3j@gmail.com', '{MD5}{CzzFeDBLGEXsC5xOsQun7fM1LmFuX/oHiLfAlBFBylk=}308a9c767fd80e3ec182eb8ff1a5797f'),
    -- sb@wp.pl / Pjwstk0112? / CLIENT
    ('Szymon', 'Kowalski', 'sb@wp.pl', '{noop}Pjwstk0112?'),
    -- guest@gmail.com / HelloGuest! / GUEST
    ('Dummy', 'Dummy', 'guest@gmail.com', '{noop}HelloGuest!');

INSERT INTO
    UserRole (name, description)
VALUES
    ('ADMIN', 'Administrative privileges'),
    ('EMPLOYEE', 'Administrative privileges regarding movies'),
    ('CLIENT', 'Regular user privileges'),
    ('GUEST', 'No privileges');

INSERT INTO
    App_user_roles (User_id, roles_id)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (2, 2),
    (2, 3),
    (2, 4),
    (3, 3),
    (3, 4),
    (4, 4);