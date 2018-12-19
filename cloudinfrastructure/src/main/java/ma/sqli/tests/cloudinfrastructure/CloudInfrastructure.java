package ma.sqli.tests.cloudinfrastructure;

import java.util.ArrayList;
import java.util.List;


public class CloudInfrastructure {

	private List<Store> stores = new ArrayList<>();
	List<Machine> machines = new ArrayList<>(); 

	public void createStore(String string) throws CreateStoreException {
		for (Store store : stores) {
			if (store.getName().equals(string)) throw new CreateStoreException() ;
		}
		this.getStores().add(new Store(string));

	}

	public void uploadDocument(String storeName, String... docs) {
		for (Store store : this.getStores()) {
			if (store.getName().equals(storeName)) {
				for (String docName : docs) {
					store.getDocuments().add(new Document(docName));
				}
			}
		}
	}

	public String listStores() {
		String liststores = "";
		String listImages = "";

		String myImage = "";
		String myFile = "";
		for (Store store : this.stores) {
			if (store.getName().equals("myFiles")) {
				myFile = "myFiles:";

				if (store.getDocuments().isEmpty()) {
					liststores = "empty";
				}
				for (Document doc : store.getDocuments()) {
					if (store.getDocuments().size() == 1) {
						liststores += doc.getName();
					} else

						liststores += ", " + doc.getName();

				}
				liststores = myFile + liststores;
			}
			
			if (store.getName().equals("myImages")) {

				myImage = "myImages:";
				
				listImages +=myImage;

				if (store.getDocuments().isEmpty()) {
					listImages += "empty";
				}
				

					for (Document doc : store.getDocuments()) {

						if (store.getDocuments().get(store.getDocuments().size()-1).equals(doc)) {
							listImages += doc.getName() ;
						}else 
							listImages += doc.getName()+ ", " ;

					}
				
			}
			

		}
		if (this.getStores().size()>1) {
			liststores+="||"+listImages;
		}else
			liststores+=listImages;

		System.out.println(liststores);

		return liststores;

		
	}

	public void deleteStore(String string) {
		for (Store store : stores) {
			if (store.getName().equals(string)) {
				this.getStores().remove(store);

			}
		}
	}

	public void emptyStore(String string) {
		
		for (Store store : stores) {
			if (store.getName().equals(string)) {
				store.getDocuments().clear();

			}
		}
	}

	public Object listMachines() {
		String string="";
		for (Machine machine : machines) {
				if (machines.get(machines.size()-1).equals(machine)) {
					string += machine.getName()+":"+machine.getState();
				}else
			string += machine.getName()+":"+machine.getState()+"||";
		}
		return string;
	}

	public void startMachine(String string) throws MachineStateException {
					for (Machine machine : machines) {
						
						if (machine.getName().equals(string)) {
							if (machine.getState().equals(State.running)) throw new MachineStateException();
							machine.setState(State.running);
						}
					}
	}

	public void stopMachine(String string) {
		for (Machine machine : machines) {
			if (machine.getName().equals(string)) {
				machine.setState(State.stopped);
			}
		}

	}

	public void createMachine(String name,String operating_system,String disk_size,String memory) {
		this.machines.add(new Machine(name, operating_system, disk_size, memory,State.inactive));
		
	}

	public double usedMemory(String string) {
		String [] memory ; 
		double size = 0 ; 
		for (Machine machine : machines) {
			if (machine.getName().equals(string)) {
				if (machine.getState().equals(State.running)) {
				    memory =  machine.getDisk_size().split("", -2);
				    size =  Double.parseDouble(memory[0]) ;
				  System.out.println(size);
				}
			}
		}
		return size;
	}

	public double usedDisk(String string) {
		String [] disk ; 
		double size = 0;
		for (Machine machine : machines) {
			if (machine.getName().equals(string)) {
				    disk =  machine.getMemory().split("",-2);
				    size=   Double.parseDouble(disk[0]+disk[1]) ;
				  
			}
			
		}
		for (Store store : this.stores) {
			if (store.getName().equals("myImages")) {
				size= 0.1*store.getDocuments().size();
			}
		}
		return size;
	}

	public double globalUsedMemory() {
		String [] memory ; 
		double size = 0 ; 
		for (Machine machine : machines) {
				if (machine.getState().equals(State.running)) {
				    memory =  machine.getDisk_size().split("", -2);
				    size +=  Double.parseDouble(memory[0]) ;
				
			}
		}
		return size;

	}

	public double globalUsedDisk() {
		String [] disk ; 
		double size = 0;
		for (Machine machine : machines) {

				    disk =  machine.getMemory().split("",-2);
				    size+=   Double.parseDouble(disk[0]+disk[1]) ;
				 
			
		}
		for (Store store : this.stores) {
			if (store.getName().equals("myImages")) {
				size+= 0.1*store.getDocuments().size();
			}
		}
		return size;
	}

	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}

	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

}
