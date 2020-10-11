package jethro.momenton;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OrgHierarchyHelperTest {

    private OrgHierarchyHelper orgHierarchyHelper;

    @Before
    public void setup() {
        orgHierarchyHelper = new OrgHierarchyHelper("/employees.csv");
    }

    @Test
    public void testTreeCreation() {        
        TreeNode<Employee> root = orgHierarchyHelper.createHierarchyTree();
        assertEquals("Jamie", root.getNodeElement().getName());
        
        assertEquals("Alan", root.getChildren().get(0).getNodeElement().getName());
        assertEquals("Martin", root.getChildren().get(0).getChildren().get(0).getNodeElement().getName());
        assertEquals("Alex", root.getChildren().get(0).getChildren().get(1).getNodeElement().getName());
        
        assertEquals("Steve", root.getChildren().get(1).getNodeElement().getName());
        assertEquals("David", root.getChildren().get(1).getChildren().get(0).getNodeElement().getName());
    }

}
