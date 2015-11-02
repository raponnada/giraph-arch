package edu.umkc.sad;

import org.apache.giraph.conf.GiraphConfiguration;
import org.apache.giraph.conf.GiraphConstants;
import org.apache.giraph.examples.SimpleShortestPathsComputation;
import org.apache.giraph.io.formats.GiraphFileInputFormat;
import org.apache.giraph.io.formats.IdWithValueTextOutputFormat;
import org.apache.giraph.io.formats.JsonLongDoubleFloatDoubleVertexInputFormat;
import org.apache.giraph.job.GiraphJob;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class GiraphAppRunner implements Tool {
	
	private Configuration conf;
	
	private String inputPath;
	private String OutputPath;
	
	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getOutputPath() {
		return OutputPath;
	}

	public void setOutputPath(String outputPath) {
		OutputPath = outputPath;
	}
	
	@Override
	public Configuration getConf() {
		// TODO Auto-generated method stub
		return conf;
	}

	@Override
	public void setConf(Configuration conf) {
		// TODO Auto-generated method stub
		this.conf = conf;
	}

	@Override
	public int run(String[] argss) throws Exception {
		// TODO Auto-generated method stub
		setInputPath("/home/anvesh/Documents/Giraph/ShortestPath/input");
		setOutputPath("/home/anvesh/Documents/Giraph/ShortestPath/output");

		
		GiraphConfiguration giconf = new GiraphConfiguration(getConf());
        		
		giconf.setComputationClass(SimpleShortestPathsComputation.class);
		giconf.setVertexInputFormatClass(JsonLongDoubleFloatDoubleVertexInputFormat.class);
		
		GiraphFileInputFormat.addVertexInputPath(giconf, new Path(getInputPath()));
		
		giconf.setVertexOutputFormatClass(IdWithValueTextOutputFormat.class);
		
		giconf.setWorkerConfiguration(0, 1, 100);
		giconf.setLocalTestMode(true);
		giconf.setMaxNumberOfSupersteps(100);
		
		GiraphConstants.SPLIT_MASTER_WORKER.set(giconf, false);
		GiraphConstants.USE_OUT_OF_CORE_GRAPH.set(giconf, true);
		
		GiraphJob job = new GiraphJob(giconf,getClass().getName());
		
		FileOutputFormat.setOutputPath(job.getInternalJob(), new Path(getOutputPath()));

		job.run(true);
		
		return 1;
	}
	 
	public static void main(String[] args) throws Exception {
		ToolRunner.run(new GiraphAppRunner(), args);
	}
}
