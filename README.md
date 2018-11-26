# FamilyTree
A Java project that uses Maven as a build tool. 
Application takes a file containing children and their parents names and outputs a family tree.

## Example of input and output
### Content of input file:
...
Adam Ivan
Marko Stjepan
Stjepan Adam
Robert Stjepan
Fran Ivan
Leopold Luka
Leopold Ivan
Teodor Leopold
Stjepan Josip
...

### Expected utput:
...
Ivan
    Adam
        Stjepan
            Marko
            Robert
    Fran
    Leopold
        Teodor
Luka
    Leopold
        Teodor
Josip
    Stjepan
        Marko
        Robert
...

## Running and testing the application
Application takes a file path as an argument from command line and outputs a result.

### Example of running an application through command line using javac
...
..\FamilyTree\src\main\java>javac App.java
..\FamilyTree\src\main\java>java App C:\FamilyTree\src\main\resources\podaci.txt
Ivan
    Adam
        Stjepan
            Marko
            Robert
    Fran
    Leopold
        Teodor
Luka
    Leopold
        Teodor
Josip
    Stjepan
        Marko
        Robert
...

Application can be tested from command line using Maven commands.

### Example of running tests from command line using Maven
