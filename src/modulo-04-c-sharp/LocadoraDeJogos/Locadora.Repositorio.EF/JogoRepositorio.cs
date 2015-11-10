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
    public class JogoRepositorio : IJogoRepositorio
    {
        BancoDeDados db = new BancoDeDados();

        public int Atualizar(Jogo entidade)
        {
            using (db)
            {
                Jogo jogoAAtualizar = db.Jogo.Include("Cliente").FirstOrDefault(j => j.Id == entidade.Id);
                if (jogoAAtualizar == null) { return 0; }
                jogoAAtualizar = entidade;
                //jogoAAtualizar.Nome = entidade.Nome;
                //jogoAAtualizar.Preco = entidade.Preco;
                //jogoAAtualizar.Categoria = entidade.Categoria;
                //jogoAAtualizar.Cliente = entidade.Cliente;
                //jogoAAtualizar.Descricao = entidade.Descricao;
                //jogoAAtualizar.Selo = entidade.Selo;
                //jogoAAtualizar.Imagem = entidade.Imagem;
                //jogoAAtualizar.Video = entidade.Video;
                db.Entry(jogoAAtualizar).State = System.Data.Entity.EntityState.Modified;

                db.SaveChanges();
                return 1;
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (db)
            {
                return db.Jogo.Include("Cliente").FirstOrDefault(j => j.Id == id);
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (db)
            {
                return db.Jogo.Include("Cliente").Where(j => j.Nome.IndexOf(nome, StringComparison.OrdinalIgnoreCase) > 0).ToList();
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (db)
            {
                return db.Jogo.Include("Cliente").ToList();
            }
        }

        public int Criar(Jogo entidade)
        {
            using (db)
            {
                db.Entry(entidade).State = System.Data.Entity.EntityState.Added;
                db.SaveChanges();
                return 1;
            }
        }

        public int Excluir(int id)
        {
            using (db)
            {
                Jogo jogoAExcluir = db.Jogo.Find(id);
                db.Entry(jogoAExcluir).State = System.Data.Entity.EntityState.Deleted;
                db.SaveChanges();
                return 1;
            }
        }
    }
}
