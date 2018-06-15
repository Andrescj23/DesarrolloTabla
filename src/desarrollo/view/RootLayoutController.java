
package desarrollo.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import org.controlsfx.dialog.Dialogs;
import desarrollo.Desarrollo;



public class RootLayoutController {
    private Desarrollo desarrollo;
    
    public void setDesarrollo(Desarrollo desarrollo) {
        this.desarrollo = desarrollo;
    }
    
    @FXML
    private void hadleNew() {
        desarrollo.getPersonData().clear();
        desarrollo.getPersonFilePath(null);
    }
    
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();
        
         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        
        File file = fileChooser.showOpenDialog(desarrollo.gitPrimaryStage());
        
        if (file != null) {
            desarrollo.loadPersonDataFromFile(file);
        }
    }
    
    @FXML
    private void handleSave() {
        File personFile = desarrollo.getPersonFilePath();
        if (personFile != null) {
            desarrollo.savePersonDataToFile(personFile);
        } else {
            handleSaveAs();
        }
    }
    
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(desarrollo.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            desarrollo.savePersonDataToFile(file);
        }
    }
    @FXML
    private void handleAbout(){
        Dialogs.create()
        .title("Desarrollo")
        .masthead("About")
        .message("Author: Antoni Garcia\nwebsite: http://code.Garcia.ch")
        .showInformation();
    }
    
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
