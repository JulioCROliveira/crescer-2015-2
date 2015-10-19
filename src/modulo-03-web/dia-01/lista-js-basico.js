function daisyGame(n) {
	var texto = 'Parametro não numerico';
	if (!isNaN(n)) {		
		if ((n % 2) === 0) {
			texto = 'Love me not';
		} else {
			texto = 'Love me';
		}
	}
	return texto;
};

//====================================

function maiorTexto(arr) {
	var maior = 0;
	var texto = 'Nenhuma array inserido';
	if (arr.constructor == Array) {
		for (var i = 0; i < arr.length; i++) {
			if (arr[i].length > maior) {
				maior = arr[i].length;
				texto = arr[i];
			} 
		}
	}
	return texto;
};
//====================================

function fn(texto) {
	console.log('olá querido instrutor:', texto);
};

function imprime(arr, fn) {
	var texto = '';
	if (typeof fn != 'function' || ) {	
		texto = 'O primeiro parametro deve ser uma array e o segundo parametro deve ser uma function';
	} else {
		for (var i = 0; i < arr.length; i++) {
			fn(arr[i]);
		}
	}
	return texto;
};
//====================================

function fiboSum(inteiro) {
	var resultado = 'Parametro deve ser númerico maior que zero';
	var numeros = [1,1];
	if (!isNaN(inteiro) && inteiro > 0 ) {
		resultado  = inteiro;
		if (inteiro >= 3) {
			resultado = 2;
			for (var i = 2; i < parseInt(inteiro); i++) {
				numeros [i] = numeros [i-1] + numeros [i-2];
				resultado += numeros [i];
			} 			
		}
	}
	return resultado;
};
//====================================

function excelis(texto) {
	var resultado = 'Parametro não é uma string';
	if (typeof texto === "string") {
		texto = texto.toUpperCase();
		resultado = 0;
		for (var i = 0; i < texto.length; i++) {
			resultado += ((texto[i].charCodeAt() -64) * (Math.pow(26, texto.length-i-1)));
		}
	}
	return resultado;
};

//=================================

function queroCafe(valor, arr) {	
	return arr.filter(function(elem) {return elem <= valor;}).sort(function (elem1, elem2) {return elem1 > elem2;}).toString();
};