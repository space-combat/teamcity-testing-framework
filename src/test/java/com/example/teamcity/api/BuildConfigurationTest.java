package com.example.teamcity.api;

import com.example.teamcity.api.models.User;
import com.example.teamcity.api.spec.Specifications;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class BuildConfigurationTest extends BaseApiTest {
    @Test
    public void buildConfigurationTest() {
        var user = User.builder()
                .username("admin1")
                .password("admin1")
                .build();
        var token = RestAssured
                .given()
                .spec(Specifications.getSpec().authSpec(user))
                .get("/authenticationTest.html?crsf")
                .then().assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString();
        System.out.println(token);

//        GET http://{{user}}:{{password}}@{{host}}:8111/app/rest/projects/
//        Accept: application/json
//        @host = 192.168.2.25
//        @user= admin1
//        @password = admin1
    }
}
