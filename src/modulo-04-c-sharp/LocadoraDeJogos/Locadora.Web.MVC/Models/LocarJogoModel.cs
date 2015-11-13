using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Models
{
    public class LocarJogoModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public Selo Selo { get; set; }
        public string Imagem { get; set; }
        public DateTime DataPrevista { get; set; }

        public LocarJogoModel(int id, string nome, Selo selo, string imagem, DateTime dataPrevista)
        {
            Id = id;
            Nome = nome;
            Selo = selo;
            Imagem = imagem;
            DataPrevista = dataPrevista;
        }
    }
}