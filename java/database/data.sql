INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Brewery On Main', '923 Main Street', 'Philadelphia', 'PA', '19032', '111-111-1111', 'Breweryonmain@email.com', 'History of Brewery On Main', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Homer''s Brewery', '293 Broad Street', 'Anaheim', 'CA', '78392', '222-222-2222', 'Homersbrewer@email.com', 'History of Homer''s Brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Liberty Brewery', '14 Hay Road', 'Houston', 'TX', '38394', '333-333-3333', 'Libertybrewery@email.com', 'History of Liberty Brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Tap Brewery', '35 Beach Street', 'Orlando', 'FL', '49384', '444-444-4444', 'Tapbrewery@email.com', 'History of Tap Brewery', true);

INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Devil''s IPA', 'An IPA inspired by the Devil', '7.7', 'IPA', 'IPA.jpg');
INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Canadian Lager', 'Tastes like maple syrup!', '5.1', 'Lager', 'lager.jpg');
INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Special Wit', 'A special Wit', '4.2', 'Wit', 'belgianwitbiersmall.jpg');
INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Hefeweizen', 'Delicious', '4.1', 'Hefeweizen', 'Hefeweizen_Glass.jpg');

INSERT INTO beer_inventory (brewery_id, beer_id) VALUES (1, 1);
INSERT INTO beer_inventory (brewery_id, beer_id) VALUES (2, 2);
INSERT INTO beer_inventory (brewery_id, beer_id) VALUES (3, 3);
INSERT INTO beer_inventory (brewery_id, beer_id) VALUES (4, 4);

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

-- Ignore this section
INSERT INTO user_reviews (user_id, review_id) VALUES (1, 1);
INSERT INTO user_reviews (user_id, review_id) VALUES (1, 2);
INSERT INTO user_reviews (user_id, review_id) VALUES (1, 3);
INSERT INTO user_reviews (user_id, review_id) VALUES (1, 7);
INSERT INTO user_reviews (user_id, review_id) VALUES (1, 8);
INSERT INTO user_reviews (user_id, review_id) VALUES (1, 9);
INSERT INTO user_reviews (user_id, review_id) VALUES (2, 4);
INSERT INTO user_reviews (user_id, review_id) VALUES (2, 5);
INSERT INTO user_reviews (user_id, review_id) VALUES (2, 6);
INSERT INTO user_reviews (user_id, review_id) VALUES (2, 10);
INSERT INTO user_reviews (user_id, review_id) VALUES (2, 11);
INSERT INTO user_reviews (user_id, review_id) VALUES (2, 12);