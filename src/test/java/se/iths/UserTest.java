package se.iths;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;

    @BeforeEach
    public void setupUser() {
        user = new User(175, 85);
    
    }

    @Test
    public void canCreateUserWithHeightAndWeight() {
        
        assertEquals(175, user.height);
        assertEquals(85, user.weight);
    }

    @Test
    public void computeBodyMassIndex(){
        
        assertEquals(27.8, user.calculateBMI(), 0.1);
    }

    @Test
    public void canChangeWeightAndHeight() {
        
        assertEquals(175, user.height);
        assertEquals(85, user.weight);

        user.height = 180;
        user.weight = 90;

        assertEquals(180, user.height);
        assertEquals(90, user.weight);
    }
}
