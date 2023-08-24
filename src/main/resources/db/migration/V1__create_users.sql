CREATE DATABASE IF NOT EXISTS notes;
USE notes;

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS tasks (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    created_by INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(255),
    parent_task INT,
    FOREIGN KEY (created_by) REFERENCES users(id),
    FOREIGN KEY (parent_task) REFERENCES tasks(id)
);


INSERT INTO users (name, email, password)
VALUES ('Nandakumar', 'nandakumarp3003@gmail.com', 'Nanda@123');

INSERT INTO users (name, email, password)
VALUES ('Surya', 'surya@example.com', 'Password123');

SELECT * FROM Users;
INSERT INTO tasks (id, name, description, created_by, status)
VALUES (1, 'Java Documentation', 'I would finish my Java documentation', 1, 'In Progress');

INSERT INTO tasks (id, name, description, created_by, status)
VALUES (2, 'Practice', 'Throwing Sets for one hour', 1, 'In Progress');

INSERT INTO tasks (id, name, description, created_by, status, parent_task)
VALUES (3, 'ER Diagram', 'Mind map for my project', 1, 'Completed', 1);

INSERT INTO tasks (id, name, description, created_by, status)
VALUES (4, 'Tournament', 'Going Bangalore for Sakkath Tournament', 2, 'Pending');

SELECT * FROM Tasks;
