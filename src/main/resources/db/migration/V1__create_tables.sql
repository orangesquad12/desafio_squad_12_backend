CREATE TABLE tb_user (
  id BIGINT AUTO_INCREMENT NOT NULL,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   image VARCHAR(255) NULL,
   country VARCHAR(255) NULL,
   email VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   project_id BIGINT NULL,
   CONSTRAINT pk_tb_user PRIMARY KEY (id)
);

ALTER TABLE tb_user ADD CONSTRAINT uc_tb_user_email UNIQUE (email);

ALTER TABLE tb_user ADD CONSTRAINT uc_tb_user_first_name UNIQUE (first_name);


CREATE TABLE project_tags (
  project_id BIGINT NOT NULL,
   tags VARCHAR(255) NULL
);

CREATE TABLE tb_project (
  id BIGINT AUTO_INCREMENT NOT NULL,
   client_id BIGINT NULL,
   title VARCHAR(255) NULL,
   detailing VARCHAR(255) NULL,
   image VARCHAR(255) NULL,
   date date NULL,
   CONSTRAINT pk_tb_project PRIMARY KEY (id)
);

ALTER TABLE tb_user ADD CONSTRAINT FK_TB_USER_ON_PROJECT FOREIGN KEY (project_id) REFERENCES tb_project (id);

ALTER TABLE tb_project ADD CONSTRAINT FK_TB_PROJECT_ON_CLIENT FOREIGN KEY (client_id) REFERENCES tb_user (id);

ALTER TABLE project_tags ADD CONSTRAINT fk_project_tags_on_project FOREIGN KEY (project_id) REFERENCES tb_project (id);