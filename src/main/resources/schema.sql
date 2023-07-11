DROP TABLE IF EXISTS users;
CREATE TABLE users (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  email VARCHAR(100) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS usergroup;
CREATE TABLE usergroup (
  group_id INT AUTO_INCREMENT PRIMARY KEY,
  groupname VARCHAR(50) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS usergroup_assignment; 
CREATE TABLE usergroup_assignment (
  user_id INT NOT NULL,
  group_id INT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
  FOREIGN KEY (group_id) REFERENCES usergroup(group_id) ON DELETE RESTRICT
);

DROP TABLE IF EXISTS board; -- TRUNCATE
CREATE TABLE board (
  board_id INT AUTO_INCREMENT PRIMARY KEY,
  content TEXT NOT NULL,
  author INT,
  created_date DATETIME NOT NULL,--indexing(order by..?)
  modified_date DATETIME NOT NULL, 
  FOREIGN KEY (author) REFERENCES users(user_id) ON DELETE SET NULL
);


CREATE INDEX index_author ON board (author);
CREATE INDEX index_date ON board (created_date);