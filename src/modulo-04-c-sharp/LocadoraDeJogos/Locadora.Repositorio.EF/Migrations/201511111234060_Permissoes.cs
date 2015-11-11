namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Permissoes : DbMigration
    {
        public override void Up()
        {
            CreateIndex("dbo.Usuario", "Email", true, "UK_Usuario_Email");

            Sql("insert into Permissao (nome) values ('ADMIN')");
            Sql("insert into Permissao (nome) values ('OPERADOR')");
            Sql("insert into Usuario (Email, NomeCompleto, Senha) values ('admin@top.com', 'Admin', 'nOGwsQYJQ23RVPqipyv/tu9NnkNio9L7+Tb2A9FcuDzeTczDfqEsHDNds1DiREuuX6qd6aUUiIPDdaY6blyThUc+TaIKZ7Q=')");
            Sql("insert into Usuario (Email, NomeCompleto, Senha) values ('operador@top.com', 'Operador', 'XGJf/Lf130nyoh3Mqh7C3tEbPEwdrtexQF7aGfA8yOkhHCUHzYylvtbmAOFHGFEkKdTk4BgznWrbStydJGDzlUc+TaIKZ7Q=')");
            Sql("insert into Usuario_Permissao (IdUsuario, IdPermissao) values (1,1)");
            Sql("insert into Usuario_Permissao (IdUsuario, IdPermissao) values (1,2)");
            Sql("insert into Usuario_Permissao (IdUsuario, IdPermissao) values (2,2)");
        }
        
        public override void Down()
        {
            DropIndex("dbo.Usuario", "UK_Usuario_Email");
            Sql("delete from Permissao where nome = 'ADMIN'");
            Sql("delete from Permissao where nome = 'OPERADOR'");
        }
    }
}
