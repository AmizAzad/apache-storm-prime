name := "PrimeCheck"

version := "1.0"

scalaVersion := "2.11.12"

// including apache storm lib jars to classpath
val stormLibPath = "/Users/a.azad/IdeaProjects/apache-storm-prime/ApacheStormPrimeScala/external"
Compile / unmanagedJars ++= (file(stormLibPath) ** "*.jar").classpath

libraryDependencies ++= Seq(
  // Add any additional dependencies here, if necessary
)

ThisBuild / mainClass := Some("com.prime.PrimeTopology")
