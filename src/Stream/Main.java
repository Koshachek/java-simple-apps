package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = getAnimals();

        // Старый подход (Императивный - слишком подробно объеясняем программе, что мы хотим от нее)

        /* List<Animal> predators = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getClassification().equals(Classification.PREDATOR)) {
                predators.add(animal);
            }
        }
        predators.forEach(System.out::println); */

        // Новый подход (Декларативный - мы не говорим как работать, мы говорим какой результат желаем получить)

        // Filter
        List<Animal> predators = animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.PREDATOR))
                .collect(Collectors.toList());
        predators.forEach(System.out::println);
        System.out.println("---------------------------------------");

        // Sort
        List<Animal> sorted = animals.stream()
                .sorted(Comparator.comparing(Animal::getAge) // сортируем по возрасту
                        .thenComparing(Animal::getClassification) // а еще по классификации
                        .reversed()) // и выводим в обратном порядке
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
        System.out.println("---------------------------------------");

        // All match
        boolean allMatch = animals.stream()
                .allMatch(animal -> animal.getAge() > 10); // если все наши звери старше 10 лет
        System.out.println(allMatch);
        System.out.println("---------------------------------------");

        // Any match
        boolean anyMatch = animals.stream()
                .anyMatch(animal -> animal.getAge() > 10); // если кто-то старше 10 лет
        System.out.println(anyMatch);
        System.out.println("---------------------------------------");

        // None match
        boolean noneMatch = animals.stream()
                .noneMatch(animal -> animal.getName().equals("Медведь")); // если нет медведя вернется true
        System.out.println(noneMatch);
        System.out.println("---------------------------------------");

        // Max
        animals.stream()
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent((System.out::println)); // самое старое животное
        System.out.println("---------------------------------------");

        // Min
        animals.stream()
                .min(Comparator.comparing(Animal::getAge))
                .ifPresent((System.out::println)); // самое молодое животное
        System.out.println("---------------------------------------");

        // Group - выведем животных разбитых на группы
        Map<Classification, List<Animal>> classificationListMap = animals.stream()
                .collect(Collectors.groupingBy(Animal::getClassification));
        classificationListMap.forEach((classification, animals1) -> {
            System.out.println(classification); // выводит группы
            animals1.forEach(System.out::println); // и самих животных
            System.out.println();
        });
        System.out.println("---------------------------------------");

        // а теперь сделаем комбо из этих функций: выведем самое старое хищное животное
        Optional<String> oldestPredatorAge = animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.PREDATOR))
                .max(Comparator.comparing(Animal::getAge))
                .map(Animal::getName);
        oldestPredatorAge.ifPresent(System.out::println);

    }

    private static List<Animal> getAnimals() {
        return Arrays.asList(
                new Animal("Слон", 20, Classification.HERBIVORE),
                new Animal("Лев", 10, Classification.PREDATOR),
                new Animal("Гиена", 11, Classification.PREDATOR),
                new Animal("Жираф", 7, Classification.HERBIVORE),
                new Animal("Гибон", 35, Classification.OMNIVOROUS),
                new Animal("Лошадь", 36, Classification.HERBIVORE),
                new Animal("Рысь", 2, Classification.PREDATOR),
                new Animal("Динозавр", 200, Classification.PREDATOR)
        );
    }
}
