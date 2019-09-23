# EventsToYou
### App servidor del TFG: API REST con Spring Framework + Hibernate + JPA

Servidor construido sobre Spring Framework haciendo uso del ORM Hibernate para la capa de persistencia sobre una base de datos Derby.
Ofrece una API REST para acceder a los recursos (eventos, sesiones, usuarios...) con seguridad Http básica.

**La aplicación cliente (repositorio [client-EventToYou](https://github.com/ChemaVinas/client-EventsToYou)) hará uso de la API.**

El sistema que se desarrolla tiene el objetivo de ofrecer una plataforma donde se puedan gestionar todo tipo de eventos. 
La gestión de estos eventos va a recaer sobre los organizadores, siendo libres de proponer eventos con diferentes sesiones en cada uno.
Los miembros podrán ver estos eventos en la página principal y los podrán filtrar y buscar cómo se requiera.

Lo más interesante que se quiere proponer es ofrecer a los usuarios, más allá de los eventos en sí, funcionalidades sobre los eventos
y otros miembros. Se pretende que los usuarios puedan valorar un evento, indicar una asistencia a una sesión de un evento o marcarlo
como favorito. Estas características tendrán la intención de poner en juego más elementos de valor a la hora de determinar cuales
son los eventos más relevantes o mejor valorados de una zona.

También un usuario podrá crear un entorno personalizado según los miembros que siga, donde podrá ver las acciones de sus amigos sobre
otros eventos que hayan acudido. Es común que un usuario tenga más en consideración los eventos o las valoraciones de sus amigos,
es por eso que es importante mostrar esta actividad que será la que finalmente ofrezca los eventos de más valor para un usuario en
particular.
