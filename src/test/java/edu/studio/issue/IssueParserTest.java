package edu.studio.issue;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class IssueParserTest {

    @Test
    void testParseIssueWithValidJson() throws IOException {
        IssueParser parser = new IssueParser();
        String json = Files.readAllLines(Paths.get("src\\test\\resources\\sample-output.txt")).get(0); 
        
        List<Issue> issues = parser.parseIssues(json);
        assertNotNull(issues);
        assertEquals(4, issues.size());  
        
        Issue issue0 = issues.get(0);
        assertEquals(1044979109, issue0.getId());
        //TODO check issue properties
        
        assertEquals("minimal fields",issue0.getTitle());
       
        Issue issue1 = issues.get(1);
        User user = new User();
        User assignee = new User();
        user = issue1.getUser();
        
        assertEquals("This is our new issue", issue1.getBody());
        assertEquals("ms-O", user.getLogin());
        assertEquals("open", issue1.getState());
        
        
        
        assertEquals(null,issue1.getClosedAt());
        
    }

}
