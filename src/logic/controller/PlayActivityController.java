package logic.controller;

import java.util.ArrayList;

import logic.model.*;

public class PlayActivityController {
	private Activity activity;
	private ChannelController cController;
		
	public PlayActivityController(Activity activity) {
		this.activity = activity;
	}
	
	public void readOnChannell(int user) {
		
		if (this.cController == null) {
			
			this.cController  = new ChannelController(this.activity);
		}
		
		ArrayList<String[]> chat = this.cController.formattedChat(user);
		
		if (chat == null) {
			System.out.println("Il canale e vuoto\n");
			return;
		}
		// Qui bisognera implementare una comunicazione col bean per la pagina web o, credo meglio, piu in generale qualcosa che vada al view controller
		for (String[] i : chat) {

			//volendo potrei mettere qui il controllo dell'utente cosi da avere comunque tutti gli utenti
			if (i[0].equals(String.valueOf(0))) {
				System.out.println("<<MIO MESSAGGIO>>   " + i[1]);
			}
			else System.out.println( i[1]);

		}
	}
	
	public void writeOnChannell(int user, String textMsg) {
		cController.writeMessage(user, textMsg);
	
		// this.readOnChannell(user);
	}
}
