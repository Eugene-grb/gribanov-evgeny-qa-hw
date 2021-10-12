import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        // папка в feature файлами
//        features = {"src/test/resources/features"},
//        // папка с шагами
//        glue = {"steps", "hooks"},
//        // запуск с тегами
//        tags = "@table1",
//        // вывод шагов в окне запуска
//        stepNotifications = false,
//        plugin = "json:target/cucumber-report/cucumber.json"
)
public class RunCucumberTest {
}