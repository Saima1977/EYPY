package com.ezypay.test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomeControllerTest {

  private HomeController homeControllerUnderTest;

  @BeforeEach
  void setUp() {
    homeControllerUnderTest = new HomeController();
  }

  @Test
  void testHome() {
    // Setup

    // Run the test
    final String result = homeControllerUnderTest.home();

    // Verify the results
    assertEquals("result", result);
  }
}
