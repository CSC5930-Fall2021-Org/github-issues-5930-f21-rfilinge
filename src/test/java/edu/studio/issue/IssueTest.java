package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class IssueTest {

    @Test
    void testNumber() {
        Issue issue = new Issue();
        issue.setNumber(44);
        assertEquals(44,issue.getNumber());
    }
    @Test
    void testId() {
        Issue issue = new Issue();
        issue.setId(99);
        assertEquals(99,issue.getId());
    }
    @Test
    void testState() {
        Issue issue = new Issue();
        issue.setState("open");
        assertEquals("open",issue.getState());
    }
    @Test
    void testTitle() {
        Issue issue = new Issue();
        issue.setTitle("Issue 1");
        assertEquals("Issue 1",issue.getTitle());
    }
    @Test
    void testBody() {
        Issue issue = new Issue();
        issue.setBody("this is the first issue");
        assertEquals("this is the first issue",issue.getBody());
    }
    @Test
    void testCreatedAt() {
        Issue issue = new Issue();
        Date now = new Date();
        issue.setCreatedAt(now);
        assertEquals(now,issue.getCreatedAt());
    }
    @Test
    void testClosedAtNotClosed() {
        Issue issue = new Issue();
        assertEquals(null,issue.getClosedAt());
    }
    @Test
    void testClosedAtClosed() {
        Issue issue = new Issue();
        Date now = new Date();
        issue.setClosedAt(now);
        assertEquals(now,issue.getClosedAt());
    }
    
    @Test
    void testUserForCreator(){
        Issue issue = new Issue();
        issue.setId(99);
        
        User user = new User();
        user.setId(42);
        
        issue.setUser(user);
        assertEquals(user,issue.getUser());
        
    }
    @Test
    void testUserForAssignee(){
        Issue issue = new Issue();
        issue.setId(99);
        
        User assignee = new User();
        assignee.setId(42);
        
        issue.setAssignee(assignee);
        assertEquals(assignee,issue.getAssignee());   
    }
    
    @Test
    void testToString(){
        Issue issue = new Issue();
        
        
        User creator = new User();
        User assignee = new User();
        
        Date start = new Date();
        Date end = new Date();
        
        creator.setLogin("rfilinge");
        assignee.setLogin("Mrs. O");
        
        issue.setNumber(1);
        issue.setId(55);
        issue.setTitle("issue 1");
        issue.setState("closed");
        issue.setBody("first issue");
        issue.setCreatedAt(start);
        issue.setClosedAt(end);
        issue.setUser(creator);
        issue.setAssignee(assignee);
        
        assertEquals("Issue [number=1, id=55, state=closed, title=issue 1, body=first issue, createdAt=" + start + ", closedAt=" + end + ", user=" + creator.getLogin() + ", assignee=" + assignee + "]",issue.toString());
    }
    
    
       
    
}
