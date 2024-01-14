create table travelagency.locations
(
    id       bigint auto_increment
        primary key,
    street   varchar(50)  null,
    number   varchar(50)  null,
    city     varchar(50)  null,
    country  varchar(50)  null,
    imageUrl varchar(200) null
);

create table travelagency.holidays
(
    id        bigint auto_increment
        primary key,
    location  bigint      null,
    title     varchar(50) null,
    startDate date        null,
    duration  int         null,
    price     varchar(20) null,
    freeSlots int         null,
    constraint holidays_locations_id_fk
        foreign key (location) references travelagency.locations (id)
            on update cascade on delete cascade
);

create table travelagency.reservations
(
    id          bigint auto_increment
        primary key,
    contactName varchar(60) null,
    phoneNumber varchar(10) null,
    holiday     bigint      null,
    constraint reservations_holidays_id_fk
        foreign key (holiday) references travelagency.holidays (id)
            on update cascade on delete cascade
);

