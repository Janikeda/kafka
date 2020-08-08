import com.spec.service.MessageService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class Main {

    private static String pathToFile = "src\\main\\resources\\messages.txt";
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> data = Files.lines(Paths.get(pathToFile)).collect(Collectors.toList());
        MessageService messageService = new MessageService();
        for(String str : data) {
            TimeUnit.SECONDS.sleep(2);
            messageService.sendMessage(str);
            LOGGER.info("Отправка выполнена успешно, для сообщения: " + str);
        }
    }
}
