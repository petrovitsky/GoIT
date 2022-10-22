package module6.hero;

public class Hero {
    private String name;
    private int hp;

    public Hero (){
        this("Paratrooper",100);
    }

    public Hero(String name, int hp) {
        if (hp > 200 ){
            this.hp = 200;
        } else if ( hp < 0) {
            this.hp = 0;
        } else  {
            this.hp = hp;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }
}

class HeroTest {
    public static void main(String[] args) {
        Hero hero = new Hero("Stranger", -1);

        //Expect Stranger
        System.out.println(hero.getName());

        //Expect 50
        System.out.println(hero.getHp());
    }
}
