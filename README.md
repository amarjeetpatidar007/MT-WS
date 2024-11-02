# MultiThreaded Java Server-Client Application

This repository contains a Java implementation of a simple multithreaded server-client application.

## Features

- **Multithreaded Server**: Efficiently handles multiple client connections concurrently using threads.
- **Client-Server Communication**: Clients connect to the server on port 8010 and exchange messages.
- **Concise and Readable Code**: Employs clear variable names, comments, and best practices for maintainability.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK) 11** or later installed and configured on your system.  
  You can download it from [Oracle's Java Downloads](https://www.oracle.com/java/technologies/downloads/).

### Cloning the Repository

Clone the repository using Git:

```bash
git clone https://github.com/amarjeetpatidar007/MT-WS/MultiThreaded.git
```

### Compiling and Running

1. Navigate to the project directory:

    ```bash
    cd MultiThreaded
    ```

2. Compile both server and client classes in separate terminals:

    - **Server**:

      ```bash
      javac Server.java
      ```

    - **Client**:

      ```bash
      javac Client.java
      ```

3. Start the server:

    ```bash
    java Server
    ```

4. Open a separate terminal for each client you want to connect:

    ```bash
    java Client
    ```

   Each client will connect to the server, send a message, and receive a response.

## Explanation

### Server (`Server.java`)

- Uses a `ServerSocket` on port 8010 to listen for client connections.
- Implements a `Consumer` interface using a lambda expression to handle each accepted client connection in a separate thread.
- Sends a welcome message ("Hello from the server") to the connected client.

### Client (`Client.java`)

- Creates a `Runnable` object to encapsulate the client logic.
- Connects to the server on port 8010 using the provided hostname ("localhost").
- Sends a message ("Hello From Client" + client's local address) to the server.
- Reads the server's response and prints it to the console.
  
   Optionally, you can modify the Client code to send multiple messages or create a more interactive client interface.


## Contributing

Feel free to fork this repository, make changes, and submit pull requests to improve the code.
