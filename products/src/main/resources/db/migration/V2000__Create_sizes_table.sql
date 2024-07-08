-- Create sizes table if it doesn't exist
CREATE TABLE IF NOT EXISTS sizes
(
    id
    BIGINT
    PRIMARY
    KEY,
    created_at
    TIMESTAMP
    WITH
    TIME
    ZONE
    NOT
    NULL
    DEFAULT
    NOW
(
),
    modified_at TIMESTAMP WITH TIME ZONE,
    deleted_at TIMESTAMP WITH TIME ZONE,
                             code VARCHAR (255) NOT NULL,
    name VARCHAR
(
    255
) NOT NULL
    );

ALTER TABLE sizes
    ALTER COLUMN created_at SET DEFAULT NOW();

-- Insert initial sizes
INSERT INTO sizes (id, code, name)
VALUES (1, 'XS', 'Extra Small'),
       (2, 'S', 'Small'),
       (3, 'M', 'Medium'),
       (4, 'L', 'Large'),
       (5, 'XL', 'Extra Large'),
       (6, 'XXL', 'Double Extra Large');
