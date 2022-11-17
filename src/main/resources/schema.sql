SET MODE MySQL;
SET IGNORECASE = TRUE;

-- -----------------------------------------------------
-- Table `gym`
-- -----------------------------------------------------

DROP TABLE IF EXISTS gym;
DROP TABLE IF EXISTS manager;
DROP TABLE IF EXISTS manager_role;
DROP TABLE IF EXISTS member;

CREATE TABLE IF NOT EXISTS gym
(
    name            VARCHAR(200)            NOT NULL,
    id              INTEGER AUTO_INCREMENT  NOT NULL,
    location        VARCHAR(30)             NOT NULL,
    fee             VARCHAR(30)             NOT NULL,
    is_approved     VARCHAR(1)              NOT NULL,
    PRIMARY KEY (`id`)
)
    engine = InnoDB;

CREATE TABLE IF NOT EXISTS manager
(
    id              INTEGER AUTO_INCREMENT    NOT NULL,
    name            VARCHAR(200)              NOT NULL,
    address         VARCHAR(200)              NOT NULL,
    role_id         INTEGER                   NOT NULL,
    gym_id          INTEGER                   NOT NULL,
    PRIMARY KEY (`id`)
)
    engine = InnoDB;

CREATE TABLE IF NOT EXISTS manager_role
(
    id               INTEGER AUTO_INCREMENT     NOT NULL,
    title            VARCHAR(200)               NOT NULL,
    PRIMARY KEY (`id`)
)
    engine = InnoDB;

CREATE TABLE IF NOT EXISTS member
(
    id              INTEGER AUTO_INCREMENT     NOT NULL,
    name            VARCHAR(200)               NOT NULL,
    address         VARCHAR(200)               NOT NULL,
    tier            VARCHAR(5)                 NOT NULL,
    gym_id          INTEGER                    NOT NULL,
    PRIMARY KEY (`id`)
)
    engine = InnoDB;