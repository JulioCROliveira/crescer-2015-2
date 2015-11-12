using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Locacao
    {
        public int Id { get; private set; }
        public Jogo Jogo { get; set; }
        public int IdJogo { get; private set; }
        public Cliente Cliente { get; set; }
        public int IdCliente { get; private set; }
        public Situacao Situacao { get; set; }
        public DateTime DataEntrega { get; private set; }

        private Locacao()
        {

        }

        public Locacao(int idJogo, int idCliente, DateTime dataEntrega)
        {
            IdJogo = idJogo;
            IdCliente = idCliente;
            DataEntrega = dataEntrega;
        }
    }
}
