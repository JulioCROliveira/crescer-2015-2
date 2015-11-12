using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data.SqlClient;
using System.Data;

namespace Locadora.Repositorio.EF
{
    public class JogoRepositorio : IRepositorio<Jogo>
    {
        public int Atualizar(Jogo entidade)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                db.Entry(entidade).State = System.Data.Entity.EntityState.Modified;

                return db.SaveChanges();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Jogo.Include("Cliente").Include("Selo").FirstOrDefault(j => j.Id == id);
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Jogo.Include("Cliente").Include("Selo").Where(j => j.Nome.IndexOf(nome, StringComparison.OrdinalIgnoreCase) > 0).ToList();
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Jogo.Include("Cliente").Include("Selo").ToList();
            }
        }

        public int Criar(Jogo entidade)
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
                Jogo jogoAExcluir = db.Jogo.Find(id);
                db.Entry(jogoAExcluir).State = System.Data.Entity.EntityState.Deleted;                
                return db.SaveChanges();
            }
        }
    }
}
