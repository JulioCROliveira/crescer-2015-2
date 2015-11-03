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
        public int CategoriaDoJogo { get; set; }
        
        public JogoModel(int id, string nome, double preco, int categoria)
        {
            Id = id;
            Nome = nome;
            Preco = preco;
            CategoriaDoJogo = categoria;
        }

        public override string ToString()
        {
            Categoria categoria = new Categoria();
            return String.Format("Id:{0}{4}Nome:{1}{4}Preço:{2:c}{4}Categoria:{3}{4}", Id, Nome, Preco, categoria.ConverterEntreValores(CategoriaDoJogo), "\r\n");
        }
    }
}
