enum subMenu {
	M1("1. Add a personnel"), 
	M2("2. Add a manager");

	private final String item;

	subMenu(String m) {
		item = m;
	}

	String getsubMenuItem() {
		return item;
	}
	static void printsubMenu(){
		for (subMenu a : subMenu.values())
			System.out.println(a.getsubMenuItem());
	}
}
