package site.haiyang.hmall.bigdata;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;


public class HbaseMapReduce extends Configured implements Tool {

    // mapper class
    public static class TabMapper extends TableMapper<Text, Put> {
        private Text rowkey = new Text();
        
        @Override
        protected void map(ImmutableBytesWritable key, Result value,Context context)
                throws IOException, InterruptedException {
            byte[] bytes = key.get(); //原始数据key
            rowkey.set(Bytes.toString(bytes));
            Put put = new Put(bytes);
            
            for (Cell cell : value.rawCells()) { //一行数据
                // add cell
                if("data".equals(Bytes.toString(CellUtil.cloneFamily(cell)))) { //应该是列族
                    if("state".equals(Bytes.toString(CellUtil.cloneQualifier(cell)))) { //应该是列名
                        //排除值不等于3的。以用户进行排重分组
                        String value1 = Bytes.toString(cell.getValueArray(),  cell.getValueOffset(),  cell.getValueLength());
//                        String column = Bytes.toString( cell.getQualifierArray(), cell.getQualifierOffset(),  cell.getQualifierLength());
                        if(!value1.equals("3")){
//                            put.add(Bytes.toBytes("data"),  Bytes.toBytes("userPhone"),  Bytes.toBytes("18696223"));
                            put.add(cell);
                        }
                    }
                }
            }
            context.write(rowkey, put);
        }
    }
    
    // reduce class
    public static class TabReduce extends TableReducer<Text,Put, ImmutableBytesWritable> {
        @Override
        protected void reduce(Text key, Iterable<Put> values,Context context)
                throws IOException, InterruptedException {
            for (Put put : values) {
                //这里是key map多个值。
                System.out.println(key);
                System.out.println(put);
                context.write(null, put);
            }
        }
    }
    
    @Override
    public int run(String[] args) throws Exception {
        //create job
        Job job = Job.getInstance(this.getConf(), this.getClass().getSimpleName());
        
        // set run class
        job.setJarByClass(this.getClass());
        
        Scan scan = new Scan();
        scan.setCaching(500);
        scan.setCacheBlocks(false);
        
        // set mapper
        TableMapReduceUtil.initTableMapperJob(
                "tab1", // input table
                scan , // scan instance   
                TabMapper.class,  // set mapper class
                Text.class, // mapper output key 
                Put.class, //mapper output value 
                job // set job
        );
        
        TableMapReduceUtil.initTableReducerJob(
                "tab2" , // output table 
                TabReduce.class, // set reduce class 
                job // set job
        );
        
        job.setNumReduceTasks(1);
        
        boolean b = job.waitForCompletion(true);
        
        if(!b) {
            System.err.print("error with job!!!");
        }
        return 0;
    }
    
    public static void main(String[] args) throws Exception {
        
        //create config
        Configuration config = HBaseConfiguration.create();
        
        //submit job
        int status = ToolRunner.run(config, new HbaseMapReduce(), args);
        
        //exit
        System.exit(status);
    }

}