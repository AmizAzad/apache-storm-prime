package main.scala.com.prime

import org.apache.storm.{Config, LocalCluster}
import org.apache.storm.topology.TopologyBuilder

object PrimeTopology extends App {
  val builder: TopologyBuilder = new TopologyBuilder
  builder.setSpout("spout", new PrimeSpout)
  builder.setBolt("both", new PrimeBolt).shuffleGrouping("spout")

  val config: Config = new Config
  val cluster: LocalCluster = new LocalCluster
  cluster.submitTopology("topology", config, builder.createTopology())

  Thread.sleep(5000)

  cluster.killTopology("topology")
  cluster.shutdown()
}
