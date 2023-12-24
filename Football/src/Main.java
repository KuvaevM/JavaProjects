
public class Main {

}

class MyKeeper extends Keeper {
	int counter;

	public int moveKeeper() {
		if (Math.sqrt(Application.instance.X * Application.instance.X + Application.instance.Y * Application.instance.Y / 4)
				/ Application.instance.U
				* Application.instance.V >= Application.instance.Y / 2 - Application.instance.L / 2) {
			if (Application.instance.state == 1) {
				double betta = (Application.instance.forwardB - Application.instance.alpha / 2
						+ Application.instance.forwardHit) * Math.PI / 180;
				if (betta >= 0) {
					if (Application.instance.keeperX - Application.instance.l / 2 <= Application.instance.Y / 2
							+ Math.tan(betta) * Application.instance.X
							&& Application.instance.keeperX + Application.instance.l / 2 >= Application.instance.Y / 2
									+ Math.tan(betta) * Application.instance.X) {
						return 0;
					} else if (Application.instance.keeperX
							+ ((int) (Application.instance.X / Math.cos(betta) / Application.instance.U - counter))
									* Application.instance.V
							- Application.instance.L / 2 <= Application.instance.Y / 2
									+ Math.tan(betta) * Application.instance.X
							&& Application.instance.keeperX
									+ ((int) (Application.instance.X / Math.cos(betta) / Application.instance.U
											- counter)) * Application.instance.V
									+ Application.instance.L / 2 >= Application.instance.Y / 2
											+ Math.tan(betta) * Application.instance.X) {
						return 2;

					} else {
						counter++;
						return 1;
					}
				}
				if (betta < 0) {
					if (Application.instance.keeperX - Application.instance.l / 2 <= Application.instance.Y / 2
							- Math.tan(-betta) * Application.instance.X
							&& Application.instance.keeperX + Application.instance.l / 2 >= Application.instance.Y / 2
									- Math.tan(-betta) * Application.instance.X) {
						return 0;
					} else if (Application.instance.keeperX
							- ((int) (Application.instance.X / Math.cos(-betta) / Application.instance.U - counter))
									* Application.instance.V
							- Application.instance.L / 2 <= Application.instance.Y / 2
									- Math.tan(-betta) * Application.instance.X
							&& Application.instance.keeperX
									- ((int) (Application.instance.X / Math.cos(-betta) / Application.instance.U
											- counter)) * Application.instance.V
									+ Application.instance.L / 2 >= Application.instance.Y / 2
											- Math.tan(-betta) * Application.instance.X) {
						return -2;

					} else {
						counter++;
						return -1;
					}
				}
			}

		} else {
			if (Application.instance.forwardB > 0) {
				if ((Math.sqrt(Application.instance.X * Application.instance.X
						+ Application.instance.Y * Application.instance.Y / 4) / Application.instance.U
						* Application.instance.V >= Application.instance.Y - Application.instance.keeperX / 2
								- Application.instance.L / 2)&&(Application.instance.Y / 2 + Math.tan(Application.instance.forwardB)
								* Application.instance.X>=Application.instance.keeperX)) {
					return 0;
				} else if (Application.instance.Y / 2 + Math.tan(Application.instance.forwardB)
						* Application.instance.X > Application.instance.keeperX + Application.instance.l / 2) {
					return 1;
				} else if (Application.instance.Y / 2 + Math.tan(Application.instance.forwardB)
						* Application.instance.X < Application.instance.keeperX - Application.instance.l / 2) {
					return -1;
				} else {
					return 0;
				}
			} else {
				if ((Math.sqrt(Application.instance.X * Application.instance.X
						+ Application.instance.Y * Application.instance.Y / 4) / Application.instance.U
						* Application.instance.V >= Application.instance.keeperX / 2 - Application.instance.L / 2)&&(Application.instance.Y/2-Math.tan(Application.instance.forwardB)
				* Application.instance.X<=Application.instance.keeperX)) {
					return 0;
				} else if (Application.instance.Y / 2 - Math.tan(-Application.instance.forwardB)
						* Application.instance.X > Application.instance.keeperX + Application.instance.l / 2) {
					return 1;
				} else if (Application.instance.Y / 2 - Math.tan(-Application.instance.forwardB)
						* Application.instance.X < Application.instance.keeperX - Application.instance.l / 2) {
					return -1;
				} else {
					return 0;
				}
			}
		}
		if (Application.instance.state == 1) {
			double betta = (Application.instance.forwardB - Application.instance.alpha / 2
					+ Application.instance.forwardHit) * Math.PI / 180;
			if (betta >= 0) {
				if (Application.instance.keeperX - Application.instance.l / 2 <= Application.instance.Y / 2
						+ Math.tan(betta) * Application.instance.X
						&& Application.instance.keeperX + Application.instance.l / 2 >= Application.instance.Y / 2
								+ Math.tan(betta) * Application.instance.X) {
					return 0;
				} else if (Application.instance.keeperX
						+ ((int) (Application.instance.X / Math.cos(betta) / Application.instance.U - counter))
								* Application.instance.V
						- Application.instance.L / 2 <= Application.instance.Y / 2
								+ Math.tan(betta) * Application.instance.X
						&& Application.instance.keeperX
								+ ((int) (Application.instance.X / Math.cos(betta) / Application.instance.U - counter))
										* Application.instance.V
								+ Application.instance.L / 2 >= Application.instance.Y / 2
										+ Math.tan(betta) * Application.instance.X) {
					return 2;

				} else {
					counter++;
					return 1;
				}
			}
			if (betta < 0) {
				if (Application.instance.keeperX - Application.instance.l / 2 <= Application.instance.Y / 2
						- Math.tan(-betta) * Application.instance.X
						&& Application.instance.keeperX + Application.instance.l / 2 >= Application.instance.Y / 2
								- Math.tan(-betta) * Application.instance.X) {
					return 0;
				} else if (Application.instance.keeperX
						- ((int) (Application.instance.X / Math.cos(-betta) / Application.instance.U - counter))
								* Application.instance.V
						- Application.instance.L / 2 <= Application.instance.Y / 2
								- Math.tan(-betta) * Application.instance.X
						&& Application.instance.keeperX
								- ((int) (Application.instance.X / Math.cos(-betta) / Application.instance.U - counter))
										* Application.instance.V
								+ Application.instance.L / 2 >= Application.instance.Y / 2
										- Math.tan(-betta) * Application.instance.X) {
					return -2;

				} else {
					counter++;
					return -1;
				}
			}
		}

		return 0;
	}
}

