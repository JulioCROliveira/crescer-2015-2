using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraDeJogos.Dominio
{
    public static class StringExtensions
    {
        public static bool ContainsNoCaseSensitive(this string palavra1, string palavra2)
        {
            if (palavra1 != null && palavra2 != null)
            {
                return palavra1.ToUpper().Contains(palavra2.ToUpper());
            }
            return palavra1 == palavra2;
        }
    }
}
