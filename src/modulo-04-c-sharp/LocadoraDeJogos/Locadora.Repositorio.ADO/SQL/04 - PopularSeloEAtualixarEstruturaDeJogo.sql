insert into Selo (IdSelo, Nome) values (1 , 'OURO');
insert into Selo (IdSelo, Nome) values (2 , 'PRATA');
insert into Selo (IdSelo, Nome) values (3 , 'BRONZE');

alter table Jogo
add	
	Descricao varchar(300) not null default('Sem descrição'),
	IdSelo int not null default(1),
	Imagem varchar(128),
	Video varchar(128)
constraint FK_Jogo_Selo foreign key (IdSelo) references Selo(IdSelo);
