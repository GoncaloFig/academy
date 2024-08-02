create table t_team_member
(
    id          uuid default gen_random_uuid() not null primary key,
    team_id     uuid constraint ft_t_team references t_team,
    ctw_id      varchar(10) not null,
    name        text not null,
    create_at   timestamp default now(),
    modified_at timestamp default now()
);