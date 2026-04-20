CREATE TABLE IF NOT EXISTS books (
       isbn VARCHAR(17) PRIMARY KEY,
       title VARCHAR(255) NOT NULL,
       author VARCHAR(255) NOT NULL,
       category VARCHAR(50) NOT NULL
);