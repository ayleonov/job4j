package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
	private Input input;
  
    public StartUI(Input input) {
        this.input = input;
        
    }

    public static void main(String[] args) throws Exception {
		Input input = new ConsoleInput();
        new StartUI(input).init();		
    }

    public void init() {
		Tracker tracker = new Tracker();
		MenuTracker menu = new MenuTracker(this.input, tracker);
		menu.fillActions();
		do {
			menu.show();
			int key = Integer.valueOf(input.ask("Select: "));
			menu.select(key);
		}	while (!"y".equals(this.input.ask("Exit? y/n")));
    }
	
	

}
// java -cp target\chapter_002-2.0.jar ru.job4j.tracker.StartUI