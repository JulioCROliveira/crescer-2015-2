using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using System.Reflection;

namespace LocadoraDeJogos.Dominio
{
    public static class Categoria
    {
        public static Dictionary<int, string> idParaNome = new Dictionary<int, string>();
        public static Dictionary<string, int> NomeParaId = new Dictionary<string, int>();

        public static void InicializarRecarregarCategoria()
        {
            string enderecoCategorias = @"C:\Users\juliocesar\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\xml\categorias.xml";
            XElement XMLCategorias = XElement.Load(enderecoCategorias);
            var categorias = XMLCategorias.Elements("categoria");
            idParaNome.Clear();
            NomeParaId.Clear();

            foreach (var categoria in categorias)
            {
                idParaNome.Add(int.Parse(categoria.Attribute("id").Value), categoria.Element("nome").Value);
                NomeParaId.Add(categoria.Element("nome").Value, int.Parse(categoria.Attribute("id").Value));
            }
        }

        public static int ConverterEntreValores(string chave)
        {
            try
            {
                if (chave == null)
                {
                    throw new ArgumentNullException();
                }
                return NomeParaId[chave.ToLower()];
            }
            catch (KeyNotFoundException)
            {
                return -1;                
            }
            catch (ArgumentNullException)
            {
                return -1;
            }
            catch (Exception erro)
            {
                string localDoArquivo = @"C:\Users\juliocesar\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\log\log.txt";
                string mensagemDeLog = string.Format("{0}: {1}{2}   Classe: {3}, Metodo:{4}{2}",
                    DateTime.Now, erro.Message, "\r\n", System.Reflection.MethodInfo.GetCurrentMethod().DeclaringType.Name, System.Reflection.MethodInfo.GetCurrentMethod());
                File.AppendAllText(localDoArquivo, mensagemDeLog);
                return -1;
            }

        }

        public static string ConverterEntreValores(int chave)
        {
            try
            {
                return idParaNome[chave];
            }
            catch (KeyNotFoundException)
            {
                return "-1";
            }
            catch (Exception erro)
            {
                string localDoArquivo = @"C:\Users\juliocesar\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\log\log.txt";
                string mensagemDeLog = string.Format("{0}: {1}{2}   Classe: {3}, Metodo:{4}{2}",
                    DateTime.Now, erro.Message, "\r\n", System.Reflection.MethodInfo.GetCurrentMethod().DeclaringType.Name, System.Reflection.MethodInfo.GetCurrentMethod());
                File.AppendAllText(localDoArquivo, mensagemDeLog);
                return "-1";
            }
        }      
  
        public static string ListarCategorias()
        {
            string enderecoCategorias = @"C:\Users\juliocesar\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\xml\categorias.xml";
            XElement XMLCategorias = XElement.Load(enderecoCategorias);
            var categorias = XMLCategorias.Elements("categoria");
            string categoriasLista = "";
            int quebraLinha = 0;
            
            foreach (var categoria in categorias)
            {
                categoriasLista += string.Format("{0} - {1}, ", categoria.Attribute("id").Value, categoria.Element("nome").Value);
                if ((++quebraLinha % 4) == 0)
                {
                    categoriasLista += "\r\n";
                }
            }

            return categoriasLista;
        }
    }
}
