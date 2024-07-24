package com.prime

import org.apache.storm.{Config, LocalCluster, StormSubmitter}
import org.apache.storm.topology.TopologyBuilder
import org.apache.storm.utils.Utils

object PrimeTopology extends App {
  val builder: TopologyBuilder = new TopologyBuilder
  builder.setSpout("spout", new PrimeSpout)
  builder.setBolt("bolt", new PrimeBolt).shuffleGrouping("spout")
  System.setProperty("storm.jar", "/Users/a.azad/IdeaProjects/apache-storm-prime/ApacheStormPrimeScala/target/scala-2.12/primecheck_2.12-1.0.jar")

  val config: Config = new Config
  // val cluster: LocalCluster = new LocalCluster
  StormSubmitter.submitTopology("topology", config, builder.createTopology())

  Runtime.getRuntime.addShutdownHook(new Thread() {
    override def run(): Unit = {
      println("Shutting down storm topology of prime numbers ...")
    }
  })

  Utils.sleep(30000)
  System.exit(0)
}
