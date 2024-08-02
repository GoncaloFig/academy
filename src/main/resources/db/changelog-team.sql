create table t_team
(
    id               uuid      default gen_random_uuid() not null primary key,
    name             text                                not null,
    product          text                                not null,
    create_at        timestamp default now(),
    modified_at      timestamp default now(),
    default_location varchar(20)
);