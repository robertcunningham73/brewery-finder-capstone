INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Ben''s Brewery', '923 Main Street', 'Philadelphia', 'PA', '19032', '111-111-1111', 'Bensbrewery@email.com', 'History of Ben''s brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Bobby''s Brewery', '293 Broad Street', 'Anaheim', 'CA', '78392', '222-222-2222', 'Bobbysbrewer@email.com', 'History of Bobby''s brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Kaleb''s Brewery', '14 Hay Road', 'Houston', 'TX', '38394', '333-333-3333', 'Kalebsbrewer@email.com', 'History of Kaleb''s brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Michele''s Brewery', '35 Beach Street', 'Orlando', 'FL', '49384', '444-444-4444', 'Michelesbrewer@email.com', 'History of Michele''s brewery', true);

INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Devil''s IPA', 'An IPA inspired by the Devil', '7.7', 'IPA', '../assets/IPA.jpg');
INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Canadian Lager', 'Tastes like maple syrup!', '5.1', 'Lager', '../assets/lager.jpg');
INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Special Wit', 'A special Wit', '4.2', 'Wit', '../assets/belgianwitbiersmall.jpg');
INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Hefeweizen', 'Delicious', '4.1', 'Hefeweizen', '../assets/Hefeweizen_Glass.jpg');

INSERT INTO beer_inventory VALUES (1, 1);
INSERT INTO beer_inventory VALUES (2, 2);
INSERT INTO beer_inventory VALUES (3, 3);
INSERT INTO beer_inventory VALUES (4, 4);

INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (1, 5, 'Greating tasting beer');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (1, 4, 'Good beer');
INSERT INTO beer_reviews (beer_id, beer_rating) VALUES (1, 3);
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (2, 5, 'Greating tasting beer');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (2, 4, 'Good beer');
INSERT INTO beer_reviews (beer_id, beer_rating) VALUES (2, 3);
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (3, 5, 'Greating tasting beer');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (3, 4, 'Good beer');
INSERT INTO beer_reviews (beer_id, beer_rating) VALUES (3, 3);
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (4, 5, 'Greating tasting beer');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (4, 4, 'Good beer');
INSERT INTO beer_reviews (beer_id, beer_rating) VALUES (4, 3);