using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data.Entity.ModelConfiguration;

namespace Locadora.Repositorio
{
    class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LOCADORA_NOVA")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Permissao> Permissao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            base.OnModelCreating(modelBuilder);
        }
    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");
            HasKey(c => c.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(200);
            Property(p => p.Preco).IsRequired();
            Property(p => p.Categoria).IsRequired().HasColumnName("IdCategoria");
            //HasRequired(p => p.Cliente).WithOptional().Map(m => m.MapKey("IdClienteLocacao"));
            HasOptional(p => p.Cliente).WithOptionalDependent().Map(m => m.MapKey("IdClienteLocacao"));
            Property(p => p.Descricao).IsRequired().HasMaxLength(300);
            Property(p => p.Selo).IsRequired().HasColumnName("IdSelo");
            Property(p => p.Imagem).IsOptional().HasMaxLength(128);
            Property(p => p.Video).IsOptional().HasMaxLength(128);
        }
    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");
            HasKey(c => c.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(250);
        }
    }

    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");

            HasKey(c => c.Id);

            Property(p => p.Email).IsRequired().HasMaxLength(256);
            Property(p => p.Senha).IsRequired().HasMaxLength(256);
            Property(p => p.NomeCompleto).IsRequired().HasMaxLength(256);

            HasMany(u => u.Permissoes).WithMany(p => p.Usuarios).Map(m =>
            {
                m.ToTable("Usuario_Permissao");
                m.MapLeftKey("IdUsuario");
                m.MapRightKey("IdPermissao");
            });
        }
    }

    class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permissao");

            HasKey(c => c.Id);

            Property(p => p.nome).IsRequired().HasMaxLength(256);
        }
    }
}
