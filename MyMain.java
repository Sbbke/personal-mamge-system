import java.lang.Math.*;
import java.util.*;
import java.text.*;
import java.io.*;



public class MyMain{

	public static void main(String[] args)throws IOException, InterruptedException
	{
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		Scanner in = new Scanner(System.in);

		game();

		account();

		mainPage();
				
	}
		
	public static void account()throws IOException, InterruptedException{

		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
		Scanner in = new Scanner(System.in);
		String  x,y;

		System.out.printf("帳號:");
		x = in.next();
		System.out.printf("密碼:");
		y = in.next();

		if(x.equals("cis")==true && y.equals("1234")==true)
		{
			System.out.print("-------------------\n");
			System.out.printf("Succes\n");	
			System.out.print("-------------------\n");

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
		in.close();
		
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
		System.out.printf("進入主選單\n");
		System.out.print("-------------------\n");
		System.out.print("輸入指令:\n\n 0:使用者功能\n 1:管理功能\n -1:登出\n");
		System.out.print("-------------------\n");
		a = in.nextInt();
		System.out.print("-------------------\n");
		if(a == 0){
			
			user(s);
	
	
		}else if(a == -1){
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	


		

			System.out.print("-------------------\n");	
			System.out.printf("登出\n");
			
			System.out.print("-------------------\n");
			System.exit(1);
			

	
		}else if(a == 1){
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
			System.out.print("輸入密碼: ");
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
		System.out.printf("選擇顯示欄位\n\n");	
		int c = 1;
		System.out.printf(" 0:所有檔案\n 1:工作名稱\n 2:完成時間\n 3:完成百分比\n 4:狀態\n 5:編號\n 6:分類\n 7:工作內容\n -1:上一頁\n");
		
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
	
			System.out.printf("工作名稱	完成時間	完成百分比	狀態		編號		分類		工作內容\n");
			System.out.print("\n-------------------------------------------------------------第"+c+"頁\n");
			for(int i = 0;i<Var.fn;i++){
				System.out.printf("%-10s	%-10s	%-10s	%-10s	%-10s	%-10s	%-10s\n",str[i][0],str[i][1],str[i][2],str[i][3],str[i][4],str[i][5],str[i][6]);
				
				if((i+1)%5==0){
				System.out.print("\n-------------------------------------------------------------第"+c+"頁\n");
				c++;	
			}	
			}
		
			System.out.printf("\n -2:變更順序  -1:上一頁\n");
			a = in.nextInt();
			if(a == -1){
				manage(str);
			}else if(a == -2){
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
				System.out.printf("選擇欄位:\n 0:工作名稱\n 1:完成時間\n 2:完成百分比\n 3:狀態\n 4:編號\n 5:分類\n 6:工作內容\n -1:上一頁\n");
				b = in.nextInt();
				if(b == -1){
					manage(str);				
				}else if( a==0 || a>7 || a<-2){
					System.out.printf("ERROR");
					System.exit(1);	
				}else{
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();	
					System.out.printf("選擇順序:\n 1:由大到小\n 2:由小到大\n");
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

		System.out.print("輸入順序:\n\n 0:大>小\n 1:小>大    -1:上一頁\n--------------(排序依資料新增順序)\n");
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

			System.out.printf("-------------------\n  -1:上一頁\n");
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

			System.out.printf("-------------------\n  -1:上一頁\n");
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


		System.out.print("選擇資料(輸入資料序號):\n\n");
		System.out.print("資料序/");
		if(Var.a1 == 1) System.out.print("工作名稱/");
		if(Var.a2 == 1) System.out.print("完成時間/");
		if(Var.a3 == 1) System.out.print("完成百分比/");
		if(Var.a4 == 1) System.out.print("狀態/");
		if(Var.a5 == 1) System.out.print("編號/");
		if(Var.a6 == 1) System.out.print("分類/");
		if(Var.a7 == 1) System.out.print("工作內容/");
			
		System.out.print("\n-------------------------------------------------------------第"+c+"頁\n");
		c++;
		for(a = 0;a<Var.fn;a++){
			System.out.print("資料"+(a+1)+":  ");
			if(Var.a1 == 1) System.out.print(str[a][0]+"	");
			if(Var.a2 == 1) System.out.print(str[a][1]+"	");
			if(Var.a3 == 1) System.out.print(str[a][2]+"	");
			if(Var.a4 == 1) System.out.print(str[a][3]+"	");
			if(Var.a5 == 1) System.out.print(str[a][4]+"	");
			if(Var.a6 == 1) System.out.print(str[a][5]+"	");
			if(Var.a7 == 1) System.out.print(str[a][6]);
			System.out.printf("\n");			
			if((a+1)%5==0){
				System.out.print("\n-------------------------------------------------------------第"+c+"頁\n");
				c++;	
			}			
		}
		System.out.print("\n -4:設定顯示項目 -3:搜尋    -2:新增資料    -1:上一頁 \n");
		
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

			System.out.print("依序輸入資料:\n\n");

			System.out.print("工作名稱:");
			news = in.next();
			str[Var.fn-1][0] = news;

			System.out.print("完成時間:");
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

			System.out.print("完成百分比:");
			news = in.next();
			as = Integer.parseInt(news);
			if(as<100&&as>0){
				str[Var.fn-1][2] = news;
			}else{
				System.out.printf("ERROR");
				System.exit(1);			
			
			}
			System.out.print("狀態:");
			news = in.next();
			if(news.equals("未開始")||news.equals("執行中")||news.equals("完成")){
				str[Var.fn-1][3] = news;
			}else{
				System.out.printf("ERROR");
				System.exit(1);					
			}

			System.out.print("編號:");
			news = in.next();
			chars = news.toCharArray();
			if(Character.toString(chars[0]).matches("[A-Z?]")){
				str[Var.fn-1][4] = news;
			}else{
				System.out.printf("ERROR");
				System.exit(1);	
			}

			System.out.print("分類:");
			news = in.next();
			str[Var.fn-1][5] = news;

			System.out.print("工作內容:");	
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
			System.out.print("輸入是否要顯示的欄位():\n");

			System.out.printf(" 1:工作名稱"); 
			if(Var.a1 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 2:完成時間");
			if(Var.a2 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 3:完成百分比");
			if(Var.a3 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 4:狀態"); 
			if(Var.a4 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 5:編號"); 
			if(Var.a5 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 6:分類"); 
			if(Var.a6 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" 7:工作內容"); 
			if(Var.a7 == 1){
				System.out.printf("	O\n");
			}else{
				System.out.printf("	X\n");
			}

			System.out.printf(" -1:上一頁\n");

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
		System.out.printf("選擇搜尋項目:\n 1:工作名稱\n 2:完成時間\n 3:完成百分比\n 4:狀態\n 5:編號\n 6:分類\n 7:工作內容\n -1:上一頁\n");
		
		Scanner in = new Scanner(System.in);		
		a = in.nextInt();
		
		if(a == -1){
			user(str);
		}else{

			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			String se;
			System.out.printf("輸入搜尋內容:\n");
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
				System.out.printf("\n-1:回上一頁\n");
				System.out.print("-------------------\n");

				x = in.nextInt();

				if(x == -1){
					user(str);
				}else{
					System.out.printf("ERROR");
					System.exit(1);	
				}
			}else{
				System.out.printf("查無此項目 \n\n -1:回上一頁\n");
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
		System.out.printf("輸入指令:\n\n 0:刪除資料\n 1:工作名稱\n 2:完成時間\n 3:完成百分比\n 4:狀態\n 5:編號\n 6:分類\n 7:工作內容\n -1:上一頁\n");
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

			System.out.print("確認刪除?(yes or no)\n");
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
		System.out.printf("輸入指令:\n\n 1:編輯內容\n -1:上一頁\n");
		System.out.print("-------------------\n");
		a = in.nextInt();
		System.out.print("-------------------\n");
		if(a == -1){
			data(str,i);
			
		}else if(a == 1){
			System.out.printf("輸入新內容:");
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

				if(news.equals("未開始")||news.equals("執行中")||news.equals("完成")){
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

