# Scala Storm starter

The example [storm-starter](https://github.com/nathanmarz/storm-starter) project ported to Scala (2.9.2) and sbt (0.11.3); tested using [Specs2](http://etorreborre.github.com/specs2/). [![Build Status](https://secure.travis-ci.org/paulfryzel/scala-storm-starter.png?branch=master)](http://travis-ci.org/paulfryzel/scala-storm-starter)


## Building with sbt

    sbt compile
    
## Testing with Specs2

    sbt test

## Running an example topology

Generate [and run] a script for desired topology (mainClass key is specified in build.sbt):

    sbt generate-storm
    ./bin/run-main-topology.sh
    
## Packaging jar for remote deployment

Create a jar with dependencies using the sbt-assembly plugin:

    sbt assembly