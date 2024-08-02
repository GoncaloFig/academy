create table t_rack_asset
(
    id uuid default gen_random_uuid() not null primary key,
    asset_tag varchar(10) not null,
    rack_id   uuid not null references t_rack constraint ft_t_rack references t_rack
);