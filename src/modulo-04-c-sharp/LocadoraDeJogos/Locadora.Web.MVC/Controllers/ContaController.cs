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
            IServicoCriptografia codificador = Construtor.CriarServicoCriptografia();
            IRepositorioUsuario usuarios = new UsuarioRepositorio();
            Usuario usuarioDoBanco = usuarios.BuscarPorEmail(email);
            if (usuarioDoBanco != null && codificador.CriptografarSenha(senha) == usuarioDoBanco.Senha)
            {
                var usuarioLogadoModel = new UsuarioLogado(usuarioDoBanco);

                FormsAuthentication.SetAuthCookie(usuarioLogadoModel.Email, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;
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