using LocadoraDeJogos.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LocadoraDeJogos.IO
{
    class Program
    {
        static void Main(string[] args)
        {
            Categoria.InicializarRecarregarCategoria();
            List<JogoModel> esperado = new List<JogoModel>();
            esperado.Add(new JogoModel(2, "Top Gear", 20.0, 3));
            esperado.Add(new JogoModel(14, "Zelda: A link to the past", 110.0, 2));
            esperado.Add(new JogoModel(20, "Mickey to Donald: Magical Adventure 3", 32.9, 2));
            var lista = ListaDeJogos.BuscarPorNome("to");

            int teste = Categoria.ConverterEntreValores([1,2]);


            Console.WriteLine(ListaDeJogos.Listar());
            Console.ReadKey();
        }
    }
}
