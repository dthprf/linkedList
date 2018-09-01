package linkedList;

import java.util.Objects;

public class QueueNode {
    private String value;
    private QueueNode nextNode;
    private Integer priority;

    public QueueNode(String value){
        this.value = value;
    }

    public QueueNode(String value, Integer priority){
        this.value = value;
        this.priority = priority;
    }

    public String getValue() {
        return this.value;
    }

    public QueueNode getNextNode() {
        return this.nextNode;
    }

    public void setNextNode(QueueNode node) {
        this.nextNode = node;
    }

    public Integer getPriority() {
        return priority;
    }

    public int comparePriority(QueueNode node) {
        if (this.priority == node.getPriority()) {
            return 0;

        } else if (this.priority != null && node.getPriority() != null) {
            if (this.priority > node.getPriority()) {
                return 1;
            } else if (this.priority == node.getPriority()) {
                return 0;
            } else {
                return -1;
            }

        } else if (this.priority == null && node.getPriority() != null) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(value);

        if (priority != null) {
            sb.append(":");
            sb.append(String.valueOf(priority));

        } else {
            sb.append(":none");
        }

        sb.append(":");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueueNode queueNode = (QueueNode) o;

        return Objects.equals(getValue(), queueNode.getValue()) &&
                Objects.equals(getNextNode(), queueNode.getNextNode()) &&
                Objects.equals(getPriority(), queueNode.getPriority());
    }
}
