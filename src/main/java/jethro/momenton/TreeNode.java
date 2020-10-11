package jethro.momenton;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a node within the tree structure, which has a parent and a number of children
 * 
 * @author jhu
 *
 * @param <E>
 *        the node element
 */
public class TreeNode<E> {

    private List<TreeNode<E>> children = new ArrayList<>();
    private TreeNode<E> parent = null;
    private E nodeElement = null;

    public TreeNode(E nodeElement) {
        this.nodeElement = nodeElement;
    }

    public List<TreeNode<E>> getChildren() {
        return children;
    }

    public void addChildNode(TreeNode<E> childNode) {
        childNode.setParent(this);
        children.add(childNode);
    }

    public TreeNode<E> getParent() {
        return parent;
    }

    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    public E getNodeElement() {
        return nodeElement;
    }

    public void setNodeElement(E nodeElement) {
        this.nodeElement = nodeElement;
    }
}