import java.util.ArrayList;
import java.util.Scanner;

public class Details {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
//    int n = input.nextInt();
    BinarySearchTree<Integer> myBST = new BinarySearchTree<>();
    int[] numbers = {299,
        480, 250, 32, 376, 185, 91, 249, 229,
        367, 120, 195, 65, 330, 428, 189, 362, 265, 175, 183,
        477, 214, 408, 92, 128, 464, 149, 17, 191, 143, 228, 145, 440,
        476, 338, 391, 486, 62, 244, 117, 429, 76, 450, 216, 26, 399,
        272, 194, 115, 294, 187, 95, 99, 152, 147, 308, 293, 33, 400, 332,
        11, 457, 241, 202, 478, 326, 209, 101, 108, 52, 180, 358, 1, 80,
        88, 176, 309, 378, 416, 252, 133, 371, 420, 166, 295, 132, 73, 35,
        41, 12, 50, 46, 237, 444, 373, 395, 112, 207, 285, 278, 223, 231, 161, 335, 468,
        469, 377, 57, 47, 321, 184, 31, 415, 29, 49, 215, 471, 106, 2, 192, 78, 409, 89,
        85, 245, 462, 470, 368, 10, 165, 113, 141, 383, 379, 171, 443, 380, 105, 64, 467,
        283, 79, 109, 69, 363, 431, 9, 197, 227, 312, 389, 488, 25, 240, 193, 248, 146,
        159, 220, 436, 365, 403, 22, 324, 114, 221, 38, 59, 14, 296, 60, 345, 313,
        53, 439, 55, 172, 8, 425, 140, 426, 93, 121, 30, 199, 129, 103, 302, 422, 190, 157, 247, 36, 427,
        393, 257, 354, 66, 339, 473, 258, 186, 337, 28, 418, 402, 322, 421, 465, 353, 381, 454, 292, 205,
        310, 3, 123, 68, 236, 242, 288, 356, 290, 329, 331, 280, 23, 394, 261, 82, 463, 260, 27, 411, 268,
        370, 151, 287, 116, 203, 405, 484, 347, 86, 350, 262, 392, 4, 251, 341, 410, 87, 158, 346, 286,
        204, 94, 318, 269, 218, 297, 219, 319, 44, 169, 385, 401, 56, 333, 75, 419, 434, 125, 317, 388,
        455, 19, 424, 24, 45, 182, 213, 13, 61, 360, 446, 483, 300, 210, 232, 461, 77, 163, 211, 301, 253, 351,
        148, 453, 423, 340, 43, 366, 122, 396, 20, 222, 325, 98, 137, 39, 124, 364, 224, 485, 34, 316, 344, 305,
        281, 118, 259, 188, 198, 275, 412, 451, 441, 460, 5, 135, 437, 352, 448, 342, 243, 160, 279, 458, 369, 466,
        201, 413, 104, 445, 226, 126, 273, 375, 16, 6, 179, 307, 234, 164, 178, 361, 284, 303, 111, 206, 212, 459, 359,
        142, 264, 83, 276, 328, 323, 119, 144, 355, 474, 315, 475, 139, 255, 407, 397, 314, 267, 21, 417, 84, 238,
        390, 167, 208, 289, 130, 90, 217, 63, 233, 196, 177, 40, 271, 131, 110, 155, 382, 398, 482, 72, 282, 277, 442, 414, 37, 18,
        349, 107, 404, 479, 456, 134, 225, 343, 154, 58, 304, 173, 384, 438, 387, 67, 274, 348, 374, 97, 487,
        336, 168, 406, 162, 239, 386, 452, 311, 320, 235, 327, 7, 291, 200, 447, 48, 100, 298, 372, 170, 246, 150,
        181, 70, 433, 42, 127, 270, 15, 136, 81, 51, 256, 74, 230, 96, 357, 138, 54, 432, 102,
        472, 156, 174, 435, 334, 481, 306, 254, 430, 71, 153, 266, 263};

//    for (int i = 0; i < n; i++) {
//      int temp = input.nextInt();
//      myBST.insert(temp);
//      numbers[i] = temp;
//    }

