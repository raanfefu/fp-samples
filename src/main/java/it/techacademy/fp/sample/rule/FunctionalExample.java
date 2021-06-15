package it.techacademy.fp.sample.rule;

public class FunctionalExample {


    public static void main(String[] args) {



        Rule<String, String> rule = Rule.<String, String>get("")
                                        .addRule( s -> s.startsWith("A"), i -> "10")
                                        .and( s -> s.endsWith("C"), d-> Rule.<String, String>get(d)
                                                                            .addRule( s -> s.length() == 2, i -> i+"X"))  ;

        System.out.println(rule.apply("AaaC"));


    }

}


