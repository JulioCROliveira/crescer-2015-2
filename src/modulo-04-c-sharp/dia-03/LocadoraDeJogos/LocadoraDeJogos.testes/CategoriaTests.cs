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
            Categoria.InicializarRecarregarCategoria();

            Assert.AreEqual("RPG", Categoria.idParaNome["1"]);
            Assert.AreEqual("Aventura", Categoria.idParaNome["2"]);
            Assert.AreEqual("Corrida", Categoria.idParaNome["3"]);
            Assert.AreEqual("Luta", Categoria.idParaNome["4"]);
            Assert.AreEqual("Esporte", Categoria.idParaNome["5"]);

            Assert.AreEqual("1", Categoria.NomeParaId["RPG"]);
            Assert.AreEqual("2", Categoria.NomeParaId["Aventura"]);
            Assert.AreEqual("3", Categoria.NomeParaId["Corrida"]);
            Assert.AreEqual("4", Categoria.NomeParaId["Luta"]);
            Assert.AreEqual("5", Categoria.NomeParaId["Esporte"]);
        }
    }
}
