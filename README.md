# UFCD 0791 - Trabalho Pratico 2

## Estrutura do projeto

O projeto esta organizado em tres packages principais:

- `modelo` - contem a hierarquia de classes dos veiculos.
- `servico` - contem a logica de gestao e apresentacao de relatorios.
- `principal` - contem a classe executavel `Main`.

## Compilacao

A partir da pasta raiz `frota/`, executar:

```bash
javac -d bin src/modelo/*.java src/servico/*.java src/principal/*.java
```

## Execucao

Depois da compilacao:

```bash
java -cp bin principal.Main
```

## Justificacao arquitetonica

A separacao em packages permite isolar as entidades de dominio (`modelo`), a logica de negocio (`servico`) e o ponto de entrada da aplicacao (`principal`), promovendo uma estrutura modular e de facil manutencao. Os campos de estado sao privados para garantir encapsulamento, enquanto os construtores e metodos necessarios utilizam `public` e `protected` de acordo com a responsabilidade de cada membro; o metodo `obterVeiculos` usa visibilidade package-private por ser uma operacao interna do package `servico`. A classe `Veiculo` e abstract porque representa o conceito comum aos diferentes tipos de veiculo e define o contrato dos metodos `calcularAutonomia()` e `descrever()`, que sao implementados pelas subclasses. O modificador `final` e aplicado a constantes, ao setter de matricula e ao metodo de validacao de velocidade para impedir redefinicoes que poderiam alterar regras de negocio consideradas nucleares.

## Funcionalidades demonstradas

A classe `Main` cria um carro, uma mota e um camiao, adiciona-os ao gestor de frota, apresenta um relatorio e testa validacoes.

Tambem sao demonstradas excecoes `IllegalArgumentException` para:

- matricula com formato invalido;
- capacidade de deposito invalida;
- capacidade de carga negativa;
- matricula duplicada.
