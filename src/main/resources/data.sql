delete from SPATIAL_NUMBER_FIELD;
delete from SPATIAL_STRING_FIELD;
delete from SPATIAL_RECORD;
delete from DATA_GROUP_FIELD;
delete from DATA_TYPE;
delete from RECORD_TYPE;
delete from DATA_GROUP;
delete from MAP;
delete from USERS;

show tables;

insert into users(email, password)
values
    ('user1', '1111'), ('user2', '2222'), ('user3', '3333'),
    ('user4', '4444'), ('user5', '5555'), ('user6', '6666');

insert into map(name, owner)
values
    ('map1', 1), ('map2', 1), ('map3', 1), ('map4', 1),
    ('map5', 2), ('map6', 2), ('map7', 2),
    ('map8', 3), ('map9', 3),
    ('map10', 4), ('map11', 4),
    ('map12', 5), ('map13', 5), ('map14', 5),
    ('map15', 6), ('map16', 6);

insert into RECORD_TYPE (NAME)
values
    ('dot');

insert into DATA_TYPE (TYPE)
values ('number'), ('string'), ('url');

insert into DATA_GROUP (name, map_id)
values
    ('group1', 1), ('group2', 1);

insert into DATA_GROUP_FIELD (NAME, SEQ, DATA_GROUP_ID, DATA_TYPE_ID)
values
    ( 'name', 1, 1, 2 ), ( 'desc', 2, 1, 2 ), ( 'value', 3, 1, 1 );

insert into SPATIAL_RECORD (LATITUDE, LONGITUDE, DATA_GROUP_ID, RECORD_TYPE_ID)
values ( 35.5, 35.5, 1, 1 ), ( 35.5, 35.5, 1, 1 ), ( 35.555, 35.555, 1, 1 );

insert into SPATIAL_STRING_FIELD (DATA, SPATIAL_RECORD_ID, DATA_GROUP_FIELD_ID, DATA_TYPE_ID)
values
    ( 'name1', '1', 1,  2), ('desc1', '1', 2, 2),
    ( 'name2', '2', 1,  2), ('desc2', '2', 2, 2);

insert into SPATIAL_NUMBER_FIELD (DATA, SPATIAL_RECORD_ID, DATA_GROUP_FIELD_ID, DATA_TYPE_ID)
values
    ( 111, '1', 3,  1), (222, '2', 3, 2);