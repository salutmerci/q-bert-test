import com.badlogic.gdx.math.Vector2;
import hevs.gdx2d.components.graphics.GeomUtils;
import hevs.gdx2d.components.physics.PhysicsPolygon;
import hevs.gdx2d.components.physics.utils.PhysicsScreenBoundaries;
import hevs.gdx2d.lib.GdxGraphics;
import hevs.gdx2d.lib.PortableApplication;
import hevs.gdx2d.lib.physics.DebugRenderer;

public class Graphics extends PortableApplication{
	
	public static int width = 651;
	public static int height = 651;
	public static int table = 26;
	PhysicsPolygon path;
	DebugRenderer debugRenderer;
		//public graphics
	public Graphics(){
		super(width, height);
	}
	
	public static void main(String[] args) {
		new Graphics();
	 }
	
	
	public void onInit() {
		//Polygon for the basic path
		Vector2 obj1[] = {
				new Vector2(0, 0),
				new Vector2(10, 5),
				new Vector2(0, 10),
				new Vector2 (-10, 5),
		};
		
		GeomUtils.scale(obj1, 20);
		GeomUtils.translate(obj1, new Vector2(100, 100));
		path = new PhysicsPolygon("p1", obj1, true);
		
		new PhysicsScreenBoundaries(width, height);
		debugRenderer = new DebugRenderer();
		
	}
	
	
	public void onKeyDown(int keycode) {
		setTitle("q*bert back at it again");
	}


	public void onGraphicRender(GdxGraphics g) {
		g.clear();
		g.drawFilledPolygon(path.getPolygon(), com.badlogic.gdx.graphics.Color.YELLOW);
	}
	
}