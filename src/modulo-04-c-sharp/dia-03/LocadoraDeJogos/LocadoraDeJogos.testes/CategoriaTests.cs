using System;
using System.Text;
using System.Collections.Generic;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LocadoraDeJogos.Dominio;

namespace LocadoraDeJogos.testes
{
    /// <summary>
    /// Summary description for UnitTest1
    /// </summary>
    [TestClass]
    public class CategoriaTests
    {       
        [TestMethod]
        public void InicializandoCategoria()
        {
            Categoria categoria = new Categoria();

            Assert.AreEqual("rpg", categoria.idParaNome[1]);
            Assert.AreEqual("aventura", categoria.idParaNome[2]);
            Assert.AreEqual("corrida", categoria.idParaNome[3]);
            Assert.AreEqual("luta", categoria.idParaNome[4]);
            Assert.AreEqual("esporte", categoria.idParaNome[5]);

            Assert.AreEqual(1, categoria.NomeParaId["rpg"]);
            Assert.AreEqual(2, categoria.NomeParaId["aventura"]);
            Assert.AreEqual(3, categoria.NomeParaId["corrida"]);
            Assert.AreEqual(4, categoria.NomeParaId["luta"]);
            Assert.AreEqual(5, categoria.NomeParaId["esporte"]);
        }

        [TestMethod]
        public void ConverterDe1Para_rpg()
        {
            Categoria categoria = new Categoria();
            string esperado = "rpg", categoriaTeste = categoria.ConverterEntreValores(1);

            Assert.AreEqual(esperado, categoriaTeste);
        }

        [TestMethod]
        public void ConverterDe_aventuraPara2()
        {
            Categoria categoria = new Categoria();
            int esperado = 2, categoriaTeste = categoria.ConverterEntreValores("aventura");

            Assert.AreEqual(esperado, categoriaTeste);
        }

        [TestMethod]
        public void ListarCategorias()
        {
            Categoria categoria = new Categoria();
            string esperado = "1 - rpg, 2 - aventura, 3 - corrida, 4 - luta, \r\n5 - esporte, 6 - mundo aberto, ";

            Assert.AreEqual(esperado, categoria.ListarCategorias());
        }

        //[TestMethod]
        //public void ConverterDeIntParaString_falha()
        //{
        //    Categoria categoria = new Categoria();
        //    string esperado = "-1", categoriaTeste = categoria.ConverterEntreValores(99);

        //    Assert.AreEqual(esperado, categoriaTeste);
        //}

        //[TestMethod]
        //public void ConverterDeStringParaInt_falha()
        //{
        //    Categoria categoria = new Categoria();
        //    int esperado = -1, categoriaTeste = categoria.ConverterEntreValores("hwrshnjcxtj");

        //    Assert.AreEqual(esperado, categoriaTeste);
        //}
    }
}
