package samplee;

import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;

import java.io.File;
import sample.*;


/**
 * Created by Seagull on 23.06.2015.
 */
public class CipherSerializerView implements IView {
    public void configure(Menu menu, Main main) {
        ObservableList<MenuItem> list = menu.getItems();
        MenuItem item = new MenuItem("Укажите путь(лаб.6)");
        item.setOnAction((event) -> {
            FileChooser dialog = new FileChooser();
            File file = dialog.showOpenDialog(main.getStage());
            if (file != null) {
                Serializer.setFilePath(file.getAbsolutePath());
            }
        });
        list.add(item);
    }
}
