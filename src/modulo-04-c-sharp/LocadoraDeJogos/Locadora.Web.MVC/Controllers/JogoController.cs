using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Repositorio.ADO;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public ActionResult ManterJogo(int? id)
        {
            IJogoRepositorio jogos = new JogoRepositorio();
            ViewBag.ListaJogos = new SelectList(jogos.BuscarTodos(), "Id", "Nome");

            if (id.HasValue && id > 0)
            {
                Jogo jogoDoBanco = jogos.BuscarPorId((int)id);
                ManterJogoModel model = new ManterJogoModel()
                {                    
                    Id = jogoDoBanco.Id,
                    IdCliente = jogoDoBanco.IdClienteLocacao,
                    Nome = jogoDoBanco.Nome,
                    Preco = jogoDoBanco.Preco,
                    Categoria = jogoDoBanco.Categoria,
                    Descricao = jogoDoBanco.Descricao,
                    Selo = jogoDoBanco.Selo,
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
            IJogoRepositorio jogos = new JogoRepositorio();
            if (ModelState.IsValid)
            {
                if (model.Id > 0)
                {
                    try
                    {
                        TempData["Mensagem"] = "Jogo alterado com sucesso!";
                        jogos.Atualizar(convertModelEmJogo(model));
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
                        jogos.Criar(convertModelEmJogo(model));
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
                ViewBag.ListaJogos = new SelectList(jogos.BuscarTodos(), "Id", "Nome");

                return View("ManterJogo", model);
            }
        }

        public Jogo convertModelEmJogo(ManterJogoModel model)
        {
            int id = model.Id != null ? (int)model.Id : 0;
            return new Jogo(id, model.IdCliente)
                {
                    Nome = model.Nome,
                    Preco = model.Preco,
                    Categoria = model.Categoria,
                    Descricao = model.Descricao,
                    Selo = model.Selo,
                    Imagem = model.Imagem,
                    Video = model.Video
                };
        }
    }
}