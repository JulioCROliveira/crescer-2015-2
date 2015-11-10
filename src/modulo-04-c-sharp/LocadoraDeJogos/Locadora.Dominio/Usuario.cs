using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Usuario : EntidadeBase
    {
        public string Email { get; private set; }
        public string NomeCompleto { get; private set; }
        public string Senha { get; private set; }
        public ICollection<Permissao> Permissoes { get; set; }

        public Usuario(string email, string nome, string senha)
        {
            Email = email;
            NomeCompleto = nome;
            Senha = senha;
        }
    }
}
