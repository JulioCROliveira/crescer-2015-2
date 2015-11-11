using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IRepositorioUsuario
    {
        Usuario BuscarPorEmail(string email);
        bool Cadastrar(Usuario usuario);
        bool AdicionarPermissao(Usuario usuario, Permissao permissao);
        bool RemoverPermissao(Usuario usuario, Permissao permissao);
    }
}
