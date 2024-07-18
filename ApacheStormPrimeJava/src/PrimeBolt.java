import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;

import java.util.Map;

public class PrimeBolt extends BaseRichBolt {
    private OutputCollector collector;

    @Override
    public void prepare(Map<String, Object> map, TopologyContext topologyContext, OutputCollector outputCollector) {
        this.collector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        int number = tuple.getInteger(0);
        if(isPrime(number))
            System.out.println(number);
        collector.ack(tuple);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("number"));
    }

    private boolean isPrime(int number) {
        if (number == 1 || number == 2 || number == 3)
            return true;

        if (number % 2 == 0)
            return false;

        for (int i=3; i*i <= number; i+=2) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
