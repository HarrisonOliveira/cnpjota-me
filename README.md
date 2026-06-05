# CNPJTame
API REST para geração e validação de CNPJs alfanuméricos, desenvolvida com Java e Spring Boot.

---

## Aviso Legal

Esta API tem como único objetivo gerar CNPJs alfanuméricos para fins de desenvolvimento, testes, homologação, estudos e demonstrações.

Os valores gerados não possuem validade jurídica, fiscal ou cadastral e não devem ser utilizados para quaisquer atividades que exijam identificação oficial perante órgãos públicos ou entidades privadas.

Não é garantido que os valores gerados não coincidam com registros existentes ou futuros. Cabe ao usuário verificar a adequação dos dados gerados ao seu caso de uso.

O autor e mantenedor deste projeto não se responsabiliza por quaisquer danos, prejuízos, perdas, responsabilidades legais ou consequências decorrentes do uso indevido desta ferramenta.

Ao utilizar este software, o usuário concorda que toda responsabilidade pelo uso dos dados gerados é exclusivamente sua.

---

## 🪛 Tecnologias

- Java 25
- Spring Boot 4
- Lombok
- Spring Validation

---

## ▶️ Como rodar localmente

**Pré-requisitos:**
- Java 25 instalado
- Gradle instalado
  **Passos:**

```bash
# Clone o repositório
git clone https://github.com/HarrisonOliveira/cnpjota-me.git
 
# Entre na pasta
cd cnpjtame
 
# Rode o projeto
./gradlew bootRun
```

A API estará disponível em `http://localhost:8080`
 
---

## 📌 Endpoints

| Método | Endpoint               | Descrição                        |
|--------|------------------------|----------------------------------|
| GET    | `/api/v1/cnpj`         | Gera um CNPJ alfanumérico válido |
 
---

## 📥 Exemplos

### Gerar CNPJ
**Request:**
```
GET /api/v1/cnpj
```

**Response:**
```json
{
  "cnpj": "AB.CDE.FGH/0001-52"
}
```

---

## 📁 Estrutura do projeto

```
src/main/java/me/projects/cnpjtame/
├── controller/
│   └── CnpjController.java
├── dto/
│   ├── CnpjRequestDTO.java
│   └── CnpjResponseDTO.java
├── service/
│   ├── CnpjGenerator.java
│   └── CnpjValidator.java
└── utils/
    └── CnpjUtils.java
```
 
---

## 👨‍💻 Autor

Feito com ☕ por [Harrison Oliveira](https://github.com/HarrisonOliveira/)