import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static int menu;

	static ArrayList<RegularGuest> regularGuest = new ArrayList<>();
	static ArrayList<PermanentGuest> permanentGuest = new ArrayList<>();

	static Scanner scan = new Scanner(System.in);
	static Random random = new Random();
	static Calendar calendar = Calendar.getInstance();

	static void addSampleGuest() {

		String name = "";
		String birth = "";
		String checkIn = "";
		String checkOut = "";
		String room = null;
		String id;
		int night = 0;

		name = "Asep";

		birth = "01/05/1999";

		Integer tempRoom;
		Integer tempId;
		int max = 0;
		int min = 0;
		max = 19;
		min = 1;

		tempRoom = random.nextInt(max - min + 1) + min;
		room = "Std " + tempRoom.toString();

		tempId = random.nextInt(999);

		if (tempId < 10) {
			id = "REG00" + tempId;
		} else if (tempId < 100) {
			id = "REG0" + tempId;
		} else {
			id = "REG" + tempId;
		}

		checkIn = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
				+ calendar.get(Calendar.YEAR);

		int checkOutDate;
		int checkOutMonth;
		int checkOutYear;

		night = 1;
		checkOutDate = calendar.get(Calendar.DATE) + night;
		checkOutMonth = calendar.get(Calendar.MONTH) + 1;
		checkOutYear = calendar.get(Calendar.YEAR);

		checkOut = Integer.toString(checkOutDate) + "/" + Integer.toString(checkOutMonth) + "/"
				+ Integer.toString(checkOutYear);

		String facilities = null;

		RegularGuest data = new RegularGuest(name, birth, room, id, facilities, checkIn, checkOut, night);

		regularGuest.add(data);
		data.calculate();

		//

		String name1 = "Suparman";
		String birth1 = "01/12/1998";
		String room1 = null;

		String id1;

		int max1 = 0;
		int min1 = 0;

		max1 = 19;
		min1 = 1;
		Integer tempRoom1 = random.nextInt(max1 - min1 + 1) + min1;
		room1 = "Std " + tempRoom1.toString();

		int tempId1 = random.nextInt(999);

		if (tempId1 < 10) {
			id1 = "PER00" + tempId1;
		} else if (tempId1 < 100) {
			id1 = "PER0" + tempId1;
		} else {
			id1 = "PER" + tempId1;
		}

		int year = 4;

		String expireDate = null;
		expireDate = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
				+ (calendar.get(Calendar.YEAR) + year);

		String facilities1 = null;

		PermanentGuest data1 = new PermanentGuest(name1, birth1, room1, id1, facilities1, expireDate, year);

		permanentGuest.add(data1);
		data1.calculate();
	}

	static void addRegularGuest() {

		String name = "";
		String birth = "";
		String checkIn = "";
		String checkOut = "";
		String tempMenu;
		String room = null;
		String id;
		int night = 0;
		int roomMenu;

		do {
			System.out.print("Full Name : ");
			name = scan.nextLine();
		} while (name.length() < 1 || name.length() > 25);

		boolean format = false;

		do {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateFormat.setLenient(false);

			System.out.print("Date of Birth (dd/mm/yyyy) : ");
			birth = scan.nextLine();

			try {
				dateFormat.parse(birth);
				format = true;
			} catch (ParseException e) {
			}

		} while (!birth.matches("\\d{2}/\\d{2}/\\d{4}") || format == false);

		do {
			Integer tempRoom;
			Integer tempId;

			clear();

			System.out.println("Choose Your Room Type");
			System.out.println("=====================");
			System.out.println("1. Standard (Rp 2.000.000/night)");
			System.out.println("2. Luxury (Rp 4.000.000/night)");
			System.out.println("3. Deluxe (Rp 6.000.000/night)");
			System.out.print(">> ");
			roomMenu = scan.nextInt();
			scan.nextLine();

			int max = 0;
			int min = 0;

			if (roomMenu == 1) {
				max = 19;
				min = 1;
				tempRoom = random.nextInt(max - min + 1) + min;
				room = "Std " + tempRoom.toString();
			} else if (roomMenu == 2) {
				max = 29;
				min = 20;
				tempRoom = random.nextInt(max - min + 1) + min;
				room = "Lux " + tempRoom.toString();
			} else if (roomMenu == 3) {
				max = 39;
				min = 30;
				tempRoom = random.nextInt(max - min + 1) + min;
				room = "Dlx " + tempRoom.toString();
			}

			tempId = random.nextInt(999);

			if (tempId < 10) {
				id = "REG00" + tempId;
			} else if (tempId < 100) {
				id = "REG0" + tempId;
			} else {
				id = "REG" + tempId;
			}
		} while (roomMenu < 1 && roomMenu > 3);

		Date today = calendar.getTime();

		do {
			clear();

			System.out.print("Check In Today? [" + today + "]\n" + "[y/n] : ");
			tempMenu = scan.nextLine();

			if (tempMenu.charAt(0) == 'y') {
				checkIn = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
						+ calendar.get(Calendar.YEAR);

				int checkOutDate;
				int checkOutMonth;
				int checkOutYear;

				do {
					try {
						System.out.print("Duration (Min 1 night) : ");
						night = scan.nextInt();
					} catch (Exception e) {
					}
					scan.nextLine();
				} while (night <= 0);

				checkOutDate = calendar.get(Calendar.DATE) + night;
				checkOutMonth = calendar.get(Calendar.MONTH) + 1;
				checkOutYear = calendar.get(Calendar.YEAR);

				if (checkOutDate > 31) {
					checkOutDate -= 31;
					checkOutMonth += 1;

					if (checkOutMonth > 12) {
						checkOutYear += 1;
					}
				}

				checkOut = Integer.toString(checkOutDate) + "/" + Integer.toString(checkOutMonth) + "/"
						+ Integer.toString(checkOutYear);

			} else {

				int checkInDate;
				int checkInMonth;
				int checkInYear;
				int checkOutDate;
				int checkOutMonth;
				int checkOutYear;

				format = false;
				do {
					System.out.print("Check In Date (dd/mm/yyyy) : ");
					checkIn = scan.nextLine();

					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					dateFormat.setLenient(false);

					try {
						dateFormat.parse(checkIn);
						format = true;
					} catch (ParseException e) {
					}

				} while (!checkIn.matches("\\d{2}/\\d{2}/\\d{4}") || format == false);

				checkInDate = Integer.parseInt(checkIn.substring(0, 2));
				checkInMonth = Integer.parseInt(checkIn.substring(3, 5));
				checkInYear = Integer.parseInt(checkIn.substring(6, 10));

				do {
					try {
						System.out.print("Duration (Min 1 night) : ");
						night = scan.nextInt();
					} catch (Exception e) {
					}
					scan.nextLine();
				} while (night <= 0);

				checkOutDate = checkInDate + night;
				checkOutMonth = checkInMonth;
				checkOutYear = checkInYear;

				if (checkOutDate > 31) {
					checkOutDate -= 31;
					checkOutMonth += 1;

					if (checkOutMonth > 12) {
						checkOutYear += 1;
					}
				}

				checkOut = Integer.toString(checkOutDate) + "/" + Integer.toString(checkOutMonth) + "/"
						+ Integer.toString(checkOutYear);
			}
		} while (tempMenu.charAt(0) != 'y' && tempMenu.charAt(0) != 'n');

		String facilities = null;

		do {
			System.out.print("Additional Facilities Required? [y/n] : ");
			tempMenu = scan.nextLine();

			if (tempMenu.charAt(0) == 'y') {
				System.out.print("Additional Facilities : ");
				facilities = scan.nextLine();
				break;
			} else if (tempMenu.charAt(0) == 'n') {
				facilities = null;
				break;
			}
		} while (tempMenu.charAt(0) != 'y' || tempMenu.charAt(0) != 'n');

		RegularGuest data = new RegularGuest(name, birth, room, id, facilities, checkIn, checkOut, night);

		regularGuest.add(data);
		data.calculate();
	}

	static void addPermanentGuest() {
		String name = "";
		String birth = "";
		String room = null;
		int roomMenu;

		do {
			System.out.print("Full Name : ");
			name = scan.nextLine();
		} while (name.length() < 1 || name.length() > 25);

		boolean format = false;
		do {
			System.out.print("Date of Birth (dd/mm/yyyy) : ");
			birth = scan.nextLine();

			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			dateFormat.setLenient(false);

			try {
				dateFormat.parse(birth);
				format = true;
			} catch (ParseException e) {
			}

		} while (!birth.matches("\\d{2}/\\d{2}/\\d{4}") || format == false);

		String id;
		do {
			Integer tempRoom;
			Integer tempId;

			clear();

			System.out.println("Choose Your Room Type");
			System.out.println("=====================");
			System.out.println("1. Standard (Rp 200.000.000/year)");
			System.out.println("2. Luxury (Rp 400.000.000/year)");
			System.out.println("3. Deluxe (Rp 600.000.000/year)");
			System.out.print(">> ");
			roomMenu = scan.nextInt();
			scan.nextLine();

			int max = 0;
			int min = 0;

			if (roomMenu == 1) {
				max = 19;
				min = 1;
				tempRoom = random.nextInt(max - min + 1) + min;
				room = "Std " + tempRoom.toString();
			} else if (roomMenu == 2) {
				max = 29;
				min = 20;
				tempRoom = random.nextInt(max - min + 1) + min;
				room = "Lux " + tempRoom.toString();
			} else if (roomMenu == 3) {
				max = 39;
				min = 30;
				tempRoom = random.nextInt(max - min + 1) + min;
				room = "Dlx " + tempRoom.toString();
			}

			tempId = random.nextInt(999);

			if (tempId < 10) {
				id = "PER00" + tempId;
			} else if (tempId < 100) {
				id = "PER0" + tempId;
			} else {
				id = "PER" + tempId;
			}
		} while (roomMenu < 1 && roomMenu > 3);

		System.out.print("Duration (years) : ");
		int year = scan.nextInt();
		scan.nextLine();

		String expireDate = null;
		expireDate = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/"
				+ (calendar.get(Calendar.YEAR) + year);

		String tempMenu;
		String facilities = null;

		do {
			System.out.print("Additional Facilities Required? [y/n] : ");
			tempMenu = scan.nextLine();

			if (tempMenu.charAt(0) == 'y') {
				System.out.print("Additional Facilities : ");
				facilities = scan.nextLine();
				break;
			} else if (tempMenu.charAt(0) == 'n') {
				facilities = null;
				break;
			}
		} while (tempMenu.charAt(0) != 'y' || tempMenu.charAt(0) != 'n');

		PermanentGuest data = new PermanentGuest(name, birth, room, id, facilities, expireDate, year);

		permanentGuest.add(data);
		data.calculate();
	}

	static void showGuest() {

		if (regularGuest.isEmpty() && permanentGuest.isEmpty()) {
			System.out.println("No Data Available!");
			scan.nextLine();
		} else {
			System.out.println("Permanent Guest");
			System.out.println("---------------");
			System.out.printf("%-10s %-30s %-20s %-10s", "|Room|", "|Name|", "|Expiry Date|", "|Guest ID|");
			System.out.println("");
			System.out.println("============================================================================");

			if (permanentGuest.size() > 0) {
				for (int i = 0; i < permanentGuest.size(); i++) {
					System.out.format("%-10s %-30s %-20s %-10s", permanentGuest.get(i).getRoom(),
							permanentGuest.get(i).getName(), permanentGuest.get(i).getExpireDate(),
							permanentGuest.get(i).getId());
					System.out.println();
				}
			} else {
				System.out.format("%40s", "No Permanent Guest Available");
				System.out.println("");
			}
			System.out.println("============================================================================");
			System.out.println();
			System.out.println("Regular Guest");
			System.out.println("-------------");
			System.out.printf("%-10s %-30s %-20s %-10s", "|Room|", "|Name|", "|Check-out Date|", "|Guest ID|");
			System.out.println("");
			System.out.println("============================================================================");
			if (regularGuest.size() > 0) {
				for (int i = 0; i < regularGuest.size(); i++) {
					System.out.format("%-10s %-30s %-20s %-10s", regularGuest.get(i).getRoom(),
							regularGuest.get(i).getName(), regularGuest.get(i).getCheckOut(),
							regularGuest.get(i).getId());
					System.out.println();
				}
			} else {
				System.out.format("%40s", "No Regular Guest Available");
				System.out.println("");
			}
			System.out.println("============================================================================");
		}
	}

	static void searchGuest() {
		int count = 0;

		if (regularGuest.isEmpty() && permanentGuest.isEmpty()) {
			System.out.print("No Data Available!");
			scan.nextLine();
		} else {
			String tempMenu;
			do {
				clear();
				count = 0;
				showGuest();
				System.out.print("Proceed to Search Guest's Data? [y/n]: ");
				tempMenu = scan.nextLine();

				if (tempMenu.charAt(0) == 'y') {
					String tempId;
					do {
						System.out.print("Input Guest ID : ");
						tempId = scan.nextLine();

						if (tempId.charAt(0) == 'P') {
							for (int i = 0; i < permanentGuest.size(); i++) {
								if (tempId.equals(permanentGuest.get(i).getId())) {
									clear();
									System.out.println("Guest's Data");
									System.out.println("============");
									System.out.println();
									System.out.println("Name \t\t\t: " + permanentGuest.get(i).getName());
									System.out.println("Date of Birth \t\t: " + permanentGuest.get(i).getBirth());
									System.out.println("Hotel Room \t\t: " + permanentGuest.get(i).getRoom());
									System.out.println("ID \t\t\t: " + permanentGuest.get(i).getId());
									System.out.println(
											"Additional Facilities \t: " + permanentGuest.get(i).getAddFacilities());
									System.out.println("Expiration Date \t: " + permanentGuest.get(i).getExpireDate());
									System.out.println("Rent Fee \t\t: Rp" + permanentGuest.get(i).getPrice());
									System.out
											.println("Duration \t\t: " + permanentGuest.get(i).getYear() + " Year(s)");
								} else {
									count += 1;
								}
							}
							if (count == permanentGuest.size()) {
								System.out.println();
								System.out.print("Data not Found!");
							}
							System.out.println();
							System.out.print("Enter to continue...");
							scan.nextLine();
							break;
						} else if (tempId.charAt(0) == 'R') {
							for (int i = 0; i < regularGuest.size(); i++) {
								if (tempId.equals(regularGuest.get(i).getId())) {
									clear();
									System.out.println("Guest's Data");
									System.out.println("============");
									System.out.println("Name \t\t\t: " + regularGuest.get(i).getName());
									System.out.println("Date of Birth \t\t: " + regularGuest.get(i).getBirth());
									System.out.println("Hotel Room \t\t: " + regularGuest.get(i).getRoom());
									System.out.println("ID \t\t\t: " + regularGuest.get(i).getId());
									System.out.println(
											"Additional Facilities \t: " + regularGuest.get(i).getAddFacilities());
									System.out.println();
									System.out.println("Check-in Date \t\t: " + regularGuest.get(i).getCheckIn());
									System.out.println("Check-out Date \t\t: " + regularGuest.get(i).getCheckOut());
									System.out.println();
									System.out
											.println("Duration \t\t: " + regularGuest.get(i).getNight() + " Night(s)");
									System.out.println("Total Fee \t\t: Rp" + regularGuest.get(i).getPrice());
								} else {
									count += 1;
								}
							}
							if (count == regularGuest.size()) {
								System.out.println();
								System.out.print("Data not Found!");
							}
							System.out.println();
							System.out.print("Enter to continue...");
							scan.nextLine();
							break;
						} else {
							System.out.print("ID not valid!");
							scan.nextLine();
							break;
						}
					} while (tempId.charAt(0) != 'P' || tempId.charAt(0) != 'R');
				} else if (tempMenu.charAt(0) == 'n') {
					break;
				}
			} while (tempMenu.charAt(0) != 'y' || tempMenu.charAt(0) != 'n');
		}
	}

	static void deleteGuest() {
		int count = 0;
		int index = -1;

		if (regularGuest.isEmpty() && permanentGuest.isEmpty()) {
			System.out.print("No Data Available!");
			scan.nextLine();
		} else {
			String tempMenu;
			do {
				index = -1;
				count = 0;
				clear();
				if (regularGuest.isEmpty() && permanentGuest.isEmpty()) {
					break;
				}
				showGuest();
				System.out.print("Proceed to Delete Guest Data? [y/n]: ");
				tempMenu = scan.nextLine();

				if (tempMenu.charAt(0) == 'y') {
					String tempId;
					do {
						System.out.print("Input Guest ID to Delete : ");
						tempId = scan.nextLine();

						if (tempId.charAt(0) == 'P') {
							for (int i = 0; i < permanentGuest.size(); i++) {
								if (tempId.equals(permanentGuest.get(i).getId())) {
									index = i;
									clear();
									System.out.println("Guest's Data");
									System.out.println("============");
									System.out.println();
									System.out.println("Name \t\t\t: " + permanentGuest.get(i).getName());
									System.out.println("Date of Birth \t\t: " + permanentGuest.get(i).getBirth());
									System.out.println("Hotel Room \t\t: " + permanentGuest.get(i).getRoom());
									System.out.println("ID \t\t\t: " + permanentGuest.get(i).getId());
									System.out.println(
											"Additional Facilities \t: " + permanentGuest.get(i).getAddFacilities());
									System.out.println("Expiration Date \t: " + permanentGuest.get(i).getExpireDate());
									System.out.println("Rent Fee \t\t: Rp" + permanentGuest.get(i).getPrice());
									System.out
											.println("Duration \t\t: " + permanentGuest.get(i).getYear() + " Year(s)");
								} else {
									count += 1;
								}
							}
							if (count == permanentGuest.size()) {
								System.out.println("Data not Found!");
							} else if (index > -1) {
								System.out.println();
								System.out.println("Room " + permanentGuest.get(index).getRoom() + " Emptied!");
								permanentGuest.remove(index);
							}
							System.out.print("Enter to continue...");
							scan.nextLine();
							break;
						} else if (tempId.charAt(0) == 'R') {
							for (int i = 0; i < regularGuest.size(); i++) {
								if (tempId.equals(regularGuest.get(i).getId())) {
									index = i;
									clear();
									System.out.println("Guest's Data");
									System.out.println("============");
									System.out.println("Name \t\t\t: " + regularGuest.get(i).getName());
									System.out.println("Date of Birth \t\t: " + regularGuest.get(i).getBirth());
									System.out.println("Hotel Room \t\t: " + regularGuest.get(i).getRoom());
									System.out.println("ID \t\t\t: " + regularGuest.get(i).getId());
									System.out.println(
											"Additional Facilities \t: " + regularGuest.get(i).getAddFacilities());
									System.out.println();
									System.out.println("Check-in Date \t\t: " + regularGuest.get(i).getCheckIn());
									System.out.println("Check-out Date \t\t: " + regularGuest.get(i).getCheckOut());
									System.out.println();
									System.out
											.println("Duration \t\t: " + regularGuest.get(i).getNight() + " Night(s)");
									System.out.println("Total Fee \t\t: Rp" + regularGuest.get(i).getPrice());
								} else {
									count += 1;
								}
							}
							if (count == regularGuest.size()) {
								System.out.println("Data not Found!");
							} else if (index > -1) {
								System.out.println();
								System.out.println("Room " + regularGuest.get(index).getRoom() + " Emptied!");
								regularGuest.remove(index);
							}
							System.out.print("Enter to continue...");
							scan.nextLine();
							break;
						} else {
							System.out.println("ID not valid!");
							scan.nextLine();
							break;
						}
					} while (tempId.charAt(0) != 'P' || tempId.charAt(0) != 'R');
				} else if (tempMenu.charAt(0) == 'n') {
					break;
				}
			} while (tempMenu.charAt(0) != 'y' || tempMenu.charAt(0) != 'n');
		}
	}

	static void updateGuest() {
		int count = 0;

		if (regularGuest.isEmpty() && permanentGuest.isEmpty()) {
			System.out.print("No Data Available!");
			scan.nextLine();
		} else {
			String tempMenu;
			do {
				count = 0;
				clear();
				showGuest();
				System.out.print("Proceed to Update Guest Data? [y/n]: ");
				tempMenu = scan.nextLine();

				if (tempMenu.charAt(0) == 'y') {
					String tempId;
					do {
						System.out.print("Input Guest ID : ");
						tempId = scan.nextLine();

						if (tempId.charAt(0) == 'P') {
							for (int i = 0; i < permanentGuest.size(); i++) {
								if (tempId.equals(permanentGuest.get(i).getId())) {
									clear();
									System.out.println("Old Data");
									System.out.println("============");
									System.out.println();
									System.out.println("Name \t\t\t: " + permanentGuest.get(i).getName());
									System.out.println("Date of Birth \t\t: " + permanentGuest.get(i).getBirth());
									System.out.println("Hotel Room \t\t: " + permanentGuest.get(i).getRoom());
									System.out.println("ID \t\t\t: " + permanentGuest.get(i).getId());
									System.out.println(
											"Additional Facilities \t: " + permanentGuest.get(i).getAddFacilities());
									System.out.println("Expiration Date \t: " + permanentGuest.get(i).getExpireDate());
									System.out.println("Rent Fee \t\t: Rp" + permanentGuest.get(i).getPrice());
									System.out
											.println("Duration \t\t: " + permanentGuest.get(i).getYear() + " Year(s)");

									System.out.println("New Data");
									System.out.println("========");

									System.out.print("Name : ");
									String name = scan.nextLine();

									System.out.print("Date of Birth : ");
									String birth = scan.nextLine();

									String room;
									room = permanentGuest.get(i).getRoom();

									String id;
									id = permanentGuest.get(i).getId();

									System.out.print("Expiration Date : ");
									String expireDate = scan.nextLine();

									String tempMenu1;
									String facilities = null;
									do {
										System.out.print("Update Additional Facilities? [y/n] : ");
										tempMenu1 = scan.nextLine();

										if (tempMenu1.charAt(0) == 'y') {
											System.out.print("Additional Facilities : ");
											facilities = scan.nextLine();
											break;
										} else if (tempMenu1.charAt(0) == 'n') {
											facilities = null;
											break;
										}
									} while (tempMenu1.charAt(0) != 'y' || tempMenu1.charAt(0) != 'n');

									int year = 0;
									PermanentGuest data = new PermanentGuest(name, birth, room, id, facilities,
											expireDate, year);

									permanentGuest.set(i, data);
									System.out.println();
									System.out.println("Room " + permanentGuest.get(i).getRoom() + " Data Updated!");
									System.out.print("Enter to continue...");
									scan.nextLine();
								} else {
									count += 1;
								}
							}
							if (count == permanentGuest.size()) {
								System.out.println("Data not Found!");
							}
							break;
						} else if (tempId.charAt(0) == 'R') {
							for (int i = 0; i < regularGuest.size(); i++) {
								if (tempId.equals(regularGuest.get(i).getId())) {
									clear();
									System.out.println("Old Data");
									System.out.println("=========");
									System.out.println("Name \t\t\t: " + regularGuest.get(i).getName());
									System.out.println("Date of Birth \t\t: " + regularGuest.get(i).getBirth());
									System.out.println("Hotel Room \t\t: " + regularGuest.get(i).getRoom());
									System.out.println("ID \t\t\t: " + regularGuest.get(i).getId());
									System.out.println(
											"Additional Facilities \t: " + regularGuest.get(i).getAddFacilities());
									System.out.println();
									System.out.println("Check-in Date \t\t: " + regularGuest.get(i).getCheckIn());
									System.out.println("Check-out Date \t\t: " + regularGuest.get(i).getCheckOut());
									System.out.println();
									System.out
											.println("Duration \t\t: " + regularGuest.get(i).getNight() + " Night(s)");
									System.out.println("Total Fee \t\t: Rp" + regularGuest.get(i).getPrice());

									System.out.println("New Data");
									System.out.println("========");

									String name;
									do {
										System.out.print("Full Name : ");
										name = scan.nextLine();
									} while (name.length() < 1 || name.length() > 25);

									String birth;
									do {
										System.out.print("Date of Birth (dd/mm/yyyy) : ");
										birth = scan.nextLine();
									} while (!birth.matches("\\d{2}/\\d{2}/\\d{4}"));

									String room;
									room = regularGuest.get(i).getRoom();

									String id;
									id = regularGuest.get(i).getId();

									String checkIn = regularGuest.get(i).getCheckIn();

									String checkOut = regularGuest.get(i).getCheckOut();

									String tempMenu1;
									String facilities = null;
									do {
										System.out.print("Update Additional Facilities? [y/n] : ");
										tempMenu1 = scan.nextLine();

										if (tempMenu1.charAt(0) == 'y') {
											System.out.print("Additional Facilities : ");
											facilities = scan.nextLine();
											break;
										} else if (tempMenu1.charAt(0) == 'n') {
											facilities = null;
											break;
										}
									} while (tempMenu1.charAt(0) != 'y' || tempMenu1.charAt(0) != 'n');

									int night = regularGuest.get(i).getNight();

									RegularGuest data = new RegularGuest(name, birth, room, id, facilities, checkIn,
											checkOut, night);

									regularGuest.set(i, data);
									data.calculate();
									System.out.println();
									System.out.println("Room " + regularGuest.get(i).getRoom() + " Data Updated!");
									System.out.print("Enter to continue...");
									scan.nextLine();
								} else {
									count += 1;
								}
							}
							if (count == regularGuest.size()) {
								System.out.println("Data not Found!");
							}
							break;
						} else {
							System.out.println("ID not valid!");
							scan.nextLine();
							break;
						}
					} while (tempId.charAt(0) != 'P' || tempId.charAt(0) != 'R');
				} else if (tempMenu.charAt(0) == 'n') {
					break;
				}
			} while (tempMenu.charAt(0) != 'y' || tempMenu.charAt(0) != 'n');
		}
	}

	static void checkout() {
		int count = 0;
		int index = -1;

		if (regularGuest.isEmpty() && permanentGuest.isEmpty()) {
			System.out.print("No Data Available!");
			scan.nextLine();
		} else {
			String tempMenu;
			do {
				index = -1;
				count = 0;
				clear();
				if (regularGuest.isEmpty() && permanentGuest.isEmpty()) {
					break;
				}
				showGuest();
				System.out.print("Proceed to Checkout? [y/n]: ");
				tempMenu = scan.nextLine();

				if (tempMenu.charAt(0) == 'y') {
					String tempId;
					do {
						System.out.print("Guest ID : ");
						tempId = scan.nextLine();

						if (tempId.charAt(0) == 'P') {
							for (int i = 0; i < permanentGuest.size(); i++) {
								if (tempId.equals(permanentGuest.get(i).getId())) {
									index = i;
									clear();
									System.out.println("Guest's Data");
									System.out.println("============");
									System.out.println();
									System.out.println("Name \t\t\t: " + permanentGuest.get(i).getName());
									System.out.println("Date of Birth \t\t: " + permanentGuest.get(i).getBirth());
									System.out.println("Hotel Room \t\t: " + permanentGuest.get(i).getRoom());
									System.out.println("ID \t\t\t: " + permanentGuest.get(i).getId());
									System.out.println(
											"Additional Facilities \t: " + permanentGuest.get(i).getAddFacilities());
									System.out.println("Expiration Date \t: " + permanentGuest.get(i).getExpireDate());
									System.out.println();
									System.out
											.println("Duration \t\t: " + permanentGuest.get(i).getYear() + " Year(s)");
								} else {
									count += 1;
								}
							}
							if (count == permanentGuest.size()) {
								System.out.println("Data not Found!");
							} else if (index > -1) {
								System.out.println("Total Price : Rp" + permanentGuest.get(index).getPrice());
								long money;
								do {
									System.out.print("Input Money : Rp");
									money = scan.nextLong();
									scan.nextLine();
								} while (money < permanentGuest.get(index).getPrice());
								if (money > permanentGuest.get(index).getPrice()) {
									money = money - permanentGuest.get(index).getPrice();
									System.out.println("Change : Rp" + money);
									System.out.println();
									System.out.println("Room " + permanentGuest.get(index).getRoom() + " Emptied!");
									permanentGuest.remove(index);
								} else if (money == permanentGuest.get(index).getPrice()) {
									System.out.println();
									System.out.println("Room " + permanentGuest.get(index).getRoom() + " Emptied!");
									permanentGuest.remove(index);
								}
							}
							System.out.print("Enter to continue...");
							scan.nextLine();
							break;
						} else if (tempId.charAt(0) == 'R') {
							for (int i = 0; i < regularGuest.size(); i++) {
								if (tempId.equals(regularGuest.get(i).getId())) {
									index = i;
									clear();
									System.out.println("Guest's Data");
									System.out.println("============");
									System.out.println("Name \t\t\t: " + regularGuest.get(i).getName());
									System.out.println("Date of Birth \t\t: " + regularGuest.get(i).getBirth());
									System.out.println("Hotel Room \t\t: " + regularGuest.get(i).getRoom());
									System.out.println("ID \t\t\t: " + regularGuest.get(i).getId());
									System.out.println(
											"Additional Facilities \t: " + regularGuest.get(i).getAddFacilities());
									System.out.println();
									System.out.println("Check-in Date \t\t: " + regularGuest.get(i).getCheckIn());
									System.out.println("Check-out Date \t\t: " + regularGuest.get(i).getCheckOut());
									System.out.println();
									System.out.println("Duration : " + regularGuest.get(i).getNight() + " Night(s)");
								} else {
									count += 1;
								}
							}
							if (count == regularGuest.size()) {
								System.out.println("Data not Found!");
							} else if (index > -1) {

								System.out.println("Total Price : Rp" + regularGuest.get(index).getPrice());
								long money;
								do {
									System.out.print("Input Money : Rp");
									money = scan.nextLong();
									scan.nextLine();
								} while (money < regularGuest.get(index).getPrice());
								if (money > regularGuest.get(index).getPrice()) {
									money = money - regularGuest.get(index).getPrice();
									System.out.println("Change : Rp" + money);
									System.out.println();
									System.out.println("Room " + regularGuest.get(index).getRoom() + " Emptied!");
									regularGuest.remove(index);
								} else if (money == regularGuest.get(index).getPrice()) {
									System.out.println();
									System.out.println("Room " + regularGuest.get(index).getRoom() + " Emptied!");
									regularGuest.remove(index);
								}
							}
							System.out.print("Enter to continue...");
							scan.nextLine();
							break;
						} else {
							System.out.println("ID not valid!");
							scan.nextLine();
							break;
						}
					} while (tempId.charAt(0) != 'P' || tempId.charAt(0) != 'R');
				} else if (tempMenu.charAt(0) == 'n') {
					break;
				}
			} while (tempMenu.charAt(0) != 'y' || tempMenu.charAt(0) != 'n');
		}
	}

	static void extend() {
		int count = 0;

		if (regularGuest.isEmpty() && permanentGuest.isEmpty()) {
			System.out.print("No Data Available!");
			scan.nextLine();
		} else {
			String tempMenu;
			do {
				count = 0;
				clear();
				showGuest();
				System.out.print("Proceed to Extend Stay? [y/n]: ");
				tempMenu = scan.nextLine();

				if (tempMenu.charAt(0) == 'y') {
					String tempId;
					do {
						System.out.print("Guest ID : ");
						tempId = scan.nextLine();

						if (tempId.charAt(0) == 'P') {
							for (int i = 0; i < permanentGuest.size(); i++) {
								if (tempId.equals(permanentGuest.get(i).getId())) {
									clear();
									System.out.println("Guest's Data");
									System.out.println("============");
									System.out.println();
									System.out.println("Name \t\t\t: " + permanentGuest.get(i).getName());
									System.out.println("Date of Birth \t\t: " + permanentGuest.get(i).getBirth());
									System.out.println("Hotel Room \t\t: " + permanentGuest.get(i).getRoom());
									System.out.println("ID \t\t\t: " + permanentGuest.get(i).getId());
									System.out.println(
											"Additional Facilities \t: " + permanentGuest.get(i).getAddFacilities());
									System.out.println("Expiration Date \t: " + permanentGuest.get(i).getExpireDate());
									System.out.println("Rent Fee \t\t: Rp" + permanentGuest.get(i).getPrice());
									System.out
											.println("Duration \t\t: " + permanentGuest.get(i).getYear() + " Year(s)");

									System.out.println();

									System.out.print("Duration (years) : ");
									int tempYear = scan.nextInt();
									scan.nextLine();

									int year = permanentGuest.get(i).getYear() + tempYear;
									String expireDate = permanentGuest.get(i).getExpireDate();
									int expireYear = Integer.parseInt(expireDate.substring(5, 9));
									expireYear = expireYear + tempYear;

									expireDate = calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH) + 1)
											+ "/" + (expireYear);

									String name = permanentGuest.get(i).getName();

									String birth = permanentGuest.get(i).getBirth();

									String room;
									room = permanentGuest.get(i).getRoom();

									String id;
									id = permanentGuest.get(i).getId();

									String tempMenu1;
									String facilities = null;
									do {
										System.out.print("Update Additional Facilities? [y/n] : ");
										tempMenu1 = scan.nextLine();

										if (tempMenu1.charAt(0) == 'y') {
											System.out.print("Additional Facilities : ");
											facilities = scan.nextLine();
											break;
										} else if (tempMenu1.charAt(0) == 'n') {
											facilities = null;
											break;
										}
									} while (tempMenu1.charAt(0) != 'y' || tempMenu1.charAt(0) != 'n');

									PermanentGuest data = new PermanentGuest(name, birth, room, id, facilities,
											expireDate, year);

									permanentGuest.set(i, data);
									data.calculate();
									System.out.println();
									System.out.println("Room " + permanentGuest.get(i).getRoom() + " Extended until "
											+ permanentGuest.get(i).getExpireDate());
									System.out.print("Enter to continue...");
									scan.nextLine();
								} else {
									count += 1;
								}
							}
							if (count == permanentGuest.size()) {
								System.out.println("Data not Found!");
							}
							break;
						} else if (tempId.charAt(0) == 'R') {
							for (int i = 0; i < regularGuest.size(); i++) {
								if (tempId.equals(regularGuest.get(i).getId())) {
									clear();
									System.out.println("Guest's Data");
									System.out.println("============");
									System.out.println("Name \t\t\t: " + regularGuest.get(i).getName());
									System.out.println("Date of Birth \t\t: " + regularGuest.get(i).getBirth());
									System.out.println("Hotel Room \t\t: " + regularGuest.get(i).getRoom());
									System.out.println("ID \t\t\t: " + regularGuest.get(i).getId());
									System.out.println(
											"Additional Facilities \t: " + regularGuest.get(i).getAddFacilities());
									System.out.println();
									System.out.println("Check-in Date \t\t: " + regularGuest.get(i).getCheckIn());
									System.out.println("Check-out Date \t\t: " + regularGuest.get(i).getCheckOut());
									System.out.println();
									System.out
											.println("Duration \t\t: " + regularGuest.get(i).getNight() + " Night(s)");
									System.out.println("Total Fee \t\t: Rp" + regularGuest.get(i).getPrice());

									int night = regularGuest.get(i).getNight();
									int tempNight = 0;
									int checkOutDate;
									int checkOutMonth;
									int checkOutYear;
									String checkOut = regularGuest.get(i).getCheckOut();

									checkOutDate = Integer.parseInt(checkOut.substring(0, 2));
									checkOutMonth = Integer.parseInt(checkOut.substring(3, 4));
									checkOutYear = Integer.parseInt(checkOut.substring(5, 9));

									do {
										try {
											System.out.println();
											System.out.print("Extend (Min 1 night) : ");
											tempNight = scan.nextInt();
										} catch (Exception e) {
										}
										scan.nextLine();
									} while (night <= 0);

									night = night + tempNight;
									checkOutDate = checkOutDate + tempNight;

									if (checkOutDate > 31) {
										checkOutDate -= 31;
										checkOutMonth += 1;

										if (checkOutMonth > 12) {
											checkOutYear += 1;
										}
									}

									checkOut = Integer.toString(checkOutDate) + "/" + Integer.toString(checkOutMonth)
											+ "/" + Integer.toString(checkOutYear);

									String tempMenu1;
									String facilities = null;
									do {
										System.out.print("Update Additional Facilities? [y/n] : ");
										tempMenu1 = scan.nextLine();

										if (tempMenu1.charAt(0) == 'y') {
											System.out.print("Additional Facilities : ");
											facilities = scan.nextLine();
											break;
										} else if (tempMenu1.charAt(0) == 'n') {
											facilities = null;
											break;
										}
									} while (tempMenu1.charAt(0) != 'y' || tempMenu1.charAt(0) != 'n');

									String name = regularGuest.get(i).getName();
									String birth = regularGuest.get(i).getBirth();
									String room = regularGuest.get(i).getRoom();
									String id = regularGuest.get(i).getId();
									String checkIn = regularGuest.get(i).getCheckIn();

									RegularGuest data = new RegularGuest(name, birth, room, id, facilities, checkIn,
											checkOut, night);
									regularGuest.set(i, data);
									data.calculate();

									System.out.println();
									System.out.println("Room " + regularGuest.get(i).getRoom() + " Extended until "
											+ regularGuest.get(i).getCheckOut());
									System.out.print("Enter to continue...");
									scan.nextLine();
								} else {
									count += 1;
								}
							}
							if (count == regularGuest.size()) {
								System.out.println("Data not Found!");
							}
							break;
						} else {
							System.out.println("ID not valid!");
							scan.nextLine();
							break;
						}
					} while (tempId.charAt(0) != 'P' || tempId.charAt(0) != 'R');
				} else if (tempMenu.charAt(0) == 'n') {
					break;
				}
			} while (tempMenu.charAt(0) != 'y' || tempMenu.charAt(0) != 'n');
		}
	}

	static void clear() {
		for (int i = 0; i < 99; i++) {
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new MyThread("Initialization");
		new MyThread("Preparation");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("Program Interrupted");
		}
		
		clear();
		
		System.out.println("Starting program.....");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Program Interrupted");
		}
		
		clear();
		
		Start start = new Start();
		try {
			while (start.isAlive()) {
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Program Interrupted");
		}

		addSampleGuest();

		do {
			clear();
			System.out.println("Hotel Management System");
			System.out.println("========================");
			System.out.println("1. Check-in");
			System.out.println("2. Check-out");
			System.out.println("3. Extend Stay");
			System.out.println("4. Search Guest");
			System.out.println("5. Change Guest's Data");
			System.out.println("6. Cancel Guest");
			System.out.println("7. Exit");

			System.out.print(">> ");
			menu = scan.nextInt();
			scan.nextLine();

			switch (menu) {
			case 1:
				do {
					clear();
					System.out.println("1. Regular Guest");
					System.out.println("2. Permanent Guest");
					System.out.println("3. Back");

					System.out.print(">> ");
					menu = scan.nextInt();
					scan.nextLine();

					switch (menu) {
					case 1:
						clear();
						addRegularGuest();
						System.out.print("Regular Guest Added!");
						scan.nextLine();
						break;
					case 2:
						clear();
						addPermanentGuest();
						System.out.print("Permanent Guest Added!");
						scan.nextLine();
						break;
					}
				} while (menu != 3);
				break;
			case 2:
				clear();
				checkout();
				break;
			case 3:
				clear();
				extend();
				break;
			case 4:
				clear();
				searchGuest();
				break;
			case 5:
				clear();
				updateGuest();
				break;
			case 6:
				clear();
				deleteGuest();
				break;
			}
		} while (menu != 7);
	}
}