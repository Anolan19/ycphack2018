package com.example.a.ycphack2018;

import android.media.Image;

import java.lang.reflect.Array;

enum school {susky, york, umd}
enum tag {webdev, business, science, SRE, HCI}

public class account {
    private String name;
    private int[] rating;
    private String desc;
    private Array listings;
    private Array listings_past;
    private boolean is_on_team;
    private Image profilepic;
    private school user_school;
    private tag user_tag;
}
