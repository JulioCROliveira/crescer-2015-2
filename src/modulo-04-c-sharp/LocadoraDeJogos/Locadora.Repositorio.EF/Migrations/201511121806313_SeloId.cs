namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class SeloId : DbMigration
    {
        public override void Up()
        {
            RenameColumn(table: "dbo.Selo", name: "IdSelo", newName: "Id");
        }
        
        public override void Down()
        {
            RenameColumn(table: "dbo.Selo", name: "Id", newName: "IdSelo");
        }
    }
}
