DROP DATABASE IF EXISTS test_user_DB_1;
-- Create the database
CREATE DATABASE IF NOT EXISTS test_user_DB_1;
USE test_user_DB_1;

-- Create the users table: ID, username, useremail
CREATE TABLE IF NOT EXISTS users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE
);

-- Create the group table: ID, group
CREATE TABLE IF NOT EXISTS usergroup (
  user_id INT PRIMARY KEY,
  groupname VARCHAR(50) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- Create the board table: Id, contents, auther, make, modi,
CREATE TABLE IF NOT EXISTS board (
  board_id INT AUTO_INCREMENT PRIMARY KEY,
  content TEXT NOT NULL,
  author INT, -- reco add username 
  created DATETIME NOT NULL,
  modified DATETIME NOT NULL,
  FOREIGN KEY (author) REFERENCES users(user_id) ON DELETE SET NULL
);

INSERT INTO users (username, email)
VALUES
  ('John', 'john@example.com'),
  ('Emily', 'emily@example.com'),
  ('Michael', 'michael@example.com'),
  ('Sarah', 'sarah@example.com');

INSERT INTO usergroup (user_id, groupname)
VALUES
  (1, 'Silver'),
  (2, 'Gold'),
  (3, 'Silver'),
  (4, 'VIP');

INSERT INTO board (content, author, created, modified)
VALUES
  ('Lorem ipsum dolor sit amet.', 1, '2023-07-01 10:30:00', '2023-07-01 10:30:00'),
  ('Nulla facilisi.', 2, '2023-07-02 14:45:00', '2023-07-02 15:20:00'),
  ('Sed ut perspiciatis unde omnis iste natus error sit voluptatem.', 3, '2023-07-03 08:15:00', '2023-07-03 09:00:00'),
  ('Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit.', 4, '2023-07-04 16:00:00', '2023-07-05 11:10:00');

-- DELETE FROM users WHERE username = 'John';

select * from usergroup;

SELECT u.username, u.email, b.content, ug.groupname
FROM board b
LEFT JOIN users u ON b.author = u.user_id
LEFT JOIN usergroup ug ON u.user_id = ug.user_id;

SELECT u.username, b.content
FROM users u
JOIN usergroup ug ON u.user_id = ug.user_id
JOIN board b ON u.user_id = b.author
WHERE ug.groupname = 'VIP'
