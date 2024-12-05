INSERT INTO accommodations (name, image_url, latitude, longitude, price, rating, reviews_count)
VALUES
    ('Accommodation 1', '/img/sph1.jpeg', 37.5665, 126.9780, 100.00, 4.5, 100),
    ('Accommodation 2', '/img/sph2.jpeg', 37.5770, 126.9769, 80.00, 4.7, 120),
    ('Accommodation 3', '/img/sph3.jpg', 37.5512, 126.9882, 120.00, 4.3, 80),
    ('Accommodation 4', '/img/sph4.jpeg', 37.5800, 126.9900, 150.00, 4.9, 200);

select * from accommodations;

drop table accommodations;

use airbnb;

select * from users;