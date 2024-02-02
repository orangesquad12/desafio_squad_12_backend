CREATE TABLE tb_user (
  id BIGINT AUTO_INCREMENT NOT NULL,
   first_name VARCHAR(255) NULL,
   last_name VARCHAR(255) NULL,
   image VARCHAR(255) NULL,
   country VARCHAR(255) NULL,
   email VARCHAR(255) NULL,
   password VARCHAR(255) NULL,
   CONSTRAINT pk_tb_user PRIMARY KEY (id)
);

CREATE TABLE project_tags (
  project_id BIGINT NOT NULL,
   tags VARCHAR(255) NULL
);

CREATE TABLE tb_project (
  id BIGINT AUTO_INCREMENT NOT NULL,
   client_id BIGINT NULL,
   title VARCHAR(255) NULL,
   `description` VARCHAR(255) NULL,
   image VARCHAR(255) NULL,
   date date NULL,
   CONSTRAINT pk_tb_project PRIMARY KEY (id)
);

ALTER TABLE tb_project ADD CONSTRAINT FK_TB_PROJECT_ON_CLIENT FOREIGN KEY (client_id) REFERENCES tb_user (id);

ALTER TABLE project_tags ADD CONSTRAINT fk_project_tags_on_project FOREIGN KEY (project_id) REFERENCES tb_project (id);