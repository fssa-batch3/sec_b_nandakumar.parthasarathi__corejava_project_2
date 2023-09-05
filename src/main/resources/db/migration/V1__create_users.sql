CREATE DATABASE IF NOT EXISTS notes;
USE notes;

CREATE TABLE IF NOT EXISTS users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    is_active TINYINT(1) DEFAULT 1
);

CREATE TABLE IF NOT EXISTS tasks (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    created_by INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(255),
    FOREIGN KEY (created_by) REFERENCES users(id)
);

INSERT INTO users (name, email, password)
VALUES ('Nandakumar', 'nandakumarp3003@gmail.com', 'Nanda@123');

INSERT INTO users (name, email, password)
VALUES ('Surya', 'surya@example.com', 'Password123');

-- Corrected the SELECT statement to use the 'users' table
SELECT * FROM users;

-- For tasks table, corrected the column names in the INSERT statements
INSERT INTO tasks (name, description, status, created_by)
VALUES ('Java Documentation', 'I would finish my Java documentation', 'In Progress', 1);

INSERT INTO tasks (name, description, status, created_by)
VALUES ('Practice', 'Throwing Sets for one hour', 'In Progress', 1);

INSERT INTO tasks (name, description, status, created_by)
VALUES ('ER Diagram', 'Mind map for my project', 'Completed', 1);

INSERT INTO tasks (name, description, status, created_by)
VALUES ('Tournament', 'Going Bangalore for Sakkath Tournament', 'Pending', 2);

SELECT * FROM tasks;
