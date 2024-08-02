create table t_booking
(
    --id           uuid default gen_random_uuid() not null primary key,
    rack_id      uuid not null constraint ft_t_rack references t_rack,
    requester_id uuid not null constraint ft_t_team_member references t_team_member,
    book_from    timestamp,
    book_to      timestamp,
    created_at   timestamp default now(),
    modified_at  timestamp default now()
);