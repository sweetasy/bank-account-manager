package dekany.infred.database;

import java.io.File;
import java.util.Map;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class initNeo4j {
	public enum TestLabel implements Label {

		Client, Account, Tranzaction 
		
	}
	public enum TestRelationshipType implements RelationshipType {

		OWNER_OF, OWNED_BY
		
	}

	public static void main(String[] args) {
		
		GraphDatabaseFactory gdf = new GraphDatabaseFactory();
		GraphDatabaseService gds = gdf.newEmbeddedDatabase(new File("/home/patrik/DATA/DEVELOPMENT/NEO4J/neo4j-community-3.1.4/data/databases/graaaaaphdb.graphdb"));
		
		try (Transaction tx = gds.beginTx()) {
			
			
			Node client = gds.createNode(TestLabel.Client);
			client.setProperty("ID", 1);
			client.setProperty("Firstname", "john");
			client.setProperty("Lastname", "doe");
			client.setProperty("Adress", "22 ady ");
			client.setProperty("City", "Miskolc");
			client.setProperty("PostalCode", "3700");
			client.setProperty("PersonalID", "12345678");
			client.setProperty("Phone", "06301234567");
			client.setProperty("ClientNumber", "77766688");
			
			
			Node account = gds.createNode(TestLabel.Account);
			account.setProperty("AccountNumber", "1111111111");
			account.setProperty("Balance", "5000");
			account.setProperty("Status", "1");
			
			
			Relationship r1 = client.createRelationshipTo(account, TestRelationshipType.OWNER_OF);
			r1.setProperty("rid", 1);
	
			
			tx.success();
		}
		
		
Result r = gds.execute("MATCH (c:Tranzaction) WHERE c.ID=1 RETURN c.Firstname, c.Lastname, c.Phone;");

		
		while (r.hasNext()){
			Map<String, Object> row = r.next();
			for (String key : r.columns()){
				System.out.println(row.get(key));
			}
		}
				
		gds.shutdown();
		System.out.println("uhm okay");

	}


}
