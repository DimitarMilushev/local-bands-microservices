-- Create genders table
CREATE TABLE IF NOT EXISTS genders
(
    id          BIGSERIAL PRIMARY KEY,
    created_at  TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    modified_at TIMESTAMP WITH TIME ZONE,
    deleted_at  TIMESTAMP WITH TIME ZONE,
    name        VARCHAR(255)             NOT NULL,
    code        VARCHAR(255)             NOT NULL
);

ALTER TABLE genders
    ALTER COLUMN created_at SET DEFAULT NOW();

-- Insert initial genders
INSERT INTO genders (id, name, code)
VALUES (1, 'Male', 'M'),
       (2, 'Female', 'F'),
       (3, 'Unisex', 'U');
