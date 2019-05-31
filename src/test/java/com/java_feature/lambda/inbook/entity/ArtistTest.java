package com.java_feature.lambda.inbook.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {
    @Test
    void testArtist() {
        Artist artist = new Artist("1", "2", "3");
        System.out.println(artist.getMembers());
        System.out.println(artist);
    }

    @Test
    void test() {
        assertEquals(2, 1 + 1);
        System.out.println("ok");
    }
}