package test.etl.test.etl.app;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;
import org.apache.spark.api.java.function.VoidFunction;

/**
 * Hello world!
 *
 */
public class RddExample {
	public static void main(String[] args) {
		SparkConf conf = new SparkConf();
		JavaSparkContext sc = new JavaSparkContext(conf.setAppName("Demo")
				.setMaster("local"));
		SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);

		JavaRDD<String> data = sc
				.textFile("/home/cloudera/Desktop/employee.csv");
		JavaRDD<Records> rdd_records = data
				.map(new Function<String, Records>() {
					public Records call(String line) throws Exception {
						String[] fields = line.split(",");
						return new Records(fields[0], fields[1], fields[2],
								fields[3], fields[4], fields[5], fields[6]);

					}
				});

		System.out.println("Starting...");
		System.out.println("Number of records present are "
				+ rdd_records.count());

		System.out.println("Printing records");
		rdd_records.foreach(new VoidFunction<Records>() {

			public void call(Records arg0) throws Exception {
				// TODO Auto-generated method stub
				System.out.println(arg0);
			}

		});

		System.out.println("Ending...");
		/*
		 * StructType schema = DataTypes.createStructType(new StructField[] {
		 * DataTypes.createStructField("Name",DataTypes.StringType,true),
		 * DataTypes.createStructField("Age",DataTypes.StringType,true),
		 * DataTypes.createStructField("Id",DataTypes.StringType,true) });
		 * 
		 * DataFrame inputDF =
		 * sqlContext.read().format("com.databricks.spark.csv")l
		 * .schema(schema).option("header","true").option("delimeter",",")
		 * .load("");
		 */
	}
}
