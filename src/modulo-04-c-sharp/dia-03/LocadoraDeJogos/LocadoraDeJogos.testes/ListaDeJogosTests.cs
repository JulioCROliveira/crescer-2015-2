using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LocadoraDeJogos.Dominio;
using System.Collections.Generic;

namespace LocadoraDeJogos.testes
{
    [TestClass]
    public class ListaDeJogosTests
    {
        ListaDeJogos jogos = new ListaDeJogos();
        Categoria categoria = new Categoria();

        [TestMethod]
        public void ListarJogos()
        {
            jogos.Listar();
        }

        [TestMethod]
        public void BuscarJogoTrigger()
        {           
            List<JogoModel> busca = jogos.BuscarPorNome("Trigger");
            List<JogoModel> esperado = new List<JogoModel>();
            esperado.Add(new JogoModel(1, "Chrono Trigger", 60.0, 1));

            Assert.AreEqual(esperado[0].ToString(), busca[0].ToString());
        }

        [TestMethod]
        public void BuscarPortoERetorna3JogosIncluindoToMaiusculo()
        {            
            List<JogoModel> busca = jogos.BuscarPorNome("to");
            List<JogoModel> esperado = new List<JogoModel>();
            esperado.Add(new JogoModel(2, "Top Gear", 20.0, 3));
            esperado.Add(new JogoModel(14, "Zelda: A link to the past", 110.0, 2));
            esperado.Add(new JogoModel(20, "Mickey to Donald: Magical 3", 32.9, 2));

            Assert.AreEqual(esperado[0].ToString(), busca[0].ToString());
            Assert.AreEqual(esperado[1].ToString(), busca[1].ToString());
            Assert.AreEqual(esperado[2].ToString(), busca[2].ToString());
        }

        /*
        [TestMethod]
        public void cadastrandoMetalGear()
        {            
            int idEsperado = ListaDeJogos.getProximoId();
            string nome = "Metal Gear Solid V";
           double preco = 199.99;
            int categoria = categoria.ConverterEntreValores("Mundo Aberto");
            int idDoJogoAdicionado = jogos.Adicionar(nome, preco, categoria);

            Assert.AreEqual(idEsperado, idDoJogoAdicionado);
        }
         * */

        [TestMethod]
        public void ModificarJogo()
        {            
            int id = 3;
            string nome = "Megaman XI";
            double preco = 60;
            int categoriaJogo = categoria.ConverterEntreValores("rpg");
            jogos.Modificar(id, nome, preco, categoriaJogo);
        }
    }
}
