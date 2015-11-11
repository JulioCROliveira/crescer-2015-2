using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Permissao : EntidadeBase
    {
        public const string ADMIN = "ADMIN";
        public string Nome { get; private set; }

        public ICollection<Usuario> Usuarios { get; set; }
    }
}
