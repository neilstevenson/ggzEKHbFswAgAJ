package neil;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@BenchmarkMode({Mode.Throughput})
@State(Scope.Benchmark)
@Warmup(iterations = 5, batchSize = 10, time = 6, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, batchSize = 100, time = 60, timeUnit = TimeUnit.SECONDS)
@OperationsPerInvocation(10000)
@OutputTimeUnit(TimeUnit.SECONDS)
@Threads(value = 1)
public class Hazelcast41Benchmark extends AbstractBenchmark {
    
    @SuppressWarnings("rawtypes")
    private Map theMap;
    private HazelcastInstance hazelcastInstance;

    @SuppressWarnings("unchecked")
    @Setup(Level.Trial)
    public void setUp() {
        Config config = new Config();
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        this.hazelcastInstance = Hazelcast.newHazelcastInstance(config);
        this.theMap = this.hazelcastInstance.getMap("m");
        Reproducer1.serialize(this.theMap);
    }

    @SuppressWarnings("unchecked")
    @Benchmark
    @Threads(value = 1)
    public void test_1_serialize(Blackhole blackhole) {
        blackhole.consume(Reproducer1.serialize(this.theMap));
    }
    
    @SuppressWarnings("unchecked")
    @Benchmark
    @Threads(value = 1)
    public void test_2_deserialize(Blackhole blackhole) {
        blackhole.consume(Reproducer1.deserialize(this.theMap));
    }

    @TearDown(Level.Trial)
    public void tearDown() {
        this.hazelcastInstance.shutdown();
    }

}
