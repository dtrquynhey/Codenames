CREATE DATABASE IF NOT EXISTS codenamesdb;
CREATE TABLE IF NOT EXISTS accounts
(
    username varchar(255) not null PRIMARY KEY,
    password varchar(255) null
);
CREATE TABLE IF NOT EXISTS teams (
    teamId INT AUTO_INCREMENT PRIMARY KEY,
    spymaster VARCHAR(255) NULL,
    operative VARCHAR(255) NULL,
    color ENUM ('RED', 'BLUE') NOT NULL,
    isWinner TINYINT(1) NULL);
CREATE TABLE IF NOT EXISTS games (
    gameId INT AUTO_INCREMENT PRIMARY KEY,
    redTeam INT NULL,
    blueTeam INT NULL,
    date DATE NULL,
    result ENUM ('RED_WIN', 'BLUE_WIN', 'ON_GOING', 'INCOMPLETE') NULL,
    CONSTRAINT game_teams_teamId_fk FOREIGN KEY (redTeam) REFERENCES teams (teamId) ON DELETE CASCADE,
    CONSTRAINT game_teams_teamId_fk_2 FOREIGN KEY (blueTeam) REFERENCES teams (teamId) ON DELETE CASCADE);
CREATE TABLE IF NOT EXISTS history (
    account VARCHAR(255) NOT NULL,
    gameId INT NOT NULL,
    PRIMARY KEY (account, gameId),
    CONSTRAINT history_accounts_username_fk FOREIGN KEY (account) REFERENCES accounts (username) ON DELETE CASCADE,
    CONSTRAINT history_games_gameId_fk FOREIGN KEY (gameId) REFERENCES games (gameId) ON DELETE CASCADE);