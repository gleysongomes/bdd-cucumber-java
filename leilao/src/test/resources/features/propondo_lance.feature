# language: pt

Funcionalidade: Propondo lances ao leilao

Cenario: Propondo um unico lance valido
	Dado um lance valido
	Quando propoe ao leilao
	Entao o lance e aceito

Cenario: Propondo varios lances validos
	Dado um lance de 10.0 reais do usuario "teste1"
	E um lance de 15.0 reais do usuario "teste2"
	Quando propoe varios lances ao leilao
	Entao os lances sao aceitos

Esquema do Cenario: Propondo um lance invalido
	Dado um lance invalido de <valor> reais do usuario '<nomeUsuario>'
	Quando propoe ao leilao
	Entao o lance nao e aceito

Exemplos:
	| valor   | nomeUsuario  |
	|   0.0   |   teste1     |
	|   -1.0  |   teste2     |

Esquema do Cenario: Propondo uma sequencia de lances
	Dado um lance de 10.0 reais do usuario "teste1"
	E um lance de 15.0 reais do usuario "teste1"
	Quando propoe varios lances ao leilao
	Entao o segundo lance nao e aceito

Esquema do Cenario: Propondo uma sequencia de lances
	Dado dois lances
	| valor   | nomeUsuario  |
	|   10.0  |   teste1     |
	|   15.0  |   teste1     |
	Quando propoe varios lances ao leilao
	Entao o segundo lance nao e aceito

Esquema do Cenario: Propondo uma sequencia de lances
	Dado varios lances validos
	|   10.0  |
	|   15.0  |
	Quando propoe varios lances ao leilao
	Entao o segundo lance nao e aceito
