package com.prime

import org.apache.storm.spout.SpoutOutputCollector
import org.apache.storm.task.TopologyContext
import org.apache.storm.topology.OutputFieldsDeclarer
import org.apache.storm.topology.base.BaseRichSpout
import org.apache.storm.tuple.{Fields, Values}

import java.util

class PrimeSpout extends BaseRichSpout {
  private var collector: SpoutOutputCollector = _
  private var number: Int = 1

  override def declareOutputFields(outputFieldsDeclarer: OutputFieldsDeclarer): Unit = {
    outputFieldsDeclarer.declare(new Fields("number"))
  }

  override def open(map: util.Map[String, AnyRef], topologyContext: TopologyContext, spoutOutputCollector: SpoutOutputCollector): Unit = {
    this.collector = spoutOutputCollector
  }

  override def nextTuple(): Unit = {
    collector.emit(new Values(new Integer(number)))
    number += 1
  }
}