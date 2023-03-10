# Tic Tac Toe
> The Kotlin Android app to play Tic Tac Toe with your friend
> 
> View the code [_here_](https://github.com/AKushch1337/tic-tac-toe-game/tree/master/app/src/main/java/com/example/tictactoe). 
-------------------------------
## General Information
- The application is a game. 
- The game is played(for now) only in your local network.
- You can play simple tic tac toe game with your family member or your friend



## Technologies Used
- IDE: Android Studio
- Language: Kotlin
- Other instruments:
   - Jetpack Compose
   - Ktor
      - WebSockets
      - Routing
      - Content Negotiation
      - Call Logging
   - Dagger Hilt


## Setup

- Clone the backend project

- Download the game using APK from this github repo

- Run Application.kt in the backend project

- In file app/src/main/java/com/example/tictactoe/data/KtorRealTimeMessagingClient.kt find 

```kotlin
url("ws://192.168.0.168:8080/play")
```
- change 192.168.0.168 to your local ip address. Leave the port(8080) the same.

## Screenshots
![Game screenshot](app/src/main/res/drawable/example1.png)
![Game screenshot](app/src/main/res/drawable/example2.png)

![Game screenshot](app/src/main/res/drawable/example3.png)
![Game screenshot](app/src/main/res/drawable/example4.png)

## Project Status
Project is: _in progress_

## Room for Improvement

Room for improvement:
- Improve UI 

To do:
- Put the game on VPS so that you can play with anyone on the Earth
- Create authentication proccess
- Create lobbies to expand the game audience

## Contact
Created by Artem Kushch - [My Telegram](https://telegram.me/omegalulist) - feel free to contact me!
