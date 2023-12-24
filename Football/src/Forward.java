
public class Forward {
	public final int hit(int direction) {
		return direction + 2;
	}
	
	// 0 - стоим на месте
	// 1 - поворот направо
	// -1 - поворот налево
	// hit(x), где х - число от 0 до alpha - куда бьем внутри сектора
	public int moveForward() {
		if (Application.instance.state == 2) {
			return hit(Application.instance.alpha);
		}
		if (Application.instance.state == 3) {
			return hit(0);
		}
		return 0;
	}
}