class MyForwardIIDaniils extends Forward {
	int stroke;
	
	public int moveForward() {
		stroke ++;
		int stater = 0;
		double err [] = new double[Application.instance.alpha];
		if(Application.instance.state == 2) {
			stater = -1;
		}
		if(Application.instance.state == 3) {
			stater = 1;
		}
		// for (int i =  Application.instance.alpha - 1; i >= 0; i--)
		for (int i = 0; i < Application.instance.alpha; i++) {
			if ((Application.instance.X*Math.tan(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2.0 + i))) > Application.instance.keeperX - Application.instance.Y/2 && stater == -1 && (Application.instance.X*Math.tan(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2.0 + i))) <= Application.instance.Y/2) {
//				
				return hit (i);
//				
			}
			if ((Application.instance.X*Math.tan(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2.0 + i))) < Application.instance.keeperX - Application.instance.Y/2 && stater == 1 && (Application.instance.X*Math.tan(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2.0 + i))) >= -Application.instance.Y/2) {
//				
				return hit (i);
//				
			}
//			System.out.println(Application.instance.forwardB + "B " + Application.instance.alpha/2.0 + "alpha/2 " + i + "i " + (Application.instance.forwardB - Application.instance.alpha/2.0 + i) + " sin " + Math.abs(Application.instance.X*(Math.tan(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2.0 + i)))) + " " + Math.tan(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2.0 + i)));
			
			if (Math.abs((Application.instance.X*Math.tan(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2.0 + i)))) > Application.instance.Y/2.0) {
//				
				err[i] = -777;
//				
			}
			
			
			
			else {
				// Подлётное время мяча в ходах
			double t = 1.0*(Application.instance.X/(Math.cos(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2.0 + i))))/Application.instance.U;
			
			double deltaT = t*1.0 - (int)t;
			
