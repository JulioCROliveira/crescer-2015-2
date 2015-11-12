namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class JogoDescricao2048 : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Jogo", "Descricao", c => c.String(nullable: false, maxLength: 2048));
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Jogo", "Descricao", c => c.String(nullable: false, maxLength: 300));
        }
    }
}
