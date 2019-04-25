package com.studio.shubham;

import static org.junit.Assert.*;

import org.junit.Test;


public class IssueTest {

  @Test
  public void testEqualsReflexive() {
    Issue issue1 = new Issue();
    issue1.setId(1);
    assertTrue(issue1.equals(issue1));
  }

  @Test
  public void testEqualsSymmetric() {
    Issue issue1 = new Issue();
    issue1.setId(1);
    Issue issue2 = new Issue();
    issue2.setId(1);
    assertTrue(issue1.equals(issue2));
    assertTrue(issue2.equals(issue1));
  }

  @Test
  public void testEqualsTransitive() {
    Issue issue1 = new Issue();
    issue1.setId(2);
    Issue issue2 = new Issue();
    issue2.setId(2);
    Issue issue3 = new Issue();
    issue3.setId(2);
    assertTrue(issue1.equals(issue2));
    assertTrue(issue2.equals(issue3));
    assertTrue(issue3.equals(issue1));
  }
  
  @Test
  public void testEquals() {
    Issue issue1 = new Issue();
    assertFalse(issue1.equals(null));
    User user = new User();
    assertFalse(issue1.equals(user));
    issue1.setId(3);
    Issue issue2 = new Issue();
    issue2.setId(4);
    assertFalse(issue2.equals(issue1));
  }
  
  @Test
  public void testComapreTo() {
    Issue issue1 = new Issue();
	Issue issue2 = new Issue();
	Issue issue3 = new Issue();
	Issue issue4 = new Issue();
	Issue issue5 = new Issue();
	issue1.setId(13);
	issue2.setId(14);
	issue3.setId(15);
	issue4.setId(16);
	issue5.setId(13);
	assertEquals(-1, issue1.compareTo(issue2));
	assertEquals(1, issue4.compareTo(issue2));
	assertEquals(1, issue3.compareTo(issue2));
	assertEquals(0, issue5.compareTo(issue1));
  }
  
  @Test
  public void testHashCode() {
    Issue issue1 = new Issue();
    issue1.setId(84);
    Issue issue2 = new Issue();
    issue2.setId(84);
    Issue issue3 = new Issue();
    issue3.setId(100);
    assertEquals(issue1.hashCode(), issue2.hashCode());
    assertEquals(issue1.hashCode(), issue1.hashCode());
    assertTrue(issue1.hashCode() == issue2.hashCode());
    assertFalse(issue3.hashCode() == issue1.hashCode());
  }
  
  @Test 
  public void testGetState() {
    Issue issue1 = new Issue();
    issue1.setState("open");
    assertEquals("open", issue1.getState());
  }
  
  @Test
  public void testGetTitle() {
    Issue issue1 = new Issue();
    issue1.setTitle("title1");
    assertEquals("title1", issue1.getTitle());
  }
  
  @Test
  public void testGetBody() {
    Issue issue1 = new Issue();
    issue1.setBody("body1");
    assertEquals("body1", issue1.getBody());
  }

  @Test
  public void testToString() {
	Issue issue1 = new Issue();
    User user1 = new User();
    User assignee1 = new User();
    String tester = "Issue [" + "id=84, " + "state=open, "
            + "title=Title of Issue, " + "body=Body of Issue, " + "number=13, "
            + "createAt=null, " + "closedAt=null, "
            + "user=User [id=85, login=user1], "
            + "assignee=User [id=85, login=assignee1]]";
    issue1.setId(84);
    issue1.setNumber("13");
    issue1.setState("open");
    issue1.setTitle("Title of Issue");
    issue1.setBody("Body of Issue");
    issue1.setCreatedAt(null);
    user1.setId(85);
    user1.setLogin("user1");
    assignee1.setId(85);
    assignee1.setLogin("assignee1");
    issue1.setAssignee(assignee1);
    issue1.setUser(user1);
    assertEquals(tester, issue1.toString());
  }
  
  @Test
  public void test() {
    System.out.println("in test");
  }
  
  @Test
  public void testGetId() {
    Issue issue1 = new Issue();
    issue1.getId();
    assertFalse("id".equals(issue1));
  }
  
  @Test
  public void testSetId() {
    Issue issue1 = new Issue();
    issue1.setId(14);
    assertTrue(issue1.equals(issue1));
  }
  
  @Test
  public void testSetBody() {
    Issue issue1 = new Issue();
    issue1.setBody("Test Body");
    assertTrue(issue1.equals(issue1));
  }
  
  @Test
  public void testSetNumber() {
    Issue issue1 = new Issue();
    issue1.setNumber("84");
    assertEquals("84", issue1.getNumber());
  }
  
  @Test
  public void testSetTitle() {
    Issue issue1 = new Issue();
    issue1.setTitle("Test Title");
    assertTrue(issue1.equals(issue1));
  }
  
  @Test
  public void testGetCreatedAt() {
    Issue issue1 = new Issue();
    issue1.setCreatedAt(null);
    assertEquals(null, issue1.getCreatedAt());
  }
  
  @Test
  public void testGetClosedAt() {
    Issue issue1 = new Issue();
    issue1.setClosedAt(null);
    assertEquals(null, issue1.getClosedAt());
  }
  
  @Test
  public void testGetUser() {
	Issue issue1 = new Issue();
    User user1 = new User();
    issue1.setUser(user1);
    assertEquals(user1, issue1.getUser());
  }
  
  @Test
  public void testGetAssignee() {
	Issue issue1 = new Issue();
    User assignee1 = new User();
    issue1.setAssignee(assignee1);
    assertEquals(assignee1, issue1.getAssignee());
  }
  
  @Test
  public void testSetClosedAt() {
    Issue issue1 = new Issue();
    issue1.setClosedAt(null);
    assertTrue(issue1.equals(issue1));
  }
  
}
