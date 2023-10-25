package firstWeb;

public class Employee implements Comparable<Employee>{
	
		private int id;
		private int seniority;
		private int experience;
		private String name;
		private int age;
		private double salary;
		private int deptId;
		
		public Employee(int id,String name, int age, int experience,int seniority, double salary, int deptId) {
			super();
			this.id = id;
			this.seniority = seniority;
			this.experience = experience;
			this.name = name;
			this.age = age;
			this.salary = salary;
			this.setDeptId(deptId);
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public int getSeniority() {
			return seniority;
		}
		
		public int getExperience() {
			return experience;
		}
		
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		public double getSalary() {
			return salary;
		}
		
		public void setSeniority(int seniority) {
			this.seniority = seniority;
		}
		public void setExperience(int experience) {
			this.experience = experience;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}
		
		public int getDeptId() {
			return deptId;
		}

		public void setDeptId(int deptId) {
			this.deptId = deptId;
		}

		@Override
		public String toString() {
			return "Employee [name= " + name + ", age=" + age + ", experience=" + experience +", seniority=" 
		+ seniority +", salary=" + salary + ", empid=" + id + "deptId=" +deptId +"]";
		}

		@Override
		public int compareTo(Employee o) {
			return this.seniority - o.seniority;
			}

		


	}

