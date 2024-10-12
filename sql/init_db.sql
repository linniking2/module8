CREATE TABLE client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL,
    CHECK(LENGTH(name) BETWEEN 2 AND 1000)
);

CREATE TABLE project (
    id IDENTITY PRIMARY KEY,
    client_id INT NOT NULL,
    start_date DATE NOT NULL,
    finish_date DATE NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE worker (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL,
    birthday DATE,
    level VARCHAR(100) NOT NULL,
    salary INT NOT NULL,
    CHECK(LENGTH(name) BETWEEN 2 AND 1000),
    CHECK(YEAR(birthday) > 1900),
    CHECK(level IN ('Trainee', 'Junior', 'Middle', 'Senior')),
    CHECK(salary BETWEEN 100 AND 100000)
);

CREATE TABLE project_worker (
    project_id INT NOT NULL,
    worker_id INT NOT NULL,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY (project_id) REFERENCES project(id),
    FOREIGN KEY (worker_id) REFERENCES worker(id)
);