using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleAPP.Testes
{
    [TestClass]
    public class AgendaTestes
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();

            agenda.AdicionarContato(new Contato("Júlio César",42535));

            Assert.AreEqual("Júlio César 42535\r\n", agenda.ListarContatos());
        }

        [TestMethod]
        public void AgendaTemDoisContatoERemoveUmPorNome()
        {
            var agenda = new Agenda();

            agenda.AdicionarContato(new Contato("Júlio César", 42535));
            agenda.AdicionarContato(new Contato( "Júlio", 425));
            agenda.RemoverContato("Júlio César");

            Assert.AreEqual("Júlio 425\r\n", agenda.ListarContatos());
        }

        [TestMethod]
        public void AgendaTemDoisContatoERemoveUmPorNumero()
        {
            var agenda = new Agenda();

            agenda.AdicionarContato(new Contato("Júlio César", 42535));
            agenda.AdicionarContato(new Contato("Júlio", 425));
            agenda.RemoverContato(425);

            Assert.AreEqual("Júlio César 42535\r\n", agenda.ListarContatos());
        }

        [TestMethod]
        public void AgendaTemTresContatoEListaOsOrdenados()
        {
            var agenda = new Agenda();

            agenda.AdicionarContato(new Contato("Júlio César", 42535));
            agenda.AdicionarContato(new Contato("Ana", 425));
            agenda.AdicionarContato(new Contato("Eduardo",  300));

            Assert.AreEqual("Ana 425\r\nEduardo 300\r\nJúlio César 42535\r\n", agenda.ListarContatosOrdenadoPorNome());
        }

        [TestMethod]
        public void AgendaTemTresContatoEListaOsJaOrdenados()
        {
            var agenda = new Agenda();

            agenda.AdicionarContato(new Contato("Ana", 425));
            agenda.AdicionarContato(new Contato("Eduardo", 300));
            agenda.AdicionarContato(new Contato("Júlio César", 42535));            

            Assert.AreEqual("Ana 425\r\nEduardo 300\r\nJúlio César 42535\r\n", agenda.ListarContatosOrdenadoPorNome());
        }

        [TestMethod]
        public void AgendaTemTresContatoEListaInversoOsOrdenados()
        {
            var agenda = new Agenda();

            agenda.AdicionarContato(new Contato("Júlio César", 42535));
            agenda.AdicionarContato(new Contato("Eduardo", 300));
            agenda.AdicionarContato(new Contato("Ana", 425));            

            Assert.AreEqual("Ana 425\r\nEduardo 300\r\nJúlio César 42535\r\n", agenda.ListarContatosOrdenadoPorNome());
        }

        [TestMethod]
        public void AgendaTemTresContatoEListaOs()
        {
            var agenda = new Agenda();

            agenda.AdicionarContato(new Contato("Júlio César", 42535));
            agenda.AdicionarContato(new Contato("Ana", 425));
            agenda.AdicionarContato(new Contato("Eduardo", 300));

            Assert.AreEqual("Júlio César 42535\r\nAna 425\r\nEduardo 300\r\n", agenda.ListarContatos());
        }
    }
}
