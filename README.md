# Intro
Spring Webflux example with MongoDB

## Webflux
Is a framework that became possible program in a reactive way

## Reactive
Always when you think about reactive remember: Async and non-blocking

# Database
You can create a new databe here and get the connection string to connect the application with your DB
https://www.mongodb.com/atlas/database

# Endpoints

### GET v1/playlist/events
MVC Events Stream to compare with Reactive Events Stream
```
curl --location --request GET 'localhost:8080/v1/playlist/events'
```

## Reactive Endpoints 

### GET v2/playlist/events
Reactive Events Stream
```
curl --location --request GET 'localhost:8080/v2/playlist/events'
```

### POST v2/playlist
Create new playlist
```
curl --location --request POST 'http://localhost:8080/v2/playlist' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome":"Teste"
}'
```

### GET v2/playlist
Find all playlists
```
curl --location --request GET 'http://localhost:8080/v1/playlist'
```

### GET v2/playlist/{id}
Find playlist by Id
```
curl --location --request GET 'http://localhost:8080/v1/playlist/{id}'
```

# How to Run
```
mvn install

mvn pacakge

java -jar ./target/web-flux-0.0.1-SNAPSHOT.jar
```
