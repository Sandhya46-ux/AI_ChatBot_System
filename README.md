
# AI Chatbot System (Java GUI + MySQL)

## Project Overview
This project is an AI Chatbot system built using *Java Swing* for the GUI and *MySQL* for storing chat history and bot responses. The chatbot responds to user queries based on predefined keywords stored in the database and logs conversations for future reference.

---

## Project Structure

JavaProject/
├─ lib/ # MySQL connector jar
│ └─ mysql-connector-j-9.5.0.jar
├─ src/ # Java source code
│ ├─ ChatbotGUI.java # GUI interface
│ ├─ BotLogic.java # Bot logic and response handling
│ ├─ DatabaseHandler.java# Database operations
│ └─ Message.java # Message object (optional)
└─ README.md # This file


---

## Requirements

- Java JDK 17+
- MySQL 8+
- MySQL Connector JAR (mysql-connector-j-9.5.0.jar)
- IDE or terminal to run Java programs

---

## Database Setup
1. Create the database:

<<<<<<< HEAD
<<<<<<< HEAD
1. *Create the database:*

```sql
CREATE DATABASE message;
USE message;
=======

   CREATE DATABASE message;
   USE message;
>>>>>>> 1f5672c (Updated readme)
=======

   CREATE DATABASE message;
   USE message;
>>>>>>> e611a2a341ba555c48fefa7f24f84248b08c97ec

CREATE TABLE bot_responses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    keyword VARCHAR(50),
    reply TEXT
);

CREATE TABLE chat_history (
 id INT AUTO_INCREMENT PRIMARY KEY,
    user VARCHAR(50),
    message VARCHAR(255)
);

INSERT INTO bot_responses (keyword, reply) VALUES
('hi', 'Hello! How can I help you today?'),
('hello', 'Hi there! What can I do for you?'),
('hey', 'Hello! How are you?'),

('who made you', 'I was created by Sandhya.'),
('who created you', 'Sandhya created me.'),

('your name', 'I am your AI Chatbot.'),

('how are you', 'I am functioning perfectly! What about you?'),
('what is your purpose', 'I am here to answer your questions.'),

('bye', 'Goodbye! Talk to you later.'),
('exit', 'Take care! Have a great day.');


SELECT * FROM bot_responses;
DESCRIBE bot_responses;
<<<<<<< HEAD
<<<<<<< HEAD
SELECT keyword, reply FROM bot_responses;

=======
SELECT keyword, reply FROM bot_responses
>>>>>>> 1f5672c (Updated readme)
=======
SELECT keyword, reply FROM bot_responses
>>>>>>> e611a2a341ba555c48fefa7f24f84248b08c97ec

## How to Compile and Run

Open terminal in the src folder:

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
cd "C:\Users\SANDHYA KUMARI\AI_Chatbot_System\AI_ChatBot_System"
=======
cd "C:\Users\SANDHYA KUMARI\JavaProject\AI_Chabot_System\src"
>>>>>>> 1f5672c (Updated readme)
=======
cd "C:\Users\SANDHYA KUMARI\AI_Chatbot_System\AI_ChatBot_System"
>>>>>>> e611a2a (INITIAL COMMIT)
=======
cd "C:\Users\SANDHYA KUMARI\AI_Chatbot_System\AI_ChatBot_System"
>>>>>>> e611a2a341ba555c48fefa7f24f84248b08c97ec


Compile Java files:

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
javac -cp "lib/mysql-connector-j-9.5.0.jar" -d bin src\*.java
=======
javac -cp ".;../lib/mysql-connector-j-9.5.0.jar" *.java
>>>>>>> 1f5672c (Updated readme)
=======
javac -cp "lib/mysql-connector-j-9.5.0.jar" -d bin src\*.java
>>>>>>> e611a2a (INITIAL COMMIT)
=======
javac -cp "lib/mysql-connector-j-9.5.0.jar" -d bin src\*.java
>>>>>>> e611a2a341ba555c48fefa7f24f84248b08c97ec


Run the GUI:

java -cp "bin;lib/mysql-connector-j-9.5.0.jar" ChatbotGUI


## Features

Java Swing GUI for interactive chatbot interface

MySQL database integration for storing chat history and bot responses

Dynamic responses based on keywords

Logs all user and bot messages

## screenshot
![alt text](image-1.png)

##Notes

Make sure the MySQL server is running before launching the chatbot

Update username/password in DatabaseHandler.java if your MySQL credentials differ

## Authors

- *Pratishtha Verma* – Team Leader  
- Tanvi Singh  
- Sandhya Kumari







<!-- ## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies). -->
