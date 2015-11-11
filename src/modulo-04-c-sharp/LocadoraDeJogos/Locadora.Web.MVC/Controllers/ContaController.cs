using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Repositorio.EF;
using Locadora.Web.MVC.Security;
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
            Codificador codificador = new Codificador();
            codificador.ComputeHash("minhaSenha", null);
            return View();
        }

        public ActionResult Login(string email, string senha)
        {
            Codificador codificador = new Codificador();
            IRepositorioUsuario usuarios = new UsuarioRepositorio();
            Usuario usuarioDoBanco = usuarios.BuscarPorEmail(email);
            if (false)
            {
                var usuarioLogadoModel = new UsuarioModel("email@mail.com", new string[] { "DESCRICAO" });

                FormsAuthentication.SetAuthCookie(email, true);
                Session["USUARIO_LOGADO"] = usuarioLogadoModel;
            }

            return RedirectToAction("Index", "Home");
        }

        public ActionResult Cadastrar(UsuarioCadastroModel model)
        {
            return View();
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(UsuarioCadastroModel model)
        {
            if (ModelState.IsValid)
            {
                IRepositorioUsuario dbUsuario = new UsuarioRepositorio();
                try
                {
                    dbUsuario.Cadastrar(convertModelEmUsuario(model));
                }
                catch (Exception erro)
                {
                    TempData["Mensagem"] = erro.Message;
                }

                return RedirectToAction("Login", new { email = model.Email, senha = model.Senha});
            }
            else
            {
                return View("Cadastrar", model);
            }
        }

        public Usuario convertModelEmUsuario(UsuarioCadastroModel model)
        {
            Codificador codificador = new Codificador();
            return new Usuario(model.Email, model.NomeCompleto, codificador.ComputeHash(model.Senha, null));
        }
    }
}