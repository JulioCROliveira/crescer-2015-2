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
            UsuarioLogado usuarioLogado = filterContext.HttpContext.Session["USUARIO_LOGADO"] as UsuarioLogado;

            if (usuarioLogado != null)
            {
                GenericIdentity myIdentity = new GenericIdentity(usuarioLogado.Email);
                GenericPrincipal principal = new GenericPrincipal(myIdentity, usuarioLogado.Permissoes);

                Thread.CurrentPrincipal =
                    HttpContext.Current.User = principal;

                base.OnAuthorization(filterContext);
            }
            else
            {
                HandleUnauthorizedRequest(filterContext);
            }            
        }
    }
}