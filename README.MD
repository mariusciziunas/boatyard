## Dijkstra's shortest path algorithm

Application has been developed as unattended test for a job interview. It solves the very specific tasks here. One of the tasks is Dijkstra's shortest path algorithm implementation, which is worth sharing

The goal is to calculate distances and routes count of Venice suburbs. Input data is a Venice map which is provided in a file 'venice.txt'.
Valid data in the input file should be format of: [[suburbName][SuburbName][distanceBetween] ]. For example: AB7 BF1

Solution is provided in the form of maven (http://maven.apache.org/download.cgi) project. 

Application is developed by Java 1.7 language. As a sequence, execution of this application requires the JRE 7 install  (http://www.oracle.com/technetwork/java/javase/downloads/jre7-downloads-1880261.html)

Three executable files provided:
build.cmd - builds the application to /target/ directory
run.cmd - runs the jar
test.cmd - runs junit tests

have a good time :)