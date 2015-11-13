using Locadora.Dominio.Serviços;
using Locadora.Web.MVC.Helpers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Models
{
    public class DevolverModel
    {
        public int? IdJogo { get; set; }
        public Jogo Jogo { get; set; }
        public int? IdLocacao { get; set; }
        public Locacao Locacao { get; set; }
        public int? IdCliente { get; set; }
        public Cliente Cliente { get; set; }
        public string Mensagem { get; set; }

        public ServicoLocacao servicoLocacao = Construtor.CriarServicoLocacao();
    }
}