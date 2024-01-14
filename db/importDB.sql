

INSERT INTO locations (street, `number`, `city`,`country`, imageUrl)
VALUES ('Kavala Street', 11, 'Kavala','Greece', 'https://exploringworldsoldandnew.com/wp-content/uploads/2020/11/COVER-4.jpg'),
       ('Zeus Street', 10, 'Thessaloniki','Greece', 'https://static.independent.co.uk/2023/01/16/16/iStock-1272509097.jpg?width=1200&height=1200&fit=crop'),
       ('Kalimera Street', 13, 'Athens', 'Greece', 'https://cdn.britannica.com/66/102266-050-FBDEFCA1/acropolis-city-state-Greece-Athens.jpg'),
       ('Zizkov Street', 27, 'Prague', 'Czech Republic', 'https://blog.goway.com/globetrotting/wp-content/uploads/2018/08/Vltava-River-and-old-city-centre-Prague-Czech-Republic-_1032665644.jpg'),
       ('Vestebrogade Street', 12, 'Copenhagen', 'Denmark', 'https://ik.imgkit.net/3vlqs5axxjf/external/http://images.ntmllc.com/v4/destination/Denmark/Copenhagen/112079_SCN_Copenhagen_iStock901375804_Z947FA.jpg?tr=w-1200%2Cfo-auto'),
       ('Ringatta', 15, 'Oslo', 'Norway', 'https://www.modeshift.com/wp-content/uploads/2023/01/oslo-ranked-most-sustainble-city-in-the-world.jpg'),
       ('Oldham Road', 1, 'Manchester', 'England', 'https://assets.nationbuilder.com/icf/pages/286/attachments/original/1461185058/Edited-9-Manchester-SIM-786571-1680x1050.jpg?1461185058'),
       ('Anfield Road', 71, 'Liverpool', 'England', 'https://historyuk.s3.eu-west-2.amazonaws.com/s3fs-public/2023-05/shutterstock_2079532492-min.jpg'),
       ('Old Compton Street', 17, 'London', 'England', 'https://assets.editorial.aetnd.com/uploads/2019/03/topic-london-gettyimages-760251843-feature.jpg'),
       ('Wasagasse', 10,'Vienna', 'Austria', 'https://lp-cms-production.imgix.net/2019-06/shutterstock_249139849.jpg?auto=format&fit=crop&ar=1:1&q=75&w=1200'),
       ('Ruski Blvd', 97, 'Plovdiv', 'Bulgaria', 'https://plovdivcitycard.com/wp-content/uploads/2019/09/Your-Perfect-European-City-Break-Plovdiv-Bulgaria.png'),
       ('Albacete' , 5, 'Valencia', 'Spain', 'https://www.sixt.co.uk/magazine/wp-content/uploads//sites/11/2023/01/valencia-main-1024x642.jpg'),
       ('Diagonal Avenue', 16, 'Barcelona', 'Spain', 'https://wp.globaluniversitysystems.com/bsbi/wp-content/uploads/sites/2/2023/06/web-banner-barcelona.jpg?w=1854&h=1043&crop=1'),
       ('Somerset Street', 11, 'Ottawa', 'Canada', 'https://a.cdn-hotels.com/gdcs/production163/d857/cc29dd0e-f745-4507-80e1-6ae5a3532338.jpg'),
       ('Rivoli Street', 21, 'Paris', 'France', 'https://s27363.pcdn.co/wp-content/uploads/2023/11/Pantheon-Paris.jpg.optimal.jpg'),
       ('Franz Street', 54, 'Berlin', 'Germany', 'https://study-eu.s3.eu-west-1.amazonaws.com/uploads/image/path/171/wide_fullhd_14798621115_bcba1d1e7b_o.jpg'),
       ('Vitosha Blvd', 43, 'Sofia', 'Bulgaria', 'https://tourscanner.com/blog/wp-content/uploads/2022/07/things-to-do-in-Sofia.jpg');


########################################################################################################################################################
INSERT INTO holidays (`location`,`title`,`startDate`,`duration`,`price`, freeSlots)
VALUES (3, 'Web Development Workshop', '2024-02-15', 3, 199, 15),
       (1, 'Data Science Seminar', '2024-03-10', 2, 149, 20),
       (4, 'Graphic Design Bootcamp', '2024-04-05', 5, 299, 8),
       (2, 'Language Learning Expo', '2024-05-20', 1, 49, 30),
       (5, 'Marketing Masterclass', '2024-06-12', 4, 249, 10),
       (7, 'Entrepreneurship Summit', '2024-07-08', 2, 179, 18),
       (9, 'Photography Workshop', '2024-08-25', 3, 199, 12),
       (8, 'AI and Robotics Conference', '2024-09-18', 2, 249, 25),
       (6, 'Fitness Expo', '2024-10-30', 1, 29, 40),
       (11, 'Culinary Arts Festival', '2024-11-15', 3, 179, 15);


    ########################################################################################################################################################
INSERT INTO reservations (`contactName`,`phoneNumber`,`holiday`)
VALUES ('Veselina Georgieva', '0887108038', 1),
       ('Emily Davis', '+198765421', 2),
       ('Michael Johnson', '+345789012', 5),
       ('Sophia Brown', '+567890234', 4),
       ('Daniel White', '+234567901', 7),
       ('Olivia Miller', '+678901245', 8),
       ('Matthew Taylor', '+345678012', 6),
       ('Ava Martinez', '+789012346', 3),
       ('David Robinson', '+456789023', 9),
       ('Emma Harris', '+890123457', 10);