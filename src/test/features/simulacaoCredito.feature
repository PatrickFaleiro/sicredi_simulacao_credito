#language: pt
  Funcionalidade: Simulacao de credito
    Fundo: Acesso ao serviço de simulação de crédito
      Dado que estou no servico de simulacao de credito

    Cenário: Consultar simulações cadastradas
      Quando consulto todos os cpfs
      Então todos os cpfs cadastrados sao retornados

    #Escrevendo em pt-BR parece que o scenario outline não consegue performar corretamente, gerando erro na inicialização
    #da feature
    Cenário: Consultar cpf específico
      Quando consulto o cpf 66414919004 cadastrado
      Então e retornado os dados do cpf 66414919004 cadastrado

    Cenário: Inserir cpf na simulação de crédito
      Quando insiro as informações de crédito do novo cpf
      Então um novo cadastro de simulação de credito e gerado

    Cenário: Inserir simulação de crédito com um cpf ja cadastrado na base
      Quando insiro dados de um cpf ja cadastrado
      Então retorna mensagem de erro informando cpf duplicado

    #Pode falhar devido ao serviço retornar a mensagem em inglês algumas vezes
    #Sugestão: Verificar essa regra ao atualizar o serviço de simulação de crédito
    Cenário: Validar email na inserção de simulação de crédito
      Quando tento cadastrar uma simulação de crédito com email invalido
      Então e retornado mensagem informando que deve ser informado um email valido

      
