package soccer;

	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.Map;
	import java.util.Scanner;
	import java.util.Set;


	public class soccre1 {
	private Scanner scan;
	private  Map<String, Phone> soccreMap;

	public soccre1() {
	scan = new Scanner(System.in);
	soccreMap = new HashMap<>();

	}

	// 메뉴를 출력하는 메서드
	public void displayMenu(){
	System.out.println();
	System.out.println("메뉴를 선택하세요.");
	System.out.println(" 1. 선수정보 등록");
	System.out.println(" 2. 선수정보 수정");
	System.out.println(" 3. 선수정보 삭제");
	System.out.println(" 4. 선수정보 검색");
	System.out.println(" 5. 선수정보 전체 출력");
	System.out.println(" 0. 프로그램 종료");
	System.out.print(" 번호입력 >> ");
	}

	// 프로그램을 시작하는 메서드
	public void soccreStart(){
	System.out.println("===============================================");
	System.out.println("   선수 정보관리 프로그램");
	System.out.println("===============================================");

	while(true){

		displayMenu();  // 메뉴 출력

		int menuNum = scan.nextInt();   // 메뉴 번호 입력

		switch(menuNum){
			case 1 : insert();		// 등록
				break;	
			case 2 : update();		// 수정
				break;
			case 3 : delete();		// 삭제
				break;
			case 4 : search();		// 검색
				break;
			case 5 : displayAll();	// 전체 출력
				break;
			case 0 :
				System.out.println("프로그램을 종료합니다...");
				return;
			default :
				System.out.println("잘못 입력했습니다. 다시입력하세요.");
		} // switch문
	} // while문
	}

	private void search() {
	System.out.println();
	System.out.println("검색할 선수정보를 입력하세요");
	System.out.print("이 름 >> ");
	String name = scan.next();
	    
	    Phone p = soccreMap.get(name);
	    
	    if(p == null) {
	    System.out.println(name + " 선수 의 정보가 없습니다.");
	    } else {
	    System.out.println(name + " 선수의 정보");
	    System.out.println("이      름 : " + p.getName());
	    System.out.println("전화번호 : " + p.getTel());
	    System.out.println("에이전트  : " + p.getAgent());
	    System.out.println("국적 :" + p.getNational());
	    System.out.println("나이 :" + p.getAge());
	    System.out.println("주급 :" + p.getWage());
	    }
	    System.out.println("검색 작업 완료....");
	    }
	    

	/**

	- 전화번호 정보를 삭제하는 메서드
	*/
	private void delete() {
	System.out.println();
	System.out.println("삭제할 선수 정보를 입력하세요");
	System.out.print("이 름 >> ");
	String name = scan.next();
	    
	    // remove(key) => 삭제 성공하면 삭제된 value값만 반환하고, 실패하면 null 반환
	    if(soccreMap.remove(name) == null) {
	    System.out.println(name + " 선수는 등록된 선수가 아닙니다.");
	    } else {
	    System.out.println(name + " 선수의 정보를 삭제했습니다.");
	    }
	    System.out.println("삭제 작업 완료...");
	    }
	    

	/**

	-선수 정보를 수정하는 메서드
	*/
	private void update() {
	System.out.println();
	System.out.println("새롭게 수정할 선수의 정보를 입력하세요");
	System.out.print("이 름 >> ");
	String name = scan.next();
	    
	    // 수정할 자료가 있는지 검사
	    if(soccreMap.get(name) == null) {
	    System.out.println(name + " 선수의 정보가 없습니다.");
	    return; //메서드 종료
	    }
	    
	    System.out.print("전화번호 >> ");
	    String tel = scan.next();
	    
	    System.out.print("에이전트 >> ");
	    scan.nextLine();	
	    String agent = scan.nextLine();
	    
	    System.out.print("국적 >> ");
	    String national = scan.nextLine();
	    
	    System.out.print("나이 >> ");
	    String age = scan.nextLine();
	    
	    System.out.print("주급 >> ");
	    String wage = scan.nextLine();
	    
	    Phone p = new Phone(name,tel,agent,national,age,wage);
	    soccreMap.put(name, p);
	    
	    System.out.println(name + " 선수 수정 완료...");
	    

	}

	/**
	- 전체 자료를 출력하는 메서드
	*/
	private void displayAll() {
	Set<String> keySet = soccreMap.keySet();
	    
	    System.out.println("=====================================");
	    System.out.println(" 번호\\이름\\전화번호\\에이전트\\국적\\나이\\주급");
	    System.out.println("=====================================");
	    
	    if(keySet.size() == 0) {
	    System.out.println("등록된 전화번호 정보가 없습니다.");
	    } else {
	    Iterator<String> it = keySet.iterator();
	    
	     int cnt = 0;
	     while(it.hasNext()) {
	     	cnt++;
	     	String name = it.next();
	     	Phone p = soccreMap.get(name);
	     	System.out.println(" " + cnt + "\\" + p.getName() +"\\"+ p.getTel() +"\\"+ p.getAgent()+ "\\"+ p.getNational()+ "\\"+ p.getAge() + "\\" + p.getWage());
	     }
	    
	    
	    }
	    System.out.println("=====================================");
	    System.out.println("저장 완료");
	    }
	    

	/**

	- 새로운 선수 정보를 등록하는 메서드
	- (이미 등록된 사람은 등록되지 않는다)
	*/
	private void insert() {
	System.out.println();
	System.out.println("새롭게 등록할 선수 정보를 입력하세요");
	System.out.print("이 름 >> ");
	String name = scan.next();
	    
	    // 이미 등록된 사람인지 검사
	    // get()메서드로 값을 가져올 때 가져올 자료가 없으면 null을 반환한다.
	    if(soccreMap.get(name) != null) {
	    System.out.println(name + " 선수는 이미 등록된 선수입니다.");
	    return; //메서드 종료
	    }
	    
	    System.out.print("전화번호 >> ");
	    String tel = scan.next();
	    
	    System.out.print("에이전트 >> ");
	    scan.nextLine();	
	    String agent = scan.nextLine();
	    
	    System.out.print("국적 >> ");	
	    String national = scan.nextLine();
	    
	    System.out.print("나이 >> ");	
	    String age = scan.next();
	    
	    System.out.print("주급 >> ");	
	    String wage = scan.next();
	    
	    soccreMap.put(name, new Phone(name, tel, agent,national,age,wage));
	    System.out.println(name + "선수 새 등록 완료...");
	    }
	    
	public static void main(String[] args) {
	new soccre1().soccreStart();
	}
	}