function buscarPalavra(dificultade) {
	dificultade = dificultade || 'normal';
	var idDaDificuldade = 2;
	var indiceDaPalavra = 0;
	var palavraDeRetorno = {};
	var indice = criarListaDePalavrasParaUsuario();
	if (dificultade === 'normal') {
		idDaDificuldade = Math.random() < 0.49 ? 1 : 2;
	}
	$.get.call(this,'http://localhost:3000/palavras?idDificuldade='+idDaDificuldade).done(function(palavras) {
		var listaPalavras = JSON.parse(localStorage.palavraRepetidas);
		do {
			var indiceDaPalavra = Math.floor(Math.random() * palavras.length);
			palavraDeRetorno = palavras[indiceDaPalavra];
		} while (containsPalavra(listaPalavras[indice].palavrasRepetidas, palavraDeRetorno));
		localStorage.setItem('palavraAtual', palavraDeRetorno.nome);
		localStorage.setItem('palavraRepetidas', JSON.stringify(listaPalavras));
	});
	return;
};

function containsPalavra(arr, palavras) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].nome === palavras.nome) {
            return true;
        }
    }
    return false;
};

function containsUsuario(usuarios) {
    for (var i = 0; i < usuarios.length; i++) {
        if (usuarios[i].nome === controller.jogador.nome) {
            return i;
        }
    }
    return -1;
};

function resetaPalavrasRepetidas() {
	localStorage.setItem('palavraRepetidas', '[]');
};

function criarListaDePalavrasParaUsuario() {
	if (localStorage.palavraRepetidas === undefined) { 
		resetaPalavrasRepetidas();
	}
	var usuarios = JSON.parse(localStorage.palavraRepetidas);	
	var indice = containsUsuario(usuarios);
	if (indice === -1) {
		usuarios.push({'nome': controller.jogador.nome, 'palavrasRepetidas': []});
		indice = usuarios.length - 1;
	}
	localStorage.setItem('palavraRepetidas', JSON.stringify(usuarios));
	return indice;
};

function adicionarPalavra(palavra, dica) {
	$.get.call(this, 'http://localhost:3000/palavras').done(function (elem) {
		var proximoID = elem.length + 1;
		localStorage.setItem('proximoIDPalavra', proximoID);
	});
	var indicePalavrasPorDificultade = palavra.length < 12 ? 1 : 2;
	$.post('http://localhost:3000/palavras?_sort=number(idpalavra)&_order=DESC&_limit=1', 
	{"nome": palavra.toUpperCase(), "dica": dica, 
		"idDificuldade": indicePalavrasPorDificultade, "id": parseInt(localStorage.proximoIDPalavra)});	
};

function adicionarPalavraRepetida() {
	var indice = criarListaDePalavrasParaUsuario();
	var listaPalavras = JSON.parse(localStorage.palavraRepetidas);
	listaPalavras[indice].palavrasRepetidas.push({'nome': palavraDeRetorno.nome});
	localStorage.setItem('palavraRepetidas', JSON.stringify(listaPalavras));
};

function listarPalavrasRepetidas() {
	var indice = criarListaDePalavrasParaUsuario();
	var listaPalavras = JSON.parse(localStorage.palavraRepetidas);	
	localStorage.setItem('palavraRepetidas', JSON.stringify(listaPalavras));
	return listaPalavras[indice].palavrasRepetidas;
};