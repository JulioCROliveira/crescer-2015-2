using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioJogosDisponiveisModel
    {
        public List<JogoModel> ListaDeJogos { get; set; }
        public int QuantidadeDeJogos { get; set; }
        public string JogoMaisCaro { get; set; }
        public string JogoMaisBarato { get; set; }
        public decimal MediaDeValor { get; set; }
    }
}