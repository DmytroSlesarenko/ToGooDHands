INSERT IGNORE institutions(id, name, description)
VALUES (1, 'Dbam o Zdrowie', 'Pomoc dzieciom z ubogich rodzin.'),
       (2, 'A kogo', 'Pomoc wybudzaniu dzieci ze śpiączki.'),
       (3, 'Dla dzieci', 'Pomoc osobom znajdującym się w trudnej sytuacji życiowej.'),
       (4, 'Bez domu', 'Pomoc dla osób nie posiadających miejsca zamieszkania.');

INSERT IGNORE categories(id, name)
VALUES (1, 'ubrania, które nadają się do ponownego użycia'),
       (2, 'ubrania, do wyrzucenia'),
       (3, 'zabawki'),
       (4, 'książki'),
       (5, 'inne');