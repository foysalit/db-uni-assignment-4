package it.polito;

import it.polito.db.DB;
import it.polito.windows.MainWindow;

public class Main {

	public static void main(String[] args) {
		// Initialize the class that manage all operations
		// involving the database
		DB db=new DB();
		if(!db.OpenConnection()){
			System.err.println("Error during the connection to the DB. Impossible to continue");
			System.exit(-1);
		}
		else	
			new MainWindow(db);
	}

}