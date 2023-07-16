-- Insert sample data into the users table
INSERT INTO users (username, email) VALUES
  ('john', 'john@example.com'),
  ('mary', 'mary@example.com'),
  ('james', 'james@example.com');

-- Insert sample data into the products table
INSERT INTO products (name, price) VALUES
  ('Product A', 10.99),
  ('Product B', 15.99),
  ('Product C', 7.99);

-- Insert sample data into the orders table
INSERT INTO orders (user_id, product_id, quantity, order_date) VALUES
  (1, 1, 2, '2023-07-01 10:00:00'),
  (1, 2, 1, '2023-07-02 15:30:00'),
  (2, 3, 3, '2023-07-03 09:45:00');
