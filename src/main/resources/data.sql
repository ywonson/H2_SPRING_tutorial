INSERT INTO users (username, email)
VALUES
  ('Edwin', 'Edwin@example.com'), -- 1
  ('Dorothy', 'Dorothy@example.com'), --2
  ('Yeonwoo', 'Yeonwoo@example.com'), --3
  ('Tung', 'Tung@example.com'), --4
  ('Leo', 'Leo@example.com'); --5

INSERT INTO usergroup (groupname)
VALUES
  ('Silver'),
  ('Gold'),
  ('VIP');


INSERT INTO usergroup_assignment (user_id, group_id)
VALUES
  (1,1),
  (1,2),
  (2,3),
  (4,2),
  (4,3),
  (5,3),  
  (3,3);

INSERT INTO board (content, author, created_date, modified_date)
VALUES
  ('첫 번째로 작성한 게시글입니다!', 2, '2023-07-01 10:30:00', '2023-07-04 10:30:00'),
  ('두 번째로 작성했습니다.', 1, '2023-07-02 14:45:00', '2023-07-12 15:20:00'),
  ('7월 3일 작성된 게시글입니다.', 3, '2023-07-03 08:15:00', '2023-07-03 09:00:00'),
  ('7월 4일 장석했습니다....', 4, '2023-07-04 16:00:00', '2023-07-05 11:10:00'),
  ('가장 최근 게시글입니다. 지금까지 총 5개입니다.', 4, '2023-07-05 16:00:00', '2023-07-06 11:10:00');