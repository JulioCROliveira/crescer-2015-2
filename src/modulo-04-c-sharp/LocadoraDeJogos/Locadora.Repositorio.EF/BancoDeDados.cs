using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data.Entity.ModelConfiguration;

namespace Locadora.Repositorio.EF
{
    public class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LOCADORA_NOVA")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Permissao> Permissao { get; set; }
        public DbSet<Selo> Selo { get; set; }
        public DbSet<Locacao> Locacao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
            modelBuilder.Configurations.Add(new SeloMap());
            modelBuilder.Configurations.Add(new LocacaoMap());
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
            Property(p => p.Categoria).IsRequired().HasColumnName("IdCategoria");
            //HasRequired(p => p.Cliente).WithOptional().Map(m => m.MapKey("IdClienteLocacao"));
            Property(p =>p.IdLocacao).IsOptional();
            HasOptional(p => p.Locacao).WithMany().HasForeignKey(p => p.IdLocacao);
            Property(p => p.Descricao).IsRequired().HasMaxLength(2048);
            HasRequired(p => p.Selo).WithMany(s => s.Jogos).HasForeignKey(p => p.IdSelo);
            Property(p => p.Imagem).IsOptional().HasMaxLength(128);
            Property(p => p.Video).IsOptional().HasMaxLength(128);
        }
    }

    class SeloMap : EntityTypeConfiguration<Selo>
    {
        public SeloMap()
        {
            ToTable("Selo");
            HasKey(c => c.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(16).HasColumnName("Nome");
            Property(p => p.Preco).IsRequired().HasPrecision(18,2);
            Property(p => p.DiasLocacao).IsRequired();
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

    class LocacaoMap : EntityTypeConfiguration<Locacao>
    {
        public LocacaoMap()
        {
            ToTable("Locacao");
            HasKey(c => c.Id);

            HasRequired(p => p.Jogo).WithMany().HasForeignKey(p => p.IdJogo);
            HasRequired(p => p.Cliente).WithMany().HasForeignKey(p => p.IdCliente);
            Property(p => p.Situacao).IsRequired().HasColumnName("IdSituacao");
            Property(p => p.DataEntrega).IsRequired();
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

            Property(p => p.Nome).IsRequired().HasMaxLength(256);
        }
    }
}
