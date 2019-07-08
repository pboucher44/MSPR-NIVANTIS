package org.ss.nivantis.nivantisapirest.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.ss.nivantis.nivantisapirest.dao.QuestionRepository;
import org.ss.nivantis.nivantisapirest.model.Achat;
import org.ss.nivantis.nivantisapirest.model.DMO;
import org.ss.nivantis.nivantisapirest.model.Question;
import org.ss.nivantis.nivantisapirest.model.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuestionControllerTest {

    private QuestionController questionControllerUnderTest;

    @Before
    public void setUp() {
        questionControllerUnderTest = new QuestionController();
        questionControllerUnderTest.questionRepository = mock(QuestionRepository.class);
    }

    @Test
    public void testGetQuestion() {
        // Setup
        final long Id = 0L;
        final List<Question> expectedResult = Arrays.asList();
        when(questionControllerUnderTest.questionRepository.findAllByIdDmo(0L)).thenReturn(Arrays.asList());

        // Run the test
        final List<Question> result = questionControllerUnderTest.getQuestion(Id);

        // Verify the results
        assertEquals(expectedResult, result);
    }

    @Test
    public void testGetQuestion1() {
        // Setup
        final Iterable<Question> expectedResult = null;
        when(questionControllerUnderTest.questionRepository.findAll()).thenReturn(null);

        // Run the test
        final Iterable<Question> result = questionControllerUnderTest.getQuestion();

        // Verify the results
        assertEquals(expectedResult, result);
    }
}
