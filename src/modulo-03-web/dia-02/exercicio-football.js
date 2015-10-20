var clubes = [
  {
    nome: 'Arsenal',
    titulos: [
      { desc: 'Nacionais', qtd: 13 },
      { desc: 'Continentais', qtd: 0 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }, 
  {
    nome: 'Manchester United',
    titulos: [
      { desc: 'Nacionais', qtd: 20 },
      { desc: 'Continentais', qtd: 3 },
      { desc: 'Mundiais', qtd: 2 }
    ]
  },
  {
    nome: 'Liverpool',
    titulos: [
      { desc: 'Nacionais', qtd: 18 },
      { desc: 'Continentais', qtd: 5 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  },
  {
    nome: 'Chelsea Football Club',
    titulos: [
      { desc: 'Nacionais', qtd: 5 },
      { desc: 'Continentais', qtd: 1 },
      { desc: 'Mundiais', qtd: 0 }
    ]
  }
];

function ordenaPorNacionais(Array) {
	return Array.sort(function(elem1, elem2) {return elem1.titulos[0].qtd < elem2.titulos[0].qtd});
};

function ordenaPorContinentais(Array) {
	return Array.sort(function(elem1, elem2) {return elem1.titulos[1].qtd < elem2.titulos[1].qtd});
};

function ordenaPorMundiais(Array) {
	return Array.sort(function(elem1, elem2) {return elem1.titulos[2].qtd < elem2.titulos[2].qtd});
};

function somarPorNacionais(Array) {
	var soma = 0;
	for (var i = 0, len = Array.length; i < len; i++) {
		soma += Array[i].titulos[0].qtd;
	}
	return soma;
};

function somarPorContinentais(Array) {
	var soma = 0;
	for (var i = 0, len = Array.length; i < len; i++) {
		soma += Array[i].titulos[1].qtd;
	}
	return soma;
};

function somarPorTodosTitulos(Array) {
	var soma = 0;
	for (var i = 0, len = Array.length; i < len; i++) {
		for (var j = 0, len2 = Array[i].titulos.length; j < len2; j++) {
			soma += Array[i].titulos[j].qtd;
		}
	}
	return soma;
};

function apenasOsMelhores(Array) {
	return Array.filter(function(elem1) {return elem1.titulos[0].qtd >= 18});
};