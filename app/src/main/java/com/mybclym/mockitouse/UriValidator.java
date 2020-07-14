package com.mybclym.mockitouse;

import android.content.Context;

import java.net.URI;

public class UriValidator {
    private final Context context;

    public UriValidator(Context context) {
        this.context = context;
    }

    public String validate(String uri) {
        int resID = R.string.nothing;
        if (isUrl(uri)) {
            resID = R.string.url;
        } else if (isFile(uri)) {
            resID = R.string.file;
        }
        return context.getString(resID);
    }

    private boolean isUrl(String uri) {
        return "http".equals(URI.create(uri).getScheme());
    }

    private boolean isFile(String uri) {
        return "file".equals(URI.create(uri).getScheme());
    }
}
