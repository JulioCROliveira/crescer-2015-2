using System;
using System.Collections.Generic;

namespace ConsoleAPP
{
    public class Agenda
    {
        private List<Contato> contatos = new List<Contato>();

        public int QuantidadeDeCotatos { get { return contatos.Count; } }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        //public void RemoverContato(string nomeContato)
        //{
        //    foreach (var contato in contatos)
        //    {
        //        if (contato.nome == nomeContato)
        //        {
        //            contatos.Remove(contato);
        //            break;
        //        }
        //    }
        //}

        public void RemoverContato(string nomeContato)
        {
            var contatoARemover = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].nome == nomeContato)
                {
                    contatoARemover.Add(contatos[i]);
                }
            }

            foreach (var contato in contatoARemover)
            {
                contatos.Remove(contato);
            }
        }

        public void RemoverContato(int numeroContato)
        {
            var contatoARemover = new List<Contato>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].numero == numeroContato)
                {
                    contatoARemover.Add(contatos[i]);
                }
            }

            foreach (var contato in contatoARemover)
            {
                contatos.Remove(contato);
            }
        }

        public string ListarContatos()
        {
            string listaDeContatos = "";
            foreach (var contato in contatos)
            {
                listaDeContatos += contato.nome + " " + contato.numero+"\r\n";
            }
            return listaDeContatos;
        }

        public string ListarContatosOrdenadoPorNome()
        {
            contatos.Sort(
                delegate (Contato p1, Contato p2)
                {
                    return p1.nome.CompareTo(p2.nome);
                }
            );
            string listaDeContatos = "";
            foreach (var contato in contatos)
            {
                listaDeContatos += contato.nome + " " + contato.numero + "\r\n";
            }
            return listaDeContatos;
        }

        public static implicit operator List<object>(Agenda v)
        {
            throw new NotImplementedException();
        }
    }
}
