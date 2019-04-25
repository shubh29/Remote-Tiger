package com.studio.shubham;

import static org.junit.Assert.*;

import org.junit.Test;


public class UserTest {
  
  @Test
  public void testHashCode() {
    User user1 = new User();
    user1.setId(13);
    User user2 = new User();
    user2.setId(13);
    User user3 = new User();
    user3.setId(84);
    assertEquals(user1.hashCode(), user2.hashCode());
    assertEquals(user1.hashCode(), user1.hashCode());
    assertTrue(user1.hashCode() == user2.hashCode());
    assertFalse(user3.hashCode() == user1.hashCode());
  }

  @Test
  public void testEquals() {
    User user1 = new User();
    user1.setId(13);
    User user2 = new User();
    user2.setId(13);
    User user3 = new User();
    user3.setId(84);
    User user4 = new User();
    user4.setId(48);
    assertFalse(user1.equals(user3));
    assertTrue(user1.equals(user2));
    assertEquals(true, user1.equals(user2));
    assertEquals(true, user1.equals(user1));
    assertEquals(false, user1.equals(user4));
    
    User user5 = new User();
    assertFalse(user5.equals(null));
    Issue issue1 = new Issue();
    assertFalse(user5.equals(issue1));
    
  }

  @Test
  public void testEqualsReflexive() {
    User user1 = new User();
    user1.setId(1);
    assertTrue(user1.equals(user1));
  }

  @Test
  public void testEqualsSymmetric() {
    User user1 = new User();
    user1.setId(1);
    User user2 = new User();
    user2.setId(1);
    assertTrue(user1.equals(user2));
    assertTrue(user2.equals(user1));
  }

  @Test
  public void testEqualsTransitive() {
    User user1 = new User();
    user1.setId(2);
    User user2 = new User();
    user2.setId(2);
    User user3 = new User();
    user3.setId(2);
    assertTrue(user1.equals(user2));
    assertTrue(user2.equals(user3));
    assertTrue(user3.equals(user1));
  }

  @Test
  public void testToString() {
    User user1 = new User();
    String tester = "User [id=14, " + "login=user1]";
    user1.setId(14);
    user1.setLogin("user1");
    assertEquals(tester, user1.toString());

    User user2 = new User();
    String test = "User=User [id=userid02, login=user2]";
    user2.setId(13);
    user2.setLogin("user2");
    assertFalse(test == user2.toString());
  }
  
  @Test
  public void testGetLogin() {
    User user1 = new User();
    user1.setLogin("shubham");
    assertEquals("shubham", user1.getLogin());
  }
  
  @Test
  public void testSetLogin() {
    User user1 = new User();
    user1.setLogin("shubham");
    User user2 = new User();
    user2.setLogin("shubham");
    assertTrue(user2.equals(user1));
  }
  
  @Test
  public void testGetId() {
    User user1 = new User();
    user1.setId(13);
    assertEquals(13, user1.getId());
  }
  
  @Test
  public void testBoolean() {
    User user2 = new User();
    user2.setLogin("shubh29");
    assertNotNull(user2);
  }
}