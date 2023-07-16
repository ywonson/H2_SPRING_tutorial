DROP DATABASE IF EXISTS test_user_DB;
-- show databases;
CREATE DATABASE test_user_DB;

-- SHOW databases;
USE test_user_DB;

CREATE TABLE IF NOT EXISTS users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS usergroup (
  group_id INT AUTO_INCREMENT PRIMARY KEY,
  groupname VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS board (
  board_id INT AUTO_INCREMENT PRIMARY KEY,
  content TEXT NOT NULL,
  author INT,
  created DATETIME NOT NULL,
  modified DATETIME NOT NULL,
  FOREIGN KEY (author) REFERENCES users(user_id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS usergroup_assignment (
  user_id INT NOT NULL UNIQUE,
  group_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
  FOREIGN KEY (group_id) REFERENCES usergroup(group_id) ON DELETE RESTRICT
);

