package com.automation.base;

import static java.util.stream.Collectors.*;
import java.util.*;

public class CharacterFrequencyStream {

    public static void main(String[] args) {
        System.out.println("aabbccdd".chars()
        	.mapToObj(c -> (char) c)
        	.collect(groupingBy(e -> e, LinkedHashMap::new, counting()))
        	.entrySet().stream()
        	.map(e -> "" + e.getKey() + e.getValue())
        	.collect(joining()));
        
    }
}