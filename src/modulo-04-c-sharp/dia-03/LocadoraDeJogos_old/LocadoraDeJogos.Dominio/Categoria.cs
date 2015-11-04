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
    public class Categoria
    {
        public Dictionary<int, string> idParaNome = new Dictionary<int, string>();
        public Dictionary<string, int> NomeParaId = new Dictionary<string, int>();

        public Categoria()
        {
            IEnumerable<XElement> categorias = CarregarXML();
            idParaNome.Clear();
            NomeParaId.Clear();

            foreach (var categoria in categorias)
            {
                idParaNome.Add(int.Parse(categoria.Attribute("id").Value), categoria.Element("nome").Value);
                NomeParaId.Add(categoria.Element("nome").Value, int.Parse(categoria.Attribute("id").Value));
            }
        }

        public int ConverterEntreValores(string chave)
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
                CustomExceptionLogger.GerarLog(erro);
                return -1;
            }

        }

        public string ConverterEntreValores(int chave)
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
                CustomExceptionLogger.GerarLog(erro);
                return "-1";
            }
        }      
  
        public string ListarCategorias()
        {
            IEnumerable<XElement> categorias = CarregarXML();
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

        private IEnumerable<XElement> CarregarXML()
        {
            string enderecoCategorias = @"C:\Users\juliocesar\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\xml\categorias.xml";
            XElement XMLCategorias = XElement.Load(enderecoCategorias);
            IEnumerable<XElement> categorias = XMLCategorias.Elements("categoria");

            return categorias;
        }
    }
}
