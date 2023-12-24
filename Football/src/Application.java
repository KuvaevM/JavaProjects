import java.io.IOException;

public class Application {
	static Forward f = new MyForwardIIDaniils();
	static Keeper k = new MyKeeper();
	
	//��������� ����: 
	//	0 - ����������,
	//	1 - ������� ������,
	//	2 - ������� ������� �����,
	//	3 - ������� ������� ������ 
	int state;
	
	//���������� �� ����� �� ����� �����
	double X;
	
	//������ �����
	double Y;
	
	//������� ������� ������������ ����� ������ �����
	//����� � �������� �� 0 �� Y
	double keeperX;
	
	//������ �������
	double L;
	
	//������ �������
	double l;
	
	//�� ������� ���������� ������� ��� �������� (�� ������)
	double v;
	
	//�� ������� ���������� ������� ��� ������
	double V;
	
	// ������� ����������� ������ ������� �������� � ��������
	// � �������� ������������ ���������.
	// ������ 0 - ���������� ������
	// ������ - �����
	int forwardB;
	
	// ������ ������� �������� � ��������� � ��������
	int alpha;
	
	// �� ������� � �������� ��������� ������ �������� �� ���� ���
	int delta;
	
	// ���������� ���������� ���� ������ �������
	// ���� �� ��� �� ��� ��� ����� -1
	// ���� ������, �� ������ ���� (�� 0 �� alpha) ���� ������ ������� ������
	int forwardHit;
	
	// �������� ������ ����
	double U;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		UI ui = new UI();
	}
	
	public Application() {
		state = 0;
		X = 11;
		Y = 18;
		
		l = 1;
		L = 5;
		
		v = 1;
		V = 4;
		
		keeperX = Y/2;
		forwardB = -12;
		
		alpha = 20;
		delta = 4;
		
		forwardHit = -1;
		
		U = 2;
	}
	
	public static final Application instance = new Application();

}

