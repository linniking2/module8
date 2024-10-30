INSERT INTO client (name) VALUES
('Client A'),
('Client B'),
('Client C');

INSERT INTO project (client_id, start_date, finish_date) VALUES
(1, '2020-01-01', '2020-12-31'),
(2, '2021-01-01', '2021-12-31'),
(3, '2022-01-01', '2022-12-31');

INSERT INTO worker (name, birthday, level, salary) VALUES
('John Doe', '1985-05-15', 'Senior', 8000),
('Jane Smith', '1990-07-20', 'Middle', 6000),
('Bob Johnson', '2000-03-30', 'Junior', 3000);

INSERT INTO project_worker (project_id, worker_id) VALUES
(1, 1),
(2, 2),
(3, 3);