# Car Dealership Management System

## Description of the Project

This application is a comprehensive vehicle inventory management system for car dealerships. It connects to a MySQL database to manage vehicle information, allowing users to search, add, and remove vehicles from inventory, as well as create and track sales and lease contracts. The application uses JDBC for database connectivity and provides a console-based menu interface for easy navigation.

Key features include:
- Advanced vehicle search capabilities (by price, make/model, year, color, mileage, and type)
- Vehicle inventory management (add/remove vehicles)
- Contract management (create sales and lease contracts)
- Database-backed persistence using MySQL
- Connection pooling with Apache Commons DBCP2

## User Stories

- As a user, I want to view all vehicles in the dealership's inventory, so that I can see the full list of available cars and their details.
- As a user, I want to search for vehicles using various criteria (price, color, make/model, year, mileage, and type of vehicle), so that I can find options that fit my preferences.
- As a business owner, I want to be able to add and remove a vehicle from the dealership's inventory, so that I can ensure the system reflects currently available vehicles.
- As a business owner, I want to create sales and lease contracts for vehicles, so that I can keep a record of all transactions.
- As a user, I want to exit the application safely, so that I can close the program without losing any updates made to the database.
- As a developer, I want to use a Data Access Object (DAO) pattern, so that my database operations are organized and maintainable.
- As a developer, I want to use connection pooling, so that database connections are managed efficiently.
- As a user, I want to see helpful prompts and clear instructions in the console, so that I always know what input the program expects.

## Setup

Instructions on how to set up and run the project using IntelliJ IDEA.

### Prerequisites

- IntelliJ IDEA: Ensure you have IntelliJ IDEA installed, which you can download from [here](https://www.jetbrains.com/idea/download/).
- Java SDK: Make sure Java SDK 17 is installed and configured in IntelliJ.
- MySQL: Install MySQL Server and ensure it's running on your local machine.
- Maven: The project uses Maven for dependency management (included with IntelliJ IDEA).

### Database Setup

1. Create a MySQL database named `car_dealership`
2. Run the necessary SQL scripts to create the required tables:
   - `vehicles` table
   - `dealerships` table
   - `inventory` table
   - `sales_contracts` table
   - `lease_contracts` table

### Running the Application in IntelliJ

Follow these steps to get your application running within IntelliJ IDEA:

1. Open IntelliJ IDEA.
2. Select "Open" and navigate to the directory where you cloned or downloaded the project.
3. After the project opens, wait for IntelliJ to index the files and set up the project.
4. Ensure Maven dependencies are downloaded (IntelliJ should do this automatically).
5. Find the main class: `src/main/java/com/yearup/dealership/Main/Main.java`
6. Right-click on the file and select 'Run 'Main.main()''
7. **Important:** The application requires command-line arguments for database credentials:
   - Edit the run configuration
   - Add program arguments: `your_mysql_username your_mysql_password`
   - Example: `root mypassword`

## Technologies Used

- Java 17
- MySQL 8.0.33
- JDBC (Java Database Connectivity)
- Apache Commons DBCP2 2.9.0 (Database Connection Pooling)
- Maven (Dependency Management)

## Demo

Screenshots showcasing the application's functionality:

### Main Menu
![Main Menu](path/to/screenshot1.png)
*The main menu showing all available options*

### Search Vehicles
![Search by Filter](path/to/screenshot2.png)
*Searching for vehicles by various criteria*

### Add Vehicle
![Add Vehicle](path/to/screenshot3.png)
*Adding a new vehicle to the inventory*

### Create Contract
![Create Contract](path/to/screenshot4.png)
*Creating a sales or lease contract*

### Remove Vehicle
![Remove Vehicle](path/to/screenshot5.png)
*Removing a vehicle from inventory*

## Future Work

Potential future enhancements or functionalities:

- **Web Interface:** Develop a web-based UI using Spring Boot and Thymeleaf for better user experience
- **Admin Dashboard:** Create separate admin and customer views with role-based access control
- **Reporting Features:** Generate sales reports, inventory analytics, and financial summaries
- **Customer Management:** Add customer profiles and purchase history tracking
- **Advanced Search:** Implement full-text search and saved search filters
- **Email Notifications:** Send automated emails for contract confirmations
- **REST API:** Expose dealership data through a RESTful API for third-party integrations
- **Vehicle Images:** Support for uploading and displaying vehicle photos
- **Payment Processing:** Integrate payment gateway for deposits and transactions
- **Mobile App:** Develop a companion mobile application for on-the-go access

## Resources

Resources used during development:

- LTCA Workbooks 7a & 8c
- ChatGPT to aid in README creation

## Team Members

- **Raymond Maround** - Lead Developer - Created main menu and skeleton for project
- **Stephen Anku** - Developer - Created metheds for DAOs 

## Thanks

- Thank you to **Raymond Maroun** for continuous support and guidance throughout the development process.
