

class Shapes{            //parent class 
	void area() {
		System.out.println("I have area");	
	}                                                                             //Parent class has feauturs which is common to all classes
	void radius() {
		System.out.println("I have no radius");
	}
	
	void perimeter() {
		System.out.println("I have a specific value of perimeter");
	}
	void closedFigure() {
		System.out.println("I am a closed figure");
	}
	
}
	class triangle extends Shapes{                       //inheritance
		void NameDisplay(){
			System.out.println("I am a triangle");       //special feature
		}
		void corners() {
			System.out.println("I have 3 corners");
		}
		
	}
	class circle extends Shapes{
		void NameDisplay() {
			System.out.println("I am a circle");
		}
		@Override                                                //overriding the default feauture 
		void radius() {                                          //parent feature can be accessed by super();
			System.out.println("I have  radius");
		}
	}
	class square extends Shapes{
		void NameDisplay() {
			System.out.println("I am a square");
		}
	    @Override
		void closedFigure() {
		System.out.println("I am a closed figure with all 4 sides equal");
	}
	    }

	
	class DrawingShapes  {
		void ShapeCaller (Shapes shapes) {     //upcasting                      //to make program DRY(Dont repeat yourself)
			shapes.area();                                                       //to make srp and dry we are using another class and a function to call 
			shapes.perimeter();
			shapes.radius();
			shapes.closedFigure();
			if(shapes instanceof circle) {
			 circle c = (circle) shapes;
			 c.NameDisplay();
			}
			else if ( shapes instanceof square) {     //downcasting
				square s = (square) shapes;
					s.NameDisplay();
				}
			else if(shapes instanceof triangle)
			{
				triangle tr = (triangle) shapes;
				tr.NameDisplay();
				tr.corners();
			}
				
			System.out.println("**********************");			
		}
	}

public class InheritanceQuestion {

	public static void main(String[] args) {
		DrawingShapes ds = new DrawingShapes();     //object to DrawingShapes
		
		ds.ShapeCaller(new circle());                //program is now dry
        ds.ShapeCaller(new square());
        ds.ShapeCaller(new triangle());

	}

}
