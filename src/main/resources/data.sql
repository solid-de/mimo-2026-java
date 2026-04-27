-- Insert authors first (IDs will be auto‑generated; we’ll rely on the order)
INSERT INTO authors (name, country, biography) VALUES
       ('J.K. Rowling', 'UK', 'British author, best known for the Harry Potter series.'),
       ('Laure Moulin', 'France', 'Biographer and sister of Jean Moulin.'),
       ('Antoine de Saint-Exupéry', 'France', 'French writer and aviator, author of The Little Prince.'),
       ('George Orwell', 'UK', 'English novelist and essayist, famous for 1984 and Animal Farm.'),
       ('Yuval Noah Harari', 'Israel', 'Israeli historian and author of Sapiens.'),
       ('Albert Camus', 'France', 'French philosopher and author, Nobel Prize winner.'),
       ('Frank Herbert', 'USA', 'American science fiction writer, creator of Dune.'),
       ('Arthur Conan Doyle', 'UK', 'Scottish writer, creator of Sherlock Holmes.'),
       ('James Clear', 'USA', 'American author and speaker on habits and decision making.'),
       ('J.R.R. Tolkien', 'UK', 'English writer and philologist, author of The Lord of the Rings.'),
       ('Marjane Satrapi', 'Iran', 'Iranian-born French graphic novelist, author of Persepolis.'),
       ('Stephen Hawking', 'UK', 'English theoretical physicist and cosmologist.');

-- Insert publishers
INSERT INTO publishers (name, country) VALUES
       ('Gallimard', 'France'),
       ('Livre de Poche', 'France'),
       ('Penguin', 'USA'),
       ('Flammarion', 'France'),
       ('HarperCollins', 'USA'),
       ('Robert Laffont', 'France'),
       ('Hachette', 'France'),
       ('Random House', 'USA'),
       ('Del Rey', 'USA'),
       ('L''Iconoclaste', 'France');

-- Now insert books using the correct author_id and publisher_id (match by insertion order)
-- The IDs correspond to the order of the inserts above.
INSERT INTO books (isbn, title, author_id, publisher_id, category) VALUES
           ('9782070429158', 'Harry Potter à l''école des sorciers', 1, 4, 'Fiction'),
           ('9782253151241', 'Jean Moulin : Biographie', 2, 2, 'Biography'),
           ('9782070612758', 'Le Petit Prince', 3, 1, 'Fiction'),
           ('9780451524935', '1984', 4, 3, 'Fiction'),
           ('9782226257017', 'Sapiens : Une brève histoire de l''humanité', 5, 7, 'History'),
           ('9782070360024', 'L''Étranger', 6, 4, 'NonFiction'),
           ('9782221002247', 'Dune', 7, 6, 'SciFi'),
           ('9782253006329', 'Une étude en rouge', 8, 2, 'Fiction'),
           ('9780857197689', 'Atomic Habits', 9, 8, 'NonFiction'),
           ('9782266154116', 'Le Seigneur des Anneaux', 10, 9, 'Fiction'),
           ('9782844140586', 'Persépolis', 11, 10, 'Fiction'),
           ('9782081238626', 'Une brève histoire du temps', 12, 4, 'Science');