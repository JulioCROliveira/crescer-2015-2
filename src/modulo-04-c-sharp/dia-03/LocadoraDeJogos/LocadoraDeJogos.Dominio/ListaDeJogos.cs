using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;

namespace LocadoraDeJogos.Dominio
{
    public static class ListaDeJogos
    {
        private const string enderecoJogo = @"C:\Users\julio.oliveira\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\xml\game_store.xml";

        public static string listarJogos()
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
    }
}
