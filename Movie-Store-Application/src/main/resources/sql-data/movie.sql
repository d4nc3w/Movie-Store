insert into
    MOVIE (DIRECTOR,TITLE,PRICE,ISAVAILABLE,DESCRIPTION)
values
    ('Christopher Nolan', 'Interstellar', '59.99', 'true', 'Interstellar is a 2014 epic science fiction film with stars like Matthew McConaughey, Anne Hath and Timothee Chalamet'),
    ('Christopher Nolan', 'Inception', '49.99', 'true', 'Inception is a 2010 science fiction action film written and directed by Christopher Nolan, who also produced the film with Emma Thomas, his wife. The film stars Leonardo DiCaprio as a professional thief who steals information by infiltrating the subconscious of his targets.'),
    ('Christopher Nolan', 'The Dark Knight', '29.99', 'false', 'The Dark Knight is a 2008 superhero film directed, produced, and co-written by Christopher Nolan. Based on the DC Comics character Batman, the film is the second installment of Nolan''s The Dark Knight Trilogy and a sequel to 2005''s Batman Begins, starring Christian Bale and supported by Michael Caine, Heath Ledger, Gary Oldman, Aaron Eckhart, Maggie Gyllenhaal, and Morgan Freeman.'),
    ('Christopher Nolan', 'Dunkirk', '19.99', 'true', 'Dunkirk is a 2017 war film written, directed, and produced by Christopher Nolan that depicts the Dunkirk evacuation of World War II. Its ensemble cast includes Fionn Whitehead, Tom Glynn-Carney, Jack Lowden, Harry Styles, Aneurin Barnard, James D''Arcy, Barry Keoghan, Kenneth Branagh, Cillian Murphy, Mark Rylance, and Tom Hardy.'),
    ('Denis Villeneuve', 'Bladerunner 2049', '39.99', 'true', 'Blade Runner 2049 is a 2017 science fiction film directed by Denis Villeneuve and written by Hampton Fancher and Michael Green. A sequel to the 1982 film Blade Runner, the film stars Ryan Gosling and Harrison Ford, with Ana de Armas, Sylvia Hoeks, Robin Wright, Mackenzie Davis, Carla Juri, Lennie James, Dave Bautista, and Jared Leto in supporting roles.'),
    ('Denis Villeneuve', 'Arrival', '29.99', 'false', 'Arrival is a 2016 American science fiction film directed by Denis Villeneuve and written by Eric Heisserer. It is based on the 1998 short story "Story of Your Life" by Ted Chiang and stars Amy Adams, Jeremy Renner, and Forest Whitaker.'),
    ('Denis Villeneuve', 'Dune', '69.99', 'true', 'Dune is 2020 American science film based on book written by Frank Herbert "Dune". It features stars like Zendeya, Jason Mamoa, Timothee Chamalet and Rebecca Ferguson');

insert into
    ORDER(USER_ID,MOVIE_ID,ORDER_DATE)
values
    (1, 1, '2021-01-01');
