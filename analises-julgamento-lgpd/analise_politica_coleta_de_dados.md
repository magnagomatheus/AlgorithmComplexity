**

# data_collect_policy.md

## Relatório de Política de Coleta de Dados – Groq  
### Modelo: `openai/gpt-oss-120b`

---

### 1. Visão Geral
A Groq fornece serviços de inferência via API para o modelo de código aberto **`openai/gpt-oss-120b`**.  
Todo o tráfego que passa pelos seus endpoints está sujeito à política de privacidade e coleta de dados descrita em https://groq.com/privacy/.  
Este relatório resume os pontos críticos da política, focando nos aspectos relevantes para a LGPD (Lei Geral de Proteção de Dados).

---

### 2. Dados Coletados

| Categoria | Exemplos de Dados | Finalidade |
|-----------|-------------------|------------|
| **Payload da requisição** | Prompt, parâmetros (temperature, max_tokens etc.), metadados fornecidos pelo usuário | Processar a chamada e gerar a resposta |
| **Payload da resposta** | Texto gerado pelo modelo | Entregar ao cliente; auditoria de qualidade |
| **Metadados da chamada** | Identificador da API‑key, timestamp, IP, user‑agent, request‑ID | Segurança, monitoramento, faturamento |
| **Telemetria** | Latência, contagem de tokens (prompt + completion), uso de recursos, códigos de erro | Otimização de infraestrutura, análise de desempenho |
| **Dados opcionais (opt‑in)** | Estatísticas de uso agregadas, logs de depuração detalhados | Melhorias de produto, treinamento interno (quando habilitado) |

---

### 3. Uso dos Dados

1. **Prestação do Serviço** – Os dados são necessários para gerar a resposta solicitada.  
2. **Segurança e Prevenção de Abuso** – Detectar atividades maliciosas, spam e violações de políticas.  
3. **Melhoria de Produto** – Dados **agregados e anonimizados** podem ser usados para aprimorar a infraestrutura da Groq e, opcionalmente, para treinar modelos internos.  
4. **Conformidade Legal** – Retenção para atender a obrigações legais, responder a solicitações judiciais e aplicar os Termos de Serviço.  

> **Nota LGPD:** O tratamento é justificado pelas bases legais de execução de contrato (prestação do serviço) e proteção de interesses legítimos (segurança). O uso para melhoria de produto requer consentimento explícito (opt‑in) ou base de interesse legítimo devidamente documentada.

---

### 4. Retenção de Dados

| Tipo de Dados | Período Padrão | Possibilidade de Redução |
|---------------|----------------|--------------------------|
| Payload de requisição e resposta + Metadados | **30 dias** | Usuário pode solicitar exclusão antes desse prazo |
| Telemetria de desempenho | **90 dias** | Pode ser reduzido ou desativado via configuração de Telemetry |
| Dados de treinamento (se opt‑in) | **Indeterminado** (até que sejam agregados e anonimizados) | Usuário pode revogar consentimento a qualquer momento |

---

### 5. Telemetria Específica para `openai/gpt-oss-120b`

- **O que é registrado:** nome e versão do modelo, contagem de tokens (prompt + completion), latência, recursos computacionais consumidos.  
- **Uso desses dados:** apenas para análise de performance interna; **não** são usados para treinar o modelo público `openai/gpt-oss-120b`.  
- **Controle do cliente:** via “Telemetry Settings” no dashboard da conta, o cliente pode:
  - Desativar a coleta de telemetria para este modelo.
  - Manter a coleta para relatórios de uso, mas sem compartilhar dados para treinamento.  

---

### 6. Segurança dos Dados

| Aspecto | Detalhes |
|---------|----------|
| **Trânsito** | TLS 1.2 ou superior (HTTPS) |
| **Descanso** | Criptografia AES‑256 |
| **Controle de acesso** | Políticas de IAM rigorosas; acesso limitado a pessoal autorizado |
| **Auditoria** | Logs de acesso são mantidos e revisados periodicamente |

---

### 7. Direitos dos Titulares (Conforme LGPD)

| Direito | Como exercer |
|---------|--------------|
| **Acesso** | Download dos logs via painel de controle ou solicitação ao suporte. |
| **Retificação** | Não aplicável (dados são gerados pela interação). |
| **Apagamento** | Solicitação de exclusão de logs via dashboard ou contato com data‑privacy@groq.com; a remoção ocorre em até 7 dias úteis. |
| **Portabilidade** | Exportação dos logs em formato JSON/CSV. |
| **Revogação de consentimento** | Desativar o opt‑in para uso de dados em treinamento a qualquer momento. |
| **Oposição** | Pode solicitar que seus dados não sejam usados para fins de melhoria de produto, mesmo que não tenha opt‑in. |

---

### 8. Contato e Governança

- **E‑mail de privacidade:** data‑privacy@groq.com  
- **Responsável pelo tratamento:** Groq, Inc. (Endereço corporativo disponível na página de contato).  
- **Canal de reclamação:** Usuário pode registrar reclamação junto à Autoridade Nacional de Proteção de Dados (ANPD) caso sinta que seus direitos não foram respeitados.

---

### 9. Conclusão

A política de coleta de dados da Groq para o modelo `openai/gpt-oss-120b` é **transparente** e oferece mecanismos de controle ao cliente, alinhados com os princípios da LGPD:

- **Finalidade clara** e limitada ao fornecimento do serviço, segurança e, opcionalmente, melhoria de produto.  
- **Retenção limitada** (30‑90 dias) com possibilidade de exclusão sob demanda.  
- **Segurança robusta** tanto em trânsito quanto em repouso.  
- **Direitos dos titulares** garantidos via dashboard e contato direto.

Para garantir conformidade total, recomenda‑se que as organizações:

1. Configurem o **opt‑in** de acordo com sua política interna de uso de dados.  
2. Documentem a **base legal** utilizada para cada tratamento (contrato, legítimo interesse, consentimento).  
3. Mantenham registro das **solicitações de exclusão** e **revogação de consentimento**.  

---  

*Este relatório foi elaborado a partir da documentação oficial da Groq (https://groq.com/privacy/) em 02/Nov/2025.*