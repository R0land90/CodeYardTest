import org.openqa.selenium.WebDriver;

public class PageFactory {

    public static PageBase Create(String name, WebDriver driver){
        switch (name){
            case "FormPage":
                return new FormPage(driver);
            case "SummaryPage":
                return new SummaryPage(driver);
            case "Tools":
                return new Tools(driver);

            default:
                return null;
        }
    }
}
