-- Create product_categories table
CREATE TABLE IF NOT EXISTS product_categories
(
    id          BIGSERIAL PRIMARY KEY,
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    modified_at TIMESTAMP WITH TIME ZONE,
    deleted_at  TIMESTAMP WITH TIME ZONE,
    name        VARCHAR(255)             NOT NULL,
    code        VARCHAR(255)             NOT NULL
);

ALTER TABLE product_categories
    ALTER COLUMN created_at SET DEFAULT NOW();

-- Insert initial product categories
INSERT INTO product_categories (id, name, code)
VALUES (1, 'T-Shirts', 'TSH'),
       (2, 'Hats', 'HAT'),
       (3, 'Posters', 'POSTER'),
       (4, 'Albums', 'ALBUM'),
       (5, 'Accessories', 'ACCESSORY');