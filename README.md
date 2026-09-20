# config-service

Serveur de configuration centralisée de la plateforme **DREAMHOUSE237**, basé sur **Spring Cloud Config Server**.

## Rôle

Sert la configuration (propriétés applicatives) de chaque microservice depuis un dépôt Git dédié : [`config`](https://github.com/DREAMHOUSE-237/config). Chaque service récupère sa configuration au démarrage via une requête HTTP vers ce serveur, plutôt que d'embarquer ses propriétés en dur dans son image Docker.

## Stack

- Java / Spring Boot / Spring Cloud Config Server
- Port interne `8888`

## Architecture

C'est l'un des deux services d'infrastructure "socle" de la plateforme (avec `registry-service`), démarré en premier. Il expose les fichiers du repo `config` (`auth-service`, `users-default`, `publication-service`, `proxy-service`, etc.) sous forme d'endpoints REST, par exemple `GET /AUTHENTIFICATION/default`.

⚠️ Toute modification de configuration (adresses de services, credentials via variables d'environnement, routes du gateway) se fait dans le repo `config`, pas dans ce repo — `config-service` ne fait que la servir.

## Développement local

```bash
./mvnw spring-boot:run
```

## Déploiement

Via **Docker Swarm** (voir [`infrastructure`](https://github.com/DREAMHOUSE-237/infrastructure)). Comme `registry-service`, son indisponibilité temporaire pendant un redéploiement peut retarder le démarrage des autres services qui en dépendent au boot.
