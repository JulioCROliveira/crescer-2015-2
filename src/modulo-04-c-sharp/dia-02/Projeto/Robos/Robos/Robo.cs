using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Robos
{
    public abstract class Robo
    {
        public string Nome { get; private set; }

        public Robo(string nome)
        {
            nome = nome;
        }

        public virtual void Atacar()
        {
            Console.WriteLine("Atacar");
        }
    }    
}
