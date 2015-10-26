using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleAPP
{
    class Program
    {
        private static Agenda agenda = new Agenda();

        static void Main(string[] args)
        {
            int opcao;
            do
            {
                Console.WriteLine("Digite 1 para cadastrar novo contato\r\nDigite 2 para visualizar contatos\r\nDigite 0 para sair");
                opcao = int.Parse(Console.ReadLine());
                switch (opcao)
                {
                    case 1:
                        CadastrarContatoNovo();
                        Console.WriteLine("Contato adicionado.");
                        break;
                    case 2:
                        Console.WriteLine(listarContatos());
                        break;
                    case 0:
                        Console.WriteLine("Saindo...");
                        break;
                    default:
                        Console.WriteLine("opção invalida!");                        
                        break;
                }
                Console.ReadKey();
                Console.Clear();
            }
            while (opcao != 0);
        }

        public static void CadastrarContatoNovo()
        {
            string nome;
            int numero;
            Console.WriteLine("Escreva o nome do contato :");
            nome = Console.ReadLine();
            Console.WriteLine("Escreva o numero do contato :");
            numero = int.Parse(Console.ReadLine());
            agenda.AdicionarContato(new Contato(nome, numero));
        }

        public static string listarContatos()
        {
            return agenda.ListarContatosOrdenadoPorNome();
        }
    }
}
