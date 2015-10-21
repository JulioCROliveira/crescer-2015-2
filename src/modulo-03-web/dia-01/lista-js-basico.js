<<<<<<< HEAD
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
=======
/*
* CWI Software
*/
// Exercício 01

function isNumber(number) {
  return typeof number === 'number';
  // return !isNaN(number);
};

function isFunction(fn) {
  return typeof fn === 'function';
};

function daisyGame(petals) { console.log('inline'); };

var daisyGame = function(petals) { 
  if (isNumber(petals)) {
    return 'Love me' + ( petals % 2 === 0 ? ' not' : '' );
  } else {
    throw new Error('Petals not a number!');
  }
};

var arr = ['t1', 'maior t3xt0', 't2a', 'u', '123'];
arr['nome'] = 'Array querido';

for (var prop in arr) {
  console.log(arr[prop]);
}

(function maiorTexto(textos) {

  for (var i = 0, maiorTxt = '', len = textos.length; i < len; i++) {
    (function() {
      var dentro = 'fora';
      if (textos[i].length > maiorTxt.length) {
        maiorTxt = textos[i];
      }
      //console.log(textos[i]);
    })();
  }

  //console.log('fora: %o', dentro);

  return maiorTxt;
})(arr);

function imprime(instrutores, fn) {
  // debugger;
  if (isFunction(fn)) {
    instrutores.forEach(fn);  
  }
};

var imprimeInstrutor = function(instrutor) {
  console.log(instrutor);
};

var alerta = function(instrutor) {
  alert(instrutor);
};

imprime(['bernardo', 'nunes', 'benhur'], imprimeInstrutor);
imprime(['bernardo', 'nunes', 'benhur'], 'oi');
// ERRADO:
// imprime(['bernardo', 'nunes', 'benhur'], imprimeInstrutor());

var fibonacci = function(n) {
  if (n === 1) return 1;
  if (n === 2) return 1;

  return fibonacci(n-1)+fibonacci(n-2);
};

// fiboSum(7) => 13+8+5+3+2+1+1

var fiboSum = function(n) {
  //if (n === 1) return 1;
  //return fibonacci(n) + fiboSum(n-1);
  return fibonacci(n+2)-1;
};

function queroCafe(mascada, precos) {
  return precos
    .filter(function(elem) {
      return elem <= mascada;
    })
    .sort(function(elem1, elem2) {
      return elem1 > elem2;
    })
    .join(',');
    // alternativas:
    // join()
    // toString()
};

[
  // caso de teste 1
  { mascada: 3.14, precos: [ 5.16, 2.12, 1.15, 3.11, 17.5 ], esperado: '1.15,2.12,3.11' },
  // caso de teste 2
  { mascada: 99, precos: [ 101, 105 ], esperado: 'shimbalaie' },
].forEach(function(elem) {
  console.assert(
    queroCafe(elem.mascada, elem.precos) === elem.esperado
    , 'Falhou! ' + elem.mascada + ' ' + elem.precos
  )
});

var excelis = function(referencia) {
  referencia = referencia.toUpperCase();
  for (var i=0, soma=0, len=referencia.length; i < len; i++) {
    soma = soma * 26 + (referencia.charCodeAt(i) - 64);
  }
  return soma;
};

[
  { referencia: 'A', esperado: 1 },
  { referencia: 'a', esperado: 1 },
  { referencia: 'BA', esperado: 53 }
].forEach(function(elem) {
  console.assert(
    excelis(elem.referencia) === elem.esperado
    , 'Falhou! ' + elem.referencia
  )
});
>>>>>>> 2940c15af103f3c1b35a9c2816a84db351cebc35
