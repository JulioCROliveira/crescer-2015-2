using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class UsuarioModel
    {
        public string Email { get; private set; }

        public string Senha { get; private set; }

        public UsuarioModel(string email, string senha)
        {
            Email = email;
            Senha = senha;        
        }

        public UsuarioModel()
        {

        }
    }
}