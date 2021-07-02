DROP TABLE IF EXISTS account CASCADE;

CREATE TABLE account
(
    id           bigint      NOT NULL AUTO_INCREMENT,
    name          varchar(10) NOT NULL,
    email         varchar(50) NOT NULL,
    password        varchar(80) NOT NULL,
    nickname        varchar(100) NOT NULL,
    part        varchar(100) NOT NULL,
    role        varchar(100) NULL,
    alarm_flag        varchar(100) NULL,
    introduce        varchar(100) NULL,
    profilePath        varchar(100) NULL,
    create_date     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(), -- 생성일시
    modified_date     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(), -- 생성일시
    PRIMARY KEY (id)
);