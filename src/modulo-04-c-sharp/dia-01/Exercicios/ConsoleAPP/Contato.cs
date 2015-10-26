using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleAPP
{
    public class Contato
    {
        public string nome;
        public int numero { get; set; }

        public Contato(string nome, int numero)
        {
            this.nome = nome;
            this.numero = numero;
        }
    }
}
