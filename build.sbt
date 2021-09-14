lazy val zio_nio = project
  .in(file("nio"))
  .dependsOn(zio_nio_core)
  .settings(
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio-test-sbt" % "1.0.10" % Test
    )
  , testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  , scalaVersion := "3.1.0-RC1"
  , crossScalaVersions := "3.1.0-RC1" :: "2.13.6" :: Nil
  , scalacOptions += "-nowarn"
  )
  .dependsOn(zio_nio_core)
  .aggregate(zio_nio_core)

lazy val zio_nio_core = project
  .in(file("nio-core"))
  .settings(
    libraryDependencies ++= Seq(
      "dev.zio" %% "zio-streams"  % "1.0.10"
    , "dev.zio" %% "zio-test-sbt" % "1.0.10" % Test
    )
  , testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")
  , scalaVersion := "3.1.0-RC1"
  , crossScalaVersions := "3.1.0-RC1" :: "2.13.6" :: Nil
  , scalacOptions += "-nowarn"
  )

ThisBuild / turbo := true
ThisBuild / useCoursier := true
Global / onChangedBuildSource := ReloadOnSourceChanges