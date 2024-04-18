# API-Farm-cia-
API de uma farmácia hospitalar, feita utilizando Java SpringBoot. Esta API permite cadastrar, atualizar, listar e remover remedios do banco de dados.

  O armazenamento dos dados manipulados na API foi feito utilizando um banco de dados mysql, nele estão contidos os dados de remedios e usuarios.
  Para a segurança da aplicação, foram utilizados spring security e o sistema de TokenJWT, então antes de realizar as requisiçoes HTTP, é necessario utilizar 
  o metodo POST de login para obter um token de acesso. Com este token será possivel acessar os demais endpoits da API.
