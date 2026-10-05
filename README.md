# 🏢 Sistema de Gestão de Contratos e Renda

## 🎯 O que o projeto faz?

O usuário informa os dados de um colaborador (Nome, Cargo, Salário Base e Departamento) e registra seus contratos de trabalho daquele período. No final, ao digitar um mês e ano específicos, o sistema varre o histórico e exibe o **faturamento total consolidated** daquele mês.

### 🔄 Fluxo da Aplicação
```text
[ Dados do Trabalhador ] ➔ [ Cadastro de Contratos ] ➔ [ Filtro por Mês/Ano ] ➔ [ Salário Total Calculado ]
```

---

## 🎨 Design do Código (Como as classes conversam)

Este projeto foi construído utilizando o conceito de **Composição de Objetos** (quando uma classe "tem" outra classe dentro dela). Veja como a estrutura foi desenhada de forma limpa:

```text
       ┌───────────────┐
       │   Department  │ (Nome do setor)
       └───────┬───────┘
               │ (1 para 1)
               ▼
       ┌───────────────┐               ┌────────────────┐
       │    Worker     │──────────────►│  HourContract  │
       └───────┬───────┘  (1 para N)   └────────────────┘
               │                       (Data, Valor/Hora, Horas)
               ▼
       ┌───────────────┐
       │  WorkerLevel  │ (Enumeração: JUNIOR, MID_LEVEL, SENIOR)
       └───────────────┘
```

### 📋 Mapeamento de Responsabilidades

| Classe / Arquivo | O que ela faz no código? |
| :--- | :--- |
| 🚀 `Program.java` | É o cérebro da execução. Lê os dados digitados no terminal e exibe os resultados. |
| 👤 `Worker.java` | Classe principal. Guarda as informações do trabalhador e tem o método mágico `income()` que calcula o salário final. |
| 📄 `HourContract.java` | Representa as horas trabalhadas em um serviço específico. Calcula o subtotal de cada contrato (`totalValue`). |
| 🏢 `Department.java` | Apenas gerencia o setor onde o funcionário trabalha. |
| 🏅 `WorkerLevel.java` | Um Enum que impede erros de digitação, garantindo que o funcionário seja apenas `JUNIOR`, `MID_LEVEL` ou `SENIOR`. |

---

## 🧠 Conceitos de Programação Praticados

* **Composição Relacional:** Uso de `List<HourContract>` para permitir que um funcionário tenha infinitos contratos vinculados a ele.
* **Manipulação Ativa de Datas:** Uso de `Calendar` e `Date` para quebrar uma data completa (ex: 20/08/2026) e extrair apenas o mês e o ano para as validações de regras de negócio.
* **Instanciação Segura:** Inicialização de listas diretamente nos atributos para evitar erros clássicos do tipo `NullPointerException`.

---

## 💻 Exemplo Prático de Uso

Imagine a seguinte simulação rodando direto no terminal:

```text
Enter department's name: Design
Enter worker data: 
Name: Alex Green
Level: MID_LEVEL
Base salary: 1200.00

How many contracts to this worker? 2
Enter contract #1 data:
Date (DD/MM/YYYY): 20/08/2026
Value per hour: 50.00
Duration (hours): 20      --> (Ganhos deste contrato: 1000.00)

Enter contract #2 data:
Date (DD/MM/YYYY): 25/08/2026
Value per hour: 80.00
Duration (hours): 10      --> (Ganhos deste contrato: 800.00)

Enter moth and year too calculate income (MM/YYYY): 08/2026

Name: Alex Green
Department: Design
Income for 08/2026: 3000.00  --> [Salário Base (1200) + Contrato 1 (1000) + Contrato 2 (800)]
```
