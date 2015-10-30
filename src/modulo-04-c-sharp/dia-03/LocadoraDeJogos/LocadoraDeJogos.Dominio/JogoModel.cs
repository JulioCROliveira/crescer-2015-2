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
        public Categoria categoria { get; set; }
        
        public JogoModel(int id, string nome, double preco, Categoria categoria)
        {
            Nome = nome;
            Preco = preco;
            this.categoria = categoria;
        }
    }
}
