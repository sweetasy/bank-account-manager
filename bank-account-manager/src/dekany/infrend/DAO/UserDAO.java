package dekany.infrend.DAO;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import dekany.infred.database.initNeo4j.TestLabel;
import dekany.infrend.model.UserModel;

public class UserDAO {

	
	public static void createUser(String firstname, String lastname, String street, String city, String postalCode,
			String personalID, String phone, boolean isActive, int userCode, String pass){
		
		GraphDatabaseFactory gdf = new GraphDatabaseFactory();
		GraphDatabaseService gds = gdf.newEmbeddedDatabase(new File("/home/patrik/DATA/DEVELOPMENT/NEO4J/neo4j-community-3.1.4/data/databases/graaaaaphdb.graphdb"));
		try (Transaction tx = gds.beginTx()) {
		Node client = gds.createNode(TestLabel.Client);
		client.setProperty("Firstname", firstname);
		client.setProperty("Lastname", lastname);
		client.setProperty("Street", street);
		client.setProperty("City", city);
		client.setProperty("PostalCode", postalCode);
		client.setProperty("PersonalID", personalID);
		client.setProperty("Phone", phone);
		client.setProperty("isActive", isActive);
		client.setProperty("ClientNumber", userCode);
		client.setProperty("Password", pass);
		tx.success();
		}
		gds.shutdown();
	}
	
	public static void testUser(){
		GraphDatabaseFactory gdf = new GraphDatabaseFactory();
		GraphDatabaseService gds = gdf.newEmbeddedDatabase(new File("/home/patrik/DATA/DEVELOPMENT/NEO4J/neo4j-community-3.1.4/data/databases/graaaaaphdb.graphdb"));

		Result r = gds.execute("MATCH (c:Client) RETURN c.Firstname;");

		
		while (r.hasNext()){
			Map<String, Object> row = r.next();
			for (String key : r.columns()){
				System.out.println(row.get(key));
			}
		}
		
		gds.shutdown();
		System.out.println("aham");
	}
		

}
	
	
