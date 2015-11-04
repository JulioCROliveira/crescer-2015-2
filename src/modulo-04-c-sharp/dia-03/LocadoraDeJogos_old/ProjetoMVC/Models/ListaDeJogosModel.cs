using LocadoraDeJogos.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ProjetoMVC.Models
{
    public class ListaDeJogosModel
    {
        public List<string> Jogos {get; private set;}

        public ListaDeJogosModel()
        {
            ListaDeJogos lista = new ListaDeJogos();
            List<LocadoraDeJogos.Dominio.JogoModel> jogosOriginais = lista.GetListaDeJogos();
            foreach (var jogo in jogosOriginais)
	        {
                Jogos.Add(ConverterJogo(jogo));
	        }
            
        }

        public string ConverterJogo(LocadoraDeJogos.Dominio.JogoModel jogo)
        {
            return string.Format("ID: {0}, Nome: {1}, Preço: {2:c}", jogo.Id, jogo.Nome, jogo.Preco);
        }
    }
}