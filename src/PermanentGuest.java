public class PermanentGuest extends Guest {

	private String expireDate;
	private long price;
	private int year;

	public PermanentGuest(String name, String birth, String room, String id, String addFacilities, String expireDate,
			int year) {
		super(name, birth, room, id, addFacilities);
		this.expireDate = expireDate;
		this.year = year;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void calculate() {
		if (this.room.contains("Std")) {
			this.price = 200000000;
		} else if (this.room.contains("Lux")) {
			this.price = 400000000;
		} else if (this.room.contains("Dlx")) {
			this.price = 600000000;
		}

		this.price = this.price * this.year;
	}
}