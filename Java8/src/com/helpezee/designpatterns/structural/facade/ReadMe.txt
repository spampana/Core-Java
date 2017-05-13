Facade Design Pattern
---------------------

Provide a unified interface to a set of interfaces in a subsystem. 

Facade Pattern defines a higher-level interface that makes the subsystem easier to use.

Facade design pattern is used to help client applications to easily interact with the system.



Facade Design Pattern Important Points
-------------------------------------
Facade design pattern is more like a helper for client applications, it doesn’t hide subsystem interfaces from the client. 
Whether to use Facade or not is completely dependent on client code.

Facade design pattern can be applied at any point of development, usually when the number of interfaces grow and system gets complex.

Subsystem interfaces are not aware of Facade and they shouldn’t have any reference of the Facade interface.

Facade design pattern should be applied for similar kind of interfaces, its purpose is to provide a single interface 
rather than multiple interfaces that does the similar kind of jobs.

We can use Factory pattern with Facade to provide better interface to client systems.


public class ShapeMaker {
   private Shape circle;
   private Shape rectangle;
   private Shape square;

   public ShapeMaker() {
      circle = new Circle();
      rectangle = new Rectangle();
      square = new Square();
   }

   public void drawCircle(){
      circle.draw();
   }
   public void drawRectangle(){
      rectangle.draw();
   }
   public void drawSquare(){
      square.draw();
   }
}


public class FacadePatternDemo {
   public static void main(String[] args) {
      ShapeMaker shapeMaker = new ShapeMaker();

      shapeMaker.drawCircle();
      shapeMaker.drawRectangle();
      shapeMaker.drawSquare();		
   }
}