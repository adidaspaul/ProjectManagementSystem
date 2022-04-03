CREATE TABLE developers (
    id serial primary key,
    name varchar(255) NOT null,
    sex varchar(6) NOT null,
    salary decimal
);

CREATE TABLE skills(
    id serial primary key,
    rank varchar(255) NOT NULL,
    syntax varchar (255)
);

CREATE TABLE projects(
    id serial primary key,
    project_name varchar(255) NOT NULL,
    start_date date NOT NULL,
    cost decimal
);

CREATE TABLE companies(
    id serial primary key,
    company_name varchar(255) NOT null,
    city varchar(255) NOT null
);

CREATE TABLE clients(
    id serial primary key,
    name varchar(255) NOT null,
    country varchar(255) NOT null,
    category varchar(255) NOT null
);

CREATE TABLE devskills(
    dev_id int references developers(id) on delete cascade,
    skill_id int references skills(id) on delete cascade,
    primary key (dev_id, skill_id)
);

CREATE TABLE devprojects(
    dev_id int references developers(id) on delete cascade,
    project_id int references projects(id) on delete cascade,
    primary key (dev_id, project_id)
);

CREATE TABLE companydevs(
    company_id int references companies(id) on delete cascade,
    dev_id int references developers(id) on delete cascade,
    primary key (dev_id, company_id)
);

CREATE TABLE clientprojects(
    client_id int references clients(id) on delete cascade,
    project_id int references projects(id) on delete cascade,
    primary key (client_id, project_id)
);

CREATE TABLE companyprojects(
    company_id int references companies(id) on delete cascade,
    project_id int references projects(id) on delete cascade,
    primary key (company_id, project_id)
);