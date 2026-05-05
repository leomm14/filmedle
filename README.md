# Filmedle

Um jogo de adivinhação de filmes, onde o usuário tenta acertar um filme com base em palpites e feedbacks progressivos.

---

## Funcionalidades

- Iniciar partidas em modo:
    - *Infinito* → sem limite diário
    - *Diário* → um desafio por dia
- Enviar palpites e receber feedbacks
- Sistema de dicas após múltiplas tentativas
- Possibilidade de desistir da partida
- Encerramento automático ao acertar

---

## Estrutura da API

### Filme

#### GET /filme/filtro

Devolve todos os filmes com nome e ID.

*Resposta:*

- List<FilmeDTO>

---

### Partida

#### POST /partida/inicia?modo=

Inicia uma nova partida.

*Parâmetros:*

- modo → pode ser "infinito" ou "diario". Define o modo de jogo a ser iniciado


*Resposta:*

json
PartidaDTO


---

#### POST /partida/{idPartida}/chute/{idChute}

Realiza um palpite.

*Parâmetros:*

- idPartida → ID da partida
- idChute → ID do filme chutado

*Resposta:*

json
PartidaDTO


Inclui:

- Lista de palpites
- Feedback do palpite
- Indicação de acerto/erro
- Status da partida (encerra automaticamente se acertar)

---

#### GET /partida/{idPartida}/dica

Solicita dicas da partida.

*Regra:*

- Disponível apenas após *5 palpites*

*Resposta:*

json
List<String>


---

#### GET /partida/{idPartida}/desistir

Desiste da partida atual.

*Resposta:*

json
FilmeDTO


- Encerra a partida
- Retorna o filme correto

---

## Tecnologias

- *Backend:* Java + Spring Boot
- *Frontend:* React
- *Banco de dados:* PostgreSQL
- *API:* REST

---

## Integrantes

- Arthur Sampaio Bernardes
- Guilherme Kenzo Taba Nakamura
- Léo Montefusco Maximiano
- Leonardo Moretti Alva
- Lucas Grohmann Haro
- Vinícius Oehlmann de Lima