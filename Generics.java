
import java.time.LocalDate;
import java.util.*;

public class Generics<T>{
    private T[] objs; // can't create an array of generic types.
    private T t;

    public Generics(){

    }

    public Generics(T t){
        this.t = t;
    }

    public T getObject(){
        return this.t;
    }

    // The generic defined at method level is different from the one defined at class level
    public <U> boolean compareHashCode(U u){
        return u.hashCode() == this.t.hashCode();
    }

    // Print list of objects (any object type can fit) using wildcard
    public void printList(List<?> list){
        for(Object o: list)
            System.out.println(o);
    }

    // Print list of objects (that inherit Number); eg. ArrayList<Integer> or ArrayList<Double>
    public void printUpperBoundedList(List<? extends Number> list){
        for(Number n: list){
            System.out.println(n);
        }
    }

    // Print list of objects (that are parent of String); eg. ArrayList<CharSequence> 
    public void printLowerBoundedList(List<? super String> list){
        for(Object str: list){
            System.out.println(str);
        }
    }

    public static void main(String... args){
        Generics<StringBuilder> gen = new Generics<>(new StringBuilder("Constant"));
        String str = "Constant";
        System.out.println("Hashcode comparison: "+gen.compareHashCode(str));

        List<Float> floatList = List.of(1.2f, 3.1f, 3.4f, 5.2f, 5.7f, 4.5f);
        List<Integer> intList = Arrays.asList(3,4,5,6,2,5,67,8,7);
        List<String> strList = List.of("Florent","Olivier", "Patrick", "Nelson", "David", "Jean", "Peter");
        List<CharSequence> chrSeqList = List.of(new StringBuilder("Lelag"), 
                        new StringBuilder("Lapatte"), new StringBuffer("Kevin"), "Constant");
        gen.printList(chrSeqList);
        gen.printList(floatList);
        gen.printLowerBoundedList(chrSeqList);
        gen.printUpperBoundedList(intList);

    }

}


class User{
    private String fullname;
    private String username;
    private LocalDate dateJoined;
    private LocalDate DOB;
    private String phoneNumber;

    public User(String fullname, String username, LocalDate dateJoined, LocalDate DOB, String phoneNumber){
        this.fullname = fullname;
        this.username = username;
        this.dateJoined = dateJoined;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
    }
    
    public User(){}

}
interface Behavable<B>{
    public boolean isBehaving(B being);
}

