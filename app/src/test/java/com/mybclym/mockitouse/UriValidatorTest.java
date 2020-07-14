package com.mybclym.mockitouse;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UriValidatorTest {
    public static final String NOTHING = "Nothing";
    public static final String URL = "URL";
    public static final String FILE = "File";

    UriValidator mValidator;
    Context mockContext;

    @Before
    public void setUp() throws Exception {
        mockContext = Mockito.mock(Context.class);
        Mockito.when(mockContext.getString(R.string.nothing)).thenReturn(NOTHING);
        Mockito.when(mockContext.getString(R.string.url)).thenReturn(URL);
        Mockito.when(mockContext.getString(R.string.file)).thenReturn(FILE);
        mValidator = new UriValidator(mockContext);
    }

    @Test
    public void validate() throws Exception {
        assertThat(mValidator.validate("http://google.com"), is(URL));
        assertThat(mValidator.validate("file://sdcard/DCIM/img001.jpg"), is(FILE));
        assertThat(mValidator.validate("bla-bla-bla"), is(NOTHING));
    }

}