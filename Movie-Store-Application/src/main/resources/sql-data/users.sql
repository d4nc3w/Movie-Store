INSERT INTO
    App_user (firstName, lastName, email, password, role)
VALUES
    -- s28113@pjwstk.edu.pl/ Pjatk123 / ADMIN
    ('Piotr', 'Dancewicz', 's28113@pjwstk.edu.pl', '{SHA-256}{q63F+SzYfIZmr9Lv1HfK1lWCHSrIl8ryXmmkG4aij0A=}741fdf6ecaacece27bbe068d25c849fbab0e9f9fba6662cc89e015b95e473ade', 'ADMIN'),
    -- maci3j@gmail.com / TINtask123! / EMPLOYEE
    ('Maciej', 'Kot', 'maci3j@gmail.com', '{SHA-256}{DRiG8A4OpOI2/Ja0bMFk07HHwiaKPstxMc8h872efAk=}8906451ac3f54273806b9553535ab66e3408bd248a70ad3a5030117f51032b46', 'EMPLOYEE'),
    -- sb@wp.pl / Pjwstk0112? / CLIENT
    ('Szymon', 'Kowalski', 'sb@wp.pl', '{SHA-256}{HWT39/WqSHJNK3oS5hERGMWuw9Z0fyxjOLG/SVZaPtA=}29d353118261e32cb265500694890d3f89e3aa32796158c9db6f89cec9ef0714', 'CLIENT'),
    -- guest@gmail.com / HelloGuest!1 / GUEST
    ('Dummy', 'Dummy', 'guest@gmail.com', '{SHA-256}{iE/W8MH6wVnR+t2g8nCwdkQSIOFiCu+gYm+UG9Hue7g=}a1de37d55b00f420da0d74967e06b060642ce4a1db82e512a1dbbbe2e670ce37', 'GUEST');