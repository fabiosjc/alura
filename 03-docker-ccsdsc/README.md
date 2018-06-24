# Lista de comandos

- `docker ps` - exibe todos os containers em execução no momento.
- `docker ps -a` - exibe todos os containers, independente de estarem em execução ou não.
- `docker run -it NOME_DA_IMAGEM` - conecta o terminal que estamos utilizando com o do container.
- `docker start ID_CONTAINER` - inicia o container com id em questão.
- `docker stop ID_CONTAINER` - interrompe o container com id em questão.
- `docker start -a -i ID_CONTAINER` - inicia o container com id em questão e integra os terminais, além de permitir interação entre ambos.
- `docker rm ID_CONTAINER` - remove o container com id em questão.
- `docker container prune` - remove todos os containers que estão parados.
- `docker rmi NOME_DA_IMAGEM` - remove a imagem passada como parâmetro.
- `docker run -d -P --name NOME dockersamples/static-site` - ao executar, dá um nome ao - container.
- `docker run -d -p 12345:80 dockersamples/static-site` - define uma porta específica para ser atribuída à porta 80 do container, neste caso 12345.
- `docker run -d -e AUTHOR="Fulano" dockersamples/static-site` - define uma variável de ambiente AUTHOR com o valor Fulano no container criado.


> docker run

> docker ps

> docker start `container-id`

> docker stop `container-id`

> docker stop $(docker ps -q)

> docker rm `container-id`

> docker container prune

> docker images

> docker rmi `image-name`

> docker port `container_id`

# 01 - Comandos básicos com containers

##  docker run
> docker run hello-world

 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

> docker run ubuntu

baixa a latest version

> docker run ubuntu:16.04


## Trabalhando dentro de um container

> ### docker run -it ubuntu

Faz com que o terminal da nossa máquina seja integrado ao terminal de dentro do container

## docker ps
Visualiza quais containers estão sendo executados

> ## docker ps `-a` 

> ## docker ps `-all` 

Visualiza todos os containers 

## Executando novamente um container

> ### docker start `container-id`

Roda o container já criado, mas não atrela o nosso terminal ao dele

> ### docker start container-id `-a -i`

Roda o container já criado
- `-a` (attach): integrando os terminais
- `-i` (interactive): permite interagir com o terminal

> ### docker stop container-id

Obs: demora 10 segundos para parar o container. Para diminuir esse tempo use a flag `-t`

> ### docker -t 0 stop container-id

# 02 - Trabalhando com imagens

## docker rm `container-id`

Remove um container específico

## docker container `prune`

Remove todos os containers inativos

## docker images

Lista as imagens que temos na nossa máquina

## rocker rmi `image-name`

Remove uma imagem específica

## docker port `container_id`

Mostra o mapeamento entre as portas da nossa máquina e as do container

## Nomeando um container

> docker run -d -P `--name` meu-site dockersamples/static-site

Assim fica mais fácil rodar outros comandos

> docker stop meu-site

## Definindo uma porta aleatória

docker run -d `-P` dockersamples/static-site 

## Definindo uma porta específica

docker run -d `-p 12345:80` dockersamples/static-site

## Atribuindo uma variável de ambiente

    docker run -d -P `-e AUTHOR="Stan Lee"` dockersamples/static-site

## docker stop $(docker ps -q)

Pára todos os containers de uma só vez