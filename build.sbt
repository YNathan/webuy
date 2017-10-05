name := "WeBuy"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "mysql" % "mysql-connector-java" % "5.1.18",
  "com.sun.mail" % "javax.mail" % "1.5.5",
  "commons-io" % "commons-io" % "2.4",
  "org.projectlombok" % "lombok" % "1.16.18"
)

play.Project.playJavaSettings
