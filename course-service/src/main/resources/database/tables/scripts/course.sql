CREATE TABLE course (
  id                 BIGINT           NOT NULL    AUTO_INCREMENT,
  name               VARCHAR(250)     NOT NULL    UNIQUE,
  espb               INT(250)         NOT NULL,
  goal               VARCHAR (500)    NOT NULL,
  method_of_evaluation VARCHAR (500)    NOT NULL,
  level_of_studies_id   BIGINT           NOT NULL,
  department_id       BIGINT           NOT NULL,
  PRIMARY KEY (id)
  );
