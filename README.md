# Java-simulacao-caixa-supermercado

## Atividade Prática - Simulação de Caixas de Supermercado

### Atividade 1 - Simulação Básica
Executei a simulação com μ = 5,0, σ = 0,5, N = 100 clientes e 1000 rodadas.

**Resultado obtido:**
- Média dos tempos de atendimento: 5,000 min
- Desvio-padrão das médias: 0,050 min

### Atividade 2 - Variação do Número de Caixas
Testei com 1, 2 e 3 caixas.

**Saída do programa:**
```
=== TESTANDO NÚMEROS DE CAIXAS ===
1 caixa(s): Média = 5,000 min, Desvio = 0,050 min
2 caixa(s): Média = 4,999 min, Desvio = 0,072 min
3 caixa(s): Média = 5,000 min, Desvio = 0,088 min
```

**Observação:** A média praticamente não muda (fica em torno de 5,0 min), mas o desvio-padrão aumenta quando tem mais caixas. Isso acontece porque com mais caixas, cada uma atende menos clientes, gerando mais variabilidade nos resultados. Mais caixas não reduz o tempo médio individual de atendimento, apenas distribui melhor os clientes.

### Atividade 3 - Variação do Desvio-Padrão (σ)
Testei com σ = 0,25, 1,0 e 2,0.

**Saída do programa:**
```
=== TESTANDO DIFERENTES DESVIOS PADRÃO ===
σ = 0,25: Média = 5,000 min, Desvio = 0,025 min
σ = 1,00: Média = 5,000 min, Desvio = 0,100 min
σ = 2,00: Média = 5,004 min, Desvio = 0,198 min
```

**Observação:** Quanto maior o σ (variabilidade), mais dispersos ficam os resultados. Se os clientes têm tempos muito variados (σ alto), a simulação apresenta resultados mais diferentes entre si. Com σ baixo, os tempos ficam mais previsíveis.

### Atividade 4 - Processo Estocástico
Este simulador é considerado estocástico porque utiliza números aleatórios. No código, a função `rng.nextGaussian()` gera valores aleatórios seguindo uma distribuição normal. Cada execução do programa, mesmo com os mesmos parâmetros, produz resultados ligeiramente diferentes.
Isso representa a vida real porque num supermercado real nunca sabemos exatamente quanto tempo cada cliente vai demorar. Tem cliente que compra só um refrigerante e paga no cartão rapidinho, outros que fazem compra do mês inteiro e ainda pedem desconto... a aleatoriedade do código simula essa imprevisibilidade do mundo real, onde só conseguimos ter uma ideia da média mas não do tempo exato de cada atendimento.