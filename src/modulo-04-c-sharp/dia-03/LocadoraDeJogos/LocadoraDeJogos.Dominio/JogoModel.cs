using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel;

namespace LocadoraDeJogos.Dominio
{
    public class JogoModel
    {
        public int Id { get; private set; }
        public string Nome { get; set; }
        public double Preco { get; set; }
        public int Categoria { get; set; }
        
        public JogoModel(int id, string nome, double preco, int categoria)
        {
            Id = id;
            Nome = nome;
            Preco = preco;
            Categoria = categoria;
        }

        public override string ToString()
        {
            return String.Format("{0} {1} {2} {3}", Id, Nome, Preco, Categoria);
        }
    }
}
