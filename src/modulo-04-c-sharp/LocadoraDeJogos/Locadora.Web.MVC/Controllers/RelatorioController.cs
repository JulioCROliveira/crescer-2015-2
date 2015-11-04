using Locadora.Repositorio.ADO;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        public ActionResult JogosDisponiveis()
        {
            JogoRepositorio jogoRepositorio = new JogoRepositorio();
            var jogos = jogoRepositorio.BuscarTodos();
            var model = new RelatorioModel();
            foreach (var jogo in jogos)
            {
                model.ListaDeJogos.Add(new JogoModel()
                {
                    Nome = jogo.Nome,
                    Preco = jogo.Preco,
                    Categoria = jogo.Categoria.ToString()
                });
            }
            model.QuantidadeDeJogos = model.ListaDeJogos.Count;
            //model.JogoMaisCaro = model.ListaDeJogos.Where(jogo => jogo.Preco = model))

            return View(model);
        }
    }
}