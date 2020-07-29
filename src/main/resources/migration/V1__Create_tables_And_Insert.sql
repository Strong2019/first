
-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS intern.user_info;
CREATE TABLE intern.user_info (
    id bigserial NOT NULL primary key,
    username varchar(20) NOT NULL,
    password varchar(40) NOT NULL,
    role varchar(32) NOT NULL,
    description varchar(128)
);
