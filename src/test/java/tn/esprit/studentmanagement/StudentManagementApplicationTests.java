package tn.esprit.studentmanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // This tells Spring to use application-test.properties
class StudentManagementApplicationTests {

    @Test
    void contextLoads() {
        // This test will now use H2 database instead of MySQL
        // No changes needed to the test itself!
    }

}