using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Models
{
    public class JogoModel
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Categoria { get; set; }
        public Selo Selo { get; set; }

        public JogoModel(int id, string nome, string categoria, Selo selo)
        {
            Id = id;
            Nome = nome;
            Categoria = categoria;
            Selo = selo;
        }
    }
}