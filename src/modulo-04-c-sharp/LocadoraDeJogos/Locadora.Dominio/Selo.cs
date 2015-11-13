using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Selo
    {
        public int Id { get; private set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public int DiasLocacao { get; set; }

        public ICollection<Jogo> Jogos { get; set; }

        public Selo()
        {

        }
    }
}