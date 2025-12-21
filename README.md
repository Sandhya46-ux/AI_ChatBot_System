
# AI Chatbot System (Java GUI + MySQL)

## Project Overview
This project is an AI Chatbot system built using *Java Swing* for the GUI and *MySQL* for storing chat history and bot responses. The chatbot responds to user queries based on predefined keywords stored in the database and logs conversations for future reference.

---

## Project Structure

AI_Chatbot_System/
├── src/
│   ├── ChatbotGUI.java
│   ├── BotLogic.java
│   ├── DatabaseHandler.java
│   └── ChatServlet.java
├── WEB-INF/
│   └── classes/
├── lib/
├── index.html
├── README.md
└── root.session.sql

This project fulfills requirements related to:

Java programming
GUI development
Event handling
Client–server architecture
Database integration
Software modularity

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
--------------------------------------------------------------
## How to Compile and Run

Open terminal :

cd "C:\Users\SANDHYA KUMARI\AI_Chatbot_System\AI_ChatBot_System\src"

Compile Java files:

javac --release 17 ChatbotGUI.java BotLogic.java DatabaseHandler.java Message.java


Run the GUI:

java ChatbotGUI

The gui window will open and then you can type e.g., "hello"

------------------------------------------------------------
Project Overview

The AI Chatbot System is a Java-based application that demonstrates both desktop GUI interaction and web-based communication using modern Java technologies.

The project is divided into two execution modes:

GUI-based Chatbot (Primary & Fully Functional)

Web-based Chatbot (Innovative Extension)

🚀 Features

Java Swing–based graphical user interface

Event-driven message handling

Centralized chatbot logic

JDBC-based database connectivity (MySQL)

Modular and object-oriented design

Optional web-based chatbot using Java Servlets

🖥️ GUI-Based Chatbot (Working Version)
🔹 Description

The GUI chatbot is implemented using Java Swing.
Users can type messages in a desktop window and receive intelligent responses from the chatbot.

This version demonstrates:

GUI programming

Event handling

Object-Oriented Programming

Integration with backend logic

🔹 How to Compile (GUI Version)

Open Command Prompt and navigate to the src directory:

cd src


Compile the required files:

javac -encoding UTF-8 ChatbotGUI.java BotLogic.java DatabaseHandler.java

🔹 How to Run (GUI Version)
java ChatbotGUI


✅ A desktop window titled “AI Chatbot” will appear.
Type a message and click Send to interact with the chatbot.
-----------------------------------------------------------

🌐 Web-Based Chatbot (Innovative Extension)
🔹 Description

As an innovative enhancement, the project also includes a web-based chatbot implemented using:

Java Servlets

HTML + JavaScript frontend

Apache Tomcat server

This allows chatbot interaction through a web browser, demonstrating client–server communication.

🔹 Web-Based Architecture

index.html acts as the frontend interface

JavaScript sends POST requests to a servlet

Servlet processes the input using the same chatbot logic

Response is sent back to the browser dynamically
----------------------------------------------

1️⃣ Start Apache Tomcat Server

Open Command Prompt and run:

cd C:\apache-tomcat-9.0.113\bin
startup.bat


✔ Server starts on port 8080

2️⃣ Verify Tomcat is Running

Open a browser and visit:

http://localhost:8080/


If the Tomcat homepage appears, the server is running successfully.

3️⃣ Open the Chatbot Web Page

In the browser, open:

http://localhost:8080/AI_CHATBOT_SYSTEM/index.html


This loads the chatbot’s HTML interface.

4️⃣ Interact with the Chatbot

Type a message in the input box

Click the Send button

The message is sent to the backend servlet using an HTTP POST request

The chatbot response is displayed dynamically on the web page

5️⃣ Stop Apache Tomcat Server (After Use)

When finished, stop the server using:

cd C:\apache-tomcat-9.0.113\bin
shutdown.bat

🔄 Internal Request Flow (Behind the Scenes)
User → Browser (index.html)
     → JavaScript fetch()
     → ChatServlet (Tomcat)
     → BotLogic (Java)
     → Response sent back to browser

🎓 Academic Note

This web-based execution demonstrates:

Client–server architecture

HTTP request handling using Servlets

Integration of frontend and backend components

Reuse of chatbot logic across platforms

-----------------------------------------------

## Authors

- *Pratishtha Verma* – Team Leader  
- Tanvi Singh  
- Sandhya Kumari




