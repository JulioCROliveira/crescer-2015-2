using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Xml.Linq;
using System.Xml;
using System.IO;

namespace LocadoraDeJogos.Dominio
{
    public class ListaDeJogos
    {
        private const string enderecoJogo = @"C:\Users\juliocesar\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\xml\game_store.xml";
        Categoria categoria = new Categoria();

        public string Listar()
        {
            string lista = String.Empty;
            XElement XMLJogos = CarregarXML();
            var jogos = XMLJogos.Elements("jogo");

            foreach (var jogo in jogos)
            {
                lista += ParseFromXElement(jogo).ToString();
            }
            
            return lista;
        }

        public List<JogoModel> GetListaDeJogos()
        {
            List<JogoModel> lista = new List<JogoModel>();
            XElement XMLJogos = CarregarXML();
            var jogos = XMLJogos.Elements("jogo");

            foreach (var jogo in jogos)
            {
                lista.Add(ParseFromXElement(jogo));
            }

            return lista;
        }

        public List<JogoModel> BuscarPorNome(string nome)
        {
            List<JogoModel> lista = new List<JogoModel>();
            XElement XMLJogos = CarregarXML();
            var jogos = XMLJogos.Elements("jogo").Where(jogo => jogo.Element("nome").Value.ContainsNoCaseSensitive(nome));

            foreach (var jogo in jogos)
            {
                lista.Add(ParseFromXElement(jogo));
            }

            return lista;
        }

        public JogoModel BuscarPorId(int id)
        {
            List<JogoModel> lista = new List<JogoModel>();
            XElement XMLJogos = CarregarXML();
            IEnumerable<XElement> jogos = XMLJogos.Elements("jogo").Where(jogo => int.Parse(jogo.Attribute("id").Value) == id);

            foreach (var jogo in jogos)
            {
                lista.Add(ParseFromXElement(jogo));
            }

            return lista[0];
        }

        private XElement CarregarXML()
        {            
            XElement XMLJogos = XElement.Load(enderecoJogo);
            return XMLJogos;
        }

        public JogoModel ParseFromXElement(XElement jogo)
        {
            return new JogoModel(int.Parse(jogo.Attribute("id").Value), jogo.Element("nome").Value, 
                double.Parse(jogo.Element("preco").Value.Replace('.', ',')), int.Parse(jogo.Element("categoria").Value));
        }

        public XmlDocument ConverteEInsereNoXML(JogoModel jogoModelo)
        {
            XmlDocument XMLJogos = new XmlDocument();
            XMLJogos.Load(enderecoJogo);
            string jogoAAdicionar = string.Format("{0}    <nome>{1}</nome>{0}    <preco>{2}</preco>{0}    <categoria>{3}</categoria>{0}  ", "\r\n", 
                jogoModelo.Nome, jogoModelo.Preco.ToString().Replace(',', '.'), jogoModelo.CategoriaDoJogo);
            XmlNode jogo = XMLJogos.CreateElement("jogo");
            XmlAttribute atrId = XMLJogos.CreateAttribute("id");
            atrId.Value = jogoModelo.Id.ToString();
            jogo.Attributes.Append(atrId);
            jogo.InnerXml = jogoAAdicionar;
            XMLJogos.ChildNodes[1].AppendChild(jogo);

            return XMLJogos;
        }

        public string ToString(List<JogoModel> lista)
        {
            string listaDeJogos = String.Empty;
            foreach (var jogo in lista)
            {
                listaDeJogos += jogo.ToString() + "\r\n";
            }
            return listaDeJogos;
        }

        public int Adicionar(string nome, double preco, int categoria)
        {
            try
            {
                int id = getProximoId();
                JogoModel jogoModelo = new JogoModel(id, nome, preco, categoria);
                XmlDocument XMLJogos = ConverteEInsereNoXML(jogoModelo);                
                XMLJogos.Save(enderecoJogo);
                return id;
            }            
            catch (Exception erro)
            {
                CustomExceptionLogger.GerarLog(erro);
                return 0;
            }
        }

