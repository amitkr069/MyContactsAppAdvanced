# MyContactsApp

A comprehensive contact management application built in Java that provides users with a complete solution for organizing and managing their personal and professional contacts.


## Features

### User Management

User registration and authentication

Profile management (view, update, change password)

User preferences configuration

Session management with secure login/logout


### Contact Management

Create, view, edit, and delete contacts

Support for multiple phone numbers and email addresses per contact

Bulk operations (bulk delete, bulk tagging)

Contact categorization with tags

Soft delete functionality with contact frequency tracking


### Search and Filtering

Advanced search capabilities with multiple criteria

Search by name, email, phone number, and tags

Filter contacts by date added, frequency of contact, and custom tags

Composite search criteria for complex queries


### Advanced Features

Undo/Redo functionality for contact edits using Command pattern

Observer pattern implementation for contact deletion logging

Tag assignment and management system

Contact display decorators for formatted output


### Architecture

The application follows a layered architecture with clear separation of concerns:

## Design Patterns Implemented

**Command Pattern**: For undo/redo operations on contact edits

**Observer Pattern**: For logging contact deletions

**Factory Pattern**: For creating contacts and users

**Decorator Pattern**: For contact display formatting

**Composite Pattern**: For complex contact operations and filters

**Repository Pattern**: For data access abstraction

**Builder Pattern**: For constructing complex objects


## Technology Stack

Language: Java 21

Testing: JUnit 5

Build Tool: Eclipse IDE (with .classpath configuration)

Architecture: Layered architecture with design patterns


## Usage

The application provides a console-based menu interface with the following main sections:

Registration/Login: Create new accounts or authenticate existing users

Profile Management: Update personal information and preferences

Contact Operations: Full CRUD operations on contacts

Search and Filter: Find contacts using various criteria

Tagging System: Organize contacts with custom tags

Bulk Operations: Perform actions on multiple contacts simultaneously
