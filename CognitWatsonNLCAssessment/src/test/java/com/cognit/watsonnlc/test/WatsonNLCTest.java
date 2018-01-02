package com.cognit.watsonnlc.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.cognit.watsonnlc.constants.NLCServiceConstants;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;

public class WatsonNLCTest {

	/** The service. */
	private NaturalLanguageClassifier naturalLanguageClassifier;

	@Before
	public void setUp() throws Exception {
		naturalLanguageClassifier = new NaturalLanguageClassifier();
		naturalLanguageClassifier.setUsernameAndPassword(NLCServiceConstants.USER_NAME, NLCServiceConstants.PASSWORD);

	}

	/**
	 * Test classify function of natural language classifier service by using the pre created trained classifier 
	 *
	 * @throws Exception
	 */
	@Test
	public void validClassifierShoulBeReturned() throws Exception {
		Classification classification = naturalLanguageClassifier
				.classify(NLCServiceConstants.CLASSIFIER_ID, "which emirate is the capital of UAE?").execute();
		assertNotNull(classification);
		assertNotNull(classification.getTopClass());
		assertEquals(classification.getTopClass(), "Abu Dhabi");

	}
}
