insert into
    developers (name, sex, salary)
values
    ('Leo', 'male', 1200),
    ('Tanya', 'female', 10000),
    ('Dunkan', 'male', 1000),
    ('Jeff', 'male', 8000),
    ('Faye', 'female', 11000),
    ('Tiffany', 'female', 950),
    ('Tony', 'male', 800),
    ('Anna', 'female', 1000),
    ('Timothy', 'male', 1000),
    ('Nicholas', 'male', 980),
    ('Paul', 'male', 4000),
    ('Andrew', 'male', 5000),
    ('Ibrahim', 'male', 6000),
    ('Sergio', 'male', 1150),
    ('Pete', 'male', 9500),
    ('George', 'male', 1200),
    ('Apple', 'female', 4500);

    insert into
        skills (rank, syntax)
    values
        ('Junior', 'Java'),
        ('Middle','Java'),
        ('Senior','Java');

insert into
    projects (project_name, start_date, cost)
values
    ('LibraryApp', '2017-08-24', 100000.0),
    ('GroceryStore','2019-08-24', 200000.00),
    ('TouristAgency','2018-08-24', 375000.00),
    ('FurnitureStoreSystem','2020-08-24', 1000.0);

    insert into
        companies (company_name, city)
    values
        ('Zeus Development', 'Toronto'),
        ('Thunder Sofware', 'Los Angeles'),
        ('Soft Slab', 'New York'),
        ('Slick Devs', 'Kyiv');

    insert into
        clients (name, country, category)
    values
        ('National Library', 'USA', 'VIP'),
        ('Walcopy', 'UK', 'Premium'),
        ('Air Trip', 'Monaco', 'Premium'),
        ('Mebleva Skrynia', 'Ukraine', 'Standard');

        insert into
            devskills (dev_id, skill_id)
        values
            (1, 1),
            (2, 3),
            (3, 1),
            (4, 3),
            (5, 3),
            (6, 1),
            (7, 1),
            (8, 2),
            (9, 1),
            (10, 1),
            (11, 2),
            (12, 2),
            (13, 2),
            (14, 1),
            (15, 3),
            (16, 1),
            (17, 2);

        insert into
            devprojects (dev_id, project_id)
        values
            (1, 1),
            (2, 1),
            (3, 1),
            (4, 2),
            (5, 3),
            (6, 2),
            (7, 3),
            (8, 3),
            (9, 3),
            (10, 2),
            (11, 4),
            (12, 4),
            (13, 2),
            (14, 4),
            (15, 4),
            (16, 4),
            (17, 2),
            (2, 4),
            (4, 4),
            (5, 2),
            (15, 2),
            (8, 2),
            (17, 1);

        insert into
            companydevs (company_id, dev_id)
        values
            (1, 2),
            (1, 4),
            (1, 5),
            (1, 8),
            (1, 1),
            (1, 3),
            (1, 6),
            (2, 7),
            (2, 9),
            (2, 10),
            (2, 11),
            (3, 12),
            (3, 13),
            (3, 14),
            (4, 15),
            (4, 16),
            (4, 17);

        insert into
            clientprojects (client_id, project_id)
        values
            (1, 1),
            (1, 3),
            (2, 2),
            (2, 4),
            (3, 3),
            (3, 1),
            (4, 4),
            (4, 1);

        insert into
            companyprojects (company_id, project_id)
        values
            (1, 1),
            (1, 3),
            (2, 2),
            (3, 3),
            (4, 4);
