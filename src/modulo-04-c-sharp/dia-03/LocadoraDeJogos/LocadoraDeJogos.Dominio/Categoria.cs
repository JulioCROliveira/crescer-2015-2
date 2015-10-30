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
        public static Dictionary<string, string> idParaNome = new Dictionary<string, string>();
        public static Dictionary<string, string> NomeParaId = new Dictionary<string, string>();

        public static void InicializarRecarregarCategoria()
        {
            string enderecoCategorias = @"C:\Users\juliocesar\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\xml\categorias.xml";
            XElement XMLCategorias = XElement.Load(enderecoCategorias);
            var categorias = XMLCategorias.Elements("categoria");
            idParaNome.Clear();
            NomeParaId.Clear();

            foreach (var categoria in categorias)
            {
                idParaNome.Add(categoria.Attribute("id").Value, categoria.Element("nome").Value);
                NomeParaId.Add(categoria.Element("nome").Value, categoria.Attribute("id").Value);
            }
        }
    }
}
