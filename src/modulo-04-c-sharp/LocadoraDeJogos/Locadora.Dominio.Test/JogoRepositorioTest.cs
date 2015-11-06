using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio.Repositorio;
using System.Collections.Generic;
using System.Linq;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class JogoRepositorioTest
    {
        IJogoRepositorio banco = new Locadora.Repositorio.ADO.JogoRepositorio();
        IJogoRepositorio xml = new Locadora.Repositorio.XML.JogoRepositorio();
        Jogo megaMan = new Jogo(3)
            {
                Nome = "Megaman X",
                Preco = 40,
                Categoria = Categoria.AVENTURA,
                Descricao = "A série Mega Man X (Rockman X no Japão) foi a segunda franquia da série Mega Man. Lançada em 17 de dezembro de 1993 no Japão (e fevereiro de 1994 na América do Norte) no Super Nintendo, continuando suas diversas sequências em múltiplas plataformas.",
                Selo = Selo.PRATA,
                Imagem = "http://img11.deviantart.net/198f/i/2011/052/1/6/megaman_x_by_trunks24-d3a48pu.jpg",
                Video = "<iframe width=\"420\" height=\"315\" src=\"https://www.youtube.com/embed/WIP8S0iPCmU\" frameborder=\"0\" allowfullscreen></iframe>"
            };
        Jogo novoJogo = new Jogo()
        {
            Nome = "Fallout 4",
            Preco = (decimal)189.99,
            Categoria = Categoria.RPG,
            Descricao = "Fallout 4 é um jogo eletrônico do gênero RPG de ação ambientado em mundo aberto produzido pela Bethesda Game Studios, sendo o quinto titulo principal da série Fallout.",
            Selo = Selo.OURO,
            Imagem = "http://img11.deviantart.net/198f/i/2011/052/1/6/megaman_x_by_trunks24-d3a48pu.jpg",
            Video = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/GE2BkLqMef4\" frameborder=\"0\" allowfullscreen></iframe>"
        };

        /*[TestMethod]
        public void BuscarTodoJogosBanco()
        {
            IList<Jogo> jogosBanco = new List<Jogo>();
            jogosBanco = banco.BuscarTodos();
        }*/

        [TestMethod]
        public void InserirJogoNovo()
        {
            //Jogo deletar = banco.BuscarPorNome("Fallout 4").FirstOrDefault();
            Jogo deletar = banco.BuscarPorNome("super").FirstOrDefault();

            /*
            banco.Equals(deletar);
            banco.Criar(novoJogo);
            Jogo procurarAdicionado = banco.BuscarPorNome("Fallout 4").FirstOrDefault();
            Assert.AreEqual(procurarAdicionado, novoJogo);
             */
        }
    }
}
