//package geekbrains.oop;

public class Main {

    public static void main(String[] args) {
        Cat[] cat = new Cat[10];
        for (int i = 0; i < cat.length; i++) {
            cat[i] = new Cat("Kotik-" + (i + 1));
        }

        Plate plate = new Plate(-100);

        for(Cat cat_ : cat){
            cat_.eat(plate);
            System.out.println(cat_);
            System.out.println(plate);
        }

        System.out.println("------------------------------------------------------------------------");

        plate.addFood(40);

        for(Cat cat_ : cat){
            cat_.eat(plate);
            System.out.println(cat_);
            System.out.println(plate);
        }
    }
}

        class Cat {
            private String name;
            private int appetite = (int)(Math.random() * 26);
            private boolean is_satiety = false;

            Cat(String name) {
                this.name = name;
            }

            int getAppetite() {
                return appetite;
            }

            public boolean isIs_satiety() {
                return is_satiety;
            }

            void eat(Plate plate) {
                if(!isIs_satiety()) {
                    if (plate.decreaseFood(appetite)) {
                        this.is_satiety = true;
                    } else {
                        this.is_satiety = false;
                    }
                }
            }

            @Override
            public String toString(){
                return name + " appetit: " + appetite +  ", satiety - " + is_satiety;
            }
        }

        class Plate {
            private int food;

            Plate(int food) {
                if(food >= 0) {
                    this.food = food;
                } else {
                    System.out.println("The plate cannot be <0.");
                }
            }

            void addFood(int x){
                if(x > 0) {
                    food += x;
                }
            }

            boolean decreaseFood(int food) {
                if(this.food >= food) {
                    this.food -= food;
                    return true;

                } else {
                    return false;
                }
            }

            int getFood() {
                return food;
            }

            void setFood(int food) {
                this.food = food;
            }

            @Override
            public String toString() {
                return "Food: " + food;
            }
        }



