CREATE TABLE tasks (
                       id           BIGSERIAL PRIMARY KEY,
                       title        VARCHAR(150) NOT NULL,
                       description  TEXT,
                       is_completed BOOLEAN NOT NULL DEFAULT FALSE,
                       created_at   TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);