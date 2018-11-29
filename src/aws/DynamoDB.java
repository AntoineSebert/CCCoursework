package aws;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.client.builder.*;
import com.amazonaws.services.dynamodbv2.*;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

/**
 * Create and hold a DynamoDB client and a mapper for the database
 * 
 * @author Antoine/Anthony S�bert
 */
public class DynamoDB {
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
		public static DynamoDBMapper get_mapper() {
			if(mapper == null) {
				client = get_dynamo_client();
				mapper = new DynamoDBMapper(client);
			}
			return mapper;
		}
		/**
		 * Create the static DynamoDB client if it dies not exists, then return the static client attribute
		 * @return	A DynamoDB client
		 */
		public static AmazonDynamoDB get_dynamo_client() {
			if(client != null)
				return client;

			AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
			if(Config.REGION.equals("local"))
				builder.setEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(Config.REGION, Config.LOCAL_ENDPOINT));
			else
				builder.setRegion(Config.REGION);

			client = builder.build();
			/*
			client.deleteTable("users");

			ArrayList<AttributeDefinition> attribute_definitions = new ArrayList<AttributeDefinition>();
			attribute_definitions.add(new AttributeDefinition().withAttributeName("id").withAttributeType("S"));

			ArrayList<KeySchemaElement> key_schema = new ArrayList<KeySchemaElement>();
			key_schema.add(new KeySchemaElement().withAttributeName("id").withKeyType(KeyType.HASH));

			CreateTableRequest request = new CreateTableRequest().withTableName("users").withKeySchema(key_schema).withProvisionedThroughput(
				new ProvisionedThroughput().withReadCapacityUnits((long) 10).withWriteCapacityUnits((long) 5)
			);
			*/
			/*
				// PrecipIndex
				GlobalSecondaryIndex contactsFromIndex = new GlobalSecondaryIndex().withIndexName("ContactsFromIndex").withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits((long) 10).withWriteCapacityUnits((long) 5)).withProjection(new Projection().withProjectionType(ProjectionType.KEYS_ONLY));

				ArrayList<KeySchemaElement> indexKeySchema = new ArrayList<KeySchemaElement>();

				indexKeySchema.add(new KeySchemaElement().withAttributeName("fr").withKeyType(KeyType.HASH));
				indexKeySchema.add(new KeySchemaElement().withAttributeName("st").withKeyType(KeyType.RANGE));

				contactsFromIndex.setKeySchema(indexKeySchema);
				request.withGlobalSecondaryIndexes(contactsFromIndex);
			*/
			//request.setAttributeDefinitions(attribute_definitions);
			//client.createTable(request);
	
			return client;
		}
		public static boolean is_user_present(String user_id) {
			try {
				Map<String, AttributeValue> where = new HashMap<String, AttributeValue>();
				where.put("id", new AttributeValue(user_id));
				get_dynamo_client().getItem("users", where);

				return true;
			}
			catch(AmazonServiceException ase) {
				System.err.println("Could not complete operation");
				System.err.println("Error Message:  " + ase.getMessage());
				System.err.println("HTTP Status:    " + ase.getStatusCode());
				System.err.println("AWS Error Code: " + ase.getErrorCode());
				System.err.println("Error Type:     " + ase.getErrorType());
				System.err.println("Request ID:     " + ase.getRequestId());

				return false;
			}
			catch(AmazonClientException ace) {
				System.err.println("Internal error occured communicating with DynamoDB");
				System.out.println("Error Message:  " + ace.getMessage());

				return false;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		public static boolean createUser(String user_id) {
			try {
				Map<String, AttributeValue> where = new HashMap<String, AttributeValue>();
				where.put("id", new AttributeValue(user_id));
				get_dynamo_client().putItem("users", where);

				return true;
			}
			catch(AmazonServiceException ase) {
				System.err.println("Could not complete operation");
				System.err.println("Error Message:  " + ase.getMessage());
				System.err.println("HTTP Status:    " + ase.getStatusCode());
				System.err.println("AWS Error Code: " + ase.getErrorCode());
				System.err.println("Error Type:     " + ase.getErrorType());
				System.err.println("Request ID:     " + ase.getRequestId());

				return false;

			}
			catch(AmazonClientException ace) {
				System.err.println("Internal error occured communicating with DynamoDB");
				System.out.println("Error Message:  " + ace.getMessage());

				return false;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false; }
		}
}