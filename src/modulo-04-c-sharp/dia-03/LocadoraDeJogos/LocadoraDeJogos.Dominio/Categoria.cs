using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

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

        public static int ConverterValor(string chave)
        {
            try
            {
                if (chave == null)
                {
                    throw new ArgumentNullException();
                }
            }
            catch(ArgumentNullException erro)
            {
                
            }
        }
    }
}
