using Locadora.Dominio.Serviços;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;

namespace Locadora.Infraestrutura.Servicos
{
    public class ServicoCriptografia : IServicoCriptografia
    {
        private byte[] cc = new byte[] { 71, 62, 77, 162, 10, 103,180 };

        public string CriptografarSenha(string senha)
        {           
            byte[] saltBytes = cc;
            byte[] plainTextBytes = Encoding.UTF8.GetBytes(senha);
            byte[] plainTextWithSaltBytes = 
                    new byte[plainTextBytes.Length + saltBytes.Length];
            for (int i=0; i < plainTextBytes.Length; i++)
                plainTextWithSaltBytes[i] = plainTextBytes[i];
            for (int i=0; i < saltBytes.Length; i++)
                plainTextWithSaltBytes[plainTextBytes.Length + i] = saltBytes[i];
            HashAlgorithm hash = new SHA512Managed();
            byte[] hashBytes = hash.ComputeHash(plainTextWithSaltBytes);
            byte[] hashWithSaltBytes = new byte[hashBytes.Length + 
                                                saltBytes.Length];
            for (int i=0; i < hashBytes.Length; i++)
                hashWithSaltBytes[i] = hashBytes[i];
            for (int i=0; i < saltBytes.Length; i++)
                hashWithSaltBytes[hashBytes.Length + i] = saltBytes[i];
            string hashValue = Convert.ToBase64String(hashWithSaltBytes);

            return hashValue;
        }
    }
}