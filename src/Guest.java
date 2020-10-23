public abstract class Guest {

	protected String name;
	protected String birth;
	protected String room;
	protected String id;
	protected String addFacilities;
	protected long price;

	public Guest(String name, String birth, String room, String id, String addFacilities) {
		super();
		this.name = name;
		this.birth = birth;
		this.room = room;
		this.id = id;
		this.addFacilities = addFacilities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddFacilities() {
		return addFacilities;
	}

	public void setAddFacilities(String addFacilities) {
		this.addFacilities = addFacilities;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void calculate() {
		if (this.room.contains("Std")) {
			this.price = 2000000;
		} else if (this.room.contains("Lux")) {
			this.price = 4000000;
		} else if (this.room.contains("Dlx")) {
			this.price = 6000000;
		}
	}
}