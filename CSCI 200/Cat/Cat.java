public class Cat
{
   private int weight;
   private String mood;
   private String name;
   
   public Cat()
   {
      weight = 0;
      mood = "QUIET";
   }

   public Cat(String t_name, int t_weight)
   {
      name = t_name;
      weight = t_weight;
      mood = "QUIET";
   }
   
   public Cat(int t_weight, String t_mood)
   {
      weight = t_weight;
      mood = t_mood;
   }
   
   public void Eat()
   {
      weight++;
   }
   
   public void Poop()
   {
      weight--;
   }
   
   public void Kick()
   {
      mood = "MEOW!";
   }
   
   public void Pet()
   {
      mood = "PURRR";
   }
   
   public int getWeight()
   {
      return weight;
   }
   
   public String getMood()
   {
      return mood;
   }
   
   public void setWeight(int t_weight)
   {
      weight = t_weight;
   }
   
   public void setMood(String t_mood)
   {
      mood = t_mood;
   }
   
   public String toString()
   {
      return "Your cat " + name + " weights " + weight + " pounds and current mood is " +
             mood + "."; 
   }
}