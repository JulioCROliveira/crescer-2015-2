using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Serviços
{
    public class ServicoLocacao
    {
        public const int MAX_JOGOS_POR_PESSOA = 3;
        public const decimal MULTA_DIARIA = 5m;

        private IRepositorio<Jogo> jogoRepositorio;
        private IRepositorio<Cliente> clienteRepositorio;

        public ServicoLocacao(IRepositorio<Jogo> jogoRepositorio, IRepositorio<Cliente> clienteRepositorio)
        {
            this.jogoRepositorio = jogoRepositorio;
            this.clienteRepositorio = clienteRepositorio;
        }
    }
}
