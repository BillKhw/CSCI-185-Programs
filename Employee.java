public class Employee extends Person {
    private double salary;
    private int startingYear;
    private String idNumber;

    // Default Constructor
    public Employee(){
        super();
        salary = 0;
        startingYear = 0;
        idNumber = "No ID number generated";
    }

    // Accessors
    public double getSalary(){ return salary; }
    public int getStartingYear(){ return startingYear; }
    public String getIdNumber(){ return idNumber; }

    //Mutators
    public void setSalary(double newSalary){ salary = newSalary; }
    public void setStartingYear(int newStartingYear){ startingYear = newStartingYear; }
    public void setIdNumber(String newIdNumber){ idNumber = newIdNumber; }

    //Constructor
    public void setEmployee(String newName, double newSalary, int newStartingYear, String newIdNumber){
        this.setName(newName);
        this.setSalary(newSalary);
        this.setStartingYear(newStartingYear);
        this.setIdNumber(newIdNumber);
    }

    //Equals Method
    public boolean equals(Employee p1){
        if (this.hasSameName(p1) && this.getSalary() == p1.getSalary() && this.getStartingYear() == p1.getStartingYear() && this.getIdNumber().equalsIgnoreCase(p1.getIdNumber()))
            return true;
        else
            return false;
    }

    //Output Method
    public void writeOutput(){
        System.out.println(this.getName());
        System.out.println(this.getSalary());
        System.out.println(this.getStartingYear());
        System.out.println(this.getIdNumber());
    }
}