    for (int i = 0; i < 487; i++) {
      myBST.insert(numbers[i]);
    }
    int startOfRange = 229;
    int endOfRange = 328;

    long count = 0;

    for (int i = 0; i < 487; i++) {
      int value = numbers[i];
      if (startOfRange <= value && value <= endOfRange) {
        myBST.inorderTreeWalk(myBST.treeSearch(myBST.getRootNode(), value),true);
        ArrayList<Integer> walkResult = myBST.getInorderWalkResult();
        boolean shouldAdd = true;
        System.out.println(count);
        System.out.print(value + ":   ");
        System.out.println(walkResult);
        for (int j = 0; j < walkResult.size(); j++) {
          if (startOfRange > walkResult.get(j) || walkResult.get(j) > endOfRange) {
            shouldAdd = false;
            break;
          }
        }
        if (shouldAdd) {
          count++;
        }
      }
    }
    System.out.println(count);
  }
}


/**
 * @author Muhammad Karbalaee
 * @param <T> Any object which implements the Comparable interface is accepted
 */
class BinarySearchTree<T extends Comparable<T>>{
  private BinarySearchNode<T> rootNode;
  private final ArrayList<T> sortedData;
  private final ArrayList<T> preorderWalkResult;
  private final ArrayList<T> postorderWalkResult;

  /**
   * constructor for BinarySearchTree class.
   */
  public BinarySearchTree() {
    this.rootNode = null;
    this.sortedData = new ArrayList<>();
    this.preorderWalkResult = new ArrayList<>();
    this.postorderWalkResult = new ArrayList<>();
  }

  public ArrayList<T> getInorderWalkResult() {
    return this.sortedData;
  }
  /**
   * by calling this method the sorted data will be stored in the
   * @param node the node of the subtree to print. if you want it to print the whole tree,
   *             pass the root node to it.
   */
  public void inorderTreeWalk(BinarySearchNode<T> node,boolean shouldClear) {
    if (shouldClear) {
      this.sortedData.clear();
    }
    if (node != null) {
      this.inorderTreeWalk(node.getLeftChild(),false);
      this.sortedData.add(sortedData.size(),node.getData());
      this.inorderTreeWalk(node.getRightChild(),false);
    }
  }

  /**
   * by calling this method all the data in this tree will be walked through
   * @param node the node of the subtree to print. if you want it to print the whole tree,
   *             pass the root node to it.
   */
  public void preorderTreeWalk(BinarySearchNode<T> node) {
    if (node == this.rootNode) {
      this.preorderWalkResult.clear();
    }
    if (node != null) {
      this.preorderTreeWalk(node.getLeftChild());
      this.preorderWalkResult.add(preorderWalkResult.size(),node.getData());
      this.preorderTreeWalk(node.getRightChild());
    }
  }

  /**
   * by calling this method all the data in this tree will be walked through
   * @param node the node of the subtree to print. if you want it to print the whole tree,
   *             pass the root node to it.
   */
  public void postorderTreeWalk(BinarySearchNode<T> node) {
    if (node == this.rootNode) {
      this.postorderWalkResult.clear();
    }
    if (node != null) {
      this.postorderTreeWalk(node.getLeftChild());
      this.postorderWalkResult.add(postorderWalkResult.size(),node.getData());
      this.postorderTreeWalk(node.getRightChild());
    }
  }

  /**
   *
   * @return the root node of the tree
   */
  public BinarySearchNode<T> getRootNode() {
    return rootNode;
  }

  /**
   *
   * @return An ArrayList containing all the data inserted in the tree so far in a sorted order
   */
  public ArrayList<T> getSortedData() {
    this.inorderTreeWalk(this.rootNode,true);
    return this.sortedData;
  }

  /**
   *
   * @return data in the order presented by preorder tree walk
   */
  public ArrayList<T> getPreorderWalkResult() {
    this.preorderTreeWalk(this.rootNode);
    return this.preorderWalkResult;
  }

  /**
   *
   * @return data in the order presented by postorder tree walk
   */
  public ArrayList<T> getPostorderWalkResult() {
    this.postorderTreeWalk(this.rootNode);
    return this.postorderWalkResult;
  }

