CREATE TABLE measuring_unit (
    id SERIAL PRIMARY KEY,
    unit_name VARCHAR NOT NULL,
    unit_variable VARCHAR NOT NULL
);


CREATE TABLE ingredient (
    id SERIAL UNIQUE PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE recipe_ingredient (
    id SERIAL UNIQUE PRIMARY KEY,
    ingredient_id INTEGER NOT NULL REFERENCES ingredient(id),
    unit_id INTEGER NOT NULL REFERENCES measuring_unit(id),
    amount DECIMAL NOT NULL
);

CREATE TABLE step (
    id SERIAL UNIQUE PRIMARY KEY,
    step_ingredient_id INTEGER NOT NULL REFERENCES recipe_ingredient(id),
    instruction VARCHAR(255) NOT NULL
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
    author_id INTEGER NOT NULL REFERENCES recipe_user(id)
);

CREATE TABLE recipe_info (
    id SERIAL UNIQUE PRIMARY KEY,
    step_id INTEGER NOT NULL REFERENCES step(id) ON DELETE CASCADE,
    recipe_ingredient_id INTEGER NOT NULL REFERENCES recipe_ingredient(id) ON DELETE CASCADE,
    author_id INTEGER NOT NULL REFERENCES recipe_user(id),
    prep_time INTEGER,
    recipe_id INTEGER NOT NULL REFERENCES recipe(id) ON DELETE CASCADE,
    servings INTEGER
);

CREATE TABLE rating (
    id SERIAL UNIQUE PRIMARY KEY,
    recipe_id INTEGER NOT NULL REFERENCES recipe(id),
    reviewer_id INTEGER NOT NULL REFERENCES recipe_user(id),
    rating INTEGER CHECK (rating >= 0 ) CHECK ( rating <= 5 ),
    review VARCHAR(255)
);

CREATE TABLE recipe_book (
    id SERIAL UNIQUE PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    recipe_id INTEGER NOT NULL REFERENCES recipe(id),
    owner_id INTEGER NOT NULL REFERENCES recipe_user(id)
);