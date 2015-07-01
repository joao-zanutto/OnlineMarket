# OnlineMarket
Este é um projeto para a disciplina de POO no ICMC-USP

######`AVISO: FECHAR O SERVIDOR PELO TASK MANAGER, POIS ELE NÃO FECHA A PORTA ABERTA PARA CONEXÕES`


#### Programado em

```
Windows 8.1
JAVA 8
Eclipse Luna Service Release 2 (4.4.2)
```

#### Uso de Design Patterns identificados
  - Classe `ProductHandler` (Singleton)
  - Classe `ClientHandler` (Singleton)
  - Classe `ConnectionHandler` (Singleton)

#### Como usar o programa
  1. Baixar os .jar do cliente e do server
  2. Executar o .jar do server 
  3. Clicar no botão para abrir o servidor
  4. Executar o .jar do cliente
  5. Inserir o IP do server para conectar
  6. Conecte o cliente com o server e use as funcionalidades tanto do cliente quanto do servidor
  

#### NOTAS
- Client:
  - Conexão com o servidor: Conectar com o servidor na tab `Conectar`, passando o IP do server
  - Função cadastrar novo usuário: Conectar com o servidor na tab `Conectar`, depois ir para a tab `Registrar`
  - Função login: Conectar com o servidor na tab `Conectar`, depois ir para a tab `Login`
  - A quantidade de produtos no estoque não é exibido para o usuário; caso uma compra seja falha por falta de produtos no estoque o usuário não será informado
  - Notificação por e-mail NÃO IMPLEMENTADA
  
- Server:
  - Conexão com clientes: o servidor deve ser aberto na tab `Server`
  - O registro de produtos pode ser feito na tab `Criar novo produto`
  - Os produtos estão listados com todos os dados na tab `Lista de produtos`
  - Para adicionar ou remover produtos do estoque ir na tab `Editar produtos` e ao adicionar/remover produtos clicar no botão `Salvar` para salvar as mudanças no arquivo de dados
  - Geração de relatórios em PDF NÃO IMPLEMENTADO
  - Teste em JUnit NÃO IMPLEMENTADO
  - TextArea na tab `Server` não exerce nenhuma função
