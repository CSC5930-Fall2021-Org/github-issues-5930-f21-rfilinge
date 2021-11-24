package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testEqualsIsValueEquality() {
        User userA = new User();
        userA.setId(55);
        
        User userB = new User();
        userB.setId(55);
        
        assertEquals(userA,userB);
        
        assertEquals(userA.hashCode(), userB.hashCode());
      
    }
    
    @Test
    void compareToWhenFirstIsBigger() {
        User userA = new User();
        userA.setId(100);
        
        User userB = new User();
        userB.setId(55);
        
        assertTrue(userA.compareTo(userB)>0);
    }

}
