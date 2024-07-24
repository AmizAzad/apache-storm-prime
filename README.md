# apache-storm-prime
Apache storm is used to process a stream of infinite numbers and filter out only the prime numbers using Java and Scala.
Currently, apache-storm-2.6.2 is used and jars from apache-storm-2.6.2/lib need to be included in the buildpath (for compilation) and classpath (at runtime) to run the above Java project. However, the same is not required for the scala project as the necessary dependencies have been provided within the .sbt file.

Command used to run the topology locally:
storm jar /opt/homebrew/Cellar/scala@2.12/2.12.19/libexec/lib/scala-library.jar:/Users/a.azad/IdeaProjects/apache-storm-prime/ApacheStormPrimeScala/target/scala-2.12/primecheck_2.12-1.0.jar com.prime.PrimeTopology -c topology.debug=true
