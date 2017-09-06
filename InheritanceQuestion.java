

class Shapes{
	void area() {
		System.out.println("I have area");	
	}
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
	class triangle extends Shapes{
		void NameDisplay(){
			System.out.println("I am a triangle");
		}
		void corners() {
			System.out.println("I have 3 corners");
		}
		
	}
	class circle extends Shapes{
		void NameDisplay() {
			System.out.println("I am a circle");
		}
		@Override
		void radius() {
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
		void ShapeCaller (Shapes shapes) {
			shapes.area();
			shapes.perimeter();
			shapes.radius();
			shapes.closedFigure();
			if(shapes instanceof circle) {
			 circle c = (circle) shapes;
			 c.NameDisplay();
			}
			else if ( shapes instanceof square) {
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
		DrawingShapes ds = new DrawingShapes();
		
		ds.ShapeCaller(new circle());
        ds.ShapeCaller(new square());
        ds.ShapeCaller(new triangle());

	}

}
