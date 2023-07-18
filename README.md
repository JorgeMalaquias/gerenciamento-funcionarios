# gerenciamento-funcionarios

Aplicação para gerenciamento de dados de funcionários, seguindo requisitos propostos.

## Endpoints

## POST `/funcionarios`

É o endpoint responsável pela criação (inserção no banco de dados) dos funcionários conforme lista a seguir:

## DELETE `/funcionarios/{nome}`

Realiza a exclusão de um funcionário (dado o nome). Para por exemplo deletar o funcionário João a requisição delete deve ser feita no endpoint "/funcionarios/João".

## GET `/funcionarios`

Retorna uma lista com todos os funcionários, sendo cada funcionário no seguinte formato:

```json
{
		"salario": "2.009,44",
		"funcao": "Operador",
		"nome": "Maria",
		"nascimento": "18-10-2000"
}

```



## PATCH `/funcionarios`

Aumenta os salários de todos os funcionários registrados em 10%.

## GET `/funcionarios/map`

Retorna uma lista de funcionários, porém agrupada pelas funçôes. Conforme exemplo:

```json
[
  "Eletricista": [
  		{
  			"salario": "  1.606,85",
  			"funcao": "Eletricista",
  			"nome": "Heloísa",
  			"nascimento": "24-05-2003"
  		}
  ],
  "Diretor": [
  		{
  			"salario": " 19.119,80",
  			"funcao": "Diretor",
  			"nome": "Miguel",
  			"nascimento": "14-10-1988"
  		}
  ]
]
```

## GET `/funcionarios/funcao`

Retorna lista de funcionários, ordenada pelas funções em ordem alfabética, conforme exemplo:
```json
[
	{
		"salario": "  4.071,84",
		"funcao": "Contador",
		"nome": "Arthur",
		"nascimento": "31-03-1993"
	},
	{
		"salario": "  9.836,14",
		"funcao": "Coordenador",
		"nome": "Caio",
		"nascimento": "02-05-1961"
	},
	{
		"salario": "  2.799,93",
		"funcao": "Gerente",
		"nome": "Helena",
		"nascimento": "02-09-1996"
	},
	{
		"salario": "  3.017,45",
		"funcao": "Gerente",
		"nome": "Laura",
		"nascimento": "08-07-1994"
	}
]
```

## GET `/funcionarios/mes-aniversario`

Retorna uma lista com os funcionários que fazem aniversário nos meses de número 10 e 12, seguindo o formato de objeto dos endpoints anteriores.

## GET `/funcionarios/nome`

Retorna uma lista com todos os funcionários, no mesmo formato dos endpoints anteriores, porém, ordenados alfabeticamente pelo nome do funcionário.

## GET `/funcionarios/mais-velho`

Retorna o funcionário mais velho, com seu nome e idade somente, conforme exemplo:
```json
{
	"nome": "Caio",
	"idade": 62
}
```

## GET `/funcionarios/total-salarios`

Retorna uma mensagem informando a soma de todos os salários dos funcionários, no seguinte formato:
"O total em salários de funcionários é XX.XXX,XX"

## GET `/funcionarios/salarios-minimos`

Retorna uma lista com os funcionários, informado quantos salários mínimos cada um ganha conforme exemplo:
```json
[
	{
		"nome": "Maria",
		"salariosMinimos": "  1,66"
	},
	{
		"nome": "João",
		"salariosMinimos": "  1,88"
	},
	{
		"nome": "Caio",
		"salariosMinimos": "  8,12"
	},
	{
		"nome": "Miguel",
		"salariosMinimos": " 15,78"
	}
]
```
