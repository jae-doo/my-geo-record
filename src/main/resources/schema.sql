drop table if exists spatial_string_field;
drop table if exists spatial_number_field;
drop table if exists spatial_record;
drop table if exists record_type;
drop table if exists data_group_field;
drop table if exists data_type;
drop table if exists data_group;
drop table if exists map;
drop table if exists users;
-- 사용자 테이블
create table users (
                       id long primary key auto_increment,
                       email varchar(255) not null unique,
                       password varchar(255) not null
);

-- 지도 테이블
create table map (
                     id long primary key auto_increment,
                     name varchar(255) not null,
                     owner long not null references users(id)
                         on update cascade on delete cascade
);

-- 데이터 그룹 테이블
create table data_group (
                            id long primary key auto_increment,
                            name varchar(255) not null,
                            map_id long not null references map(id)
                                on update cascade on delete cascade
);

-- 데이터 타입 테이블
create table data_type (
                           id long primary key auto_increment,
                           type varchar(255) not null
);

-- 데이터 그룹 필드 테이블
create table data_group_field (
                                  id long primary key auto_increment,
                                  name varchar(255) not null,
                                  seq int not null,
                                  data_group_id long not null references data_group(id)
                                      on update cascade on delete cascade,
                                  data_type_id long not null references data_type(id)
);

-- 레코드 타입 테이블
create table record_type (
                             id long primary key auto_increment,
                             name varchar(255) not null
);

-- 공간 데이터 레코드 테이블
create table spatial_record (
                                id long primary key auto_increment,
                                latitude double not null,
                                longitude double not null,
                                data_group_id long not null references data_group(id)
                                    on update cascade on delete cascade,
                                record_type_id long not null references record_type(id)
);

-- 공간 데이터 문자열 필드 테이블
create table spatial_string_field (
                               id long primary key auto_increment,
                               data varchar(255) not null,
                               spatial_record_id long not null references spatial_record(id)
                                   on update cascade on delete cascade,
                               data_group_field_id long not null references data_group_field(id)
                                   on update cascade on delete cascade,
                               data_type_id long not null references data_type(id)
);

-- 공간 데이터 정수 필드 테이블
create table spatial_number_field (
                                      id long primary key auto_increment,
                                      data long not null,
                                      spatial_record_id long not null references spatial_record(id),
                                      data_group_field_id long not null references data_group_field(id),
                                      data_type_id long not null references data_type(id)
);