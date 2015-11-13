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
        public ActionResult Devolver(int? id, string mensagem)
        {
            DevolverModel model = new DevolverModel()
            {
                Mensagem = mensagem
            };
            ViewBag.ListaJogos = new SelectList(dbJogo.BuscarTodos().Where(p => p.IdLocacao != null), "Id", "Nome");

            if (id.HasValue && id > 0)
            {
                Jogo jogoDoBanco = dbJogo.BuscarPorId((int)id);
                if (jogoDoBanco.IdLocacao != null)
                {
                    Locacao locacao = Construtor.CriarLocacaoRepositorio().BuscarPorId((int)jogoDoBanco.IdLocacao);
                    model.IdLocacao = jogoDoBanco.IdLocacao;
                    model.Locacao = locacao;
                    model.IdJogo = jogoDoBanco.Id;
                    model.Jogo = jogoDoBanco;
                    model.IdCliente = locacao.IdCliente;
                    model.Cliente = locacao.Cliente;
                }
                else
                {
                    model.Mensagem = "O jogo citado não existe ou não está locado";
                } 
            }

            return View(model);
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

        [HttpPost]
        public ActionResult EfetuarDevolucao(DevolverModel model)
        {
            servicoLocacao.DevolverJogo(model.Locacao);
            string mensagem = "Devolução concluída";
            return View("Devolver", mensagem);
        }
    }
}