package streamsbrownbag.operations;
import java.util.Optional;
import streamsbrownbag.model.Dish;

import static streamsbrownbag.model.Dish.menu;

public class Finding{

    public static void main(String...args){
        if(isVegetarianFriendlyMenu()){
            System.out.println("--- Vegetarian friendly ---");
        }

        System.out.println("Is Healthy? "+isHealthyMenu());
        System.out.println("Is Too Healthy? "+isHealthyMenu2());
        
        System.out.print("A Vegetarian Dish -> ");
        Optional<Dish> dish = findVegetarianDish();
        dish.ifPresent(d -> System.out.println(d.getName()));
    }
    
    private static boolean isVegetarianFriendlyMenu(){
        return menu.stream().anyMatch(Dish::isVegetarian);
    }
    
    private static boolean isHealthyMenu(){
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }
    
    private static boolean isHealthyMenu2(){
        return menu.stream().noneMatch(d -> d.getCalories() >= 500);
    }
    
    private static Optional<Dish> findVegetarianDish(){
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }
    
}
