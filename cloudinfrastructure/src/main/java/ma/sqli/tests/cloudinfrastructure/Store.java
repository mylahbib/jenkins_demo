package ma.sqli.tests.cloudinfrastructure;

import java.util.ArrayList;
import java.util.List;

public class Store {
	private String name; 
	private List<Document> documents ;

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Store(String name) {
		super();
		this.name = name;
		this.documents = new ArrayList<>();
	} 
	
	

}
