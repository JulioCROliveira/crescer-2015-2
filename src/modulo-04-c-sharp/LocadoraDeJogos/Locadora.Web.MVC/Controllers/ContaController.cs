using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Serviços;
using Locadora.Repositorio.EF;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Security;
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
            ServicoAutenticacao autenticacao = new ServicoAutenticacao(Construtor.CriarUsuarioRepositorio(), Construtor.CriarServicoCriptografia());
            Usuario usuarioValido = autenticacao.BuscarPorAutenticacao(email, senha);
            if (usuarioValido != null)
            {
                ControleDeSessao.CriarSessaoDeUsuario(usuarioValido);
                return RedirectToAction("Index", "Home");
            }
            var model = new UsuarioModel(email, null);

            ModelState.AddModelError("INVALID_LOGIN", "Usuário ou senha inválidos.");
            return View("Index", model);
        }

        public ActionResult Sair()
        {
            Session.Clear();
            FormsAuthentication.SignOut();

            return RedirectToAction("Login", "Conta");
        }
    }
}