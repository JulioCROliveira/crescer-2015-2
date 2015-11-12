namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class SeloAlteração : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Selo", "Preco", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdSelo", "dbo.Selo");
            DropIndex("dbo.Jogo", new[] { "IdSelo" });
            DropTable("dbo.Selo");
        }
    }
}
