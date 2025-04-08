# 🚀 Multithreaded Lift Management System in Java

A multithreaded elevator simulation built in Java that models real-life elevator operations in a building. This project demonstrates the use of Java Threads, concurrency, and scheduling logic to manage multiple elevators serving requests efficiently.

## 🛠️ Features

- 🚪 Multiple elevators operating concurrently using threads
- 🎯 Dynamic request scheduling based on elevator direction and proximity
- 🔄 Intelligent routing: elevators prioritize requests in the same direction
- 🧵 Thread-safe queue for handling floor requests
- 📊 Console-based visualization of elevator status and movement
- 🔧 Configurable number of elevators and floors

## 🧱 System Architecture

- Elevator.java – A Thread class representing a single elevator
- ElevatorController.java – Controller which assigns floor requests to the optimal elevator
- PersonRequest.java – Represents a user's request (from → to)
- Main.java – Entry point; initializes elevators and simulates input
