namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class SeloDuracaoLocacao : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Selo", "DiasLocacao", c => c.Int(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Selo", "DiasLocacao");
        }
    }
}
