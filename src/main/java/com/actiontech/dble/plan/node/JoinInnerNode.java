package com.actiontech.dble.plan.node;

/**
 * Created by szf on 2019/5/31.
 */
public class JoinInnerNode extends JoinNode {

    public PlanNodeType type() {
        return PlanNodeType.JOIN_INNER;
    }

    public JoinInnerNode(PlanNode left, PlanNode right) {
        super();
        addChild(left);
        addChild(right);
        setKeepFieldSchema(left.isKeepFieldSchema() && right.isKeepFieldSchema());
    }
}
