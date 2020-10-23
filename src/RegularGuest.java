public class RegularGuest extends Guest {

	private String checkIn;
	private String checkOut;
	private int night;
	private long price;

	public RegularGuest(String name, String birth, String room, String id, String addFacilities, String checkIn,
			String checkOut, int night) {
		super(name, birth, room, id, addFacilities);
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.night = night;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public int getNight() {
		return night;
	}

	public void setNight(int night) {
		this.night = night;
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

		this.price = this.price * this.night;
	}
}