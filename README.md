# FamilyTree
A Java project that uses Maven as a build tool. 
Application takes a file containing children and their parents names and outputs a family tree.

## Example of input and output
### Content of input file:
<pre>
Adam Ivan
Marko Stjepan
Stjepan Adam
Robert Stjepan
Fran Ivan
Leopold Luka
Leopold Ivan
Teodor Leopold
Stjepan Josip
</pre>
### Expected utput:
<pre>
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
</pre>

## Running and testing the application
### Example of running an application through command line using javac
Application takes a file path as an argument from command line and outputs a result.
<pre>
[ProjectPath]\FamilyTree\src\main\java>javac App.java
[ProjectPath]\FamilyTree\src\main\java>java App [ProjectPath]\FamilyTree\src\main\resources\podaci.txt
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
</pre>
### Example of running tests from command line using Maven
Application can be tested from command line using Maven commands.
<pre>
[ProjectPath]\FamilyTree>mvn test
</pre>
