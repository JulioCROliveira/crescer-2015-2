using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }

        public Categoria Categoria { get; set; }

        public Cliente Cliente { get; set; }

        public int? IdCliente { get; set; }

        public string Descricao { get; set; }

        public int IdSelo { get; set; }

        public Selo Selo { get; set; }

        public string Imagem { get; set; }

        public string Video { get; set; }

        public Jogo()
        {

        }

        public Jogo(int id, int? idCliente = 0)
        {
            Id = id;
            IdCliente = idCliente;
        }

        public void LocarPara(Cliente cliente)
        {
            IdCliente = cliente.Id;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Categoria: " + this.Categoria);
            builder.AppendLine("Descrição: " + this.Descricao);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if(obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Categoria == jogoComp.Categoria
                    && this.Cliente == jogoComp.Cliente
                    && this.Descricao == jogoComp.Descricao;
            }

            return false;
        }
    }
}
