function Item(sku, descricao, quantidade, valorUnitario) {
	this.sku = sku;
	this.descricao = descricao;
	this.quantidade = quantidade;
	this.valorUnitario = valorUnitario;
};

function CarrinhoDeCompras() {
	this.carrinho = new Array();
	
	CarrinhoDeCompras.prototype.adicionarItem = function (item) {
		if (item.instanceof CarrinhoDeCompras) {
			this.carrinho.push(item);
		} else {
			return 'Insira um parametro do tipo Item';
		}
	};
};