-- Создаем таблицу пользователей
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Добавляем колонку user_id в таблицу задач
ALTER TABLE tasks ADD COLUMN user_id BIGINT;

-- Делаем её обязательной
DELETE FROM tasks;
ALTER TABLE tasks ALTER COLUMN user_id SET NOT NULL;

-- Создаем связь
ALTER TABLE tasks ADD CONSTRAINT fk_tasks_users FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE;