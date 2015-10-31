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

            Assert.AreEqual("rpg", Categoria.idParaNome[1]);
            Assert.AreEqual("aventura", Categoria.idParaNome[2]);
            Assert.AreEqual("corrida", Categoria.idParaNome[3]);
            Assert.AreEqual("luta", Categoria.idParaNome[4]);
            Assert.AreEqual("esporte", Categoria.idParaNome[5]);

            Assert.AreEqual(1, Categoria.NomeParaId["rpg"]);
            Assert.AreEqual(2, Categoria.NomeParaId["aventura"]);
            Assert.AreEqual(3, Categoria.NomeParaId["corrida"]);
            Assert.AreEqual(4, Categoria.NomeParaId["luta"]);
            Assert.AreEqual(5, Categoria.NomeParaId["esporte"]);
        }
    }
}
