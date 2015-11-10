using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebApplication1.Filters;

namespace WebApplication1.Controllers
{
    [Autorizador]
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            ViewBag.NomeUsuario = Session["NOME_USUARIO"];
            return View();
        }

        [Autorizador(Roles = "MASTER")]
        public ActionResult Master()
        {
            return View();
        }

        [AllowAnonymous]
        public ActionResult Sobre()
        {
            return View();
        }
    }
}