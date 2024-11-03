-- Create the 'users' table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    pin NUMERIC(4, 0),
    quotes VARCHAR(300),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

-- Create the 'currencies' table
CREATE TABLE currencies (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(3) UNIQUE NOT NULL,
    symbol VARCHAR(5) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

-- Create the 'currency_rates' table
CREATE TABLE currency_rates (
    id SERIAL PRIMARY KEY,
    currency_id INTEGER NOT NULL REFERENCES currencies(id),
    rates INTEGER NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

-- Create the 'wallets' table
CREATE TABLE wallets (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(id),
    current_balance INTEGER DEFAULT 0,
    currency_id INTEGER NOT NULL REFERENCES currencies(id),
    is_active BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

-- Create the 'pockets' table
CREATE TABLE pockets (
    id SERIAL PRIMARY KEY,
    wallet_id INTEGER NOT NULL REFERENCES wallets(id),
    target_balance INTEGER DEFAULT 0,
    current_balance INTEGER DEFAULT 0,
    description TEXT,
    emoji VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

-- Create the 'goals' table
CREATE TABLE goals (
    id SERIAL PRIMARY KEY,
    wallet_id INTEGER NOT NULL REFERENCES wallets(id),
    name VARCHAR(100) NOT NULL,
    target_balance INTEGER DEFAULT 0,
    current_balance INTEGER DEFAULT 0,
    description TEXT,
    attachment VARCHAR,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

-- Create the 'transaction_records' table
CREATE TABLE transaction_records (
    id SERIAL PRIMARY KEY,
    pocket INTEGER NOT NULL REFERENCES pockets(id),
    goal INTEGER REFERENCES goals(id),
    name VARCHAR(100) NOT NULL,
    amount INTEGER NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

-- Create the 'notification_types' table
CREATE TABLE notification_types (
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

-- Create the 'notifications' table
CREATE TABLE notifications (
    id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL REFERENCES users(id),
    notification_type INTEGER REFERENCES notification_types(id),
    name VARCHAR(100) NOT NULL,
    details TEXT,
    is_read BOOLEAN DEFAULT FALSE,
    sent_at TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP
);

