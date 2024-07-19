name := "PrimeCheck"

version := "1.0"

scalaVersion := "2.11.12"

resolvers ++= Seq(
  "artifactory-releases" at "https://artifactory.adform.com/artifactory/libs-release/",
  "artifactory-snapshots" at "https://artifactory.adform.com/artifactory/libs-snapshot/",
  "artifactory-release-local" at "https://artifactory.adform.com/artifactory/libs-release-local",
  "alexandrnikitin" at "https://github.com/alexandrnikitin/bloom-filter-scala/releases"
)

val stormVersion = "2.6.2"

libraryDependencies ++= Seq(
  // Add any additional dependencies here, if necessary
  "org.apache.storm"            % "storm-core"                % stormVersion
)

ThisBuild / mainClass := Some("com.prime.PrimeTopology")
