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
        BancoDeDados db = new BancoDeDados();

        public Usuario BuscarPorEmail(string email)
        {
            using (db)
            {
                return db.Usuario.Include("Permissao").Where(u => u.Email == email).FirstOrDefault();
            } 
        }

        public bool Cadastrar(Usuario usuario)
        {
            using (db)
            {
                if (db.Usuario.Where(u => u.Email == usuario.Email).FirstOrDefault() != null) { return false; }
                db.Entry(usuario).State = System.Data.Entity.EntityState.Added;

                db.SaveChanges();
                return true;
            }
        }

        public bool AdicionarPermissao(Usuario usuario, Permissao permissao)
        {
            using (db)
            {
                if (db.Usuario.Where(u => u.Email == usuario.Email).FirstOrDefault() == null
                    || db.Permissao.Where(p => p.Nome == permissao.Nome).FirstOrDefault() == null) { return false; }
                usuario.Permissoes.Add(permissao);
                db.Entry(usuario).State = System.Data.Entity.EntityState.Modified;
                db.Entry(permissao).State = System.Data.Entity.EntityState.Unchanged;

                db.SaveChanges();
                return true;
            }
        }

        public bool RemoverPermissao(Usuario usuario, Permissao permissao)
        {
            using (db)
            {
                if (db.Usuario.Where(u => u.Email == usuario.Email).FirstOrDefault() == null
                    || db.Permissao.Where(p => p.Nome == permissao.Nome).FirstOrDefault() == null) { return false; }
                usuario.Permissoes.Remove(permissao);
                db.Entry(usuario).State = System.Data.Entity.EntityState.Modified;
                db.Entry(permissao).State = System.Data.Entity.EntityState.Unchanged;

                db.SaveChanges();
                return true;
            }
        }
    }
}
