using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class PermissaoRepositorio : IRepositorioPermissao
    {
        public Permissao BuscarPorNome(string nome)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Permissao.Where(p => p.Nome == nome).FirstOrDefault();
            }
        }
    }
}
