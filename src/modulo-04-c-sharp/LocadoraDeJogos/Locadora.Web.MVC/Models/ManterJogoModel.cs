using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class ManterJogoModel
    {
        public int? Id { get; set; }
        public Cliente Cliente { get; set; }

        [Required]
        [StringLength(250, MinimumLength = 5, ErrorMessage = "O nome deve ter entre 5 e 250 caracteres")]
        public string Nome { get; set; }

        [Required]
        public Categoria Categoria { get; set; }

        [Required]
        [StringLength(300, MinimumLength = 12, ErrorMessage = "A descrição deve ter entre 12 e 300 caracteres")]
        public string Descricao { get; set; }

        [Required]
        public Selo Selo { get; set; }
        public string Imagem { get; set; }
        public string Video { get; set; }
    }
}