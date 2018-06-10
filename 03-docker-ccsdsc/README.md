# Lista de comandos

> docker run

> docker ps

> docker start container-id

> docker stop container-id

> docker rm container-id

> docker container prune 

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

> ## docker ps -a

Visualiza todos os containers 

## Executando novamente um container

> ### docker start container-id

Roda o container já criado, mas não atrela o nosso terminal ao dele

> ### docker start container-id -a -i

Roda os conteiner já criado
- -a (attach): integrando os terminais
- -i (interactive): permite interagir com o terminal

> ### docker stop container-id

# 02 - Trabalhando com imagens

## docker rm container-id

Remove um container específico

## docker container prune 

Remove todos os containers inativos

## docker images

Lista as imagens que temos na nossa máquina

## rocker rmi image-name

Remove 

