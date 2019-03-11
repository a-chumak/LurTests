import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public class BaseTests {

    @BeforeEach
    void init(TestInfo testInfo) {
        System.out.println("Test <" + testInfo.getDisplayName() + "> starts running");
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("Test <" + testInfo.getDisplayName() + "> finished");
        System.out.println("---------------------------------------------------------------------------------");
    }

}
