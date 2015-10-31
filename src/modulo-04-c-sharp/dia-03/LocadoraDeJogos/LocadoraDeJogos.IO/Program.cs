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
        public const string LISTAR_TODOS_JOGOS = "1", BUSCAR_JOGO_POR_NOME = "2", ADICIONAR_JOGO  = "3", ALTERAR_JOGO = "4", EXPORTAR_RELATORIO = "5", SAIR = "0";
        public const string Buscar = "-1";

        static void Main(string[] args)
        {
            try
            {
                Categoria.InicializarRecarregarCategoria();
                MostrarMenuPrincipal();
            }           
            catch (Exception erro)
            {
                string localDoArquivo = @"C:\Users\juliocesar\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\log\log.txt";
                string mensagemDeLog = string.Format("{0}: {1}{2}   Classe: {3}, Metodo:{4}{2}",
                    DateTime.Now, erro.Message, "\r\n", System.Reflection.MethodInfo.GetCurrentMethod().DeclaringType.Name, System.Reflection.MethodInfo.GetCurrentMethod());
                File.AppendAllText(localDoArquivo, mensagemDeLog);
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
            Console.WriteLine(ListaDeJogos.Listar());
            Console.WriteLine("\r\nPressione qualquer tecla para prosseguir");
            Console.ReadKey();
        }

        public static void BuscarJogo()
        {
            List<JogoModel> jogos = new List<JogoModel>();
            string nomeDoJogo;
            Console.Clear();            
            Console.WriteLine("Escreva o nome do que procura:");
            nomeDoJogo = Console.ReadLine();
            jogos = ListaDeJogos.BuscarPorNome(nomeDoJogo);
            if (jogos.Count < 1)
            {
                Console.WriteLine("Nenhum jogo encontrado");
            }
            else
            {
                foreach (JogoModel jogo in jogos)
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
            while (nome == "-1")
            {
                nome = Console.ReadLine();
                if (nome.Replace(" ", "") == "")
                {
                    Console.WriteLine("Insira um nome valido");
                    nome = "-1";
                }
            }
            while (categoria == -1)
            {                
                Console.WriteLine("Selecione uma das categorias:");
                Console.WriteLine(Categoria.ListarCategorias());
                escrita = Console.ReadLine();
                if (int.TryParse(escrita, out categoria))
                {
                    escrita = Categoria.ConverterEntreValores(int.Parse(escrita));
                    categoria = Categoria.ConverterEntreValores(escrita);
                }
                else
                {
                    categoria = Categoria.ConverterEntreValores(escrita);
                }
                if (categoria == -1) { 
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
                    Console.WriteLine("nome: " + nome + "\r\nCategoria: " + Categoria.ConverterEntreValores(categoria)+
                        "\r\nValor deve ser um número maior que zero, digite novamente");
                }       
            }
            try
            {
                ListaDeJogos.Adicionar(nome, preco, categoria);
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
                if (id == -1) { BuscarJogo(); }
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
            while (categoria == -1)
            {
                Console.WriteLine("Selecione uma das categorias:");
                Console.WriteLine(Categoria.ListarCategorias());
                escrita = Console.ReadLine();
                if (int.TryParse(escrita, out categoria))
                {
                    escrita = Categoria.ConverterEntreValores(int.Parse(escrita));
                    categoria = Categoria.ConverterEntreValores(escrita);
                }
                else
                {
                    categoria = Categoria.ConverterEntreValores(escrita);
                }
                if (categoria == -1)
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
            if (jogo.Nome == nome && jogo.Preco == preco && categoria == jogo.CategoriaDoJogo)
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
                    escrita += "\r\n Categoria alterado de " + Categoria.ConverterEntreValores(jogo.CategoriaDoJogo) + " para " + Categoria.ConverterEntreValores(categoria);
                }
                ListaDeJogos.Modificar(id, nome, preco, categoria);
                Console.WriteLine("Jogo alterado com as seguintes modificações:" + escrita);

            }
            
            Console.WriteLine("\r\nPressione qualquer tecla para prosseguir");
            Console.ReadKey();
        }

        public static JogoModel ListarInformacoesPorId(int id)
        {
            Console.Clear();
            JogoModel jogo = ListaDeJogos.BuscarPorId(id);
            Console.WriteLine("Id: {1}{0}Nome: {2}{0}Categoria: {3}{0}Preco: {4:c}{0}", "\r\n", jogo.Id, jogo.Nome, Categoria.ConverterEntreValores(jogo.CategoriaDoJogo), jogo.Preco);
            return jogo;
        }

        public static void ExportarRelatorio()
        {
            ListaDeJogos.ExportarRelatorio();
            Console.WriteLine("Relatório exportado para a pasta de log");
            Console.WriteLine("\r\nPressione qualquer tecla para prosseguir");
            Console.ReadKey();
        }
    }
}
