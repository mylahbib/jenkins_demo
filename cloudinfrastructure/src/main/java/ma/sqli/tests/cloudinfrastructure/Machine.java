package ma.sqli.tests.cloudinfrastructure;

public class Machine {
	
	  private State state;

	private String name ;
	private String operating_system;
	private String disk_size;
	private String memory;
	
	
	
	public String getOperating_system() {
		return operating_system;
	}
	
	public Machine(String name,String operating_system,String memory,  String disk_size, State state) {
		super();
		this.state = state;
		this.name = name;
		this.operating_system = operating_system;
		this.disk_size = disk_size;
		this.memory = memory;
	}

	public void setOperating_system(String operating_system) {
		this.operating_system = operating_system;
	}

	public String getDisk_size() {
		return disk_size;
	}

	public void setDisk_size(String disk_size) {
		this.disk_size = disk_size;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Machine(String name, String operating_system, String disk_size, String memory) {
		super();
		this.name = name;
		this.operating_system = operating_system;
		this.disk_size = disk_size;
		this.memory = memory;
	}

	

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	} 
	
	
}
