using ProjetoMVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ProjetoMVC.Controllers
{
    public class RelatorioController : Controller
    {
        // GET: Relatorio
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult JogosDisponiveis()
        {
            RelatorioModel modelo = new RelatorioModel();
            List<string> list = new List<string>();
            list.Add(modelo.Relatorio.Replace("\r\n", "<br />"));
            return View(list);
        }
    }
}