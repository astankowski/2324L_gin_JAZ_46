create table if not exists Personal_Records(
                    ID uuid not null,
                    WEIGHT varchar(255),
                    EXERCISE varchar(255),
                    OWNER_NAME varchar(255),
                    PRIMARY KEY ( ID )
);

INSERT INTO Personal_Records (id, weight, exercise, owner_name) VALUES
('6085f36e-762a-4348-8ba4-1acaff537c83', '100', 'BENCH_PRESS', 'Jan'),
('87026cfb-1564-4e24-b8c3-dd8d5eb606b8 ', '140', 'SQUAT', 'Kuba'),
('b69a502c-0813-4cf9-839e-1ab88975bc27', '180', 'DEADLIFT', 'Daniel'),
('f1fbb012-f1d8-40c7-9d2e-6d63567e3c28', '120', 'BARBELL_ROW', 'Jan'),
('441c0dd9-7a22-42d3-a9b7-de8dc956ee61', '60', 'OVERHEAD_PRESS', 'Marek');
