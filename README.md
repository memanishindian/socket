# Country and Capital Service

## Description

The purpose of this Java Application is to show socket programming with a 
simple example.

The application has a server program and a client program. The server program is 
started first before any client can connect

## Starting Server

Compile server.java file with ``` javac server.java ```
Run the server.java with ``` java server ```
It listens on port 3456 by default so make sure that port is free.

### Starting Client

Compile client.java file with ``` javac client.java ```
Run the client.java with ``` java client localhost 3456 ```

## Background

This application was created as an exercise in Socket programming.

## Classes

- Server.java
This class starts up the application. It listens for incoming connections on port 3456.
The class creates a new thread for each client connection established.

- Client.java
This class connects to the server and makes requests subsequently. Many clients can
connect to the server simultaneouly.



## Support

Pull requests and new issues are of course welcome. If you have any questions, comments or feedback you can 
contact me by email at arthurugochukwu@gmail.com.
