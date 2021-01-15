![Socialyze][]
# Software Architecture Document


## 1. Introduction 
### 1.1 Purpose
This document provides a comprehensive architectural overview of the system, 
using a number of different architectural views to depict different aspects of the system. 
It is intended to capture and convey the significant architectural decisions which have been made on the system.

### 1.2 Scope
The scope of this SAD is to show the architecture of the Socialyze project. Affected are the class structure, the use cases and the data representation.

### 1.3 References
- [GitHub](https://github.com/soshalyze)
- [Blog](https://socialyze807275475.wordpress.com/)
- [Overall Use case diagram](https://github.com/soshalyze/socialyze_doc/blob/master/usecase/use_case_diagram.png)
- [Software Requirements Specification](SRS.MD)
- [UC Create Account](markdown_CreateAccount.md)
- [UC Login](markdown_Login.md)
- [UC Retrieve Data from Server](markdown_ChooseVisualizationType.md)
- [UC ChooseVisualization](markdown_RetrrieveDataFromServer.md)
- [UC SelectDataset](markdown_SelectDataset.md)


## 2. Architectural Representation
Socialyze uses the MVD Pattern from Django for its architecture design.

MVT Diagram: 
- [MVT Pattern](https://github.com/soshalyze/socialyze_doc/blob/master/img_blog/Django_MVT-1-683x1024.jpg)



## 3.Architectural Goals and Constraints 
We decided to use praw for the back-end as a connection to reddit and Plotly for the front-end for the visualization of the dataset.
Both components are coupled by the Rest-API. 

## 4. Use-Case View 
n/a

## 5. Logical View
Templates aren´t no classes, in our project they are only HTML files.
Our classes were only in model.py

- [Diagram](https://github.com/soshalyze/socialyze_doc/blob/master/img_blog/LogicalView.png)


## 6. Process View
n/a

## 7. Deployment View
n/a
## 8. Implementation View
n/a

## 9. Data View
We're using the PostgreSQL database to store our data. 


## 10. Size and Performance
tbd

## 11. Quality
We use PyCharm as our IDE and Django as our webframework.
