package es.pildorasinformaticas.javafx;

import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class PrimeraAplicacion extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Button miBoton = new Button("Click aquí");
		
		miBoton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
				System.out.println("Has pulsado el botón");
			}
			
			
		});
		
		StackPane raiz = new StackPane();

		raiz.getChildren().add(miBoton);
		
		Scene miEscena = new Scene(raiz,500,300);
		
		arg0.setScene(miEscena);
		
		arg0.show();
	}
	
	
}
