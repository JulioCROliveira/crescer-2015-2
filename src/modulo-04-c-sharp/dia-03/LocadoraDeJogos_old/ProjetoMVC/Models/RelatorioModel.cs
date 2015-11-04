using LocadoraDeJogos.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ProjetoMVC.Models
{
    public class RelatorioModel
    {
        public string Relatorio { get; set; }

        public RelatorioModel()
        {
            ListaDeJogos lista = new ListaDeJogos();
            Relatorio = lista.EscreverRelatorio();
        }
    }
}