create table cards(
    cid int(5) primary key,
    cnum varchar(10)
);

create table students(
    sid int(5) primary key,
    sname varchar(10),
    scid int(5) ,
    constraint scid_fk foreign key(scid) references cards(cid)
);

insert into cards(cid,cnum) values(1,"111");
insert into students(sid,sname,scid) values(1,"jackline",1);
