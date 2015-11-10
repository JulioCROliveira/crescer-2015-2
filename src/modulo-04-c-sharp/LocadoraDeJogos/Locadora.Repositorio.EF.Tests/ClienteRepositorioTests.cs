using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF.Tests
{
    [TestClass]
    public class ClienteRepositorioTests
    {
        IRepositorio bdClientes = new ClienteRepositorio();

        [TestMethod]
        public void AdicionarCliente()
        {
            Cliente cliente = new Cliente(99999)
                {
                    Nome = "Júlio"
                };
            bdClientes.Criar(cliente);
        }
    }
}
