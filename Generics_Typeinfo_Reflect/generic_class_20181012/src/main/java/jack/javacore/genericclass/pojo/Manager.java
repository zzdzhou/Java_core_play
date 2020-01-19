package jack.javacore.genericclass.pojo;

/**
 * Theme:
 * <p>
 * Description:
 *
 * @author Java 核心技术 卷I 10th
 * Created on 20181013
 */
public class Manager extends Employee {

    private double bonus;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        this.bonus = 0L;
    }

    public double getSalary() {
        return super.getSalary() + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return this.bonus;
    }

    public String toString() {
        return "Manager{" + "name='" + super.getName() + '\'' +
                ", salary=" + super.getSalary() +
                ", hireDate=" + super.getHireDate() +
                ", bonus=" + bonus +
                '}';
    }
}
