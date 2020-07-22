package com.example.demo;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DemoApplicationTests {

	@Test
	void testHangingFeatureWithScenarioOutline() {

		String path = "src/test/resources";
		File testResourceFile = new File(path);
		String testResourcesAbsolutePath = testResourceFile.getAbsolutePath();

		Results results = Runner.path(testResourcesAbsolutePath + "/input/main-feature.feature").parallel(5);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());

	}

	@Test
	void testHangingFeature() {

		String path = "src/test/resources";
		File testResourceFile = new File(path);
		String testResourcesAbsolutePath = testResourceFile.getAbsolutePath();

		Results results = Runner.path(testResourcesAbsolutePath + "/input/main-feature-no-outline.feature").parallel(5);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());

	}

	@Test
	void testHangingFeature_WithSuccessKarateTest() {

		String path = "src/test/resources";
		File testResourceFile = new File(path);
		String testResourcesAbsolutePath = testResourceFile.getAbsolutePath();

		Results results = Runner.path(testResourcesAbsolutePath + "/input/main-feature-success-karate-test.feature").parallel(5);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());

	}

	@Test
	void testNotHangingFeature_ReferenceToFreemarkerCleanedBeforeCall() {

		String path = "src/test/resources";
		File testResourceFile = new File(path);
		String testResourcesAbsolutePath = testResourceFile.getAbsolutePath();

		Results results = Runner.path(testResourcesAbsolutePath + "/input/main-feature-cleaning-ref-before-call.feature").parallel(5);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

	@Test
	void testNotHangingFeature_ReferenceToFreemarkerCleanedAfterCall() {

		String path = "src/test/resources";
		File testResourceFile = new File(path);
		String testResourcesAbsolutePath = testResourceFile.getAbsolutePath();

		Results results = Runner.path(testResourcesAbsolutePath + "/input/main-feature-cleaning-ref-after-call.feature").parallel(5);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

	@Test
	void testNotHangingFeature_ParamOfCallToOtherFeatureDoesNotIncludeFreemarkerVariable() {

		String path = "src/test/resources";
		File testResourceFile = new File(path);
		String testResourcesAbsolutePath = testResourceFile.getAbsolutePath();

		Results results = Runner.path(testResourcesAbsolutePath + "/input/main-feature-call-other-no-ref.feature").parallel(5);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}
}
