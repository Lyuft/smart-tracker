FROM node:22-alpine
WORKDIR /app

COPY package*.json ./
RUN npm install

COPY . .

# Angular по умолчанию использует порт 4200
EXPOSE 4200

# Запускаем Angular dev-сервер с доступом извне (флаг --host 0.0.0.0)
CMD ["npm", "start", "--", "--host", "0.0.0.0", "--port", "4200"]
