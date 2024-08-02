create table t_rack
(
    --id               uuid      default gen_random_uuid() not null primary key,
    id               uuid not null primary key,
    serial_number    varchar(20) not null unique,
    team_id          uuid constraint ft_t_team references t_team,
    default_location varchar(10),
    created_at       timestamp default now(),
    status           varchar(20) constraint checkstatus
        check ((status)::text = ANY
        ((ARRAY ['AVAILABLE'::character varying, 'BOOKED'::character varying, 'UNAVAILABLE'::character varying])::text[])),
    modified_at      timestamp default now()
);