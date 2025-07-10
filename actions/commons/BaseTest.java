package commons;

import java.util.Random;

public class BaseTest {
    protected int generateRandomInt () {
        return new Random().nextInt(99999);
    }
}
