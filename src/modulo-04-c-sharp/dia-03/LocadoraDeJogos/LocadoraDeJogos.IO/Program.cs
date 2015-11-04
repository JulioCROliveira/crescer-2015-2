using LocadoraDeJogos.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;

namespace LocadoraDeJogos.IO
{
    class Program
    {
        static Categoria categoriaRepositorio = new Categoria();
        static ListaDeJogos jogos = new ListaDeJogos();
        public const string LISTAR_TODOS_JOGOS = "1", BUSCAR_JOGO_POR_NOME = "2", ADICIONAR_JOGO  = "3", ALTERAR_JOGO = "4", EXPORTAR_RELATORIO = "5", SAIR = "0";
        public const string INVALIDO = "-1";
        public const int INVALIDA = -1, BUSCANDO = -1;

        static void Main(string[] args)
        {
            try
            {                
                MostrarMenuPrincipal();
            }           
            catch (Exception erro)
            {
                CustomExceptionLogger.GerarLog(erro);
            }
        }

        public static void MostrarMenuPrincipal()
        {
            string opcao = "", escrita;            
            while (opcao != SAIR)
            {
                Console.Clear();
                Console.WriteLine(string.Format("SISTEMA DE LOCADORA DE JOGOS {0}{0}Digite 1 para listar todos os jogos{0}" +
                "Digite 2 para buscar jogo por nome{0}Digite 3 para adicionar jogo novo{0}" +
                "Digite 4 para alterar jogo existente{0}Digite 5 para exportar relatorio{0}Digite 0 para sair", "\r\n"));
                opcao = Console.ReadLine();
                switch (opcao)
                {
                    case LISTAR_TODOS_JOGOS:
                        ListarTodosOsJogos();
                        break;
                    case BUSCAR_JOGO_POR_NOME:
                        BuscarJogo();
                        break;
                    case ADICIONAR_JOGO:
                        AdicionarJogo();
                        break;
                    case ALTERAR_JOGO:
                        AlterarJogo();
                        break;
                    case EXPORTAR_RELATORIO:
                        ExportarRelatorio();
                        break;
                    case SAIR:
                        opcao = "-1";
                        Console.WriteLine("Tem certeza que quer sair do sistema? (s/n)");
                        escrita = Console.ReadLine();
                        while (escrita.Length < 1) { escrita = Console.ReadLine(); }
                        if (escrita.Substring(0, 1).ToLower() == "s") 
                        {
                            opcao = "0";
                        }
                        break;
                    default:
                        break;
                }
            }            
        }

        public static void ListarTodosOsJogos()
        {
            Console.WriteLine(jogos.Listar());
            Console.WriteLine("\r\nPressione qualquer tecla para prosseguir");
            Console.ReadKey();
        }

        public static void BuscarJogo()
        {
            List<JogoModel> jogosPesquisa = new List<JogoModel>();
            string nomeDoJogo;
            Console.Clear();            
            Console.WriteLine("Escreva o nome do que procura:");
            nomeDoJogo = Console.ReadLine();
            jogosPesquisa = jogos.BuscarPorNome(nomeDoJogo);
            if (jogosPesquisa.Count < 1)
            {
                Console.WriteLine("Nenhum jogo encontrado");
            }
            else
            {
                foreach (JogoModel jogo in jogosPesquisa)
                {
                    Console.WriteLine(jogo.ToString());
                }
            }
            Console.WriteLine("\r\nPressione qualquer tecla para prosseguir");
            Console.ReadKey();
        }

        public static void AdicionarJogo()
        {
            Console.Clear();
            string nome = "-1", escrita;
            int categoria = -1;
            double preco = -1;
            Console.WriteLine("Insira o nome do jogo:");
            while (nome == INVALIDO)
            {
                nome = Console.ReadLine();
                if (nome.Replace(" ", "") == "")
                {
                    Console.WriteLine("Insira um nome valido");
                    nome = INVALIDO;
                }
            }
            while (categoria == INVALIDA)
            {                
                Console.WriteLine("Selecione uma das categorias:");
                Console.WriteLine(categoriaRepositorio.ListarCategorias());
                escrita = Console.ReadLine();
                if (int.TryParse(escrita, out categoria))
                {
                    escrita = categoriaRepositorio.ConverterEntreValores(int.Parse(escrita));
                    categoria = categoriaRepositorio.ConverterEntreValores(escrita);
                }
                else
                {
                    categoria = categoriaRepositorio.ConverterEntreValores(escrita);
                }
                if (categoria == INVALIDA) { 
                    Console.Clear();
                    Console.WriteLine("nome: " + nome +"\r\nCategoria inserida não existe, digite novamente");
                }                 
            }
            while (preco <= 0)
            {
                Console.WriteLine("Insira o valor do jogo:");
                escrita = Console.ReadLine().Replace(".",",");
                if (double.TryParse(escrita, out preco))
                {
                    preco = double.Parse(escrita);
                }
                if (preco <= 0)
                {                    
                    Console.Clear();
                    Console.WriteLine("nome: " + nome + "\r\nCategoria: " + categoriaRepositorio.ConverterEntreValores(categoria)+
                        "\r\nValor deve ser um número maior que zero, digite novamente");
                }       
            }
            try
            {
                jogos.Adicionar(nome, preco, categoria);
                Console.WriteLine("Jogo inserido com sucesso");
            }
            catch (Exception)
            {
                Console.WriteLine("Falha ao inserir jogo");
            }

            Console.WriteLine("\r\nPressione qualquer tecla para prosseguir");
            Console.ReadKey();
        }

