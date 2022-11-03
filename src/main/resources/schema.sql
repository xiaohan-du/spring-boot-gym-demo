SET MODE MySQL;
SET IGNORECASE = TRUE;

-- -----------------------------------------------------
-- Table `gym`
-- -----------------------------------------------------

drop table if exists gym;


create table if not exists gym
(
    name            varchar(200) not null,
    id              varchar(15)  not null,
    location        varchar(30)  not null,
    fee             varchar(30)  not null,
    is_approved     varchar(1)   not null,
    primary key (`id`)
    )
    engine = InnoDB;