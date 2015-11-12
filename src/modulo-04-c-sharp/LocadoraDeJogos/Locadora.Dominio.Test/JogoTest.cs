using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class JogoTest
    {
        [TestMethod]
        public void JogoADeveSerIgualJogoB()
        {
            Jogo jogoA = new Jogo(id: 1);
            Jogo jogoB = new Jogo(id: 1);

            Assert.AreEqual(jogoA, jogoB);
        }
    }
}
