CREATE TABLE measuring_unit (
    id SERIAL PRIMARY KEY,
    unit_name VARCHAR NOT NULL,
    unit_variable VARCHAR NOT NULL
);

CREATE TABLE recipe_user (
    id SERIAL UNIQUE PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE
);

CREATE TABLE recipe (
    id SERIAL UNIQUE PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description VARCHAR(255) NOT NULL,
);