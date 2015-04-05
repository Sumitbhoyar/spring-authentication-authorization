CREATE SCHEMA SA;
CREATE TABLE Employee (
  username varchar(20) NOT NULL,
  password varchar(20) NOT NULL,
  enabled SMALLINT NOT NULL,
  PRIMARY KEY (username)
) ;


CREATE TABLE Roles (
  username varchar(20) NOT NULL,
  role varchar(20) NOT NULL,
  PRIMARY KEY (username,role)
) ;
 
INSERT INTO Employee (username, password, enabled)
VALUES
    ('sumit', '7225ff71e8821b24fd72b4c8fda95b9a', 1);

INSERT INTO Employee (username, password, enabled)
VALUES
    ('vir', '590f35821fbed7b2ab58a9dbaf36c42d', 1);
 
INSERT INTO Roles (username, role)
VALUES
    ('sumit', 'Admin');
INSERT INTO Roles (username, role)
    VALUES
    ('sumit', 'CEO');

INSERT INTO Roles (username, role)
    VALUES
    ('vir', 'User');

