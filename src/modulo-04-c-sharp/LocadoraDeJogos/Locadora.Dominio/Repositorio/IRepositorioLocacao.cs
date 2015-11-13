using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IRepositorioLocacao
    {
        IList<Locacao> BuscarPorJogo(Jogo jogo);
        IList<Locacao> BuscarTodos();
        int Criar(Locacao locacao);
        int DevolverJogo(Locacao locacao);
        Locacao BuscarPorId(int id);
        IList<Locacao> BuscarAtivos();
        int RetornarIdLocacao(Jogo jogo);
    }
}
