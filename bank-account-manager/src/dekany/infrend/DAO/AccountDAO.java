package dekany.infrend.DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import dekany.infred.database.initNeo4j.TestLabel;
import dekany.infred.database.initNeo4j.TestRelationshipType;
import dekany.infrend.model.AccountModel;

public class AccountDAO {
	
	public static List<AccountModel> showAccount(String user){

		List<AccountModel> accounts = new ArrayList<AccountModel>();
		GraphDatabaseFactory gdf = new GraphDatabaseFactory();
		GraphDatabaseService gds = gdf.newEmbeddedDatabase(new File("/home/patrik/DATA/DEVELOPMENT/NEO4J/neo4j-community-3.1.4/data/databases/graaaaaphdb.graphdb"));

		Result r = gds.execute("MATCH (a:Client {ClientNumber: '" + user + "'})-[r]-(b:Account) RETURN b.Balance, b.AccountNumber, b.Status");

		
		while (r.hasNext()){
			AccountModel acc = new AccountModel();
			Map<String, Object> row = r.next();
			for (String key : r.columns()){
				switch (key){
				case "b.AccountNumber":
						acc.setAccountNumber(row.get(key).toString());
					break;
				case "b.Balance":
					acc.setBalance(Integer.parseInt(row.get(key).toString()));
					break;
				case "b.Status":
					acc.setStatus(row.get(key).toString());
					break;
				}
			}
			accounts.add(acc);
		}
		
		gds.shutdown();
		return accounts;
	}
	
	public static void addAccount(String userCode, String cash){
		
		String accnum = generateNumber(Integer.parseInt(userCode));
		
		GraphDatabaseFactory gdf = new GraphDatabaseFactory();
		GraphDatabaseService gds = gdf.newEmbeddedDatabase(new File("/home/patrik/DATA/DEVELOPMENT/NEO4J/neo4j-community-3.1.4/data/databases/graaaaaphdb.graphdb"));
		
		try (Transaction tx = gds.beginTx()) {
			
	
			Node account = gds.createNode(TestLabel.Account);
			account.setProperty("AccountNumber", accnum);
			account.setProperty("Balance", cash);
			account.setProperty("Status", "1");
			
			
		//	Relationship r = resultNode.createRelationshipTo(account, TestRelationshipType.OWNER_OF);
	
			
			
			tx.success();
			}
		gds.execute("MATCH (c:Client {ClientNumber:'" + userCode + "'}), (a:Account {AccountNumber:'" + accnum + "'})CREATE (c)-[:OWNER_OF]->(a)");

			gds.shutdown();
	}
	
	private static String generateNumber(int code){
		
		return "312412512";
	}
	
}
