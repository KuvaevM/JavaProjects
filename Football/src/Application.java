import java.io.IOException;

public class Application {
	static Forward f = new MyForwardIIDaniils();
	static Keeper k = new MyKeeper();
	
	//состояние игры: 
	//	0 - подготовка,
	//	1 - форвард ударил,
	//	2 - вратарь прыгнул влево,
	//	3 - вратарь прыгнул вправо 
	int state;
	
	//расстояние до ворот от точки удара
	double X;
	
	//ширина ворот
	double Y;
	
	//позиция вратаря относительно левой стойки ворот
	//лежит в пределах от 0 до Y
	double keeperX;
	
	//высота вратаря
	double L;
	
	//ширина вратаря
	double l;
	
	//на сколько сдвигается вратарь при движении (не прыжок)
	double v;
	
	//на сколько сдвигается вратарь при прыжке
	double V;
	
	// текущее направление ЦЕНТРА сектора обстрела у форварда
	// в градусах относительно вертикали.
	// Больше 0 - отклонение вправо
	// Меньше - влево
	int forwardB;
	
	// Размер сектора обстрела у форвардва в градусах
	int alpha;
	
	// На сколько в градусах смещается сектор форварда за один ход
	int delta;
	
	// Переменная показывает куда ударил форвард
	// Если он еще не бил она равна -1
	// Если ударил, то хранит угол (от 0 до alpha) куда внутри сектора ударил
	int forwardHit;
	
	// Скорость полета мяча
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

