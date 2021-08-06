INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, brewer_id, active) VALUES ('Brewery On Main', '923 Main Street', 'Philadelphia', 'PA', '19032', '111-111-1111', 'Breweryonmain@email.com', 'History of Brewery On Main', 3, true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, brewer_id, active) VALUES ('Homer''s Brewery', '293 Broad Street', 'Anaheim', 'CA', '78392', '222-222-2222', 'Homersbrewer@email.com', 'History of Homer''s Brewery', 3, true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, brewer_id, active) VALUES ('Liberty Brewery', '14 Hay Road', 'Houston', 'TX', '38394', '333-333-3333', 'Libertybrewery@email.com', 'History of Liberty Brewery', 3, true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, brewer_id, active) VALUES ('Tap Brewery', '35 Beach Street', 'Orlando', 'FL', '49384', '444-444-4444', 'Tapbrewery@email.com', 'History of Tap Brewery', 3, true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Freedom Brewery', '2244 Independence Blvd', 'Kansas City','MO', '64030', '555-555-5555', 'Freedombrewery@email.com', 'History of Freedom Brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Silver Mine Brewery', '10 Mine Lane', 'Red Lodge', 'MT', '59068', '666-666-6666', 'SilverBrewery@email.com', 'History of Silver Brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Poor Richard Brewery', '4554 Sococo Street', 'Valley Forge', 'PA', '19460', '777-777-7777', 'BadRichbrewery@email.com', 'History Of Bad Rich Brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Scarlet Brewery', '183 Labrador Lane', 'Hershey', 'PA', '17017', '888-888-8888', 'Scarletbrewery@email.com', 'History of Scarlet Brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Good Dog Brewery', '22 Park Lane', 'Kemmerer', 'WY', '83101', '999-999-9999', 'Gooddog@email.com', 'History of Good Dog Brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Linden Lane Brewery', '101 Linden Lane', 'Linden', 'MI', '48451', '123-555-5555', 'LindenBrewery@email.com', 'History of LL Brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Best Beach Brewery', '99 Bay Side Avenue', 'Oceanside', ' CA', '92003','212-555-9999', 'Bestbeachbrew@email.com', 'History of Best Beach Brewery', true);
INSERT INTO breweries (brewery_name, brewery_address, brewery_city, brewery_state, brewery_zip, brewery_phone, brewery_email, brewery_history, active) VALUES ('Cat Scratch Brewery', '66 Swish Tails Court', 'Cat Spring', 'TX','78933', '323-555-3333', 'Catspringbrewery@email.com', 'History of Cat Scratch Brewery', true);

INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Devil''s IPA', 'An IPA inspired by the Devil', '7.7', 'IPA', 'IPA.jpg');
INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Canadian Lager', 'Tastes like maple syrup!', '5.1', 'Lager', 'lager.jpg');
INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Special Wit', 'A special Wit', '4.2', 'Wit', 'belgianwitbiersmall.jpg');
INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Hefeweizen', 'Delicious', '4.1', 'Hefeweizen', 'Hefeweizen_Glass.jpg');
INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Witches Brew', 'Magical', '3.3', 'IPA', 'IPA.jpg');
INSERT INTO beer (beer_name, beer_description, beer_abv, beer_type, beer_image) VALUES ('Ocean Delight', 'Refreshing', '7.0','Wit', 'belgianwitbiersmall.jpg' );


INSERT INTO beer_inventory (brewery_id, beer_id) VALUES (1, 1);
INSERT INTO beer_inventory (brewery_id, beer_id) VALUES (2, 2);
INSERT INTO beer_inventory (brewery_id, beer_id) VALUES (3, 3);
INSERT INTO beer_inventory (brewery_id, beer_id) VALUES (4, 4);

INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (1, 5, 'Greating tasting beer');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (1, 2, 'Okay');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (1, 4);
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (2, 1, 'Too sweet for me');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (2, 3, 'Average tasting lager');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (2, 2);
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (3, 4, 'This Wit has earned the special title!');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (3, 2, 'Not the worst Wit I''ve had, but far from the best.');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (3, 5);
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (4, 4, 'Absolutely delicious');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (4, 2, 'Not bad');
INSERT INTO beer_reviews (beer_id, beer_rating, beer_review) VALUES (4, 1);

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