package se.iths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    public void canCreateUserWithHeightAndWeight() {
        User user = new User(175, 85);

        assertEquals(175, user.height);
        assertEquals(85, user.weight);
    }
}
