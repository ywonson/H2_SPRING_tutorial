USE test_user_DB;
-- Inserting mock data into the 'users' table
INSERT INTO users (username, email) VALUES
  ('User1', 'user1@example.com'),
  ('User2', 'user2@example.com'),
  ('User3', 'user3@example.com');

-- Inserting mock data into the 'usergroup' table
INSERT INTO usergroup (groupname) VALUES
  ('Silver'),
  ('Gold'),
  ('Iron'),
  ('VIP');

-- Inserting mock data into the 'usergroup_assignment' table
INSERT INTO usergroup_assignment (user_id, group_id) VALUES
  (1, 1), -- User1 assigned to Silver group
  (2, 3), -- User2 assigned to Iron group
  (3, 4); -- User3 assigned to VIP group
  
-- Inserting mock data into the 'board' table
INSERT INTO board (content, author, created, modified) VALUES
  ('Board content 1', 1, NOW(), NOW()),
  ('Board content 2', 1, NOW(), NOW()),
  ('Board content 3', 2, NOW(), NOW()),
  ('Board content 4', 3, NOW(), NOW());

-- show
SELECT u.username, ug.groupname, b.board_id, b.content
FROM users u
LEFT JOIN usergroup_assignment ua ON u.user_id = ua.user_id
LEFT JOIN usergroup ug ON ua.group_id = ug.group_id
LEFT JOIN board b ON u.user_id = b.author
WHERE u.user_id = 3;


DELETE FROM users WHERE username = 'User3';


