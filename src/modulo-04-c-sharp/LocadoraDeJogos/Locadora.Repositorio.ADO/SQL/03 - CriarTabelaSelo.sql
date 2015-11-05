create table Selo
(IdSelo int,
Nome varchar(20) not null,
constraint PK_Selo primary key (IdSelo),
constraint FK_Selo_Nome unique (Nome));