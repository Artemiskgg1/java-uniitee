// Why Annotations?
// - used to provide metadata for Java code.
// - do not change the actions of a compiled program. 
// - used by the compiler to detect errors or suppress warnings. 
// - used by the compiler to generate code, XML files, etc.

import java.lang.annotation.*;

// @Override Annotation ----------------------------------------------------------------------
// used to indicate that a method is overriding a method in the superclass.
// If a method marked with @Override fails to correctly override a method in one of its superclasses, the compiler generates an error.

// class A{
//     public void f(){
//         System.out.println("A.f()");
//     }
// }
// class B extends A{
//     @Override // Annotation to indicate that the method is overriding a method in the superclass
//     public void f(){
//         System.out.println("B.f()");
//     }
// }
// public class Main_Annot_01{
//     public static void main(String[] args){
//         B b = new B();
//         b.f();
//     }
// }

// @Deprecated Annotation ----------------------------------------------------------------------
// to indicate that a method is deprecated (still usable, but not recommended because they are outdated/unsafe.)
// If a method marked with @Deprecated is used, the compiler generates a warning.

// class A{
//     @Deprecated 
//     public void f(){
//         System.out.println("A.f()");
//     }
// }
// public class Main_Annot_01{
//     public static void main(String[] args){
//         A a = new A();
//         a.f();
//     }
// }

// @SuppressWarnings Annotation ----------------------------------------------------------------------
// used to suppress warnings generated by the compiler.
// eg. about unchecked operations, deprecation, and other warnings.

// class A{
//     public void f(){
//         System.out.println("A.f()");
//     }
// }
// public class Main_Annot_01{
//     public static void main(String[] args){
//         @SuppressWarnings("unused")
//         A a = new A();
//     }
// }

// Own Annotation ----------------------------------------------------------------------
// Class -> public class ClassName{};
// Interface -> public interface InterfaceName{};
// Annotation -> public @interface AnnotationName{};    

@Target({ElementType.TYPE,ElementType.METHOD}) // which java element the annotation can be used
@Retention(RetentionPolicy.RUNTIME) // how long the annotation is retained
@interface VeryImportant{
    String value() default "This is very important";
}
@VeryImportant()
class A{
    @VeryImportant
    public void f(){
        System.out.println("A.f()");
    }
    public void g(){
        System.out.println("A.g()");
    }
}
public class Main_Annot_01{
    public static void main(String[] args){
        A a = new A();
        VeryImportant annotation = a.getClass().getAnnotation(VeryImportant.class);
        if (annotation != null) {
            System.out.println(annotation.value());
        } else {
            System.out.println("No annotation found");
        }
    }
}

// RetentionPolicy.SOURCE: Discarded during compilation
// RetentionPolicy.CLASS: Stored in class file but not available at runtime (default)
// RetentionPolicy.RUNTIME: Available at runtime through reflection