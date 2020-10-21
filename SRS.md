# littleBeasts - Software Requirements Specification

## Table of Contents

-   [Flashcard Community - Software Requirements Specification](#flashcard-community---software-requirements-specification)

    -   [Table of Contents](#table-of-contents)

    -   [1. Introduction](#1-introduction)

        -   [1.1 Purpose](#11-purpose)
        -   [1.2 Scope](#12-scope)
        -   [1.3 Definitions, Acronyms and Abbreviations](#13-definitions-acronyms-and-abbreviations)
        -   [1.4 References](#14-references)
        -   [1.5 Overview](#15-overview)

    -   [2. Overall Description](#2-overall-description)

        -   [2.1 Vision](#21-vision)

    -   [2.2 Product perspective](#22-product-perspective)

        -   [2.3 User characteristics](#23-user-characteristics)
        -   [2.4 Dependencies](#24-dependencies)

    -   [3. Specific Requirements](#3-specific-requirements)

        -   [3.1 Functionality – Data Backend](#31-functionality--data-backend)

            -   [3.1.1 Read data given over API endpoints](#311-read-data-given-over-api-endpoints)
            -   [3.1.2 Parse data](#312-parse-data)
            -   [3.1.3 Provide data](#313-provide-data)

        -   [3.2 Reliability](#32-reliability)

            -   [3.4.1 Availability](#341-availability)
            -   [3.4.2 MTBF, MTTR](#342-mtbf-mttr)
            -   [3.4.3 Accuracy](#343-accuracy)
            -   [3.4.4 Bug classes](#344-bug-classes)

        -   [3.3 Performance](#33-performance)

            -   [3.5.1 Response time](#351-response-time)
            -   [3.5.2 Throughput](#352-throughput)
            -   [3.5.3 Capacity](#353-capacity)
            -   [3.5.4 Resource utilization](#354-resource-utilization)

        -   [3.4 Supportability](#34-supportability)

        -   [3.5 Design Constraints](#35-design-constraints)

            -   [3.5.1 Development tools](#351-development-tools)
            -   [3.5.2 Spring Boot](#352-spring-boot)
            -   [3.5.3 ReactJS](#353-reactjs)
            -   [3.5.4 Supported Platforms](#354-supported-platforms)

        -   [3.6 Online User Documentation and Help System Requirements](#36-online-user-documentation-and-help-system-requirements)

        -   [3.7 Purchased Components](#37-purchased-components)

        -   [3.8 Interfaces](#38-interfaces)

            -   [3.8.1 User Interfaces](#381-user-interfaces)
            -   [3.8.2 Hardware Interfaces](#382-hardware-interfaces)
            -   [3.8.3 Software Interfaces](#383-software-interfaces)
            -   [3.8.4 Communications Interfaces](#384-communications-interfaces)

        -   [3.9 Licensing Requirements](#39-licensing-requirements)

        -   [3.10 Legal, Copyright and other Notices](#310-legal-copyright-and-other-notices)

        -   [3.11 Applicable Standards](#311-applicable-standards)

    -   [4. Supporting Information](#4-supporting-information)

## 1. Introduction

### 1.1 Purpose
This Software Requirements Specification (SRS) describes all specifications for the application "GuessWhere". It includes an overview about this project and its vision, detailed information about the planned features and boundary conditions of the development process.

### 1.2 Scope
The project is going to be realized as an Android App.  
  
Planned Subsystems are: 
* The Game:  
The game is the essential part of the app. Game sessions should be visualized as postings including relevant information about the session. Those should be partly standardized by a form with a free text option for specifics. The data must be stored accordingly.

* Account System:  
Users can create accounts to save their progress made in the game. User data must be stored alongside the posting data.

* Friend List:  
Once the account system is created there will be the option to mark users as favorites.

* User Ranking:
There should be a leaderboard for users to compare themselves amongst each other.

* Storing Data:  
User data for accounts and possibly profiles has to be stored. Also game statistics have to be stored in order to be used for the leaderboard.

### 1.3 Definitions, Acronyms and Abbreviations

| Term     |                                     |
| -------- | ----------------------------------- |
| **SRS**  | Software Requirements Specification |
| **JSON** | JavaScript Object Notation          |
| **API**  | Application Programming Interface   |
| **MTBF** | Mean Time Between Failures          |
| **MTTR** | Mean Time To Repair                 |
| **DTO**  | Data Transfer Object                |
| **HTTP** | Hypertext Transfer Protocol         |
| **FAQ**  | Frequently Asked Questions          |
| **REST** | Representational State Transfer     |

### 1.4 References

| Title                                                                                                 | Date       |
| ----------------------------------------------------------------------------------------------------- | ---------- |
| [Blog](https://wordpress.com/page/guesswheregame.wordpress.com)                                       | 21/10/2020 |
| [GitHub](https://github.com/Eightdays1/guesswhere)                                                    | 21/10/2020 |

### 1.5 Overview

## 2. Overall Description

### 2.1 Vision
The app we want to create is a game where you are shown a picture from somewhere around the world and you have to point somewhere on the world map where you think this location is. The closer you are the more points you get. We were inspired by several other games that are similar to our idea. Most of these are either browser games or are badly implemented f.e. with lots of ads or paylocked-content. We plan to create this without those "features".

## 2.2 Product perspective
In addition to the game, we want to implement several other features that are supposed to make the game experience even better. Those are for example a general account system, a database, a leaderboard and friendslist. 

### 2.3 User characteristics
A user is defined by a Username, an unchangeable ID, a score and a list of ID's they're friends with. 

### 2.4 Dependencies
Not decided yet, though we are probably going to use python for the backend.

## 3. Specific Requirements
### 3.1 Functionality
This section explains all of the functional requierements and the order in which we plan to implement them.
3.1.1 The Game
3.1.2 Interface
3.1.3 User accounts
3.1.3 Database
3.1.4 Statistics
3.1.5 Leaderboard
3.1.6 Friends
Possibly:
3.1.7 A versus mode
3.1.8 A chat function

#### 3.1.1 The Game
The User should be able to:
    - create an account
    - change settings on this account
    - play the game
    - look at a leaderboard
    - look at their own statistics
    - send other players friend invites
    
#### 3.1.2 Interface

#### 3.1.3 User accounts

#### 3.1.3 User accounts

#### 3.1.3 Database

#### 3.1.4 Statistics

#### 3.1.5 Leaderboard

#### 3.1.6 Friends

#### 3.1.7 A versus mode

#### 3.1.8 A chat function

### 3.2 Reliability

#### 3.2.1 Availability

#### 3.2.2 MTBF, MTTR

#### 3.2.3 Accuracy

#### 3.2.4 Bug classes

### 3.3 Performance

#### 3.3.1 Response time

#### 3.3.2 Throughput

#### 3.3.3 Capacity

#### 3.3.4 Resource utilization

### 3.4 Supportability

### 3.5 Design Constraints

#### 3.5.1 Development tools

#### 3.5.2 Spring Boot

#### 3.5.3 ReactJS

#### 3.5.4 Supported Platforms

### 3.6 Online User Documentation and Help System Requirements

### 3.7 Purchased Components

### 3.8 Interfaces

#### 3.8.1 User Interfaces

#### 3.8.2 Hardware Interfaces

#### 3.8.3 Software Interfaces

#### 3.8.4 Communications Interfaces

### 3.9 Licensing Requirements

### 3.10 Legal, Copyright and other Notices

### 3.11 Applicable Standards

## 4. Supporting Information
