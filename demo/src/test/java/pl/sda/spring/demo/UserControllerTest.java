package pl.sda.spring.demo;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = DemoApplication.class)
public class UserControllerTest {

    @LocalServerPort
    int localPort;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void shouldRetrieveUserData() {
        //given
        final Long id = 1l;
        final String expectedUsername = "Michał";
        final int expectedAge = 30;

        //when
        ResponseEntity<User> serviceResponse = this.testRestTemplate.getForEntity(
                "http://localhost:" + localPort + "/users/" + id,
                User.class);

        //then
        User user = serviceResponse.getBody();
        Assert.assertEquals(expectedUsername, user.getName());
        Assert.assertEquals(expectedAge, user.getAge());
    }

    @Test
    public void shouldAddUserData() {
        //given
        final String testUserName = "Joanna";
        final int testUserAge = 29;
        final Long expectedId = 4l;

        final User testUser = new User();
        testUser.setName(testUserName);
        testUser.setAge(testUserAge);

        //when
        ResponseEntity<User> responseEntity =
                this.testRestTemplate.postForEntity("http://localhost:" + localPort + "/users",
                testUser, User.class);

        //then
        User user = responseEntity.getBody();
        Assert.assertEquals(testUserName, user.getName());
        Assert.assertEquals(testUserAge, user.getAge());
        Assert.assertEquals(expectedId, user.getId());
    }
}
