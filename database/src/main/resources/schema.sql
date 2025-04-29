-- =========== appdb.sql ===========

-- Enable UUID generation
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- 1. Users
CREATE TABLE users (
  id            UUID        PRIMARY KEY DEFAULT uuid_generate_v4(),
  email         VARCHAR(255) UNIQUE NOT NULL,
  password_hash VARCHAR(255) NOT NULL,
  full_name     VARCHAR(255) NOT NULL,
  created_at    TIMESTAMP   NOT NULL DEFAULT now(),
  updated_at    TIMESTAMP   NOT NULL DEFAULT now()
);

-- 2. Flight Logs
CREATE TABLE flight_logs (
  id             UUID      PRIMARY KEY DEFAULT uuid_generate_v4(),
  user_id        UUID      NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  flight_number  VARCHAR(50) NOT NULL,
  departure_airport VARCHAR(10),
  arrival_airport   VARCHAR(10),
  departure_time    TIMESTAMP,
  arrival_time      TIMESTAMP,
  created_at        TIMESTAMP NOT NULL DEFAULT now()
);

-- 3. Chatrooms
CREATE TABLE chatrooms (
  id            UUID      PRIMARY KEY DEFAULT uuid_generate_v4(),
  flight_log_id UUID      NOT NULL REFERENCES flight_logs(id) ON DELETE CASCADE,
  status        VARCHAR(10) NOT NULL DEFAULT 'open',
  created_at    TIMESTAMP   NOT NULL DEFAULT now()
);

-- 4. Chatroom Participants
CREATE TABLE chatroom_participants (
  id           UUID      PRIMARY KEY DEFAULT uuid_generate_v4(),
  chatroom_id  UUID      NOT NULL REFERENCES chatrooms(id) ON DELETE CASCADE,
  user_id      UUID      NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  joined_at    TIMESTAMP NOT NULL DEFAULT now(),
  UNIQUE (chatroom_id, user_id)
);

-- 5. Chat Messages
CREATE TABLE chat_messages (
  id              UUID      PRIMARY KEY DEFAULT uuid_generate_v4(),
  chatroom_id     UUID      NOT NULL REFERENCES chatrooms(id) ON DELETE CASCADE,
  sender_id       UUID      NOT NULL REFERENCES users(id) ON DELETE CASCADE,
  message_content TEXT      NOT NULL,
  sent_at         TIMESTAMP NOT NULL DEFAULT now()
);
