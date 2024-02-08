package hw1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Lottery lottery = new Lottery();
        initToys(lottery);
        //TODO добавить количество игрушек

//        start(lottery);


        boolean continueLoop = true;
        while (lottery.getToysListSize() != 0 && continueLoop){
            System.out.println("""
                    1 - Испытать удачу
                    2 - Посмтреть вероятность выпадения игрушек
                    3 - Добавить игрушку
                    4 - Выйти
                    """);
            try {
                Scanner sc = new Scanner(System.in);
                switch (sc.nextLine()) {
                    case "1" -> start(lottery);
                    case "2" -> chancePrinter(lottery);
                    case "3" -> addToy(lottery);
                    case "4" -> {
                        System.out.println("До вскорой встречи, друг!");
                        continueLoop = false;
                    }
                }
            }catch (InputMismatchException e) {
                System.out.println("Некорректная команда.");
            } catch (NoSuchElementException ex) {
                System.out.println("Вы ничего не ввели!");
            }
        }
    }

    private static void chancePrinter(Lottery lottery) {
        System.out.println("Вероятность выпадения игрушек: ");
        lottery.updateOverallRate().forEach(System.out::println);
    }

    private static void initToys(Lottery lottery) {
        lottery.addToy(new Toy(1, 2, "Blue tractor"));
        lottery.addToy(new Toy(2, 2, "Barbie"));
        lottery.addToy(new Toy(3, 6, "Doctor's kit"));
        System.out.println("По умолчанию добавлены игрушки: Blue tractor, Barbie, Doctor's kit.");
    }

    private static void addToy(Lottery lottery) {
        try  {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите id: ");
            int id = scanner.nextInt();
            System.out.println("Введите количество игрушек: ");
            double rate = scanner.nextDouble();
            System.out.println("Введите название игрушки: ");
            String name = scanner.nextLine();
            lottery.addToy(new Toy(id, rate, name));
            System.out.println("Игрушка добавлена!");

        } catch (InputMismatchException e) {
            System.out.println("Некорректная команда.");
        } catch (NoSuchElementException ex) {
            System.out.println("Вы ничего не ввели!");
        }
    }

    private static void start(Lottery lottery) {
        if (lottery.getToysListSize() == 0){
            System.out.println("Упс! Игрушки закончились.");
        }else System.out.println("Вы выиграли: " + lottery.getToy());
    }

}