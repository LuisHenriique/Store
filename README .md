
# Exercício: Polimorfismo e Herança - Loja de Produtos

Este projeto é um exercício de programação orientada a objetos com foco em **herança** e **polimorfismo**, onde é criada uma hierarquia de classes para representar diferentes tipos de produtos em uma loja: **Livros**, **CDs** e **DVDs**. Além disso, há uma classe `Loja` responsável por gerenciar o estoque, buscas e vendas de produtos.

## 📚 Estrutura do Projeto

O sistema gerencia os seguintes tipos de produtos:

- `Livro`: possui atributos como autor, editora, ano, edição, páginas e idioma.
- `CD`: possui atributos como cantor/banda, número de faixas, gravadora e ano.
- `DVD`: possui atributos como diretor, idioma, gênero, ano e nacionalidade.

Todos os produtos possuem um **código de barras único**, além de um nome/título, e são armazenados na loja.

## 🛒 Funcionalidades da Loja

A loja é capaz de:

- **Inserir produtos** (livros, CDs, DVDs)
- **Adicionar produtos ao estoque**
- **Vender produtos**
- **Procurar produtos por código ou nome**
- **Exibir um sumário do estoque**, incluindo contagem por produto e por categoria

## 📥 Formato dos Comandos

Os comandos são fornecidos por linha de entrada com os seguintes formatos:

### Inserção de Produtos
```
I, Livro, código, nome, autor, editora, ano, edição, páginas, idioma  
I, CD, código, título, cantor/banda, nº de trilhas, gravadora, ano  
I, DVD, código, nome do filme, diretor, idioma, gênero, ano, nacionalidade
```

### Adição ao Estoque
```
A, código, quantidade
```

### Venda de Produto
```
V, código, quantidade
```

### Busca de Produto
```
P, código  
P, nome
```

### Sumário da Loja
```
S
```

## ✅ Objetivos Didáticos

- Praticar o uso de **herança** e **polimorfismo** em Java/C++/Python (linguagem a ser definida conforme implementação)
- Compreender como utilizar classes base e derivadas para representar objetos do mundo real
- Exercitar a manipulação de dados por meio de entrada textual estruturada
- Implementar um sistema com funcionalidades de CRUD (Create, Read, Update, Delete) básico

## 🧪 Casos de Teste

A saída esperada para cada comando será definida em arquivos de teste automatizados como os utilizados no Runcodes.

## 📄 Licença

Este projeto é apenas para fins educacionais.
