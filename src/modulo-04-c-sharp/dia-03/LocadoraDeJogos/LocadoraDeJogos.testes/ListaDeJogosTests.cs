using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LocadoraDeJogos.Dominio;

namespace LocadoraDeJogos.testes
{
    [TestClass]
    public class ListaDeJogosTests
    {
        [TestMethod]
        public void listarJogos()
        {
            ListaDeJogos.listarJogos();
        }
    }
}
