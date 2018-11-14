package aws;

import com.amazonaws.client.builder.*;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.datamodeling.*;

/**
 * Create and hold a DynamoDB client and a mapper for the database
 * @author Antoine/Anthony Sébert
 */
public class dynamo_util {
	/* ATTRIBUTES */
		/**
		 * The database client object
		 */
		private static AmazonDynamoDB client = null;
		/**
		 * The DynamoDB mapper
		 */
		private static DynamoDBMapper mapper = null;
	/* METHODS */
		/**
		 * @param	region		The AWS region to connect to. e.g. "eu-west-1". To connect to a local server, use "local"
		 * @parm	end_point	The URL of the local DynamoDB server. e.g. http://localhost:8000 This parameter is only used if region is specified as "local"
		 * @return	A DynamoDBMapper object for accessing DynamoDB
		 */
		public static DynamoDBMapper get_mapper(String region, String endPoint) {
			if(dynamo_util.mapper == null) {
				dynamo_util.client = get_dynamo_client(region, endPoint);
				dynamo_util.mapper = new DynamoDBMapper(client);
			}
			return dynamo_util.mapper;
		}
		/**
		 * Create the static DynamoDB client if it dies not exists, then return the static client attribute
		 * @return	A DynamoDB client
		 */
		public static AmazonDynamoDB get_dynamo_client(String region, String endPoint) {
			if(dynamo_util.client != null)
				return dynamo_util.client;

			AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
			if(region.equals("local"))
				builder.setEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endPoint, region));
			else
				builder.setRegion(region);

			return builder.build();
		}
}