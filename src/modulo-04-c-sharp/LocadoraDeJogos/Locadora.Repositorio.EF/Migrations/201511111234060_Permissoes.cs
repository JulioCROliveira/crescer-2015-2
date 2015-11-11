namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Permissoes : DbMigration
    {
        public override void Up()
        {
            CreateIndex("dbo.Usuario", "Email", true, "UK_Usuario_Email");

            Sql("insert into Permissao (nome) values ('DescricaoJogo')");
            Sql("insert into Permissao (nome) values ('EditarJogo')");
        }
        
        public override void Down()
        {
            DropIndex("dbo.Usuario", "UK_Usuario_Email");
            Sql("delete from Permissao where nome = 'DescricaoJogo'");
            Sql("delete from Permissao where nome = 'EditarJogo'");
        }
    }
}
