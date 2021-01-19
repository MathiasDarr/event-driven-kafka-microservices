import findspark
findspark.init()
import pyspark as ps


def getSparkInstance():
    """
    @return: Return Spark session
    """
    spark = ps.sql.SparkSession.builder \
        .master("local[4]") \
        .appName("individual") \
        .getOrCreate()
    return spark




