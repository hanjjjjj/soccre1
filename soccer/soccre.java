package soccer;
	class Phone{
	private String name;	// 이름
	private String tel;	// 전화번호
	private String agent;
	private String national;
	private String age;
	private String wage;
	
	public Phone(String name, String tel, String agent, String national, String age, String wage) {
		super();
		this.name = name;
		this.tel = tel;
		this.agent = agent;
		this.national = national;
		this.age = age;
		this.wage = wage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getNational() {
		return national;
	}
	public void setNational(String national) {
		this.national = national;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
		
	}
	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", agent=" + agent + ", national=" + national + ", age=" + age
				+ ", wage=" + wage + "]";
	}
	}
	