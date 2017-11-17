name := "SparkUdf"

version := "1.0"

fork := true

scalaVersion := "2.11.2"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "1.6.3"

resolvers += "Sonatype OSS Snapshots" at
  "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.8.2" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"

testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework")