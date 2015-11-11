using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Security.Models
{
    public class UsuarioModel
    {
        public string Email { get; private set; }

        public string[] Permissoes { get; private set; }

        public UsuarioModel(string email, string[] permissoes)
        {
            Email = email;
            Permissoes = permissoes;
        }
    }
}