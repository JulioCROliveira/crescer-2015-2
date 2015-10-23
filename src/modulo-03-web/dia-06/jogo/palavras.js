function getPalavra(dificultade) {
	dificultade = dificultade || 'normal';
	var indicePalavrasPorDificultade = 2;
	var indiceDaPalavra = 0;
	var palavraDeRetorno = {};
	if (dificultade === 'normal') {
		indicePalavrasPorDificultade = Math.random() < 0.49 ? 1 : 2;
	}
	$.get('http://localhost:3000/palavras?idDificuldade='+indicePalavrasPorDificultade).done(function(palavras) {
		var indiceDaPalavra = Math.floor(Math.random() * palavras.length);
		palavraDeRetorno = palavras[indiceDaPalavra];
		console.log(palavraDeRetorno); // não retorna pelo return
	});	
	
	return palavraDeRetorno;
};

function adicionarPalavra(palavra, dica) {
	indicePalavrasPorDificultade = palavra.length < 12 ? 1 : 2;
	$.post('http://localhost:3000/palavras?idDificuldade=', 
	{"palavra": palavra, "dica": dica, 	"idDificuldade": indicePalavrasPorDificultade});	
};