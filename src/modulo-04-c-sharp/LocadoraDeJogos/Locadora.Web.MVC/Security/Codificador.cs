﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;

namespace Locadora.Web.MVC.Security
{
    public class Codificador
    {
        private byte[] cc = new byte[] { 71, 62, 77, 162, 10, 103,180 };
        public string ComputeHash(string plainText, byte[] saltBytes)
        {
            if (saltBytes == null)
            {
                //int minSaltSize = 4;
                //int maxSaltSize = 8;
                //Random  random = new Random();
                //int saltSize = random.Next(minSaltSize, maxSaltSize);            
                saltBytes = cc;
                //RNGCryptoServiceProvider rng = new RNGCryptoServiceProvider();
                //rng.GetNonZeroBytes(saltBytes);
            }
            byte[] plainTextBytes = Encoding.UTF8.GetBytes(plainText);
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

        public bool VerifyHash(string plainText, string hashValue)
        {
            byte[] hashWithSaltBytes = Convert.FromBase64String(hashValue);
            int hashSizeInBytes = 64;
            if (hashWithSaltBytes.Length < hashSizeInBytes) { return false; }
            byte[] saltBytes = new byte[hashWithSaltBytes.Length - hashSizeInBytes];
            for (int i = 0; i < saltBytes.Length; i++)
            {
                saltBytes[i] = hashWithSaltBytes[hashSizeInBytes + i];
            }
            string expectedHashString = ComputeHash(plainText, saltBytes);

            return (hashValue == expectedHashString);
        }
    }
}