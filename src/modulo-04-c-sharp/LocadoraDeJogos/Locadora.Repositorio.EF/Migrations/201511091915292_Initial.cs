namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                    })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    IdCategoria = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false, maxLength: 64),
                })
                .PrimaryKey(t => t.IdCategoria);

            Sql("insert into Categoria(IdCategoria, Nome) values (1,'RPG');");
            Sql("insert into Categoria(IdCategoria, Nome) values (2,'CORRIDA');");
            Sql("insert into Categoria(IdCategoria, Nome) values (3,'AVENTURA');");
            Sql("insert into Categoria(IdCategoria, Nome) values (4,'LUTA');");
            Sql("insert into Categoria(IdCategoria, Nome) values (5,'ESPORTE');");

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    IdSelo = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false, maxLength: 16),
                })
                .PrimaryKey(t => t.IdSelo);

            Sql("insert into Selo(IdSelo, Nome) values (1,'OURO');");
            Sql("insert into Selo(IdSelo, Nome) values (2,'PRATA');");
            Sql("insert into Selo(IdSelo, Nome) values (3,'BRONZE');");
            
            CreateTable(
                "dbo.Jogo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 200),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCategoria = c.Int(nullable: false),
                        Descricao = c.String(nullable: false, maxLength: 300),
                        IdSelo = c.Int(nullable: false),
                        Imagem = c.String(maxLength: 128),
                        Video = c.String(maxLength: 128),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Categoria", t => t.IdCategoria)
                .ForeignKey("dbo.Selo", t => t.IdSelo)
                .Index(t => t.IdCategoria)
                .Index(t => t.IdSelo);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdCategoria", "dbo.Categoria");
            DropForeignKey("dbo.Jogo", "IdSelo", "dbo.Selo");
            DropIndex("dbo.Jogo", new[] { "IdCategoria" });
            DropIndex("dbo.Jogo", new[] { "IdSelo" });
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
            DropTable("dbo.Categoria");
            DropTable("dbo.Selo");
        }
    }
}
