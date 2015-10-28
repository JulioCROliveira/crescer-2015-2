using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System.Collections.Generic;
using System.Linq;

namespace DBFuncionarios.Testes
{
    [TestClass]
    public class TesteFuncionarios
    {
        [TestMethod]
        public void OrdenandoListaPorNome()
        {
            Funcionarios lista = new Funcionarios();
            var teste = lista.OrdenadosPorCargo();
            bool testeTudoCerto = true;

            for (int i = 0; i < 2; i++)
            {
                if (teste[i].Cargo.Titulo != "Analista")
                {
                    testeTudoCerto = false;
                }
            }
            for (int i = 2; i < 9; i++)
            {
                if (teste[i].Cargo.Titulo != "Desenvolvedor")
                {
                    testeTudoCerto = false;
                }
            }
            if (teste[10].Cargo.Titulo != "Gerente")
            {
                testeTudoCerto = false;
            }

            Assert.AreEqual(true, testeTudoCerto);
        }

        [TestMethod]
        public void OrdenandoBuscandoPorNome()
        {
            Funcionarios funcionarios = new Funcionarios();
            List<Funcionario> lista = funcionarios.BuscarPorNome("el");
            var query = (from id in lista select id.Id).ToArray();
            int[] esperado = {6,9,3};
            
            Assert.AreEqual(esperado[0], query[0]);
            Assert.AreEqual(esperado[1], query[1]);
            Assert.AreEqual(esperado[2], query[2]);
        }
        
        //[TestMethod]
        //public void BuscaRapida()
        //{
        //    Funcionarios funcionarios = new Funcionarios();
        //    dynamic funcionarioLista = funcionarios.BuscaRapida("Rafael Benetti");

        //    Assert.AreEqual("Rafael Benetti", funcionarioLista[0].Nome);
        //    Assert.AreEqual("Desenvolvedor", funcionarioLista[0].Cargo);
        //}


    }
}