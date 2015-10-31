using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;

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
                    "\r\nCategoria : " + jogo.Element("categoria").Value + "\r\n\r\n";
            }
            
            return lista;
        }

        public static List<JogoModel> BuscarPorNome(string nome)
        {
            List<JogoModel> lista = new List<JogoModel>();
            XElement XMLJogos = XElement.Load(enderecoJogo);
            var jogos = XMLJogos.Elements("jogo").Where(jogo => contemPalavra(jogo.Element("nome").Value, nome));

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

        public static bool contemPalavra(string palavra1, string palavra2)
        {
            if (palavra1 != null && palavra2 != null)
            {
                return palavra1.ToUpper().Contains(palavra2.ToUpper());
            }
            return palavra1 == palavra2;
        }
    }
}
