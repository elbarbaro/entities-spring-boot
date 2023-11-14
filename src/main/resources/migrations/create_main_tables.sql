create table if not exists persons(
    id serial not null primary key,
    first_name varchar(30) not null,
    last_name varchar(30) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);

create table if not exists pets(
    id serial not null primary key,
    name varchar(30) not null,
    created_at timestamp not null,
    updated_at timestamp not null
);