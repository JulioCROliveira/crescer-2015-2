using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LocadoraDeJogos.Dominio;
using System.Collections.Generic;

namespace LocadoraDeJogos.testes
{
    [TestClass]
    public class ListaDeJogosTests
    {
        [TestMethod]
        public void ListarJogos()
        {
            ListaDeJogos.ListarJogos();
        }

        [TestMethod]
        public void BuscarJogoTrigger()
        {
            Categoria.InicializarRecarregarCategoria();
            List<JogoModel> busca = ListaDeJogos.BuscarJogo("Trigger");
            List<JogoModel> esperado = new List<JogoModel>();
            esperado.Add(new JogoModel(1, "Chrono Trigger", 60.0, 1));

            Assert.AreEqual(esperado.ToString(), busca.ToString());
        }

        [TestMethod]
        public void BuscarPortoERetorna3JogosIncluindoToMaiusculo()
        {
            Categoria.InicializarRecarregarCategoria();
            List<JogoModel> busca = ListaDeJogos.BuscarJogo("Trigger");
            List<JogoModel> esperado = new List<JogoModel>();
            esperado.Add(new JogoModel(2, "Top Gear", 20.0, 3));
            esperado.Add(new JogoModel(14, "Zelda: A link to the past", 110.0, 2));
            esperado.Add(new JogoModel(20, "Mickey to Donald: Magical Adventure 3", 32.9, 2));

            Assert.AreEqual(esperado.ToString(), busca.ToString());
        }
    }
}
