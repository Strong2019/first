DROP TABLE IF EXISTS intern.relation_user_role;
DROP TABLE IF EXISTS intern.user_info;
DROP TABLE IF EXISTS intern.role;

CREATE TABLE intern.user_info
(
    user_id  bigint                            NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    username text COLLATE pg_catalog."default" NOT NULL,
    password text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT user_info_pkey PRIMARY KEY (user_id),
    CONSTRAINT unique_user_id UNIQUE (user_id) INCLUDE (user_id)
) TABLESPACE pg_default;
ALTER TABLE intern.user_info
    OWNER to postgres;
COMMENT ON TABLE intern.user_info IS 'user info';
COMMENT ON COLUMN intern.user_info.user_id IS 'user id';
COMMENT ON COLUMN intern.user_info.username IS 'username';
COMMENT ON CONSTRAINT unique_user_id ON intern.user_info IS 'ensure user_id is unique.';

CREATE TABLE intern.role
(
    role_id   bigint                            NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1 ),
    role_name text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT role_pkey PRIMARY KEY (role_id),
    CONSTRAINT unique_role_id UNIQUE (role_id) INCLUDE (role_id)
) TABLESPACE pg_default;
ALTER TABLE intern.role
    OWNER to postgres;
COMMENT ON TABLE intern.role IS 'user permission role';
COMMENT ON CONSTRAINT unique_role_id ON intern.role IS 'ensure the id is unique.';

INSERT INTO intern.role(role_name)
VALUES ('ADMIN');
INSERT INTO intern.role(role_name)
VALUES ('COMMON');

CREATE TABLE intern.relation_user_role
(
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,
    CONSTRAINT relation_user_role_pkey PRIMARY KEY (user_id, role_id),
    CONSTRAINT unique_relation UNIQUE (user_id, role_id) INCLUDE (user_id, role_id),
    CONSTRAINT foreign_role_id FOREIGN KEY (role_id) REFERENCES intern.role (role_id) MATCH SIMPLE ON DELETE NO ACTION,
    CONSTRAINT foreign_user_id FOREIGN KEY (user_id) REFERENCES intern.user_info (user_id) MATCH SIMPLE ON UPDATE NO ACTION
) TABLESPACE pg_default;
ALTER TABLE intern.relation_user_role
    OWNER to postgres;
COMMENT ON TABLE intern.relation_user_role IS 'the relation between user and role.';
COMMENT ON CONSTRAINT unique_relation ON intern.relation_user_role IS 'ensure user_id and role_id are unique.';
COMMENT ON CONSTRAINT foreign_role_id ON intern.relation_user_role IS 'reference role_id which in role table.';
COMMENT ON CONSTRAINT foreign_user_id ON intern.relation_user_role IS 'reference user_id which in user_info table.';