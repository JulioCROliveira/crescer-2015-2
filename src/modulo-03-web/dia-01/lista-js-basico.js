function daisyGame(n) {
	var texto = 'Love me';
	if ((n % 2) === 0) {
		texto = 'Love mot not';
	}
	return texto;
}

daisyGame(3)

daisyGame(4)

daisyGame(10)

daisyGame(7)

//====================================

function maiorTexto(arr) {
	var maior = 0;
	var texto = 'Nenhum texto inserido';
	if (arguments.length > 0) {
		for (var i = 0; i < arr.length; i++) {
			if (arr[i].length > maior) {
				maior = arr[i].length;
				texto = arr[i];
			} 
		}
	}
	return texto;
}

maiorTexto(['bernardo', 'nunes', 'dudu', 'ben-hur', 'fabrício', 'zanatta'])

maiorTexto(['bernardo', 'nunes', 'dudu', 'Pneumoultramicroscopicossilicovulcanoconiótico' ,'ben-hur', 'fabrício', 'zanatta'])

//====================================

function fn(texto) {
	console.log('olá querido instrutor:', texto);
}

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
}

imprime(['bernardo', 'nunes', 'dudu', 'ben-hur', 'fabrício', 'zanatta'], fn)

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
}

fiboSum(7)

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
}

excelis('a')
1
excelis('Z')
26
excelis('AA')
27
excelis('AZ')
52
excelis('BA')
53
excelis('ZZ')
702
excelis('AAA')
703
excelis('aab')
704

//=================================

function queroCafe(valor, arr) {
	var valMen = new Array;
	if (!isNaN(valor) && arr.constructor == Array) {
		for (var i = 0; i < arr.length; i++) {
			if (arr[i] <= valor) {
				valMen.push(arr[i]);
			}
		}
		if (valMen.length >= 0) {
		valMen.sort();
		} else {
			valMen = 'Sem retorno.'
		}
	} else {
		 valMen = "Insira valor numerico no primeiro parametro e array no segundo";
	 }
	return valMen.toString();
}