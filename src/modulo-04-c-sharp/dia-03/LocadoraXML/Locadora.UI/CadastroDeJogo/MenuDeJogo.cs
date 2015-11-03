﻿using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.UI.CadastroDeJogo
{
    abstract class MenuDeJogo : TelaBase
    {
        private Dictionary<int, Categoria> menuCategorias;
        
        public MenuDeJogo()
        {
            MontarMenuCategorias();
        }

        protected void AtualizarDadosDoJogo(Jogo jogo)
        {
            Console.WriteLine("Insira os dados do jogo:");
            string nome = LerNome();
            double preco = LerPreco();
            Categoria categoria = LerCaregoria();

            jogo.Nome = nome;
            jogo.Preco = preco;
            jogo.Categoria = categoria;
        }

        protected abstract void SalvarJogo(Jogo jogo);

        private double LerPreco()
        {
            while (true)
            {
                string preco = LerDados("Preço");
                double precoConvertido = 0;

                if (double.TryParse(preco, out precoConvertido))
                {
                    return precoConvertido;
                }

                ImprimirErro("Informe um preço válido...");
            }
        }

        private string LerNome()
        {
            while (true)
            {
                string nome = LerDados("Nome");

                if (String.IsNullOrWhiteSpace(nome))
                {
                    ImprimirErro("O nome é obrigatório.");
                }
                else
                {
                    return nome;
                }
            }
        }

        private Categoria LerCaregoria()
        {
            while (true)
            {
                Console.WriteLine("Escolha a categoria:");

                foreach (var cat in menuCategorias)
                {
                    Console.WriteLine(String.Format("{0} - {1}", cat.Key, Enum.GetName(typeof(Categoria), cat.Value)));
                }

                string valorEscolhido = LerDados("Escolher");
                int categoriaEscolhida = 0;

                if (int.TryParse(valorEscolhido, out categoriaEscolhida))
                {
                    if (menuCategorias.ContainsKey(categoriaEscolhida))
                    {
                        return (Categoria)categoriaEscolhida;
                    }
                }

                ImprimirErro("Categoria inválida...");
                Console.WriteLine();
            }
        }

        private void MontarMenuCategorias()
        {
            menuCategorias = new Dictionary<int, Categoria>();

            foreach (int item in Enum.GetValues(typeof(Categoria)))
            {
                menuCategorias.Add(item, (Categoria)item);
            }
        }

    }
}
