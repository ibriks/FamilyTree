# FamilyTree
A Java project that uses Maven as a build tool.  
Application takes a file containing children's and their parents' names and outputs a family tree.

## Behaviour and look
First entry of child and parent.
<pre>
Adam Ivan
</pre>
<pre>
Ivan
    Adam
</pre>
New entry, child not in family, parent not in family.
<pre>
Marko Stjepan
</pre>
<pre>
Ivan
    Adam
Stjepan
    Marko
</pre>
New entry, child not in family, parent in family.
<pre>
Robert Stjepan
</pre>
<pre>
Ivan
    Adam
Stjepan
    Marko
    Robert
</pre>
New entry, child in family, parent not in family.
<pre>
Robert Josip
</pre>
<pre>
Ivan
    Adam
Josip
    Robert
Stjepan
    Marko
    Robert
</pre>
New entry, child in family, parent in family, with no rules broken.
<pre>
Stjepan Adam
</pre>
<pre>
Ivan
    Adam
        Stjepan
            Marko
            Robert
Josip
    Robert
</pre>
New entry, child in family, parent in family, with breaking the rules. <br/>
"Adam Ivan" repeats a relation. <br/>
"Adam Adam" creates a loop within person. <br/>
"Adam Robert" creates a cyclic relation. <br/>
For each forbidden entry a RelationNotAllowedException is thrown with message about a specific problem. Application continues to run without adding forbidden relation to the family.
<pre>
Adam Ivan
Adam Adam
Adam Robert
</pre>
<pre>
RelationNotAllowedException: Msg: Adam is already a child of Ivan!
RelationNotAllowedException: Msg: Adam cannot be its parent or child!
RelationNotAllowedException: Msg: Trying to make cyclic relation with Adam and Robert!
Ivan
    Adam
        Stjepan
            Marko
            Robert
Josip
    Robert
</pre>

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
