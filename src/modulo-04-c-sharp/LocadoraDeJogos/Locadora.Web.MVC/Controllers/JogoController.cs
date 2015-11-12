using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Repositorio.EF;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Security;
using System;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador(Roles = Permissao.ADMIN)]
    public class JogoController : Controller
    {
        IRepositorio<Jogo> bdJogos = Construtor.CriarJogoRepositorio();
        IRepositorio<Selo> bdSelos = Construtor.CriarSeloRepositorio();

        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public ActionResult ManterJogo(int? id)
        {            
            ViewBag.ListaJogos = new SelectList(bdJogos.BuscarTodos(), "Id", "Nome");
            ViewBag.ListaSelos = new SelectList(bdSelos.BuscarTodos(), "Id", "Nome");

            if (id.HasValue && id > 0)
            {
                Jogo jogoDoBanco = bdJogos.BuscarPorId((int)id);
                ManterJogoModel model = new ManterJogoModel()
                {                    
                    Id = jogoDoBanco.Id,
                    IdCliente = jogoDoBanco.IdCliente,
                    Nome = jogoDoBanco.Nome,
                    Categoria = jogoDoBanco.Categoria,
                    Descricao = jogoDoBanco.Descricao,
                    IdSelo = jogoDoBanco.Selo.Id,
                    Imagem = jogoDoBanco.Imagem,
                    Video = jogoDoBanco.Video
                };

                return View(model);
            }
            else
            {
                return View();
            }
        }

        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(ManterJogoModel model)
        {
            if (ModelState.IsValid)
            {
                if (model.Id > 0)
                {
                    try
                    {
                        TempData["Mensagem"] = "Jogo alterado com sucesso!";
                        bdJogos.Atualizar(convertModelEmJogo(model));
                    }
                    catch (Exception erro)
                    {
                        TempData["Mensagem"] = erro.Message;
                    }
                }
                else
                {
                    try
                    {
                        TempData["Mensagem"] = "Jogo cadastrado com sucesso!";
                        bdJogos.Criar(convertModelEmJogo(model));
                    }
                    catch (Exception erro)
                    {
                        TempData["Mensagem"] = erro.Message;
                    }
                }

                return RedirectToAction("Index");
            }
            else
            {                
                ViewBag.ListaJogos = new SelectList(bdJogos.BuscarTodos(), "Id", "Nome");
                ViewBag.ListaSelos = new SelectList(bdSelos.BuscarTodos(), "Id", "Nome");

                return View("ManterJogo", model);
            }
        }

        public Jogo convertModelEmJogo(ManterJogoModel model)
        {
            int id = model.Id != null ? (int)model.Id : 0;
            return new Jogo(id, model.IdCliente)
                {
                    Nome = model.Nome,
                    Categoria = model.Categoria,
                    Descricao = model.Descricao,
                    IdSelo = model.IdSelo,
                    //Selo = bdSelos.BuscarPorId(model.IdSelo),
                    Imagem = model.Imagem,
                    Video = model.Video
                };
        }
    }
}