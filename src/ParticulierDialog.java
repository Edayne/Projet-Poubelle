import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ParticulierDialog extends Stage{
	public ParticulierDialog(Stage upperStage){
		Pane globalPane = new Pane();
		Scene scene = new Scene(globalPane);
		this.setScene(scene);
		this.setTitle("New User");
		this.show();
		this.initOwner(upperStage);
		this.initModality(Modality.WINDOW_MODAL);
		
	}
}
