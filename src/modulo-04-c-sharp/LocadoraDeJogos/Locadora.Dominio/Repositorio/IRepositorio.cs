using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IRepositorio<T>
    {
        IList<T> BuscarPorNome(string nome);
        IList<T> BuscarTodos();
        int Criar(T jogo);
        int Atualizar(T jogo);
        int Excluir(int id);
        T BuscarPorId(int id);
    }
}
