using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Security.Models
{
    public class UsuarioCadastroModel
    {
        [Required]
        [StringLength(256, ErrorMessage= "E-mail não pode conter mais de 256 caracteres")]
        [DataType(DataType.EmailAddress, ErrorMessage = "E-mail não válido")]
        [Display(Name = "E-mail")]
        public string Email { get; private set; }

        [Required]
        [StringLength(256, ErrorMessage = "E-mail não pode conter mais de 256 caracteres")]
        [DataType(DataType.EmailAddress, ErrorMessage = "E-mail não válido")]
        [Compare("Email")]
        [Display(Name = "Confirmação de E-mail")]
        public string ConfirmacaoEmail { get; private set; }

        [Required]
        [StringLength(256, ErrorMessage = "Nome completo não pode conter mais de 256 caracteres")]
        [Display(Name = "Nome completo")]
        public string NomeCompleto { get; private set; }

        [Required]
        [StringLength(256, ErrorMessage = "Senha não pode conter mais de 256 caracteres")]
        [DataType(DataType.Password)]
        public string Senha { get; private set; }

        [Required]
        [StringLength(256, ErrorMessage = "Senha não pode conter mais de 256 caracteres")]
        [DataType(DataType.Password)]
        [Compare("Senha")]
        [Display(Name = "Confirmação da senha")]
        public string VerificacaoSenha { get; private set; }

        public UsuarioCadastroModel(string email, string emailConfirmacao, string nome, string senha, string confirmacaoSenha)
        {
            Email = email;
            ConfirmacaoEmail = emailConfirmacao;
            NomeCompleto = nome;
            Senha = senha;
            VerificacaoSenha = confirmacaoSenha;
        }
    }
}