using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioJogosModel
    {
        public List<JogoModel> ListaDeJogos { get; set; }
        public int QuantidadeDeJogos { get; set; }
    }
}