using LocadoraDeJogos.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace LocadoraDeJogos.IO
{
    class Program
    {
        static void Main(string[] args)
        {
            Categoria.InicializarRecarregarCategoria();
            
            Console.WriteLine(ListaDeJogos.Listar());
            Console.ReadKey();
        }
    }
}
