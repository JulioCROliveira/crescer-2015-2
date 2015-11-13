using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Models
{
    public class LocarModel
    {
        public int? Id { get; set; }
        public IList<LocarJogoModel> Jogos { get; set; }
        public IList<Cliente> Clientes { get; set; }

        public LocarModel()
        {
            Jogos = new List<LocarJogoModel>();
            Clientes = new List<Cliente>();
        }
    }
}