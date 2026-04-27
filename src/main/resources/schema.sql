-- Create authors table
CREATE TABLE IF NOT EXISTS authors (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       name VARCHAR(255) NOT NULL,
    country VARCHAR(100),
    biography VARCHAR(500)
    );

-- Create publishers table
CREATE TABLE IF NOT EXISTS publishers (
                                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                          name VARCHAR(255) NOT NULL,
    country VARCHAR(100)
    );

-- Alter existing books table (or drop and recreate) – here we recreate for clarity
DROP TABLE IF EXISTS books;
CREATE TABLE books (
                       isbn VARCHAR(17) PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       author_id BIGINT NOT NULL,
                       publisher_id BIGINT NOT NULL,
                       category VARCHAR(50) NOT NULL,
                       FOREIGN KEY (author_id) REFERENCES authors(id),
                       FOREIGN KEY (publisher_id) REFERENCES publishers(id)
);

