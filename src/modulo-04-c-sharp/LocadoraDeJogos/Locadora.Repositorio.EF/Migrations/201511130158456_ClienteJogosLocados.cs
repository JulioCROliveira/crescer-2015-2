namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ClienteJogosLocados : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Cliente", "JogosLocados", c => c.Int(nullable: false));
        }
        
        public override void Down()
        {
            DropColumn("dbo.Cliente", "JogosLocados");
        }
    }
}
