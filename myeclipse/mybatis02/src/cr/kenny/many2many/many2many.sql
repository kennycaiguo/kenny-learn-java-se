create table courses(
    cid int(5) primary key,
    cname varchar(20)
);

create table students(
    sid int(5) primary key,
    sname varchar(10)    
);

create table middles(
   msid int(5),
   mcid int(5),
   primary key(msid,mcid)
   
);
insert into courses(cid,cname) values(1,"java");
insert into courses(cid,cname) values(2,"c++");
insert into courses(cid,cname) values(3,".net");
insert into courses(cid,cname) values(4,"python");

insert into students(sid,sname) values(1,"jackline");
insert into students(sid,sname) values(2,"mary");
insert into students(sid,sname) values(3,"tary");
insert into students(sid,sname) values(4,"gary");
insert into students(sid,sname) values(5,"dary");
insert into students(sid,sname) values(6,"crary");

insert into middles(msid,mcid) values(1,1);
insert into middles(msid,mcid) values(1,2);
insert into middles(msid,mcid) values(2,1);
insert into middles(msid,mcid) values(2,2);
insert into middles(msid,mcid) values(3,3);
insert into middles(msid,mcid) values(3,4);
insert into middles(msid,mcid) values(4,1);
insert into middles(msid,mcid) values(4,2);

