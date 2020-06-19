// Shivangi Khanna

// LetterInventory is used to maintain a count of how many of each alphabetic letters are in a string. It 
// is not case sensitive.
public class LetterInventory{
   private int[] elementData;
   private int size;
   
   // Declaring the class constant
   public static final int DEFAULT_CAPACITY = 26;
   
   // Post: Contructs an inventory of the alphabetic letters in a given string. It ignores the case of 
   //       the letter and ignores the non-alphabetic charcaters in the string.
   public LetterInventory(String data) {
      elementData = new int[DEFAULT_CAPACITY];
      size = 0;
      data = data.toLowerCase();
      for(int i = 0; i < data.length(); i++) {
         if(Character.isLetter(data.charAt(i))) {
            elementData[data.charAt(i) - 'a']++;
            size++;
         }
      }
   }
   
   // Post: Returns the number of alphabetic characters in the string. 
   public int size() {
      return size;
   }
   
   // Post: Checks if the inventory is empty.
   public boolean isEmpty() {
      return size == 0;
   }
   
   // Pre: Throws an IllegalArgumentException when the character entered is nonalphabetic.
   // Post: Returns the count of how many of this letter are in the inventory, while ignoring the case. 
   public int get(char letter) {
      if(!Character.isLetter(letter)) {
         throw new IllegalArgumentException();
      }
      return elementData[Character.toLowerCase(letter) - 'a'];
   }
   
   // Post: Returns a string representation of the all the alphabetic letters in the given string in 
   //       lowercase and in a sorted order, surrounded by square brackets.
   public String toString() {
      String result = "[";
      for(int i = 0; i < DEFAULT_CAPACITY; i++) {
         for(int j = 0; j < elementData[i]; j++) {
            result = result + (char)(i + 'a');
         }
      }
      return result + "]";
   }
   
   // Pre: Throws IllegalArgumentException if the letter entered if nonalphabetic or if the value 
   //      is less than 0.
   // Post: Sets the count for the given letter to be the given value in the inventory.
   public void set(char letter, int value) {
      if(!Character.isLetter(letter) || value < 0) {
         throw new IllegalArgumentException();
      }
      size = size - elementData[Character.toLowerCase(letter) - 'a'];
      elementData[Character.toLowerCase(letter) - 'a'] = value;
      size = size + value;
   }
   
   // Pre: Takes a letter inventory 'other' as a parameter. 
   // Post: Returns a new Letter Inventory which consists of the sum of the counts of each letter in the 
   //       two inventories, current and other. 
   public LetterInventory add(LetterInventory other) {
      LetterInventory newInvent = new LetterInventory("");
      for(int i = 0; i < DEFAULT_CAPACITY; i++) {
         newInvent.elementData[i] = elementData[i] + other.elementData[i];
      }
      newInvent.size = size + other.size;
      return newInvent;
   }
   
  // Pre: Takes a letter inventory 'other' as a parameter. 
  // Post: Returns a new Letter Inventory which consists of the difference of the counts of each letter in the 
  //       two inventories, current and other. It is null if the difference is negative.
   public LetterInventory subtract(LetterInventory other) {
      LetterInventory newInvent = new LetterInventory("");
      for(int i = 0; i < DEFAULT_CAPACITY; i++) {
         newInvent.elementData[i] = elementData[i] - other.elementData[i];
         if(newInvent.elementData[i] < 0) {
            return null;
         }
         newInvent.size = newInvent.size + newInvent.elementData[i];
      }      
      return newInvent;
   }  
}