# FamilyTree
A Java project that uses Maven as a build tool. 
Application takes a file containing children and their parents names and outputs a family tree.

## Behaviour and look
First entry of child and parent:
<pre>
Adam Ivan
</pre>
<pre>
Ivan
    Adam
</pre>
New entry of new child and new parent:
<pre>
Adam Ivan
Marko Stjepan
</pre>
<pre>
Ivan
    Adam
Stjepan
    Marko
</pre>
New entry of new child and parent that is already in family:
<pre>
Adam Ivan
Marko Stjepan
Robert Stjepan
</pre>
<pre>
Ivan
    Adam
Stjepan
    Marko
</pre>

family.addRelation("Adam", "Ivan");
		family.addRelation("Marko", "Stjepan");
		family.addRelation("Robert", "Stjepan");
		family.addRelation("Stjepan", "Adam");
	
		//Test
		family.addRelation("Adam", "Robert");

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
