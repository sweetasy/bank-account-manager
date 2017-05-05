package dekany.infrend.DAO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import dekany.infred.database.initNeo4j.TestLabel;
import dekany.infrend.model.UserModel;

public class SearchDAO {
	public static List<UserModel> searchUserbyfName(String fname){
		List<UserModel> users = new ArrayList<UserModel>();
		
		GraphDatabaseFactory gdf = new GraphDatabaseFactory();
		GraphDatabaseService gds = gdf.newEmbeddedDatabase(new File("/home/patrik/DATA/DEVELOPMENT/NEO4J/neo4j-community-3.1.4/data/databases/graaaaaphdb.graphdb"));

		Result r = gds.execute("MATCH (c:Client) WHERE c.Firstname='"+fname+"' RETURN c.Firstname, c.Lastname, c.Street, c.City, c.PostalCode, c.PersonalID, c.Phone, c.isActive, c.ClientNumber, c.Password ;");

		
		while (r.hasNext()){
			UserModel user = new UserModel();
			Map<String, Object> row = r.next();
			for (String key : r.columns()){
			
				switch (key){
				case "c.Firstname":
						user.setFirstname(row.get(key).toString());
						break;
				case "c.Lastname":
						user.setLastname(row.get(key).toString());
						break;
				case "c.Street":
						user.setStreet(row.get(key).toString());
						break;
				case "c.City":
						user.setCity(row.get(key).toString());
						break;
				case "c.PostalCode":
						user.setPostalCode(row.get(key).toString());
						break;
				case "c.PersonalID":
						user.setPersonalID(row.get(key).toString());
						break;
				case "c.Phone":
						user.setPhone(row.get(key).toString());
						break;
				case "c.isActive":
						user.setActive((boolean)row.get(key));
						break;
				case "c.ClientNumber":
						user.setUserCode(Integer.valueOf(row.get(key).toString()));
						break;
				case "c.Password":
						user.setPass(row.get(key).toString());
						break;				
				}
			}users.add(user);
			
		}	
		
		gds.shutdown();
		return users;
	}
	
	public static List<UserModel> searchUserbylName(String lname){
		List<UserModel> users = new ArrayList<UserModel>();
		
		GraphDatabaseFactory gdf = new GraphDatabaseFactory();
		GraphDatabaseService gds = gdf.newEmbeddedDatabase(new File("/home/patrik/DATA/DEVELOPMENT/NEO4J/neo4j-community-3.1.4/data/databases/graaaaaphdb.graphdb"));

		Result r = gds.execute("MATCH (c:Client) WHERE c.Lastname='"+lname+"' RETURN c.Firstname, c.Lastname, c.Street, c.City, c.PostalCode, c.PersonalID, c.Phone, c.isActive, c.ClientNumber, c.Password ;");

		
		while (r.hasNext()){
			UserModel user = new UserModel();
			Map<String, Object> row = r.next();
			for (String key : r.columns()){
			
				switch (key){
				case "c.Firstname":
						user.setFirstname(row.get(key).toString());
						break;
				case "c.Lastname":
						user.setLastname(row.get(key).toString());
						break;
				case "c.Street":
						user.setStreet(row.get(key).toString());
						break;
				case "c.City":
						user.setCity(row.get(key).toString());
						break;
				case "c.PostalCode":
						user.setPostalCode(row.get(key).toString());
						break;
				case "c.PersonalID":
						user.setPersonalID(row.get(key).toString());
						break;
				case "c.Phone":
						user.setPhone(row.get(key).toString());
						break;
				case "c.isActive":
						user.setActive((boolean)row.get(key));
						break;
				case "c.ClientNumber":
						user.setUserCode(Integer.valueOf(row.get(key).toString()));
						break;
				case "c.Password":
						user.setPass(row.get(key).toString());
						break;				
				}
			}users.add(user);
			
		}	
		
		gds.shutdown();
		return users;
	}
	
	public static List<UserModel> searchUserbyPersonalID(String pid){
		List<UserModel> users = new ArrayList<UserModel>();
		
		GraphDatabaseFactory gdf = new GraphDatabaseFactory();
		GraphDatabaseService gds = gdf.newEmbeddedDatabase(new File("/home/patrik/DATA/DEVELOPMENT/NEO4J/neo4j-community-3.1.4/data/databases/graaaaaphdb.graphdb"));

		Result r = gds.execute("MATCH (c:Client) WHERE c.PersonalID='"+pid+"' RETURN c.Firstname, c.Lastname, c.Street, c.City, c.PostalCode, c.PersonalID, c.Phone, c.isActive, c.ClientNumber, c.Password ;");

		
		while (r.hasNext()){
			UserModel user = new UserModel();
			Map<String, Object> row = r.next();
			for (String key : r.columns()){
			
				switch (key){
				case "c.Firstname":
						user.setFirstname(row.get(key).toString());
						break;
				case "c.Lastname":
						user.setLastname(row.get(key).toString());
						break;
				case "c.Street":
						user.setStreet(row.get(key).toString());
						break;
				case "c.City":
						user.setCity(row.get(key).toString());
						break;
				case "c.PostalCode":
						user.setPostalCode(row.get(key).toString());
						break;
				case "c.PersonalID":
						user.setPersonalID(row.get(key).toString());
						break;
				case "c.Phone":
						user.setPhone(row.get(key).toString());
						break;
				case "c.isActive":
						user.setActive((boolean)row.get(key));
						break;
				case "c.ClientNumber":
						user.setUserCode(Integer.valueOf(row.get(key).toString()));
						break;
				case "c.Password":
						user.setPass(row.get(key).toString());
						break;				
				}
			}users.add(user);
			
		}	
		
		gds.shutdown();
		return users;
	}
	
}
