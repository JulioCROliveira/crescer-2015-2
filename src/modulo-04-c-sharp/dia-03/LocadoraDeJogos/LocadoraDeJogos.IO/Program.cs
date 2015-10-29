using LocadoraDeJogos.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraDeJogos.IO
{
    class Program
    {
        static void Main(string[] args)
        {
            string lista = ListaDeJogos.listarJogos();

            Console.WriteLine(lista);
            Console.ReadKey();
        }
    }
}
