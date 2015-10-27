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
            const int SAIR = 0, CADASTRAR_CONTATO = 1, VISUALIZAR_CONTATOS = 2;
            int opcao;
            do
            {
                Console.WriteLine("Digite 1 para cadastrar novo contato\r\nDigite 2 para visualizar contatos\r\nDigite 0 para sair");
                opcao = int.Parse(Console.ReadLine());
                switch (opcao)
                {
                    case CADASTRAR_CONTATO:
                        CadastrarContatoNovo();
                        Console.WriteLine("Contato adicionado.");
                        break;
                    case VISUALIZAR_CONTATOS:
                        Console.WriteLine(listarContatos());
                        break;
                    case SAIR:
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
