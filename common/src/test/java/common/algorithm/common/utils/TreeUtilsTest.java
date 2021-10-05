package common.algorithm.common.utils;

import com.algorithm.common.datastructure.generic.TreeNode;
import com.algorithm.common.utils.TreeUtils;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * @author QingFan 2021/10/5
 * @version 1.0.0
 */
public class TreeUtilsTest {

    private static TreeNode<Integer> root;

    @Before
    public void before() {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        root = TreeUtils.buildTree(arr, root, 0);
    }

    @Test
    public void testPrint() {
        TreeUtils.print(root);
    }

    @Test
    public void testPreOrder() {
        List<Integer> list = new ArrayList<>();
        TreeUtils.preOrder(root, list);
        System.out.println(list);
    }
}
