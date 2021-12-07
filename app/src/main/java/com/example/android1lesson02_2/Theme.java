package com.example.android1lesson02_2;

import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;

public enum Theme {
    ONE(R.style.Theme_Android1Lesson022, R.string.theme_one, "one"),
    TWO(R.style.Theme_Android1Lesson022_Second, R.string.theme_two, "two"),
    THREE(R.style.Theme_Android1Lesson022_Third, R.string.theme_three, "there"),
    FOUR(R.style.Theme_Android1Lesson022_Fourth, R.string.theme_four, "four");

    @StyleRes
    private int theme;
    @StringRes
    private int name;

    private String key;

    Theme(int theme, int name, String key) {
        this.theme = theme;
        this.name = name;
        this.key = key;
    }

    public int getTheme() {
        return theme;
    }

    public int getName() {
        return name;
    }

    public String getKey() {
        return key;
    }
}
