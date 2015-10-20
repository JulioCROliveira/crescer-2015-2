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

function ordenaPorIndice(indice, clubes) {
	return clubes.sort(function(elem1, elem2) {return elem1.titulos[indice].qtd < elem2.titulos[indice].qtd;});
};

function ordenaPorNacionais(clubes) {
	return ordenaPorIndice(0, clubes);
};

function ordenaPorContinentais(clubes) {
	return ordenaPorIndice(1, clubes);
};

function ordenaPorMundiais(clubes) {
	return ordenaPorIndice(2, clubes);
};

function somarPorIndice(clubes, indice) {
	return clubes.reduce(function(acumulador, elem) {
		return acumulador + elem.titulos[indice].qtd;
	}, 0);
};

function somarPorNacionais(clubes) {
	return somarPorIndice(clubes, 0);
};

function somarPorContinentais(clubes) {
	return somarPorIndice(clubes, 1);
};

function somarPorTodosTitulos(clubes) {
	var soma = somarPorIndice(clubes, 0);
	soma += somarPorIndice(clubes, 1);
	soma += somarPorIndice(clubes, 2);
	return soma;
};

function apenasOsMelhores(Array) {
	return Array.filter(function(elem1) {return elem1.titulos[0].qtd >= 18});
};