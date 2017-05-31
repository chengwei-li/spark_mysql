package test.etl.test.etl.app;

import java.util.Properties;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

public class DataframeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SparkConf conf = new SparkConf();
		JavaSparkContext sc = new JavaSparkContext(conf.setAppName("Demo")
				.setMaster("local"));
		SQLContext sqlContext = new org.apache.spark.sql.SQLContext(sc);
		Properties prop = new Properties();
		prop.setProperty("driver", "com.mysql.jdbc.Driver");
		prop.setProperty("user", "root");
		prop.setProperty("password", "cloudera");

		StructType schema = DataTypes
				.createStructType(new StructField[] {
						DataTypes.createStructField("id", DataTypes.StringType,
								true),
						DataTypes.createStructField("first_name",
								DataTypes.StringType, true),
						DataTypes.createStructField("last_name",
								DataTypes.StringType, true),
						DataTypes.createStructField("mail",
								DataTypes.StringType, true),
						DataTypes.createStructField("salary",
								DataTypes.StringType, true),
						DataTypes.createStructField("phone",
								DataTypes.StringType, true),
						DataTypes.createStructField("cost",
								DataTypes.StringType, true) });

		System.out.println("Starting to load data...");
		DataFrame inputDF = sqlContext.read()
				.format("com.databricks.spark.csv").schema(schema)
				.option("header", "false").option("delimiter", ",")
				.load("/home/cloudera/Desktop/employee.csv");
		inputDF.show();

		String url = "jdbc:/mysql://localhost:3036/test";
		String table = "test";

		// inputDF.write().mode("append").jdbc(url, table, prop);

		inputDF.write().mode("append")
				.jdbc("jdbc:mysql://localhost:3306/test", table, prop);
		/*
		 * .format("com.mysql.jdbc.Driver") .option("url",
		 * "jdbc:/mysql://localhost:3036/test?user=root&password=cloudera")
		 * .option("dbtable", table) //.option("tempdir", "s3n://" + bucketName
		 * + "/tempAvroDir") .mode(SaveMode.Append).save();
		 */

		System.out.println("Ending...");

	}

}
