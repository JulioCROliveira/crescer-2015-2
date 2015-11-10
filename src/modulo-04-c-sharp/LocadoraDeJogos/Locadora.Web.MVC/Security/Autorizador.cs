using Locadora.Web.MVC.Security.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Security
{
    public class Autorizador : AuthorizeAttribute
    {
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            UsuarioModel usuarioLogado = filterContext.HttpContext.Session["USUARIO_LOGADO"] as UsuarioModel;

            if (usuarioLogado != null)
            {
                var identidade = new GenericIdentity(usuarioLogado.Email);
                string[] roles = usuarioLogado.Permissoes;

                var principal = new GenericPrincipal(identidade, roles);

                Thread.CurrentPrincipal = principal;
                HttpContext.Current.User = principal;

                base.OnAuthorization(filterContext);
            } else
            {
                HandleUnauthorizedRequest(filterContext);
            }            
        }
    }
}