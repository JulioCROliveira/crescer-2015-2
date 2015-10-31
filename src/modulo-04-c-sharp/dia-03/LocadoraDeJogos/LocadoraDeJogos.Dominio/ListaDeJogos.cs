using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using System.Xml;
using System.IO;

namespace LocadoraDeJogos.Dominio
{
    public static class ListaDeJogos
    {
        private const string enderecoJogo = @"C:\Users\juliocesar\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\xml\game_store.xml";

        public static string Listar()
        {            
            string lista = "";
            XElement XMLJogos = XElement.Load(enderecoJogo);
            var jogos = XMLJogos.Elements("jogo");

            foreach (var jogo in jogos)
            {                
                lista += "ID : " + jogo.Attribute("id").Value +
                    "\r\nNome : " + jogo.Element("nome").Value +
                    "\r\nPreço : " + jogo.Element("preco").Value +
                    "\r\nCategoria : " + Categoria.ConverterEntreValores(int.Parse(jogo.Element("categoria").Value)) + "\r\n\r\n";
            }
            
            return lista;
        }

        public static List<JogoModel> BuscarPorNome(string nome)
        {
            List<JogoModel> lista = new List<JogoModel>();
            XElement XMLJogos = XElement.Load(enderecoJogo);
            var jogos = XMLJogos.Elements("jogo").Where(jogo => jogo.Element("nome").Value.ContainsNoCaseSensitive(nome));

            foreach (var jogo in jogos)
            {
                lista.Add(new JogoModel(int.Parse(jogo.Attribute("id").Value), jogo.Element("nome").Value, double.Parse(jogo.Element("preco").Value.Replace('.',',')), int.Parse(jogo.Element("categoria").Value)));
            }

            return lista;
        }

        public static JogoModel BuscarPorId(int id)
        {
            List<JogoModel> lista = new List<JogoModel>();
            XElement XMLJogos = XElement.Load(enderecoJogo);
            var jogos = XMLJogos.Elements("jogo").Where(jogo => int.Parse(jogo.Attribute("id").Value) == id);

            foreach (var jogo in jogos)
            {
                lista.Add(new JogoModel(int.Parse(jogo.Attribute("id").Value), jogo.Element("nome").Value, double.Parse(jogo.Element("preco").Value.Replace('.', ',')), int.Parse(jogo.Element("categoria").Value)));
            }

            return lista[0];
        }

        public static string ToString(List<JogoModel> lista)
        {
            string listaDeJogos = "";
            foreach (var jogo in lista)
            {
                listaDeJogos += jogo.ToString() + "\r\n";
            }
            return listaDeJogos;
        }

        public static int Adicionar(string nome, double preco, int categoria)
        {
            try
            {                
                int id = getProximoId();
                string jogoAAdicionar = string.Format("{0}    <nome>{1}</nome>{0}    <preco>{2}</preco>{0}    <categoria>{3}</categoria>{0}  ", "\r\n", nome, preco, categoria);
                XmlDocument XMLJogos = new XmlDocument();
                XMLJogos.Load(enderecoJogo);
                XmlNode jogo = XMLJogos.CreateElement("jogo");
                XmlAttribute atrId = XMLJogos.CreateAttribute("id");
                atrId.Value = id.ToString();
                jogo.Attributes.Append(atrId);
                jogo.InnerXml = jogoAAdicionar;
                XMLJogos.ChildNodes[1].AppendChild(jogo);
                XMLJogos.Save(enderecoJogo);
                return id;
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

        public static int getProximoId()
        {
            XElement XMLJogos = XElement.Load(enderecoJogo);
            var jogos = XMLJogos.Elements("jogo");
            return XMLJogos.Descendants("jogo").Max(x => (int)x.Attribute("id")) + 1;
        }
    }
}