  /**
   * to insert a new node with new data into the tree
   * @param newData data of type T which is the same type as the type specified when creating BinarySearchTree class
   */
  public void insert(T newData) {
    BinarySearchNode<T> newNode = new BinarySearchNode<>(null,null,null,newData);
    BinarySearchNode<T> parentOfNewNode = null;
    BinarySearchNode<T> temporaryNode = this.rootNode;
    while (temporaryNode != null) {
      parentOfNewNode = temporaryNode;
      int comparisonResult = newNode.getData().compareTo(temporaryNode.getData());
      if (comparisonResult < 0) {
        temporaryNode = temporaryNode.getLeftChild();
      } else {
        temporaryNode = temporaryNode.getRightChild();
      }
    }
    newNode.setParent(parentOfNewNode);
    int parentChildDataComparisonResult = 0;
    if (parentOfNewNode != null) {
      parentChildDataComparisonResult = newNode.getData().compareTo(parentOfNewNode.getData());
    }
    if (parentOfNewNode == null) {
      this.rootNode = newNode;
    } else if (parentChildDataComparisonResult < 0) {
      parentOfNewNode.setLeftChild(newNode);
    } else {
      parentOfNewNode.setRightChild(newNode);
    }
  }

  /**
   *
   * @param pivotNode the node that its value is compared to searchingValue parameter
   * @param searchingValue the value to search for in the tree
   * @return the node with the wanted value
   */
  public BinarySearchNode<T> treeSearch(BinarySearchNode<T> pivotNode,T searchingValue) {
    if (pivotNode == null || pivotNode.getData() == searchingValue) {
      return pivotNode;
    }
    int comparisonResult = pivotNode.getData().compareTo(searchingValue);
    if (comparisonResult > 0) {
      return this.treeSearch(pivotNode.getLeftChild(),searchingValue);
    } else {
      return this.treeSearch(pivotNode.getRightChild(),searchingValue);
    }
  }

  /**
   *
   * @param startingNode the node to start finding the minimum from.
   *                     if you want the minimum node of the whole tree, pass the root node to this
   *                     method;otherwise, it will find the minimum value in the subtree.
   * @return the node of the tree which has the minimum data value
   */
  public BinarySearchNode<T> treeMinimum(BinarySearchNode<T> startingNode) {
    while (startingNode.getLeftChild() != null) {
      startingNode = startingNode.getLeftChild();
    }
    return startingNode;
  }

  /**
   *
   * @param startingNode the node to start finding the maximum from.
   *                     if you want the minimum node of the whole tree, pass the root node to this
   *                     method;otherwise, it will find the maximum value in the subtree.
   * @return the node of the tree which has the maximum data value
   */
  public BinarySearchNode<T> treeMaximum(BinarySearchNode<T> startingNode) {
    while (startingNode.getRightChild() != null) {
      startingNode = startingNode.getRightChild();
    }
    return startingNode;
  }

  /**
   *
   * @param node the node which we want its successor
   * @return the node which comes exactly after the node in sorted order
   */
  public BinarySearchNode<T> treeSuccessor(BinarySearchNode<T> node) {
    if (node.getRightChild() != null) {
      return this.treeMinimum(node.getRightChild());
    }
    BinarySearchNode<T> temporaryNode = node.getParent();
    while (temporaryNode != null && node == temporaryNode.getRightChild()) {
      node = temporaryNode;
      temporaryNode = temporaryNode.getParent();
    }
    return temporaryNode;
  }

  /**
   *
   * @param node the node which we want its predecessor
   * @return the node which comes exactly before the node in sorted order
   */
  public BinarySearchNode<T> treePredecessor(BinarySearchNode<T> node) {
    if (node.getLeftChild() != null) {
      return this.treeMaximum(node.getLeftChild());
    }
    BinarySearchNode<T> temporaryNode = node.getParent();
    while (temporaryNode != null && node == temporaryNode.getLeftChild()) {
      node = temporaryNode;
      temporaryNode = temporaryNode.getParent();
    }
    return temporaryNode;
  }

