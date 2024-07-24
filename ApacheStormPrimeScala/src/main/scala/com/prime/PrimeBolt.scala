package com.prime

import org.apache.storm.task.{OutputCollector, TopologyContext}
import org.apache.storm.topology.OutputFieldsDeclarer
import org.apache.storm.topology.base.BaseRichBolt
import org.apache.storm.tuple.{Fields, Tuple}

import java.util

class PrimeBolt extends BaseRichBolt {
  private var collector: OutputCollector = _

  override def prepare(map: util.Map[String, AnyRef], topologyContext: TopologyContext, outputCollector: OutputCollector): Unit = {
    this.collector = outputCollector
  }

  override def execute(tuple: Tuple): Unit = {
    var number = tuple.getInteger(0)
    if (isPrime(number)) println("Prime Number: "+number)
    Thread.sleep(500)
    collector.ack(tuple)
  }

  override def declareOutputFields(outputFieldsDeclarer: OutputFieldsDeclarer): Unit = {
    outputFieldsDeclarer.declare(new Fields("number"))
  }

  private def isPrime(number: Int): Boolean = {
    if (number == 1 || number == 2 || number == 3) return true
    else if (number % 2 == 0) return false
    else {
      for {
        i <- 3 to Math.sqrt(number).toInt by 2
      } yield if (number % i == 0) return false
    }
    true
  }
}
