
public class Forward {
	public final int hit(int direction) {
		return direction + 2;
	}
	
	// 0 - ����� �� �����
	// 1 - ������� �������
	// -1 - ������� ������
	// hit(x), ��� � - ����� �� 0 �� alpha - ���� ���� ������ �������
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
