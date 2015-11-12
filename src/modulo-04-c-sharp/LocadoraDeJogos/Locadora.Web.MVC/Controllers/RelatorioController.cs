﻿using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Repositorio.EF;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Security;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class RelatorioController : Controller
    {
        IRepositorio<Jogo> bdJogos = new JogoRepositorio();

        [HttpGet]
        public ActionResult JogosDisponiveis(int id = 0, string nome = null)
        {
            if (id > 0)
            {
                return RedirectToAction("DescricaoJogo", id);
            }
            IList<Locadora.Dominio.Jogo> listaJogos;
            if (nome == null)
            {
                listaJogos = bdJogos.BuscarTodos();
            }
            else
            {
               listaJogos = bdJogos.BuscarPorNome(nome);
            }            
            RelatorioJogosModel model = new RelatorioJogosModel();
            model.ListaDeJogos = new List<JogoModel>();
            foreach (var jogo in listaJogos)
            {
                model.ListaDeJogos.Add(new JogoModel(jogo.Id, jogo.Nome, jogo.Categoria.ToString(), jogo.Selo));
            }
            model.QuantidadeDeJogos = model.ListaDeJogos.Count;        

            return View(model);
        }

        [HttpGet]
        public ActionResult DescricaoJogo(int id)
        {
            var jogo = bdJogos.BuscarPorId(id);
            DescricaoJogoModel model = new DescricaoJogoModel(jogo.Nome, jogo.Categoria.ToString())
            {
                Descricao = jogo.Descricao,
                Imagem = jogo.Imagem,
                Video = jogo.Video,
                Selo = jogo.Selo.Nome
            };
            return View(model);
        }
    }
}