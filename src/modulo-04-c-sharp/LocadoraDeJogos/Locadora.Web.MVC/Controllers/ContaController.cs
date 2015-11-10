using Locadora.Web.MVC.Security.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class ContaController : Controller
    {
        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Login(string email, string senha)
        {
            //TODO: validar usuario

            if (email == "email@mail.com" && senha == "senha")
            {
                var usuarioLogadoModel = new UsuarioModel("email@mail.com", new string[] { "DESCRICAO" });

                FormsAuthentication.SetAuthCookie(email, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;
            }

            return RedirectToAction("Index", "Home");
        }
    }
}