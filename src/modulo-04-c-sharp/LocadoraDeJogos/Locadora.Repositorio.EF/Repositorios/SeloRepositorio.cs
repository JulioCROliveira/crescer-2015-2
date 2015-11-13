using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Repositorios
{
    public class SeloRepositorio : IRepositorio<Selo>
    {
        public int Atualizar(Selo entidade)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                db.Entry(entidade).State = System.Data.Entity.EntityState.Modified;

                return db.SaveChanges();
            }
        }

        public Selo BuscarPorId(int id)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Selo.Find(id);
            }
        }



        public IList<Selo> BuscarPorNome(string nome)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Selo.Where(j => j.Nome.IndexOf(nome, StringComparison.OrdinalIgnoreCase) > 0).ToList();
            }
        }

        public IList<Selo> BuscarTodos()
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Selo.ToList();
            }
        }

        public IList<Selo> BuscarTodosDisponiveis()
        {
            return BuscarTodos();
        }

        public int Criar(Selo entidade)
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
                Selo seloAExcluir = db.Selo.Find(id);
                db.Entry(seloAExcluir).State = System.Data.Entity.EntityState.Deleted;
                return db.SaveChanges();
            }
        }
    }
}
