package jethro.momenton;

/**
 * A entity class representing an employee
 * @author jhu
 *
 */
public class Employee {

    private final String name;
    private final Long id;
    private final Long managerId;

    private Employee(String name, Long id, Long managerId) {
        this.name = name;
        this.id = id;
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Long getManagerId() {
        return managerId;
    }

    public static Employee of(String name, Long id, Long managerId) {
        return new Employee(name, id, managerId);
    }
}
