using LocadoraDeJogos.Dominio;
using ProjetoMVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ProjetoMVC.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {            
            return View();
        }

        public ActionResult CarregarLista()
        {
            var lista = new ListaDeJogosModel();
            List<string> jogos = lista.Jogos;
            return View(jogos);
        }
    }
}