//			
			
			double arr [] = new double[(int)(2*((int) t) + 2*(((int) (t) + 1)/2)*((int)t))];
			double brr [] = new double[arr.length];
			double crr [] = new double[arr.length];
			
			int koef = 1;
			if (Math.sin(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2 + i)) > 0) {
				koef = 1;
			}
			else {
				koef = -1;
			}
			for (int j = 0;j < ((int) t); j++) {
				arr[j] = koef*Application.instance.v*j + Application.instance.keeperX;
				
				brr [j] = arr[j] + Application.instance.l/2.0;
				crr [j] = arr[j] - Application.instance.l/2.0;
				
				if (arr[j] >= Application.instance.Y) {
					arr[j] = Application.instance.Y -  Application.instance.l/2.0;
					
					brr[j] = Application.instance.Y;
					crr[j] = Application.instance.Y - Application.instance.l;
					
				}
				if (arr[j] <= 0) {
					arr[j] = Application.instance.l/2.0;
					
					brr[j] = Application.instance.l;
					crr[j] = 0;
					
				}
			}
			for (int j = ((int) t);j < 2*((int) t); j++) {
				arr[j] = koef*(Application.instance.v*j + Application.instance.v*j*deltaT) + Application.instance.keeperX;
				
				brr [j] = arr[j] + Application.instance.l/2.0;
				crr [j] = arr[j] - Application.instance.l/2.0;
				
				if (arr[j] >= Application.instance.Y) {
					arr[j] = Application.instance.Y -  Application.instance.l/2.;
					
					brr[j] = Application.instance.Y;
					crr[j] = Application.instance.Y - Application.instance.l;
					
				}
				if (arr[j] <= 0) {
					arr[j] = Application.instance.l/2.0;
					
					brr[j] = Application.instance.l;
					crr[j] = 0;
					
				}
			}
			for (int j = 2*((int) t);j < 2*((int) t) + (((int) (t) +1)/2)*((int)t); j++) {
				for (int g = 0; g < t - j; g++) {
					arr[j] = koef*(Application.instance.v*j + Application.instance.V*j*(g)) + Application.instance.keeperX;
					
					brr [j] = arr[j] + Application.instance.L/2.0;
					crr [j] = arr[j] - Application.instance.L/2.0;
					
					if (arr[j] >= Application.instance.Y) {
						arr[j] = Application.instance.Y -  Application.instance.L/2.;
						
						brr[j] = Application.instance.Y;
						crr[j] = Application.instance.Y - Application.instance.L;
						
					}
					if (arr[j] <= 0) {
						arr[j] = Application.instance.L/2.0;
						
						brr[j] = Application.instance.L;
						crr[j] = 0;
						
					}
				}
				
			}
			for (int j = 2*((int) t) + (((int) (t) +1)/2)*((int)t);j < 2*((int) t) + 2*(((int) (t) +1)/2)*((int)t); j++) {
				for (int g = 0; g < t - j; g++) {
					arr[j] = koef*(-Application.instance.v*j + Application.instance.V*j*(t - j)) + Application.instance.keeperX;
					
					brr [j] = arr[j] + Application.instance.L/2.0;
					crr [j] = arr[j] - Application.instance.L/2.0;
					
					if (arr[j] >= Application.instance.Y) {
						arr[j] = Application.instance.Y -  Application.instance.L/2.;
						
						brr[j] = Application.instance.Y;
						crr[j] = Application.instance.Y - Application.instance.L;
						
					}
					if (arr[j] <= 0) {
						arr[j] = Application.instance.L/2.0;
						
						brr[j] = Application.instance.L;
						crr[j] = 0;
						
					}
				}
				
			}


			int chance = 0;
			
			
			
			
			
			for (int j = 0; j < arr.length; j++) {
				
				
				
				
				if ((Application.instance.X*Math.tan(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2 + i)) + Application.instance.Y/2.0 >= Math.min(brr[j], crr[j]) && Application.instance.X*Math.tan(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2 + i)) + Application.instance.Y/2.0 <= Math.max(brr[j], crr[j]))) {
					chance++;
				}

				
			}

			err [i] = chance;
			}
			
			
			
			
		}
		
		double min = 999999999;
		int minNum = 0;
		
		
		
		
		
		for (int n = 0; n < err.length; n++) {
			
			if (err [n] < min && err[n] != -777) {
				
				min = err [n];
				minNum = n;
			}
		}
		
		int koefII = 1;
		if (Application.instance.X*Math.tan(Math.toRadians(Application.instance.forwardB - Application.instance.alpha/2 + minNum)) - Application.instance.keeperX - Application.instance.Y > 0) {
			koefII = -1;
		}
		else {
			koefII = 1;
		}
		

		
		
		
		if (err[minNum] == 0.0) {
			
			return hit (minNum + 1);
		}
		
		if (stroke <= 25 && min > 0) {
			return koefII;
		}
		
		if (stroke <= 45 && min >= 2) {
			return koefII;
		}
		if (stroke <= 49 && min >= 5) {
			return koefII;
		}
		if (stroke > 25 && min <= 1) {
			return hit (minNum);
		}
		if (stroke > 45 && min <= 2) {
			return hit (minNum);
		}
		if (stroke == 50) {
			return hit (minNum);
		}
		
		return 0;

		
	}
}
