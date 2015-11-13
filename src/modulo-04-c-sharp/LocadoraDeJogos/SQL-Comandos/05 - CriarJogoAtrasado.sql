insert into Locacao (IdJogo, IdCliente, IdSituacao, DataEntrega) Values (13, 3, 1, convert(datetime, '07/11/2015', 103));

update Jogo set IdLocacao = 1 where id = 13;

update Cliente set JogosLocados = 1 where id = 3;