using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Repositorios
{
    public class LocacaoRepositorio : IRepositorioLocacao
    {
        public IList<Locacao> BuscarPorJogo(Jogo jogo)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Locacao.Include("Jogo").Include("Cliente").Where(l => l.IdJogo == jogo.Id).ToList();
            } 
        }

        public IList<Locacao> BuscarTodos()
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Locacao.Include("Jogo").Include("Cliente").ToList();
            } 
        }

        public int LocarJogo(Locacao locacao)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                db.Entry(locacao).State = System.Data.Entity.EntityState.Added;
                db.SaveChanges();

                return RetornarIdLocacao(locacao.Jogo);
            } 
        }

        public int DevolverJogo(Locacao locacao)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                locacao.Situacao = Situacao.ENTREGUE;
                db.Entry(locacao).Property(p => p.Situacao).IsModified = true;
                return db.SaveChanges();
            } 
        }

        public Locacao BuscarPorId(int id)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Locacao.Include("Jogo").Include("Cliente").FirstOrDefault(p => p.Id == id);
            } 
        }

        public IList<Locacao> BuscarAtivos()
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Locacao.Include("Jogo").Include("Cliente").Where(p => p.Situacao == Situacao.ATIVO).ToList();
            } 
        }

        public int RetornarIdLocacao(Jogo jogo)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                return db.Locacao.FirstOrDefault(p => p.IdJogo == jogo.Id && p.Situacao == Situacao.ATIVO).Id;
            } 
        }
    }
}
