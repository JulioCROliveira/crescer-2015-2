function CarrinhoDeComprasChantagista() {
	CarrinhoDeCompras.apply(this);
}

CarrinhoDeComprasChantagista.prototype = Object.create(CarrinhoDeCompras.prototype);

CarrinhoDeComprasChantagista.prototype.forcarCompra = function() {
	if (!this.intervalo) {
		var self = this;
		this.intervalo = setInterval(function () {
			self.carrinho.map(function(elem) {
				return elem.valorUnitario *= 1.1;
			});
			console.log(self.carrinho);
		}, 5000);
	}
};

CarrinhoDeComprasChantagista.prototype.concluirPedido = function() {
	clearInterval(this.intervalo);
	delete this.intervalo;
}