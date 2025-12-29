# Vehicle Rental Management System

## Description

This is a Java GUI application for managing an imaginary vehicle rental business. Built using object-oriented principles, it allows client registration, vehicle rental and return, vehicle status tracking, viewing active rentals, exporting data to TXT or binary files, and customizing the interface color theme.

The application categorizes vehicles into family cars, trucks, and sports cars, each with specific attributes. It uses Swing for the graphical user interface and demonstrates inheritance and polymorphism through vehicle subclasses.

## Features

- **Client Management**: Add new clients with name, email, and phone number.
- **Vehicle Inventory**: Predefined lists of family cars, trucks, and sports cars with details like brand, model, rental cost, and specific attributes (e.g., passenger capacity for family cars, load capacity for trucks, power for sports cars).
- **Rental Operations**: Rent available vehicles to clients, updating availability status.
- **Vehicle Return**: Receive returned vehicles and reset their status.
- **Maintenance**: Perform maintenance on available vehicles to reset their maintenance counter.
- **Active Rentals View**: Display a list of currently rented vehicles along with the renting client's name.
- **Reports**: Generate reports on rentals (implementation focuses on displaying or exporting rental data).
- **Data Export**: Export client and rental data to TXT or binary files for persistence.
- **UI Customization**: Change the interface color theme via menu options (e.g., red, blue, pink, green, gray).
- **Error Handling**: Basic exception handling with user-friendly messages via JOptionPane.

## Technologies Used

- Java (JDK 8 or higher)
- Swing for GUI components
- Object-Oriented Programming (OOP) concepts: Inheritance (e.g., vehicle subclasses extend `Auto`), Encapsulation, and Polymorphism.
- Data Structures: ArrayLists for managing clients and vehicles.
- File I/O: Serialization for binary exports and basic file output for TXT.

## Installation

1. **Prerequisites**: Ensure you have Java JDK installed (version 8 or higher). You can download it from [Oracle's website](https://www.oracle.com/java/technologies/downloads/) or use OpenJDK.

2. **Clone the Repository**:
   ```
   git clone https://github.com/yourusername/vehicle-rental-system.git
   cd vehicle-rental-system
   ```

3. **Compile the Code**:
   Use your IDE (e.g., NetBeans, IntelliJ, Eclipse) to open the project, or compile via command line:
   ```
   javac -d . src/proyecto/pkgfinal/*.java
   ```

4. **Run the Application**:
   ```
   java proyecto.pkgfinal.ProyectoFinal
   ```

## Usage

1. Launch the application by running the `ProyectoFinal` class.
2. The main window displays lists for:
   - Family Cars
   - Trucks
   - Sports Cars
   - Clients
   - Rented Vehicles
3. **Add a Client**: Click "Agregar nuevo cliente" and enter details in the prompts.
4. **Rent a Vehicle**: Select a vehicle from one of the lists and a client, then click "Rentar".
5. **Return a Vehicle**: Select a rented vehicle and click "Recibir".
6. **Maintenance**: Select an available vehicle and click "Mantenimiento".
7. **Customize Theme**: Use the "Diseño" menu to select a color.
8. **Generate Report**: Use the "Reportes" menu to generate and export rental data.

Note: Vehicles have a maintenance counter; they cannot be rented if maintenance is overdue.
