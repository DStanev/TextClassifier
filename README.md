# Text classifier API

The API could be used in two different manners:
1. as standard java class getting the singleton instance of TextClassifierAPISingleton class. 
In this case the user should take care of adding the StringRepresentationStrategies on its own.

2. as a spring boot component. 
In this case all implementors of StringRepresentationStrategy are dynamically referenced by the container


## Running the Application
There are two ways to run the application :  
1. run the Main class and writing lines to the standard input
2. run the Application class - this starts a Rest service on localhost:8080/text.
You can use a GET request on the following uri: http://localhost:8080/text/{text}


