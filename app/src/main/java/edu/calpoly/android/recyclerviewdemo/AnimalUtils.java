package edu.calpoly.android.recyclerviewdemo;

import java.util.ArrayList;

public class AnimalUtils {

    public static class Animal {
        private String mName;
        private String mImageUrl;

        public Animal(String name, String imageUrl) {
            this.mName = name;
            this.mImageUrl = imageUrl;
        }

        public String getName() {
            return mName;
        }

        public String getImageUrl() {
            return mImageUrl;
        }
    }

    public static ArrayList<Animal> getAllTheAnimals() {
        ArrayList<Animal> animals = new ArrayList<>(ANIMALS.length);
        for (int i = 0; i < ANIMALS.length; i++) {
            animals.add(new Animal(ANIMALS[i], URLS[i]));
        }

        return animals;
    }

    private static String[] ANIMALS = {
            "pronghorn",
            "bunny",
            "dromedary",
            "fawn",
            "jackal",
            "guinea pig",
            "kitten",
            "rabbit",
            "ibex",
            "meerkat",
            "leopard",
            "blue crab",
            "starfish",
            "squirrel",
            "bison",
            "woodchuck",
            "ox",
            "grizzly bear",
            "chinchilla",
            "mynah bird",
            "polar bear",
            "vicuna",
            "mountain goat",
            "chipmunk",
            "buffalo",
            "ermine",
            "impala",
            "skunk",
            "goat",
            "okapi",
            "rooster",
            "walrus",
            "toad",
            "puma",
            "antelope",
            "parrot",
            "coati",
            "opossum",
            "parakeet",
            "doe",
            "ferret",
            "musk deer",
            "hamster",
            "bat",
            "basilisk",
            "ground hog",
            "fox",
            "gnu",
            "cow",
            "marten"};

    public static String[] URLS = {
            "https://www.randomlists.com/img/animals/pronghorn.jpg",
            "https://www.randomlists.com/img/animals/bunny.jpg",
            "https://www.randomlists.com/img/animals/dromedary.jpg",
            "https://www.randomlists.com/img/animals/fawn.jpg",
            "https://www.randomlists.com/img/animals/jackal.jpg",
            "https://www.randomlists.com/img/animals/guinea_pig.jpg",
            "https://www.randomlists.com/img/animals/kitten.jpg",
            "https://www.randomlists.com/img/animals/rabbit.jpg",
            "https://www.randomlists.com/img/animals/ibex.jpg",
            "https://www.randomlists.com/img/animals/meerkat.jpg",
            "https://www.randomlists.com/img/animals/leopard.jpg",
            "https://www.randomlists.com/img/animals/blue_crab.jpg",
            "https://www.randomlists.com/img/animals/starfish.jpg",
            "https://www.randomlists.com/img/animals/squirrel.jpg",
            "https://www.randomlists.com/img/animals/bison.jpg",
            "https://www.randomlists.com/img/animals/woodchuck.jpg",
            "https://www.randomlists.com/img/animals/ox.jpg",
            "https://www.randomlists.com/img/animals/grizzly_bear.jpg",
            "https://www.randomlists.com/img/animals/chinchilla.jpg",
            "https://www.randomlists.com/img/animals/mynah_bird.jpg",
            "https://www.randomlists.com/img/animals/polar_bear.jpg",
            "https://www.randomlists.com/img/animals/vicuna.jpg",
            "https://www.randomlists.com/img/animals/mountain_goat.jpg",
            "https://www.randomlists.com/img/animals/chipmunk.jpg",
            "https://www.randomlists.com/img/animals/buffalo.jpg",
            "https://www.randomlists.com/img/animals/ermine.jpg",
            "https://www.randomlists.com/img/animals/impala.jpg",
            "https://www.randomlists.com/img/animals/skunk.jpg",
            "https://www.randomlists.com/img/animals/goat.jpg",
            "https://www.randomlists.com/img/animals/okapi.jpg",
            "https://www.randomlists.com/img/animals/rooster.jpg",
            "https://www.randomlists.com/img/animals/walrus.jpg",
            "https://www.randomlists.com/img/animals/toad.jpg",
            "https://www.randomlists.com/img/animals/puma.jpg",
            "https://www.randomlists.com/img/animals/antelope.jpg",
            "https://www.randomlists.com/img/animals/parrot.jpg",
            "https://www.randomlists.com/img/animals/coati.jpg",
            "https://www.randomlists.com/img/animals/opossum.jpg",
            "https://www.randomlists.com/img/animals/parakeet.jpg",
            "https://www.randomlists.com/img/animals/doe.jpg",
            "https://www.randomlists.com/img/animals/ferret.jpg",
            "https://www.randomlists.com/img/animals/musk_deer.jpg",
            "https://www.randomlists.com/img/animals/hamster.jpg",
            "https://www.randomlists.com/img/animals/bat.jpg",
            "https://www.randomlists.com/img/animals/basilisk.jpg",
            "https://www.randomlists.com/img/animals/ground_hog.jpg",
            "https://www.randomlists.com/img/animals/fox.jpg",
            "https://www.randomlists.com/img/animals/gnu.jpg",
            "https://www.randomlists.com/img/animals/cow.jpg",
            "https://www.randomlists.com/img/animals/marten.jpg"};


}
