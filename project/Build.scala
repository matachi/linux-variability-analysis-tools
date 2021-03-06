import sbt._
import Keys._

object LVATBuild extends Build {
    lazy val root = Project(id = "lvat", base = file("."))
    lazy val fmTranslation = Project(id = "fm-translation", base = file("fm-translation/")) dependsOn (root)
    lazy val paperTools = Project(id = "paper-tools", base = file("paper-tools/")) dependsOn (fmTranslation)
    lazy val incremental = Project(id = "incremental", base = file("incremental/")) dependsOn (fmTranslation)
    lazy val synthesis = Project(id = "synthesis", base = file("synthesis/")) dependsOn (fmTranslation)
}

// vim: set ts=4 sw=4 et:
