package ru.job4j.tracker;

	class EditItem implements UserAction {
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
			return String.format("%s. %s", this.key(), "Edit existing item");
		}		
	}


public class MenuTracker {
	private Input input;
	private Tracker tracker;
	private UserAction[] actions = new UserAction[6];
	
	public MenuTracker(Input input, Tracker tracker) {
		this.input = input;
		this.tracker = tracker;
	}
	
	public void fillActions() {
		
		this.actions[0] = this.new AddItem();
		this.actions[1] = new MenuTracker.ShowItems();
		this.actions[2] = new EditItem();
		this.actions[3] = new MenuTracker.DeleteItems();
		this.actions[4] = new MenuTracker.FindById();
		this.actions[5] = new MenuTracker.FindByName();		
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
			return String.format("%s. %s", this.key(), "Add the new item");
		}		
	}
	
	private static class ShowItems implements UserAction {
		public int key() {
			return 1;
		}
		public void execute(Input input, Tracker tracker) {			
				System.out.println("--------------- Items found (name description id): -------------- ");
			for (Item item : tracker.findAll()) {
				System.out.println(String.format("%s %s %s", item.getName(), item.getDesc(), item.getId()));
			}
			System.out.println("--------------------------------------------------- ");				
		}
		
		public String info() {
			return String.format("%s. %s", this.key(), "Show all items");
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
	
		
	private static class FindById implements UserAction {
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
			return String.format("%s. %s", this.key(), "Found by id");
		}		
	}
	
	
	
	private static class FindByName implements UserAction {
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
			return String.format("%s. %s", this.key(), "Found by Name");
		}		
	}
	
	
	
	
	
	//  cd c:\\projects\job4j\chapter_002
	// java -cp target/tracker.jar ru.job4j.tracker.StartUI
}