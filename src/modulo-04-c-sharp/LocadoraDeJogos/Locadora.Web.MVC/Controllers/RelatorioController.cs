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
            Locadora.Dominio.Repositorio.IJogoRepositorio jogoRepositorio = new JogoRepositorio();
            var jogos = jogoRepositorio.BuscarTodos();
            RelatorioModel model = new RelatorioModel();
            model.ListaDeJogos = new List<JogoModel>();
            foreach (var jogo in jogos)
            {
                model.ListaDeJogos.Add(new JogoModel(jogo.Nome, jogo.Preco, jogo.Categoria.ToString()));
            }
            model.QuantidadeDeJogos = model.ListaDeJogos.Count;
            model.JogoMaisCaro = model.ListaDeJogos.Aggregate((jogo1, jogo2) => jogo1.Preco > jogo2.Preco ? jogo1 : jogo2).Nome;
            model.JogoMaisBarato = model.ListaDeJogos.Aggregate((jogo1, jogo2) => jogo1.Preco < jogo2.Preco ? jogo1 : jogo2).Nome;
            model.MediaDeValor = model.ListaDeJogos.Average(jogo => jogo.Preco);

            return View(model);
        }
    }
}