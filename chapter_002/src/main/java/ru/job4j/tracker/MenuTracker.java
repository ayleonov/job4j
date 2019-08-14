package ru.job4j.tracker;

public class MenuTracker {
	private final int NUMBER_POINTS_MENU = 7;
	private Input input;

	private Tracker tracker;
	private UserAction[] actions = new UserAction[NUMBER_POINTS_MENU];
	
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public int[] fillActions() {
		int[] menunumbers = new int[NUMBER_POINTS_MENU];
		this.actions[0] = this.new AddItem();
		this.actions[1] = this.new ShowItems();
		this.actions[2] = this.new EditItem();
		this.actions[3] = this.new DeleteItems();
		this.actions[4] = this.new FindById();
		this.actions[5] = this.new FindByName();
		this.actions[6] = this.new ExitProgram();
		for (int i = 0; i < actions.length ; i++) {
			menunumbers[i] = actions[i].key();
		}
		return menunumbers;
	}
	
	public void select(int key) {
		this.actions[key].execute(this.input, this.tracker);
	}
	
	public void show() {		
		for (UserAction action : this.actions) {
			if (action != null) {
				System.out.println(action.info());
			}
		}
	}
	
	private class AddItem implements UserAction {
		public int key() {
			return 0;
		}
		public void execute(Input input, Tracker tracker) {			
			String name = input.ask("Please, enter the task's name: ");
			String desc = input.ask("Please, enter the task's desc: ");			
			long time = System.currentTimeMillis();			
			tracker.add(new Item(name, desc, time));
		}
		
		public String info() {			
			return String.format("%s. %s", this.key(), "Add new item");
		}		
	}
	
	private class ShowItems implements UserAction {
		public int key() {
			return 1;
		}
		public void execute(Input input, Tracker tracker) {			
				System.out.println("---------------Items found (name description id): --------------");
			for (Item item : tracker.findAll()) {
				System.out.println(String.format("%s %s %s", item.getName(), item.getDesc(), item.getId()));
			}
			System.out.println("--------------------------------------------------- ");				
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Show all items");
		}		
	}

	private class EditItem implements UserAction {
		public int key() {
			return 2;
		}
		public void execute(Input input, Tracker tracker) {
			String id = input.ask("Please, enter the task's id: ");
			String name = input.ask("Please, enter the task's name: ");
			String desc = input.ask("Please, enter the task's desc: ");
			long time = System.currentTimeMillis();
			Item item = new Item(name, desc, time);
			tracker.replace(id, item);
			System.out.println("Item replaced");
		}

		public String info() {
			return String.format("%s. %s", this.key(), "Edit item");
		}
	}
	
	private class DeleteItems implements UserAction {
		public int key() {
			return 3;
		}	
		
		public void execute(Input input, Tracker tracker) {			
		String id = input.ask("Please, enter the task's id: ");
		System.out.println("------------ Delete item --------------");        
        boolean result = tracker.delete(id);
        if (result) {
            System.out.println("\n------------ Item deleted --------------");
        } else {
            System.out.println("Item not founded.\n");
        }    			
			System.out.println("--------------------------------------------------- ");	
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Delete item");
		}		
	}
	
		
	private class FindById implements UserAction {
		public int key() {
			return 4;
		}
		
		public void execute(Input input, Tracker tracker) {	
		System.out.println("------------ Id search --------------");        
		String id = input.ask("Please, enter the task's id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(String.format("------------ Item found: %s %s --------------", item.getName(), item.getDesc()));
        } else {
            System.out.println("Item NOT found.\n");
        }				
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Find item by id");
		}		
	}
	
	
	
	private class FindByName implements UserAction {
		public int key() {
			return 5;
		}
		public void execute(Input input, Tracker tracker) {			
		 
        System.out.println("------------ Search item by name --------------");
        String word = input.ask("Введите слово для поиска заявки :");
        Item[] foundItems = tracker.findByName(word);
        if (foundItems.length != 0) {
            System.out.println("\n------------ Items found:  name description id --------------");
            for (Item item : foundItems) {
                System.out.println(String.format("%s %s %s", item.getName(), item.getDesc(), item.getId()));
            }
        } else {
            System.out.println("Item NOT found.\n");
        }
        System.out.println("---------------------------------------------------------\n");   
		}		
		
		public String info() {
			return String.format("%s. %s", this.key(), "Find items by name");
		}		
	}

	private class ExitProgram implements UserAction {
		public int key() {
			return 6;
		}
		public void execute(Input input, Tracker tracker) {

			System.out.println("Exit the program");
		}

		public String info() {
			return String.format("%s. %s", this.key(), "Exit program");
		}
	}
	
	
	
	//  cd c:\\projects\job4j\chapter_002
	// java -cp target/tracker.jar ru.job4j.tracker.StartUI
}