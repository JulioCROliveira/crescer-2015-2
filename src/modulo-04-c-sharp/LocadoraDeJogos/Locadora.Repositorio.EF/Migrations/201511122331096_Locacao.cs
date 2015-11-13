namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Locacao : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Situacao",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false, maxLength: 24)
                })
                .PrimaryKey(t => t.Id)
                .Index(i => i.Nome, "UK_Situacao_Nome", true);

            Sql("insert into dbo.Situacao (Id, Nome) values (1, 'ATIVO')");
            Sql("insert into dbo.Situacao (Id, Nome) values (2, 'ENTREGUE')");

            CreateTable(
                "dbo.Locacao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        IdJogo = c.Int(nullable: false),
                        IdCliente = c.Int(nullable: false),
                        IdSituacao = c.Int(nullable: false),
                        DataEntrega = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .ForeignKey("dbo.Jogo", t => t.IdJogo, cascadeDelete: true)
                .ForeignKey("dbo.Situacao", t => t.IdSituacao, cascadeDelete: true)
                .Index(t => t.IdJogo)
                .Index(t => t.IdCliente);
            
            AddColumn("dbo.Jogo", "IdLocacao", c => c.Int());
            CreateIndex("dbo.Jogo", "IdLocacao");
            AddForeignKey("dbo.Jogo", "IdLocacao", "dbo.Locacao", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdLocacao", "dbo.Locacao");
            DropForeignKey("dbo.Locacao", "IdJogo", "dbo.Jogo");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropIndex("dbo.Locacao", new[] { "IdJogo" });
            DropIndex("dbo.Jogo", new[] { "IdLocacao" });
            DropColumn("dbo.Jogo", "IdLocacao");
            DropTable("dbo.Situacao");
            DropTable("dbo.Locacao");
        }
    }
}