        public static void AlterarJogo()
        {
            Console.Clear();
            string nome = "-1", escrita;
            int categoria = -1, id = 0;
            double preco = -1;     
            JogoModel jogo;
            while (id <= 0)
            {
                if (id == BUSCANDO) { BuscarJogo(); }
                Console.WriteLine("Insira o id do jogo ou digite -1 para buscar por nome");
                escrita = Console.ReadLine();
                while (!int.TryParse(escrita, out id))
                {
                    Console.WriteLine("Insira o id do jogo ou digite -1 para buscar (deve ser valor numerico)");
                    escrita = Console.ReadLine();
                }
            }
            jogo = ListarInformacoesPorId(id);
            Console.WriteLine("Insira o nome do jogo para alterar ou pressione enter para manter:");
            nome = Console.ReadLine();
            if (nome.Replace(" ", "") == "")
            {                
               nome = jogo.Nome;               
            }
            while (categoria == INVALIDA)
            {
                Console.WriteLine("Selecione uma das categorias:");
                Console.WriteLine(categoriaRepositorio.ListarCategorias());
                escrita = Console.ReadLine();
                if (int.TryParse(escrita, out categoria))
                {
                    escrita = categoriaRepositorio.ConverterEntreValores(int.Parse(escrita));
                    categoria = categoriaRepositorio.ConverterEntreValores(escrita);
                }
                else
                {
                    categoria = categoriaRepositorio.ConverterEntreValores(escrita);
                }
                if (categoria == INVALIDA)
                {
                    Console.Clear();
                    Console.WriteLine("nome: " + nome + "\r\nCategoria inserida não existe, digite novamente");
                }
            }
            Console.WriteLine("Insira o novo preço do jogo ou pressione enter para manter:");
            escrita = Console.ReadLine().Replace(".", ",");
            if (escrita.Replace(" ", "") == "")
            {
                preco = jogo.Preco;
            }
            else
            {
                while (preco <= 0)
                {                    
                    if (double.TryParse(escrita, out preco))
                    {
                        preco = double.Parse(escrita);
                    }
                    if (preco <= 0)
                    {                        
                        Console.WriteLine("Valor deve ser um número maior que zero, digite novamente");
                        escrita = Console.ReadLine().Replace(".", ",");
                    }                    
                }
            }
            bool nenhumaAlteracao = jogo.Nome == nome && jogo.Preco == preco && categoria == jogo.CategoriaDoJogo;
            if (nenhumaAlteracao)
            {
                Console.WriteLine("Nenhuma alteração a realizar");
            }
            else
            {                
                escrita = "";
                if (jogo.Nome != nome)
                {
                    escrita += "\r\n Nome alterado de " + jogo.Nome + " para " + nome;
                }
                if (jogo.Preco != preco)
                {
                    escrita += "\r\n Preço alterado de " + jogo.Preco + " para " + preco;
                }
                if (jogo.CategoriaDoJogo != categoria)
                {
                    escrita += "\r\n Categoria alterado de " + categoriaRepositorio.ConverterEntreValores(jogo.CategoriaDoJogo) + " para " + categoriaRepositorio.ConverterEntreValores(categoria);
                }
                jogos.Modificar(id, nome, preco, categoria);
                Console.WriteLine("Jogo alterado com as seguintes modificações:" + escrita);

            }
            
            Console.WriteLine("\r\nPressione qualquer tecla para prosseguir");
            Console.ReadKey();
        }

        public static JogoModel ListarInformacoesPorId(int id)
        {
            Console.Clear();
            JogoModel jogo = jogos.BuscarPorId(id);
            Console.WriteLine(jogo.ToString());
            return jogo;
        }

        public static void ExportarRelatorio()
        {
            jogos.ExportarRelatorio();
            Console.WriteLine("Relatório exportado para a pasta de log");
            Console.WriteLine("\r\nPressione qualquer tecla para prosseguir");
            Console.ReadKey();
        }
    }
}
