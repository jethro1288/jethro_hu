package jethro.momenton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The helper class used for displaying organization hierarchy.
 * 
 * @author jhu
 *
 */
public class OrgHierarchyHelper {

    private final List<Employee> employees;

    public OrgHierarchyHelper(String employeesCSVFile) {
        this.employees = initEmployeesFromCSVFile(employeesCSVFile);
    }    

    /**
     * Recursively display the organization hierarchy
     * 
     * @param root
     *        the organization hierarchy tree to display
     * @param marginSpacesNum
     *        the number of spaces to be displayed
     */
    public void displayHierarchy(TreeNode<Employee> root, int marginSpacesNum) {
        String marginSpaces = getMarginSpaces(marginSpacesNum);
        System.out.println(marginSpaces + root.getNodeElement().getName());
        System.out.println("--------------------------------------");

        List<TreeNode<Employee>> children = root.getChildren();
        if (children.isEmpty()) {
            return;
        }
        marginSpacesNum += 12;
        for (TreeNode<Employee> child : children) {
            displayHierarchy(child, marginSpacesNum);
        }
    }

    /**
     * Create the organization tree based on the employees
     * 
     * @return the root of organization tree
     */
    public TreeNode<Employee> createHierarchyTree() {
        Employee ceo = employees.stream().filter(e -> e.getManagerId() == null).findFirst().orElse(null);
        if (ceo == null) {
            return null;
        }
        TreeNode<Employee> rootNode = new TreeNode<>(ceo);
        fillInChildren(rootNode);
        return rootNode;
    }

    /*
     * Recursively fill in the children for the given {@code root} of tree
     */
    private void fillInChildren(TreeNode<Employee> root) {
        List<Employee> subordinates = employees.stream()
                .filter(e -> e.getManagerId() != null && e.getManagerId().equals(root.getNodeElement().getId()))
                .collect(Collectors.toList());

        if (subordinates.isEmpty()) {
            return;
        }

        for (Employee employee : subordinates) {
            TreeNode<Employee> subordinateNode = new TreeNode<>(employee);
            root.addChildNode(subordinateNode);
            fillInChildren(subordinateNode);
        }
    }

    /**
     * Get the spaces printed ahead of each line on the console
     * 
     * @param spacesNum
     *        the number of spaces
     * @return the given number of spaces
     */
    private String getMarginSpaces(int spacesNum) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < spacesNum; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
    
    /**
     * 
     * @param employeesCSVFile the csv file that includes all records of employees
     * @return a list of employee entities
     */
    private List<Employee> initEmployeesFromCSVFile(String csvFileName) {       
        List<Employee> employees = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(csvFileName)));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] record = line.split(",", -2);
                if (record.length < 3) {
                    throw new Exception(String.format("The line of %s is invalid", line));
                }
                employees.add(Employee.of(record[0], Long.valueOf(record[1]),
                        (record[2] == null || record[2].length() == 0) ? null : Long.valueOf(record[2])));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }

        }
        return employees;
    }

}
