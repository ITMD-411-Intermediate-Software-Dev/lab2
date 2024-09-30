// BankRecords.java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BankRecords extends Client {
    // Instance fields for each CSV column
    private String id;
    private int age;
    private String sex;
    private String region;
    private double income;
    private String married;
    private int children;
    private String car;
    private String save_act;
    private String current_act;
    private String mortgage;
    private String pep;

    // ArrayList to store all the data records
    private ArrayList<String[]> records = new ArrayList<>();

    // Getters and setters for each field
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getSex() { return sex; }
    public void setSex(String sex) { this.sex = sex; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public double getIncome() { return income; }
    public void setIncome(double income) { this.income = income; }

    public String getMarried() { return married; }
    public void setMarried(String married) { this.married = married; }

    public int getChildren() { return children; }
    public void setChildren(int children) { this.children = children; }

    public String getCar() { return car; }
    public void setCar(String car) { this.car = car; }

    public String getSave_act() { return save_act; }
    public void setSave_act(String save_act) { this.save_act = save_act; }

    public String getCurrent_act() { return current_act; }
    public void setCurrent_act(String current_act) { this.current_act = current_act; }

    public String getMortgage() { return mortgage; }
    public void setMortgage(String mortgage) { this.mortgage = mortgage; }

    public String getPep() { return pep; }
    public void setPep(String pep) { this.pep = pep; }

    @Override
    public void readData() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("bank-Detail.csv"))) {
            // Skip the header
            br.readLine();

            // Read each line of the file
            while ((line = br.readLine()) != null) {
                // Split the line by comma to get individual data fields
                String[] values = line.split(",");
                // Add the record to the ArrayList
                records.add(values);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    @Override
    public void processData() {
        // Process the data by assigning values from the ArrayList to the instance fields
        for (int i = 0; i < records.size(); i++) {
            String[] record = records.get(i);

            setId(record[0]);
            setAge(Integer.parseInt(record[1]));
            setSex(record[2]);
            setRegion(record[3]);
            setIncome(Double.parseDouble(record[4]));
            setMarried(record[5]);
            setChildren(Integer.parseInt(record[6]));
            setCar(record[7]);
            setSave_act(record[8]);
            setCurrent_act(record[9]);
            setMortgage(record[10]);
            setPep(record[11]);
        }
    }

    @Override
    public void printData() {
        System.out.printf("%-10s %-5s %-10s %-15s %-10s %-10s%n", "ID", "AGE", "SEX", "REGION", "INCOME", "MORTGAGE");
        System.out.println("-------------------------------------------------------------");

        // Print the first 25 records
        for (int i = 0; i < 25 && i < records.size(); i++) {
            String[] record = records.get(i);
            System.out.printf("%-10s %-5s %-10s %-15s %-10s %-10s%n",
                record[0],  // ID
                record[1],  // Age
                record[2],  // Sex
                record[3],  // Region
                record[4],  // Income
                record[10]  // Mortgage
            );
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        BankRecords br = new BankRecords();
        br.readData();       // Read data from CSV
        br.processData();    // Process the data
        br.printData();      // Print first 25 records
    }
}
