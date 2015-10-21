function validarCamposNumericos(campo) {	
	if (isNaN(campo)) {
		throw new Error ('Quantidade e valor devem ser numericos');
	}
	return parseFloat(campo);
};

function Item(sku, descricao, quantidade, valorUnitario) { 
	this.sku = sku; 
	this.descricao = descricao; 
	this.quantidade = validarCamposNumericos(quantidade); 
	this.valorUnitario = validarCamposNumericos(valorUnitario); 
}
 
function CarrinhoDeCompras() { 
	this.carrinho = new Array(); 	 
}

CarrinhoDeCompras.prototype.adicionarItem = function (itemAdd) { 
	if (itemAdd instanceof Item) { 
		for (var i = this.carrinho.length-1, sku = itemAdd.sku; i >= 0; i--) {
			if (this.carrinho[i].sku === sku) {				
				throw new Error ('Item já existe!');
			}
		}
		this.carrinho.push(itemAdd); 
		return itemAdd;
	} else { 
		throw new Error ('Insira um parametro do tipo Item'); 
	} 
}; 

CarrinhoDeCompras.prototype.removerItem = function (sku) { 
	if (typeof sku == "string") { 
		for (var i = this.carrinho.length-1, itemIndex = -1; i >= 0; i--) {
			if (this.carrinho[i].sku === sku) {				
				itemIndex = i;
			}
			if (itemIndex != -1) {
				break;
			}
		}
		if (itemIndex != -1) {			
			this.carrinho.splice(itemIndex, 1);	
			return 'Item removido';
		} else {
			throw new Error ('Item não encontrado.');
		}
	} else {
		throw new Error ('Informa o sku (string)');
	}
}; 

CarrinhoDeCompras.prototype.atualizarQuantidade = function (sku, qtd) { 
	if (typeof sku == "string" && typeof qtd == "number") { 
		for (var i = this.carrinho.length-1, itemIndex = -1; i >= 0; i--) {
			if (this.carrinho[i].sku === sku) {				
				itemIndex = i;
			}
			if (itemIndex != -1) {
				break;
			}
		}
		if (itemIndex != -1) {			
			this.carrinho[itemIndex].quantidade += qtd;
			return 'Item alterado';
		} else {
			throw new Error ('Item não encontrado.');
		}
	} else {
		throw new Error ('Informa o sku (string) e a quantidade (numerico)');
	}
};

CarrinhoDeCompras.prototype.calcularSubTotal = function() {
	var subTotal = new Array();
	var car = this.carrinho;
	for (var i = 0, len = this.carrinho.length; i < len; i++) {
		adicionar = car[i].quantidade 
					+ " " + car[i].descricao 
					+ " R$" + (car[i].quantidade * car[i].valorUnitario).toFixed(2);
		subTotal.push(adicionar);
	}
	return subTotal;
};

CarrinhoDeCompras.prototype.calcularTotal = function() {
	var desconto = '';
	var	total = this.carrinho.reduce(function(total, elem) {
		return total += elem.quantidade * elem.valorUnitario;
	},0);
	if (Math.random() <= 0.4) {
		total *= 0.9;
		desconto = 'com desconto ';
	}
	return 'Valor total ' + desconto + 'R$' + total.toFixed(2);
};