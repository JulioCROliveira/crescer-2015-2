function getPalavra(dificultade) {
	dificultade = dificultade || 'normal';
	var indicePalavrasPorDificultade = 2;
	var indiceDaPalavra = 0;
	var palavraDeRetorno = {};
	if (localStorage.palavraRepetidas === undefined) { 
		resetaPalavrasRepetidas();
	}
	if (dificultade === 'normal') {
		indicePalavrasPorDificultade = Math.random() < 0.49 ? 1 : 2;
	}
	$.get.call(this,'http://localhost:3000/palavras?idDificuldade='+indicePalavrasPorDificultade).done(function(palavras) {
		var palavrasRepetidas = JSON.parse(localStorage.palavraRepetidas);
		do {
			var indiceDaPalavra = Math.floor(Math.random() * palavras.length);
			palavraDeRetorno = palavras[indiceDaPalavra];
		} while (containsPalavra(palavrasRepetidas, palavraDeRetorno));
		palavrasRepetidas.push(palavraDeRetorno);
		localStorage.setItem('palavraRepetidas', JSON.stringify(palavrasRepetidas));
		console.log(palavraDeRetorno); // não retorna pelo return
	});	
	
	return palavraDeRetorno;
};

function containsPalavra(arr, palavras) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].palavra === palavras.palavra) {
            return true;
        }
    }
    return false;
}

function resetaPalavrasRepetidas() {
	localStorage.setItem('palavraRepetidas', '[]');
}

function adicionarPalavra(palavra, dica) {
	indicePalavrasPorDificultade = palavra.length < 12 ? 1 : 2;
	$.post('http://localhost:3000/palavras?idDificuldade=', 
	{"palavra": palavra.toUpperCase(), "dica": dica, 	"idDificuldade": indicePalavrasPorDificultade});	
};