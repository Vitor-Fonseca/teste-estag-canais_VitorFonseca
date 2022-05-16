JC = javac
JVM= java 
MP= my_program
MAIN = program 

.SUFFIXES: .java .class

.java.class:
	$(JC) $(MP)/*.java

all: run clean

run: compile
	$(JVM) $(MP).$(MAIN)

compile: 
	$(JC) $(MP)/*.java        

clean:
	$(RM) $(MP)/*.class
