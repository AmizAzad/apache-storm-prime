import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class PrimeTopology {

    public static void main(String[] args) throws Exception {
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("spout", new PrimeSpout());
        builder.setBolt("bolt", new PrimeBolt()).shuffleGrouping("spout");

        Config config = new Config();
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("topology", config, builder.createTopology());

        Thread.sleep(5000);

        cluster.killTopology("topology");
        cluster.shutdown();
    }
}
