package HomeWork.Tuan10;

    static int getHeight(Node node) {
        if (node == null) return -1;
        return node.ht;
    }

    static int balanceFactor(Node node) {
        if (node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    static Node rotateRight(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.ht = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    static Node rotateLeft(Node root) {
        Node newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        newRoot.ht = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    static Node balance(Node root) {
        if (Math.abs(balanceFactor(root)) <= 1) return root;
        else if (balanceFactor(root) > 1) { 
            if (balanceFactor(root.left) < 0) { 
                root.left = rotateLeft(root.left);
            }
                      
            root = rotateRight(root);
        } else {
            if (balanceFactor(root.right) > 0) {    
                root.right = rotateRight(root.right);
            }
                    
            root = rotateLeft(root);
        }
        return root;
    }

    static Node insert(Node root,int val)
    {
        if (root == null) {
            Node node = new Node();
            node.val = val;
            node.ht = 0;
            node.left = null;
            node.right = null;
            return node;
        }
        if (root.val < val) {
            root.right = insert(root.right, val);
        } else if (root.val > val) {
            root.left = insert(root.left, val);
        } else {
            return root;
        }
        root.ht = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        return balance(root);
    }
