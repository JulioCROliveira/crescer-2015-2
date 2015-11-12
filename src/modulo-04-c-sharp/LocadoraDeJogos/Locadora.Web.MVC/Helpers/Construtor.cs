using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Serviços;
using Locadora.Repositorio.EF;
using Locadora.Repositorio.EF.Repositorios;
using Locadora.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Helpers
{
    public class Construtor
    {
        public static IRepositorio<Jogo> CriarJogoRepositorio()
        {
            return new JogoRepositorio();
        }

        public static IRepositorio<Selo> CriarSeloRepositorio()
        {
            return new SeloRepositorio();
        }

        public static IRepositorioUsuario CriarUsuarioRepositorio()
        {
            return new UsuarioRepositorio();
        }

        public static IServicoCriptografia CriarServicoCriptografia()
        {
            return new ServicoCriptografia();
        }

        public static ServicoAutenticacao CriarServicoAutenticacao()
        {
            return new ServicoAutenticacao(CriarUsuarioRepositorio(), CriarServicoCriptografia());
        }
    }
}