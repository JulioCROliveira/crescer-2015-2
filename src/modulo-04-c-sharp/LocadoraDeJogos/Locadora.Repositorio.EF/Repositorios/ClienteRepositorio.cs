using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class ClienteRepositorio : IRepositorio<Cliente>
    {
        public int Atualizar(Cliente entidade)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                db.Entry(entidade).State = System.Data.Entity.EntityState.Modified;                
                return db.SaveChanges();
            }
        }

        public Cliente BuscarPorId(int id)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Cliente.Find(id);
            }
        }

        public IList<Cliente> BuscarPorNome(string nome)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Cliente.Where(j => j.Nome.IndexOf(nome, StringComparison.OrdinalIgnoreCase) > 0).ToList();
            }
        }

        public IList<Cliente> BuscarTodos()
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Cliente.ToList();
            }
        }

        public IList<Cliente> BuscarTodosDisponiveis()
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Cliente.Where(c => c.JogosLocados < 3).ToList();
            }
        }

        public int Criar(Cliente entidade)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                db.Entry(entidade).State = System.Data.Entity.EntityState.Added;                
                return db.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                Cliente clienteAExcluir = db.Cliente.Find(id);
                db.Entry(clienteAExcluir).State = System.Data.Entity.EntityState.Deleted;                
                return db.SaveChanges();
            }
        }
    }
}
