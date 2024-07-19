# apache-storm-prime
Apache storm is used to process a stream of infinite numbers and filter out only the prime numbers using Java and Scala.
Currently, apache-storm-2.6.2 is used and jars from apache-storm-2.6.2/lib need to be included in the buildpath (for compilation) and classpath (at runtime) to run the above Java project only. The scala project has been provided with the required .sbt file.

Command used to run the topology locally:
storm local /Users/a.azad/IdeaProjects/apache-storm-prime/ApacheStormPrimeScala/target/scala-2.11/primecheck_2.11-1.0.jar com.prime.PrimeTopology -c topology.debug=true
