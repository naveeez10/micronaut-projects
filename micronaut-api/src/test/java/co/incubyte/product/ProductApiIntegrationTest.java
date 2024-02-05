package co.incubyte.product;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;

import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.inject.Inject;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MicronautTest
public class ProductApiIntegrationTest {

  String base;

  @Inject EmbeddedServer server;

  public static final Logger logger = LoggerFactory.getLogger(ProductApiIntegrationTest.class);

  @BeforeEach
  void setUp() {
    base = server.getURI().toString();
  }

  @Test
  public void saveProduct() {
    String id = postProduct();
    String actualId = getProduct();

    assertThat(actualId).isEqualTo(id);
  }

  public String getProduct() {

    return RestAssured.get(base + "/product/all").then().log().all().extract().path("[0].id");
  }

  public static Matcher<String> isDateWithinLast30Seconds() {

    return new TypeSafeMatcher<>() {
      public boolean matchesSafely(String dateTime) {
        DateTimeFormatter isoFormat = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        OffsetDateTime createdAt = isoFormat.parse(dateTime, OffsetDateTime::from);
        logger.info("createdAt: " + createdAt);
        OffsetDateTime now = OffsetDateTime.now();
        return createdAt.isAfter(now.minusSeconds(2));
      }

      public void describeTo(Description description) {
        description.appendText("a date within the last 30 seconds");
      }
    };
  }

  private String postProduct() {
    String name = "manish bhai";
    return RestAssured.given()
        .when()
        .contentType(ContentType.JSON)
        .body(
            """
                    {
                        "name": "$name"
                    }

            """
                .replace("$name", name))
        .post(base + "/product")
        .then()
        .log()
        .all()
        .body("id", not(blankOrNullString()))
        .body("name", is(name))
        .body("createdAt", isDateWithinLast30Seconds())
        .body("updatedAt", not(blankOrNullString()))
        .extract()
        .body()
        .path("id");
  }

  @AfterEach
  void tearDown() {}
}
