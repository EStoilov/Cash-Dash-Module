package com.example.fib.cashdashmodule;

import com.fib.cashdashmodule.CashDashModuleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest(classes = CashDashModuleApplication.class)
class CashDashModuleApplicationTests {

	@Test
	public void testWithdrawal() {
		given()
				.port(port)
				.header("FIB-X-AUTH", "f9Uie8nNf112hx8s")
				.contentType("application/json")
				.body("{\"amount\":100,\"currency\":\"BGN\"}")
				.when()
				.post("/api/v1/cash-operation")
				.then()
				.statusCode(200)
				.body("message", equalTo("Withdrawal successful"));
	}

	@Test
	public void testDeposit() {
		given()
				.port(port)
				.header("FIB-X-AUTH", "f9Uie8nNf112hx8s")
				.contentType("application/json")
				.body("{\"amount\":200,\"currency\":\"EUR\"}")
				.when()
				.post("/api/v1/cash-operation")
				.then()
				.statusCode(200)
				.body("message", equalTo("Deposit successful"));
	}

	@Test
	public void testCheckBalance() {
		given()
				.port(port)
				.header("FIB-X-AUTH", "f9Uie8nNf112hx8s")
				.when()
				.get("/api/v1/cash-balance")
				.then()
				.statusCode(200)
				.body("BGN", equalTo(800))
				.body("EUR", equalTo(2200));
	}

}
