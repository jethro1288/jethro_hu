package jethro.momenton;

public class Main {

    public static void main(String[] args) {
        OrgHierarchyHelper helper = new OrgHierarchyHelper("/employees.csv");
        System.out.println("\n*******Organization Hierarchy*********\n");
        helper.displayHierarchy(helper.createHierarchyTree(), 1);
    }
}
