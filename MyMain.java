import java.lang.Math.*;
import java.util.*;
import java.text.*;
import java.io.*;



public class MyMain{

	public static void main(String[] args)throws IOException, InterruptedException
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		Scanner in = new Scanner(System.in);
		int s;


		System.out.printf("���ڭ̨Ӫ��Ӥp�C���a!\n");
		System.out.printf("�C������:�N�u�O�ŤM*���Y*���Ӥw\n");
		System.out.printf("�qĹ�F�N�i�H�i�t���o!\n(��J0�H�i�J�U�@�B)\n");

		s = in.nextInt();
		if(s == 0){

		
			account();

			mainPage();
		} 		
	}
		
	public static void account()throws IOException, InterruptedException{

		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
		Scanner in = new Scanner(System.in);
		String  x,y;

		System.out.printf("�b��:");
		x = in.next();
		System.out.printf("�K�X:");
		y = in.next();

		if(x.equals("cis")==true && y.equals("1234")==true)
		{
			System.out.print("-------------------\n");
			System.out.printf("Succes\n");	
			System.out.print("-------------------\n");
			String filePath = "member/cis.txt";

			File file = new File("member",x);

			if(!file.exists())
			{
   				file.getParentFile().mkdirs();

   				try{
   					file.createNewFile();
   				}catch (IOException e){
   					e.printStackTrace();
  				}
			}
		}else{
			System.out.print("ERROR");
			System.exit(1);
		}
	
		
	}


	public static void mainPage()throws IOException, InterruptedException{
		
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();			

		File f = new File("member/cis.txt");
		String str = "";
		String[][] s = new String[128][(int)f.length()];
		String s1;


		int j = 0;
		int i = 0;
		try{
			BufferedReader in = new BufferedReader(new FileReader("member/cis.txt"));


			while((str = in.readLine()) != null){
				
				StringTokenizer st = new StringTokenizer(str, "	");
				j = 0;

				while (st.hasMoreTokens()){
					
					s[i][j] = st.nextToken();
					
					j++;
				}
			
				i++;
			}	
		}catch (IOException e){
			e.printStackTrace();
		}

		Var.fn = i;

		Scanner in = new Scanner(System.in);
		int a;
		
		
		System.out.print("-------------------\n");
		System.out.printf("�i�J�D���\n");
		System.out.print("-------------------\n");
		System.out.print("��J���O:\n\n 0:�ϥΪ̥\��\n 1:�޲z�\��\n -1:�n�X\n");
		System.out.print("-------------------\n");
		a = in.nextInt();
		System.out.print("-------------------\n");
		if(a == 0){
			
			user(s);
	
	
		}else if(a == -1){
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	


		

			System.out.print("-------------------\n");	
			System.out.printf("�n�X\n");
			
			System.out.print("-------------------\n");
			System.exit(1);
			

	
		}else if(a == 1){
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
			System.out.print("��J�K�X: ");
			a = in.nextInt();

			if(a == 1234){
			
				manage(s);

			}else{
				System.out.printf("ERROR");
				System.exit(1);	
			}	
		}else{
			System.out.printf("ERROR");
			System.exit(1);
		}

	}



	public static void manage(String[][] str)throws IOException, InterruptedException{


		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
		System.out.printf("���������\n\n");	
		int c = 1;
		System.out.printf(" 0:�Ҧ��ɮ�\n 1:�u�@�W��\n 2:�����ɶ�\n 3:�����ʤ���\n 4:���A\n 5:�s��\n 6:����\n 7:�u�@���e\n -1:�W�@��\n");
		
		Scanner in = new Scanner(System.in);
		int a, b,x;
		a = in.nextInt();
		if(a == -1){
			
			mainPage();
		}else if(a>0 && a<=7){
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
			print(str,a);
		}else if(a == 0){

			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			

			c++;
	
			System.out.printf("�u�@�W��	�����ɶ�	�����ʤ���	���A		�s��		����		�u�@���e\n");
			System.out.print("\n-------------------------------------------------------------��"+c+"��\n");
			for(int i = 0;i<Var.fn;i++){
				System.out.printf("%-10s	%-10s	%-10s	%-10s	%-10s	%-10s	%-10s\n",str[i][0],str[i][1],str[i][2],str[i][3],str[i][4],str[i][5],str[i][6]);
				
				if((i+1)%5==0){
				System.out.print("\n-------------------------------------------------------------��"+c+"��\n");
				c++;	
			}	
			}
		
			System.out.printf("\n -2:�ܧ󶶧�  -1:�W�@��\n");
			a = in.nextInt();
			if(a == -1){
				manage(str);
			}else if(a == -2){
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
				System.out.printf("������:\n 0:�u�@�W��\n 1:�����ɶ�\n 2:�����ʤ���\n 3:���A\n 4:�s��\n 5:����\n 6:�u�@���e\n -1:�W�@��\n");
				b = in.nextInt();
				if(b == -1){
					manage(str);				
				}else if( a==0 || a>7 || a<-2){
					System.out.printf("ERROR");
					System.exit(1);	
				}else{
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
					System.out.printf("��ܶ���:\n 1:�Ѥj��p\n 2:�Ѥp��j\n");
					x = in.nextInt();
					if(x == 1){
						Big(str,b);
					}else if(x == 2){
						Small(str,b);
					}else{
						System.out.printf("ERROR");
						System.exit(1);						
					}
					
				}
			}else{
				System.out.printf("ERROR");
				System.exit(1);	
			}
		}else{

			System.out.printf("ERROR");
			System.exit(1);		

		}
	}

	public static void Big(String[][] str,int i)throws IOException, InterruptedException{
		String[][] s = new String[2][7];
		for(int y = Var.fn;y>0;y-- ){
			for(int j = Var.fn-1;j>0;j--){
				if(str[j][i].compareTo(str[j-1][i])==0){

				}else if(str[j][i].compareTo(str[j-1][i])<0){

				}else{
					for(int x = 0;x<7;x++){
						s[0][x] = str[j][x];
						str[j][x] = str[j-1][x];
						str[j-1][x] = s[0][x];
					}
								
				}
	
			}
		}
		write(str);
		manage(str);
	
	}

	public static void Small(String[][] str,int i)throws IOException, InterruptedException{

		String[][] s = new String[2][7];
		for(int y = Var.fn;y>0;y-- ){
			for(int j = Var.fn-1;j>0;j--){
				if(str[j][i].compareTo(str[j-1][i])==0){

				}else if(str[j][i].compareTo(str[j-1][i])<0){
					for(int x = 0;x<7;x++){
						s[0][x] = str[j][x];
						str[j][x] = str[j-1][x];
						str[j-1][x] = s[0][x];
					}

				}else{

					
			
				}
	
			}
		}
		write(str);
		manage(str);
	}

	public static void print(String[][] str, int i)throws IOException, InterruptedException{
		
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	

		System.out.print("��J����:\n\n 0:�j>�p\n 1:�p>�j    -1:�W�@��\n--------------(�ƧǨ̸�Ʒs�W����)\n");
		Scanner in = new Scanner(System.in);
		int a;
		int f = 0, n = 0;
		a = in.nextInt();

		if(a == -1){

			manage(str);	

		}else if(a == 0){

			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

			for(f = 0;f<Var.fn;f++){
	
				System.out.printf(str[f][i-1]+"\n");
			
			}

			System.out.printf("-------------------\n  -1:�W�@��\n");
			n = in.nextInt();
			if(n == -1){
				manage(str);			
			}

	
		}else if(a == 1){

			f = Var.fn-1;

			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

			for(;f>=0;f--){

				System.out.printf(str[f][i-1]+"\n");

			}

			System.out.printf("-------------------\n  -1:�W�@��\n");
			n = in.nextInt();
			if(n == -1){
				manage(str);			
			}	

		}else{
			System.out.printf("ERROR");
			System.exit(1);	
		}
	
	}

	public static void user(String[][] str)throws IOException, InterruptedException{

		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	

		int a;
		int c = 1;
		int g;


		System.out.print("��ܸ��(��J��ƧǸ�):\n\n");
		System.out.print("��Ƨ�/");
		if(Var.a1 == 1) System.out.print("�u�@�W��/");
		if(Var.a2 == 1) System.out.print("�����ɶ�/");
		if(Var.a3 == 1) System.out.print("�����ʤ���/");
		if(Var.a4 == 1) System.out.print("���A/");
		if(Var.a5 == 1) System.out.print("�s��/");
		if(Var.a6 == 1) System.out.print("����/");
		if(Var.a7 == 1) System.out.print("�u�@���e/");
			
		System.out.print("\n-------------------------------------------------------------��"+c+"��\n");
		c++;
		for(a = 0;a<Var.fn;a++){
			System.out.print("���"+(a+1)+":  ");
			if(Var.a1 == 1) System.out.print(str[a][0]+"	");
			if(Var.a2 == 1) System.out.print(str[a][1]+"	");
			if(Var.a3 == 1) System.out.print(str[a][2]+"	");
			if(Var.a4 == 1) System.out.print(str[a][3]+"	");
			if(Var.a5 == 1) System.out.print(str[a][4]+"	");
			if(Var.a6 == 1) System.out.print(str[a][5]+"	");
			if(Var.a7 == 1) System.out.print(str[a][6]);
			System.out.printf("\n");			
			if((a+1)%5==0){
				System.out.print("\n-------------------------------------------------------------��"+c+"��\n");
				c++;	
			}			
		}
		System.out.print("\n -4:�]�w��ܶ��� -3:�j�M    -2:�s�W���    -1:�W�@�� \n");
		
		System.out.print("-------------------------------------------------------------\n");

		Scanner in = new Scanner(System.in);
		int b;
		b = in.nextInt();

		System.out.print("-------------------------------------------------------------\n");

		if(b == -1){
		
			mainPage();
		}else if(b == -2){
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			char[] chars = new char[100];
			int as;
	
			Var.fn +=1;
			String news;

			System.out.print("�̧ǿ�J���:\n\n");

			System.out.print("�u�@�W��:");
			news = in.next();
			str[Var.fn-1][0] = news;

			System.out.print("�����ɶ�:");
			news = in.next();
			chars = news.toCharArray();
			if((Character.toString(chars[0]).matches("[2?]")&&Character.toString(chars[1]).matches("[0-3?]")||
			Character.toString(chars[0]).matches("[0-1?]")&&Character.toString(chars[1]).matches("[0-9?]"))
				&&Character.toString(chars[2]).matches("[0-5?]")&&Character.toString(chars[3]).matches("[0-9?]")){
			str[Var.fn-1][1] = news;
			}else{
				System.out.printf("ERROR");
				System.exit(1);		
			}

			System.out.print("�����ʤ���:");
			news = in.next();
			as = Integer.parseInt(news);
			if(as<100&&as>0){
				str[Var.fn-1][2] = news;
			}else{
				System.out.printf("ERROR");
				System.exit(1);			
			
			}
			System.out.print("���A:");
			news = in.next();
			if(news.equals("���}�l")||news.equals("���椤")||news.equals("����")){
				str[Var.fn-1][3] = news;
			}else{
				System.out.printf("ERROR");
				System.exit(1);					
			}

			System.out.print("�s��:");
			news = in.next();
			chars = news.toCharArray();
			if(Character.toString(chars[0]).matches("[A-Z?]")){
				str[Var.fn-1][4] = news;
			}else{
				System.out.printf("ERROR");
				System.exit(1);	
			}

			System.out.print("����:");
			news = in.next();
			str[Var.fn-1][5] = news;

			System.out.print("�u�@���e:");	
			news = in.next();
			str[Var.fn-1][6] = news;


			write(str);
			mainPage();
							
		}else if(b>Var.fn){
			System.out.printf("ERROR");
			System.exit(1);			
		
		}else if(b == -3){
			search(str);	
		}else if(b == -4){
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.print("��J�O�_�n��ܪ����():\n");

			System.out.printf(" 1:�u�@�W��"); 
			if(Var.a1 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 2:�����ɶ�");
			if(Var.a2 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 3:�����ʤ���");
			if(Var.a3 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 4:���A"); 
			if(Var.a4 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 5:�s��"); 
			if(Var.a5 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 6:����"); 
			if(Var.a6 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 7:�u�@���e"); 
			if(Var.a7 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" -1:�W�@��\n");

			g = in.nextInt();
			if(g == -1){
				user(str);
			}else if(g == 0||g>7||g<-1){
				System.out.printf("ERROR");
				System.exit(1);				
			}else{
				if(g == 1){
					if(Var.a1 == 1){
						Var.a1 = 0;
					}else{
						Var.a1 = 1;
					}	
				}
				if(g == 2){
					if(Var.a2 == 1){
						Var.a2 = 0;
					}else{
						Var.a2 = 1;
					}	
				}
				if(g == 3){
					if(Var.a3 == 1){
						Var.a3 = 0;
					}else{
						Var.a3 = 1;
					}	
				}
				if(g == 4){
					if(Var.a4 == 1){
						Var.a4 = 0;
					}else{
						Var.a4 = 1;
					}	
				}
				if(g == 5){
					if(Var.a5 == 1){
						Var.a5 = 0;
					}else{
						Var.a5 = 1;
					}	
				}
				if(g == 6){
					if(Var.a6 == 1){
						Var.a6 = 0;
					}else{
						Var.a6 = 1;
					}
				}
				if(g == 7){
					if(Var.a7 == 1){
						Var.a7 = 0;
					}else{
						Var.a7 = 1;
					}
				}				
				user(str);
			}
		
		}else{
			data(str,b);	
		}
	}	 
	
	public static void search(String[][] str)throws IOException, InterruptedException{

		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		int a,x,h = 0;
		System.out.printf("��ܷj�M����:\n 1:�u�@�W��\n 2:�����ɶ�\n 3:�����ʤ���\n 4:���A\n 5:�s��\n 6:����\n 7:�u�@���e\n -1:�W�@��\n");
		
		Scanner in = new Scanner(System.in);		
		a = in.nextInt();
		
		if(a == -1){
			user(str);
		}else{

			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			String se;
			System.out.printf("��J�j�M���e:\n");
			se = in.next();
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			
			for(int i = 0;i<Var.fn;i++){

				if(str[i][a-1].equals(se)){
					h = 1;
					for(int j = 0;j<6;j++){
					
						
						System.out.print(str[i][j]+"	");
						
						
					}
					System.out.print(str[i][6]+"\n");
				}
			}

			if(h == 1){
				System.out.printf("\n-1:�^�W�@��\n");
				System.out.print("-------------------\n");

				x = in.nextInt();

				if(x == -1){
					user(str);
				}else{
					System.out.printf("ERROR");
					System.exit(1);	
				}
			}else{
				System.out.printf("�d�L������ \n\n -1:�^�W�@��\n");
				System.out.print("-------------------\n");

				x = in.nextInt();
				if(x == -1){
					user(str);
				}else{
					System.out.printf("ERROR");
					System.exit(1);	
				}
			}
		}
		
		
	}

	public static void data(String[][] str,int i)throws IOException,InterruptedException{

		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	

		int a;
		System.out.printf("��J���O:\n\n 0:�R�����\n 1:�u�@�W��\n 2:�����ɶ�\n 3:�����ʤ���\n 4:���A\n 5:�s��\n 6:����\n 7:�u�@���e\n -1:�W�@��\n");
		System.out.print("-------------------\n");

		Scanner in = new Scanner(System.in);		
		a = in.nextInt();

		System.out.print("-------------------\n");
		if(a == -1){
			user(str);		
		}else if(a>0){
			while( a != 0 ){
				switch(a){
					case 1: edit(str,0,i);break;
					case 2: edit(str,1,i);break;
					case 3: edit(str,2,i);break;
					case 4: edit(str,3,i);break;
					case 5: edit(str,4,i);break;
					case 6: edit(str,5,i);break;
					case 7: edit(str,6,i);break;
					default: System.out.printf("ERROR");System.exit(1);
				}
			}
		a = in.nextInt();			
		}else if(a == 0){
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

			System.out.print("�T�{�R��?(yes or no)\n");
			String y;

			y = in.next();

			if(y.equals("yes")){
				for(;i<Var.fn-1;i++){
					for(int j = 0;j<7;j++){
						str[i][j] = str[i+1][j];
						System.out.print(str[i][j]);
						}
					}
		
				for(int x = 0;x<7;x++){
					System.out.print(str[Var.fn-1][x]);
					str[Var.fn-1][x] = "";
					
					}
				write(str);
				mainPage();
			}else if(y.equals("no")){
				data(str,i);
			}else{
				System.out.printf("ERROR");
				System.exit(1);				
			}
		}else{
			System.out.printf("ERROR");
			System.exit(1);		
		}
	
	
	
	}


	public static void edit(String[][] str,int x,int i)throws IOException, InterruptedException{

		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	

		
		Scanner in = new Scanner(System.in);
		int a;
		char[] chars = new char[100];
		int as;
		String news;

		System.out.print("-------------------\n");
		System.out.print(str[i][x]+"\n");	
		System.out.print("-------------------\n");			
		System.out.printf("��J���O:\n\n 1:�s�褺�e\n -1:�W�@��\n");
		System.out.print("-------------------\n");
		a = in.nextInt();
		System.out.print("-------------------\n");
		if(a == -1){
			data(str,i);
			
		}else if(a == 1){
			System.out.printf("��J�s���e:");
			news = in.next();

			if(x == 0){
				str[Var.fn-1][0] = news;
			}else if(x == 1){

				chars = news.toCharArray();
				if((Character.toString(chars[0]).matches("[2?]")&&Character.toString(chars[1]).matches("[0-3?]")||
				Character.toString(chars[0]).matches("[0-1?]")&&Character.toString(chars[1]).matches("[0-9?]"))
				&&Character.toString(chars[2]).matches("[0-5?]")&&Character.toString(chars[3]).matches("[0-9?]")){
				
				str[Var.fn-1][1] = news;
				}else{
					System.out.printf("ERROR");
					System.exit(1);		
				}
			}else if(x == 2){

				as = Integer.parseInt(news);
				if(as<100&&as>0){
					str[Var.fn-1][2] = news;
				}else{
					System.out.printf("ERROR");
					System.exit(1);			
			
				}
			}else if(x == 3){

				if(news.equals("���}�l")||news.equals("���椤")||news.equals("����")){
					str[Var.fn-1][3] = news;
				}else{
					System.out.printf("ERROR");
					System.exit(1);					
				}
			}else if(x == 4){
	

				chars = news.toCharArray();
				if(Character.toString(chars[0]).matches("[A-Z?]")){
					str[Var.fn-1][4] = news;
				}else{
					System.out.printf("ERROR");
					System.exit(1);	
				}
			}else if(x == 5){

				str[Var.fn-1][5] = news;
			}else{


				str[Var.fn-1][6] = news;
			}
	
	
			write(str);
			data(str,i);
		}else{
			System.out.printf("ERROR");
			System.exit(1);
		}	
	}
	


	public static void write(String[][] str){
	
			
		try{
			FileWriter fw = new FileWriter("member/cis.txt"); 
			
	
			for(int i = 0;i<Var.fn;i++){

				for(int j = 0;j<7;j++){

					if((str[i][j]!=null)&& !str[i][j].equals("")){
						if(j != 6){
							fw.write(str[i][j]+"	");
						}else{
							fw.write(str[i][j]);	
						}
						
					}

	 			}
				if((str[i+1][0]!=null)&& !str[i+1][0].equals("")){
					fw.write("\r\n");
				}
			}	
				
				
			

			fw.close();
		}catch (IOException e){
   			e.printStackTrace();
  		}

		
	}
	

}

