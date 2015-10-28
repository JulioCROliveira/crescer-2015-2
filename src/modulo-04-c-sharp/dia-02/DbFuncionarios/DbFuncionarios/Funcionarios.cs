﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class Funcionarios
    {
        private static BaseDeDados baseDeDados = new BaseDeDados();
        private List<Funcionario> listaFuncionarios = baseDeDados.Funcionarios;

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return listaFuncionarios.OrderBy(funcionario => funcionario.Cargo.Titulo).ToList();
        }

        public List<Funcionario> BuscarPorNome(string nome)
        {
            if (nome == null) {
                return null;
            }
            return listaFuncionarios.Where(funcionario => funcionario.Nome.Contains(nome)).OrderBy(funcionario => funcionario.Nome).ToList();
        }
               
        public dynamic BuscaRapida(string nome)
        {
            dynamic query = (from func in listaFuncionarios where func.Nome == nome select new {Nome = func.Nome, Cargo = func.Cargo.Titulo}).ToList();
            return query;
        }
    }
}
