using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Serviços;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class LocacaoController : Controller
    {
        IRepositorio<Jogo> dbJogo = Construtor.CriarJogoRepositorio();
        IRepositorio<Cliente> dbCliente = Construtor.CriarClienteRepositorio();
        IRepositorioLocacao dbLocacao = Construtor.CriarLocacaoRepositorio();
        ServicoLocacao servicoLocacao = Construtor.CriarServicoLocacao();

        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public ActionResult Locar(int? id)
        {

            var model = new LocarModel() { Id = id };
            var listaJogos = dbJogo.BuscarTodosDisponiveis();
            foreach (Jogo jogo in listaJogos)
            {
                model.Jogos.Add(new LocarJogoModel(jogo.Id, jogo.Nome, jogo.Selo, jogo.Imagem, (DateTime.Now.AddDays((double)jogo.Selo.DiasLocacao))));
            }
            model.Clientes = dbCliente.BuscarTodosDisponiveis();

            return View(model);
        }

        [HttpGet]
        public ActionResult Devolver()
        {
            return View();
        }

        [HttpPost]
        public ActionResult EfetuarLocacao(int id, int idCliente)
        {
            var jogo = dbJogo.BuscarPorId(id);
            var cliente = dbCliente.BuscarPorId(idCliente);
            if (jogo != null && cliente != null)
            {
                servicoLocacao.LocarJogo(jogo, cliente);
                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            return View("Locar");
        }
    }
}