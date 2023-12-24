
public class Hittable {
	int x;
	int y;
	int width;
	int height;

	int Hittest(int y1, int x1, int R) {
		if ((y1 > y - R) && (y1 < y + height) && (x1 >= x - R) && (x1 <= x - R + Main.MotionV)) {
			return Main.leftHit;
		}
		if ((y1 > y - R) && (y1 < y + height) && (x1 <= x + width) && (x1 >= x + width - Main.MotionV)) {
			return Main.rightHit;
		}
		if ((y1 >= y - R) && (y1 <= y - R + Main.MotionV) && (x1 <= x + width - R / 2) && (x1 >= x - R / 2)) {
			return Main.upHit;
		}
		if ((y1 >= y + height - Main.MotionV) && (y1 <= y + height) && (x1 <= x + width - R / 2) && (x1 >= x - R / 2)) {
			return Main.downHit;
		}
		return 0;
	}
	// int Hittest(int y1, int x1, int R) {
	// if () {
	// return 1;
	// }
	// if ((y1 >= y) && (y1 <= y + height) && (x1 <= x + width+2) && (x1 >= x +
	// width / 8)) {
	// return 3;
	// }
	// if ((y1 < y + height / 8) && (y1 > y - R) && (x1 <= x + width) && (x1 >= x -
	// R)) {
	// return 2;
	// }
	// if () {
	// return 4;
	// }
	// return 0;
	// }

}
