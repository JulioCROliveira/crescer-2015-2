using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel;

namespace ProjetoMVC.Models
{
    public class JogoModel
    {
        public int Id { get; private set; }
        public string Nome { get; set; }
        public double Preco { get; set; }
        public int CategoriaDoJogo { get; set; }

        public JogoModel(int id, string nome, double preco, int categoria)
        {
            Id = id;
            Nome = nome;
            Preco = preco;
            CategoriaDoJogo = categoria;
        }
    }
}