import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.nsu.ccfit.nadezhkin.lab1.presenter.Presenter;

public class Sources {
    private static Logger logger = LogManager.getLogger(Sources.class);
    public static void main(String[] args) {
        //logger.info("Start logging");
        Presenter presenter = new Presenter();
        presenter.run();
    }
}
