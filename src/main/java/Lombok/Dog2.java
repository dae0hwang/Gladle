package Lombok;

import lombok.Builder;

@Builder

public class Dog2 {
    private int weight;
    private int height;
    private String color;

    Dog2(int weight, int height, String color) {
        this.weight = weight;
        this.height = height;
        this.color = color;
    }

    public static Dog2Builder builder() {
        return new Dog2Builder();
    }


    public static class Dog2Builder {

        private int weight;
        private int height;
        private String color;

        Dog2Builder() {
        }

        public Dog2Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Dog2Builder height(int height) {
            this.height = height;
            return this;
        }

        public Dog2Builder color(String color) {
            this.color = color;
            return this;
        }

        public Dog2 build() {
            return new Dog2(this.weight, this.height, this.color);

        }

        public String toString() {
            return "Dog2.Dog2Builder(weight=" + this.weight + ", height=" + this.height + ", color=" + this.color + ")";
        }

        public void hey() {
            System.out.println("aa ");
        }

    }



}