        public void Modificar(int id, string nome, double preco, int categoria)
        {
            try
            {
                XElement XMLJogos = CarregarXML();
                foreach (XElement jogo in XMLJogos.Elements("jogo"))
                {
                    if (jogo.Attribute("id").Value == id.ToString())
                    {
                        if (nome != String.Empty) { jogo.Element("nome").Value = nome.ToString(); }
                        if (preco >= 0) { jogo.Element("preco").Value = preco.ToString().Replace(',', '.'); }
                        if (categoria >= 0) { jogo.Element("categoria").Value = categoria.ToString(); }
                        break;
                    }
                }

                XMLJogos.Save(enderecoJogo);                
            }
            catch (Exception erro)
            {
                CustomExceptionLogger.GerarLog(erro);         
            }
        }

        public int getProximoId()
        {
            XElement XMLJogos = CarregarXML();
            var jogos = XMLJogos.Elements("jogo");
            return XMLJogos.Descendants("jogo").Max(x => (int)x.Attribute("id")) + 1;
        }

        public void ExportarRelatorio()
        {
            string localDoArquivo = @"C:\Users\juliocesar\Documents\crescer-2015-2\src\modulo-04-c-sharp\dia-03\LocadoraDeJogos\log\relatorio.txt";

            File.WriteAllText(localDoArquivo, String.Empty);
            File.AppendAllText(localDoArquivo, EscreverRelatorio());            
        }

        public string EscreverRelatorio()
        {            
            XElement XMLJogos = CarregarXML();
            var jogos = XMLJogos.Elements("jogo");
            double maisCaro = 0, maisBarato = 9999, media = 0;
            string nomeCaro = String.Empty, nomeBarato = String.Empty;
            int quantidadeDeJogos = 0;

            string relatorio = String.Empty;
            
            relatorio += string.Format("{0}LOCADORA TOP GAMES{1}", "                             ", "\r\n");
            relatorio += string.Format("{0:dd/MM/yyy}                                                              {0:hh:mm:ss}{1}", DateTime.Now, "\r\n");
            relatorio += string.Format("{0}Relatório de jogos{1}", "                              ", "\r\n");
            relatorio += string.Format("================================================================================\r\n");
            relatorio += string.Format("ID       Categoria        Nome                          Preço         Disponivel\r\n");
            foreach (var jogo in jogos)
            {
                relatorio += string.Format("{0,-9}{1,-17}{2,-30}R$ {3,6:0.00}{4,14}{5}", jogo.Attribute("id").Value,
                    categoria.ConverterEntreValores(int.Parse(jogo.Element("categoria").Value)).ToUpper(),
                    jogo.Element("nome").Value.ToUpper(), double.Parse(jogo.Element("preco").Value.Replace('.', ',')), "SIM", "\r\n");
                quantidadeDeJogos++;
                media += double.Parse(jogo.Element("preco").Value.Replace('.', ','));
                if (double.Parse(jogo.Element("preco").Value.Replace('.', ',')) > maisCaro)
                {
                    nomeCaro = jogo.Element("nome").Value.ToUpper();
                    maisCaro = double.Parse(jogo.Element("preco").Value.Replace('.', ','));
                }
                if (double.Parse(jogo.Element("preco").Value.Replace('.', ',')) < maisBarato)
                {
                    nomeBarato = jogo.Element("nome").Value.ToUpper();
                    maisBarato = double.Parse(jogo.Element("preco").Value.Replace('.', ','));
                }
            }
            media /= quantidadeDeJogos;
            relatorio += "--------------------------------------------------------------------------------\r\n";
            relatorio += string.Format("Quantidade total de jogos: {0}{1}", quantidadeDeJogos, "\r\n");
            relatorio += string.Format("Quantidade de jogos disponíveis: {0}{1}", quantidadeDeJogos, "\r\n");
            relatorio += string.Format("Valor médio por jogo: R$ {0:.00}{1}", media, "\r\n");
            relatorio += string.Format("Jogo mais caro: {0}{1}", nomeCaro, "\r\n");
            relatorio += string.Format("Jogo mais barato: {0}{1}", nomeBarato, "\r\n");
            relatorio += "================================================================================\r\n";

            return relatorio;
        }
    }
}
