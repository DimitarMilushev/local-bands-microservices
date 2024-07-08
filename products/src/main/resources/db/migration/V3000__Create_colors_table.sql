-- Create colors table
CREATE TABLE IF NOT EXISTS colors
(
    id          BIGSERIAL PRIMARY KEY,
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    modified_at TIMESTAMP WITH TIME ZONE,
    deleted_at  TIMESTAMP WITH TIME ZONE,
    name        VARCHAR(255)             NOT NULL,
    hex         VARCHAR(7)               NOT NULL,
    code        VARCHAR(255)             NOT NULL
);

ALTER TABLE colors
    ALTER COLUMN created_at SET DEFAULT NOW();

-- Insert initial colors
INSERT INTO colors (id, name, hex, code)
VALUES (1, 'Black', '#000000', 'BLACK'),
       (2, 'White', '#FFFFFF', 'WHITE'),
       (3, 'Red', '#FF0000', 'RED'),
       (4, 'Blue', '#0000FF', 'BLUE'),
       (5, 'Yellow', '#FFFF00', 'YELLOW');
