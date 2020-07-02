package competition;


public class Competition {

    public static void main(String[] args) {
        System.out.println("Соревнование начинается");

        Move[] competitors = {
                new Cat("Мурзик", 5, 12),
                new Cat("Рыжик>", 1, 19),
                new Human("Кирилл", 3, 17),
                new Human("Сергей", 2, 23),
                new Robot("R2-D2", 5,18),
                new Robot("Wall-e", 2, 27),
        };

        Obstruction[] obstructions = {
                new Wall(1),
                new Tread(10),
                new Wall(2),
                new Tread(15),
                new Wall(3),
                new Tread(20),
        };

        for (Move competitor : competitors) {
            for (int i = 0; i < obstructions.length; i++) {
                if (obstructions[i] instanceof Wall) {
                    competitor.jump((Wall) obstructions[i]);
                    if (competitor.jump((Wall) obstructions[i])) {
                        System.out.println(competitor + " сумел перепрыгнуть");
                    } else {
                        competitor.setDroppedOut(true);
                    }
                } else if (obstructions[i] instanceof Tread) {
                    competitor.run((Tread) obstructions[i]);
                    if (competitor.run((Tread) obstructions[i])) {
                        System.out.println(competitor + " сумел пробежать");
                    } else {
                        break;
                    }
                } else {
                    if (competitor.overcome(obstructions[i])) {
                        System.out.println(competitor + " выбыл");
                    } else {
                        break;
                    }
                }
            }
        }


        for (int i = 0; i < obstructions.length; i++) {
            for (Move competitor : competitors) {
                if (competitor.isDroppedOut()) {
                    continue;
                }

                if (obstructions[i] instanceof Wall) {
                    competitor.jump((Wall) obstructions[i]);
                    if (competitor.jump((Wall) obstructions[i])) {
                        System.out.println(competitor + " сумел перепрыгнуть");
                    } else {
                        competitor.setDroppedOut(true);
                    }
                } else if (obstructions[i] instanceof Tread) {
                    if (competitor.run((Tread) obstructions[i])) {
                        System.out.println(competitor + " сумел пробежать");
                    } else {
                        competitor.setDroppedOut(true);
                    }
                } else {
                    if (competitor.overcome(obstructions[i])) {
                        System.out.println(competitor + " выбыл");
                    } else {
                        competitor.setDroppedOut(true);{
                        }
                    }
                }
            }
        } System.out.println("Соревнование завершено");
    }
}