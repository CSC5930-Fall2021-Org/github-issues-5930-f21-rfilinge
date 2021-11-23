package edu.studio.issue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IssueTest {

    @Test
    void testProperties() {
        Issue issue = new Issue();
        issue.setId(99);
        assertEquals(99,issue.getId());
    }
}
