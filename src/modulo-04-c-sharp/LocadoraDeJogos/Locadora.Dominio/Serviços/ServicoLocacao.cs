using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Serviços
{
    public class ServicoLocacao
    {
        public const int MAX_JOGOS_POR_PESSOA = 3;
        public const decimal MULTA_DIARIA = 5m;

        private IRepositorio<Jogo> jogoRepositorio;
        private IRepositorio<Cliente> clienteRepositorio;
        private IRepositorioLocacao locacaoRepositorio;

        public ServicoLocacao(IRepositorio<Jogo> jogoRepositorio, IRepositorio<Cliente> clienteRepositorio, IRepositorioLocacao locacaoRepositorio)
        {
            this.jogoRepositorio = jogoRepositorio;
            this.clienteRepositorio = clienteRepositorio;
            this.locacaoRepositorio = locacaoRepositorio;
        }

        public void LocarJogo(Jogo jogo, Cliente cliente)
        {
            Locacao locacao = new Locacao(jogo, cliente, CalcularDataEntrega(jogo));
            int idLocacao = locacaoRepositorio.LocarJogo(locacao);
            jogo.IdLocacao = idLocacao;
            jogoRepositorio.Atualizar(jogo);
        }

        public void DevolverJogo(Locacao locacao)
        {
            jogoRepositorio.BuscarPorId(locacao.IdJogo).IdLocacao = null;
            locacaoRepositorio.DevolverJogo(locacao);
        }

        public decimal CalcularValor(Locacao locacao)
        {
            int atraso = (new DateTime().Subtract(locacao.DataEntrega)).Days;
            decimal multa = atraso > 0 ? atraso * MULTA_DIARIA : 0;
            return locacao.Jogo.Selo.Preco + multa;
        }

        private DateTime CalcularDataEntrega(Jogo jogo)
        {
            return new DateTime().AddDays((double)jogo.Selo.DiasLocacao);
        }
    }
}