  /**
   * this method replaces one subtree as a child of its parent
   * with another subtree.
   * @param firstSubtreeRoot the root of first subtree
   * @param secondSubtreeRoot the root of second subtree
   */
  public void transplant(BinarySearchNode<T> firstSubtreeRoot,
                         BinarySearchNode<T> secondSubtreeRoot) {
    if (firstSubtreeRoot.getParent() == null) {
      this.rootNode = secondSubtreeRoot;
    } else if (firstSubtreeRoot == firstSubtreeRoot.getParent().getLeftChild()) {
      firstSubtreeRoot.getParent().setLeftChild(secondSubtreeRoot);
    } else {
      firstSubtreeRoot.getParent().setRightChild(secondSubtreeRoot);
    }
    if (secondSubtreeRoot != null) {
      secondSubtreeRoot.setParent(firstSubtreeRoot.getParent());
    }
  }

  /**
   * deletes the specified node from the tree
   * @param nodeToDelete the node that you want to delete from the tree
   */
  public void delete(BinarySearchNode<T> nodeToDelete) {
    if (nodeToDelete.getLeftChild() == null) {
      this.transplant(nodeToDelete,nodeToDelete.getRightChild());
    } else if (nodeToDelete.getRightChild() == null) {
      this.transplant(nodeToDelete,nodeToDelete.getLeftChild());
    } else {
      BinarySearchNode<T> temporaryNode = this.treeMinimum(nodeToDelete.getRightChild());
      if (temporaryNode.getParent() != nodeToDelete) {
        this.transplant(temporaryNode,temporaryNode.getRightChild());
        temporaryNode.setRightChild(nodeToDelete.getRightChild());
        temporaryNode.getRightChild().setParent(temporaryNode);
      }
      this.transplant(nodeToDelete,temporaryNode);
      temporaryNode.setLeftChild(nodeToDelete.getLeftChild());
      temporaryNode.getLeftChild().setParent(temporaryNode);
    }
  }
}


/**
 * @author Muhammad Karbalaee
 * @param <T> Any object which implements the Comparable interface is accepted
 */
class BinarySearchNode<T extends Comparable<T>>{
  private BinarySearchNode<T> parent;
  private BinarySearchNode<T> leftChild;
  private BinarySearchNode<T> rightChild;
  private T data;

  public BinarySearchNode(BinarySearchNode<T> parent, BinarySearchNode<T> leftChild,
                          BinarySearchNode<T> rightChild, T data) {
    this.parent = parent;
    this.leftChild = leftChild;
    this.rightChild = rightChild;
    this.data = data;
  }

  /**
   *
   * @return the parent node
   */
  public BinarySearchNode<T> getParent() {
    return parent;
  }

  /**
   *
   * @param parent the new parent node to be set
   */
  public void setParent(BinarySearchNode<T> parent) {
    this.parent = parent;
  }

  /**
   *
   * @return left child of the node
   */
  public BinarySearchNode<T> getLeftChild() {
    return leftChild;
  }

  /**
   *
   * @param leftChild the new left chilad node to be set
   */
  public void setLeftChild(BinarySearchNode<T> leftChild) {
    this.leftChild = leftChild;
  }

  /**
   *
   * @return right child node
   */
  public BinarySearchNode<T> getRightChild() {
    return rightChild;
  }

  /**
   *
   * @param rightChild the new right child node to be set
   */
  public void setRightChild(BinarySearchNode<T> rightChild) {
    this.rightChild = rightChild;
  }

  /**
   *
   * @return the satellite data stored int the node
   */
  public T getData() {
    return data;
  }

  /**
   *
   * @param data the new data object to be set
   */
  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    T parentData = null;
    T leftData = null;
    T rightData = null;

    if (parent != null) {
      parentData = parent.getData();
    }
    if (leftChild != null) {
      leftData = leftChild.getData();
    }
    if (rightChild != null) {
      rightData = rightChild.getData();
    }

    return "BinarySearchNode{" +
        "parent=" + parentData + ", " +
        "leftChild=" + leftData + ", " +
        "rightChild=" + rightData + "," +
        " data=" + data +
        '}';
  }
}