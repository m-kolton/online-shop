CREATE TABLE category (

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(225),
	image_url VARCHAR(50),
	is active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
	
);