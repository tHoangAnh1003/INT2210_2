package HomeWork.Tuan10;

boolean checkBST(Node root) {
    return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

boolean check(Node root, int min, int max) {
    if(root.data <= min || root.data >= max) return false;

    boolean isLeftBST;
    if(root.left == null) isLeftBST = true;
    else isLeftBST = check(root.left, min, root.data);

    boolean isRightBST;
    if(root.right == null) isRightBST = true;
    else isRightBST = check(root.right, root.data, max);
      return isLeftBST && isRightBST;
}