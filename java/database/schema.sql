BEGIN TRANSACTION;

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS breweries CASCADE;
DROP TABLE IF EXISTS beer CASCADE;
DROP TABLE IF EXISTS beer_inventory CASCADE;
DROP TABLE IF EXISTS beer_reviews CASCADE;
DROP TABLE IF EXISTS user_reviews CASCADE;
DROP TABLE IF EXISTS user_brewery_favorites CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE breweries(
  brewery_id serial,
  brewery_name varchar(50) NOT NULL,
  brewery_address varchar(50),
  brewery_city varchar(50),
  brewery_state varchar(2),
  brewery_zip varchar(5),
  brewery_phone varchar(14),
  brewery_email varchar(100),
  brewery_history varchar(255),
  active boolean,
  PRIMARY KEY(brewery_id)
);

CREATE TABLE beer(
  beer_id serial,
  beer_name varchar(50) NOT NULL,
  beer_description varchar(255) NOT NULL,
  beer_abv numeric(3, 1) NOT NULL,
  beer_type varchar(50) NOT NULL,
  PRIMARY KEY(beer_id)
);

CREATE TABLE beer_inventory(
  brewery_id int,
  beer_id int,
  active boolean,
  PRIMARY KEY(brewery_id, beer_id),
  FOREIGN KEY(brewery_id) REFERENCES breweries(brewery_id),
  FOREIGN KEY(beer_id) REFERENCES beer(beer_id)
);

CREATE TABLE beer_reviews(
  beer_id int NOT NULL,
  review_id serial,
  beer_rating int,
  beer_review varchar(255),
  PRIMARY KEY(review_id),
  FOREIGN KEY(beer_id) REFERENCES beer(beer_id)
);

CREATE TABLE user_reviews(
  user_id int,
  review_id int,
  PRIMARY KEY(user_id, review_id),
  FOREIGN KEY(user_id) REFERENCES users(user_id),
  FOREIGN KEY(review_id) REFERENCES beer_reviews(review_id)
);

CREATE TABLE user_brewery_favorites(
  user_id int,
  brewery_id int,
  PRIMARY KEY(user_id, brewery_id),
  FOREIGN KEY(user_id) REFERENCES users(user_id),
  FOREIGN KEY(brewery_id) REFERENCES breweries(brewery_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
