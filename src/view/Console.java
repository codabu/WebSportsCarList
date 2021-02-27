package view;

//Corry Burton 2/12/2021

import java.util.List;
import java.util.Scanner;

import controller.LIHelper;
import model.ListItem;

public class Console {

		static Scanner in = new Scanner(System.in);
		static LIHelper lih = new LIHelper();

		//addAnItem method gets Make, Model and Year of a new sports car to add to the DB, passes this info as a ListItem to the insertItem method of the controller
		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a Make: ");
			String make = in.nextLine();
			System.out.print("Enter a Model: ");
			String model = in.nextLine();
			System.out.print("Enter a Year: ");
			String year = in.nextLine();
			ListItem toAdd = new ListItem(make, model, year);
			lih.insertItem(toAdd);

		}

		//deleteAnItem method gets make, model and year of a sports car to delete, and passes this info as a ListItem to the deleteItem method of the controller
		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the Make to delete: ");
			String make = in.nextLine();
			System.out.print("Enter the Model to delete: ");
			String model = in.nextLine();
			System.out.print("Enter the Year to delete: ");
			String year = in.nextLine();
			ListItem toDelete = new ListItem(make, model, year);
			lih.deleteItem(toDelete);

		}
		
		//editAnItem method allows you to searh the sports cars by Make, Model or Year, pick an ID corresponding to the car you want to edit, and then edit the make, model or year of that car
		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Make");
			System.out.println("2 : Search by Model");
			System.out.println("3 : Search by Year");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the Make: ");
				String makeName = in.nextLine();
				foundItems = lih.searchForCarByMake(makeName);
				
			} 
			else if (searchBy ==2) {
				System.out.print("Enter the Model: ");
				String modelName = in.nextLine();
				foundItems = lih.searchForCarByModel(modelName);
			}
			else {
				System.out.print("Enter the Year: ");
				String year = in.nextLine();
				foundItems = lih.searchForCarByYear(year);
			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.getMake() + " " + l.getModel() + " " + l.getYear());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForCarById(idToEdit);
				System.out.println("Retrieved " +  toEdit.getMake() + " " + toEdit.getModel() + " " +  toEdit.getYear());
				System.out.println("1 : Update Make");
				System.out.println("2 : Update Model");
				System.out.println("3 : Update Year");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Make: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
				} 
				if (update == 2) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				}
				else if (update == 3) {
					System.out.print("New Year: ");
					String newYear = in.nextLine();
					toEdit.setYear(newYear);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}
		
		//the main method just runs the menu method
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		//the run menu method gives users options for adding, editing, deleting cars, as well as viewing the list of sports cars and exiting the application
		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our car inventory list ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add a car");
				System.out.println("*  2 -- Edit a car");
				System.out.println("*  3 -- Delete a car");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit application");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Thank you and goodbye!   ");
					goAgain = false;
				}

			}

		}

		//the view the list method shows all the sports cars stored in the database using the showAllItems method of the controller
		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListItem> allItems = lih.showAllItems();
			for(ListItem singleItem : allItems){
			System.out.println(singleItem.returnItemDetails());
		}

	}
}