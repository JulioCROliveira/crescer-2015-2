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
        public ActionResult JogosDisponiveis(int id = 0, string nome = null)
        {
            if (id > 0)
            {
                return RedirectToAction("DescricaoJogo", id);
            }
            Dominio.Repositorio.IJogoRepositorio jogoRepositorio = new JogoRepositorio();
            IList<Locadora.Dominio.Jogo> jogos;
            if (nome == null)
            {
                jogos = jogoRepositorio.BuscarTodos();
            }
            else
            {
               jogos = jogoRepositorio.BuscarPorNome(nome);
            }            
            RelatorioModel model = new RelatorioModel();
            model.ListaDeJogos = new List<JogoModel>();
            foreach (var jogo in jogos)
            {
                model.ListaDeJogos.Add(new JogoModel(jogo.Id, jogo.Nome, jogo.Preco, jogo.Categoria.ToString()));
            }
            model.QuantidadeDeJogos = model.ListaDeJogos.Count;
            model.JogoMaisCaro = model.ListaDeJogos.Aggregate((jogo1, jogo2) => jogo1.Preco > jogo2.Preco ? jogo1 : jogo2).Nome;
            model.JogoMaisBarato = model.ListaDeJogos.Aggregate((jogo1, jogo2) => jogo1.Preco < jogo2.Preco ? jogo1 : jogo2).Nome;
            model.MediaDeValor = model.ListaDeJogos.Average(jogo => jogo.Preco);

            return View(model);
        }

        public ActionResult DescricaoJogo(int id)
        {
            Dominio.Repositorio.IJogoRepositorio jogoRepositorio = new JogoRepositorio();
            var jogo = jogoRepositorio.BuscarPorId(id);
            DescricaoJogoModel model = new DescricaoJogoModel(jogo.Nome, jogo.Preco, jogo.Categoria.ToString())
            {
                Descricao = jogo.Descricao,
                Imagem = jogo.Imagem,
                Video = jogo.Video,
                Selo = jogo.Selo.ToString()
            };
            return View(model);
        }
    }
}