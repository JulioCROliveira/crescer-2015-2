using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class UsuarioRepositorio : IRepositorioUsuario
    {
        public Usuario BuscarPorEmail(string email)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                if (email == null) { return null; }
                return db.Usuario.Include("Permissoes").FirstOrDefault(u => u.Email == email);
            } 
        }

        public bool Cadastrar(Usuario usuario)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                if (db.Usuario.FirstOrDefault(u => u.Email == usuario.Email) != null) { return false; }
                db.Entry(usuario).State = System.Data.Entity.EntityState.Added;

                db.SaveChanges();
                return true;
            }
        }

        public bool AdicionarPermissao(Usuario usuario, Permissao permissao)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                if (db.Usuario.FirstOrDefault(u => u.Email == usuario.Email) == null
                    || db.Permissao.FirstOrDefault(p => p.Nome == permissao.Nome) == null) { return false; }
                usuario.Permissoes.Add(permissao);
                db.Entry(usuario).State = System.Data.Entity.EntityState.Modified;
                db.Entry(permissao).State = System.Data.Entity.EntityState.Unchanged;

                db.SaveChanges();
                return true;
            }
        }

        public bool RemoverPermissao(Usuario usuario, Permissao permissao)
        {
            using (BancoDeDados db = new BancoDeDados())
            {
                if (db.Usuario.FirstOrDefault(u => u.Email == usuario.Email) == null
                    || db.Permissao.FirstOrDefault(p => p.Nome == permissao.Nome) == null) { return false; }
                usuario.Permissoes.Remove(permissao);
                db.Entry(usuario).State = System.Data.Entity.EntityState.Modified;
                db.Entry(permissao).State = System.Data.Entity.EntityState.Unchanged;

                db.SaveChanges();
                return true;
            }
        }
    }
}
