package com.mybclym.mockitouse;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UriValidatorTest {

    UriValidator mValidator;
    Context mockContext;

    @Before
    public void setUp() throws Exception {
        mockContext = Mockito.mock(Context.class);
        mValidator = new UriValidator(mockContext);
    }

    @Test
    public void validate() throws Exception {
        System.out.println("context get string url = " + mockContext.getString(R.string.url));
        System.out.println("context get string file = " + mockContext.getString(R.string.file));
        System.out.println("context get string nothing = " + mockContext.getString(R.string.nothing));
    }

}